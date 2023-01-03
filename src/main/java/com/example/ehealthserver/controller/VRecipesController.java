package com.example.ehealthserver.controller;

import com.example.ehealthserver.entity.VRecipes;
import com.example.ehealthserver.service.VRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/references/recipes")
public class VRecipesController {
    @Autowired
    private final VRecipesService vRecipesService;

    public VRecipesController (VRecipesService vRecipesService) {
        this.vRecipesService = vRecipesService;
    }

    @GetMapping("/getByUinDoctor/{startDate}/{endDate}/{uinDoctor}")
    public List<VRecipes> getByUinDoctor(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                         @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
                                         @PathVariable String uinDoctor) {
        return vRecipesService.findAllBySome(startDate, endDate, uinDoctor);
    }
}
