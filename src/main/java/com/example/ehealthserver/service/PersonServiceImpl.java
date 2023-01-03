package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.Persons;
import com.example.ehealthserver.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonsService {

    @Autowired
    private PersonsRepository personsRepository;

    @Override
    public List<Persons> findAll() {
        return personsRepository.findAll();
    }

    @Override
    public Optional<Persons> findByPersonIdentificator(String personIdentificator) {
        return personsRepository.findByPersonIdentificator(personIdentificator);
    }

    @Override
    public Optional<Persons> findById(Long id) {
        return personsRepository.findById(id);
    }


}
