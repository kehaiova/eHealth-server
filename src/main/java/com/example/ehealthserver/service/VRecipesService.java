package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.VRecipes;

import java.util.Date;
import java.util.List;

public interface VRecipesService {

    List<VRecipes> findAllBySome(Date startDate, Date endDate, String uinDoctor);

}
