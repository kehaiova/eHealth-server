package com.example.ehealthserver.controller;

import com.example.ehealthserver.entity.Recipes;
import com.example.ehealthserver.repository.RecipesRepository;
import com.example.ehealthserver.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/recipes", produces = "application/json")
public class RecipesController {

    @Autowired
    private final RecipesService recipesService;

    @Autowired
    private final RecipesRepository recipesRepository;

    public RecipesController(RecipesService recipesService, RecipesRepository recipesRepository) {
        this.recipesService = recipesService;
        this.recipesRepository = recipesRepository;
    }

    @PostMapping("/saveAndFlush")
    public ResponseEntity<Recipes> saveAndFlush(@RequestBody @Validated Recipes recipes) {
        return new ResponseEntity<>(recipesRepository.save(recipes), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public List<Recipes> findAll() {
        return recipesService.findAll();
    }

    @GetMapping("/findRecipesById/{id}")
    public List<Recipes> findRecipesById(@PathVariable Long id) {
        return recipesService.findRecipesById(id);
    }

    @GetMapping("/getByUinDoctor/{startDate}/{endDate}/{uinDoctor}")
    public List<Recipes> getByUinDoctor(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
                                        @PathVariable String uinDoctor) {
        return recipesService.findAllBySome(startDate, endDate, uinDoctor);
    }


}
