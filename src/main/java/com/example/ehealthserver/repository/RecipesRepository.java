package com.example.ehealthserver.repository;

import com.example.ehealthserver.entity.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RecipesRepository extends JpaRepository<Recipes, Long> {

    List<Recipes> findAll();

    @Query(value = "SELECT r FROM Recipes r JOIN FETCH r.recipeDrugsList d WHERE d.recipeId = r.id")
    List<Recipes> findRecipesById(Long id);

    @Query(value = "SELECT recipe from Recipes recipe where recipe.issueDate>=:startDate and recipe.issueDate<=:endDate and recipe.uinDoctor=:uinDoctor")
    List<Recipes> findAllBySome(Date startDate, Date endDate, String uinDoctor);
}
