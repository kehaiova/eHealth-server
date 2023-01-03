package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.Recipes;
import com.example.ehealthserver.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecipesServiceImpl implements RecipesService {

    @Autowired
    private RecipesRepository recipesRepository;


    @Override
    public List<Recipes> findAll() {
        return recipesRepository.findAll();
    }

    @Override
    public List<Recipes> findRecipesById(Long id) {
        return recipesRepository.findRecipesById(id);
    }

    @Override
    public List<Recipes> findAllBySome(Date startDate, Date endDate, String uinDoctor) {
        return recipesRepository.findAllBySome(startDate, endDate, uinDoctor);
    }
}
