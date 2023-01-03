package com.example.ehealthserver.controller;

import com.example.ehealthserver.entity.Persons;
import com.example.ehealthserver.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/persons", produces = "application/json")
public class PersonsController {

    @Autowired
    private final PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/findAll")
    public List<Persons> findAll() {
        return personsService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Optional<Persons> findById(@PathVariable ("id") Long id) {
        return personsService.findById(id);
    }

    @GetMapping("/findByPersonIdentificator/{personIdentificator}")
    public Optional<Persons> findByIdentificator(@PathVariable ("personIdentificator") String personIdentificator) {
        return personsService.findByPersonIdentificator(personIdentificator);
    }
}
