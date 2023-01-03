package com.example.ehealthserver.repository;

import com.example.ehealthserver.entity.VRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VRecipesRepository extends JpaRepository<VRecipes, Long> {

    @Query(value = "SELECT recipe from VRecipes recipe where recipe.issueDate>=:startDate and recipe.issueDate<=:endDate and recipe.uinDoctor=:uinDoctor")
    List<VRecipes> findAllBySome(Date startDate, Date endDate, String uinDoctor);
}
