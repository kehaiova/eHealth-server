package com.example.ehealthserver.controller;

import com.example.ehealthserver.entity.Reasons;
import com.example.ehealthserver.service.ReasonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/reasons", produces = "application/json")
public class ReasonsController {
    @Autowired
    private final ReasonsService reasonsService;

    public ReasonsController(ReasonsService reasonsService) {
        this.reasonsService = reasonsService;
    }

    @GetMapping("/findAll")
    public List<Reasons> findAll() {
        return reasonsService.findAll();
    }
}
