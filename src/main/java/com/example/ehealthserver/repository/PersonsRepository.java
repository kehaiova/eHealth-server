package com.example.ehealthserver.repository;

import com.example.ehealthserver.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons, Long> {

    Optional<Persons> findByPersonIdentificator(String personIdentificator);

}
