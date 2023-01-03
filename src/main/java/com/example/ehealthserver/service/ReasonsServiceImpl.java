package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.Reasons;
import com.example.ehealthserver.repository.ReasonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReasonsServiceImpl implements ReasonsService {

    @Autowired
    private ReasonsRepository reasonsRepository;

    @Override
    public List<Reasons> findAll() {
        return reasonsRepository.findAll();
    }

}
