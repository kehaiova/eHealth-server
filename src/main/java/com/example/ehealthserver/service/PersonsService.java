package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonsService {
    List<Persons> findAll();

    Optional<Persons> findByPersonIdentificator(String personIdentificator);

    Optional<Persons> findById(Long id);

}
