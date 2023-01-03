package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.Recipes;

import java.util.Date;
import java.util.List;

public interface RecipesService {

    List<Recipes> findAll();

    List<Recipes> findRecipesById(Long id);

    List<Recipes> findAllBySome(Date startDate, Date endDate, String uinDoctor);

}
