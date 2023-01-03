package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.VRecipes;
import com.example.ehealthserver.repository.VRecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VRecipesServiceImpl implements VRecipesService {

    @Autowired
    private VRecipesRepository vRecipesRepository;

    @Override
    public List<VRecipes> findAllBySome(Date startDate, Date endDate, String uinDoctor) {
        return vRecipesRepository.findAllBySome(startDate, endDate, uinDoctor);
    }
}
