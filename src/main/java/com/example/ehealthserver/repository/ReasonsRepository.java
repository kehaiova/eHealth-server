package com.example.ehealthserver.repository;

import com.example.ehealthserver.entity.Reasons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReasonsRepository extends JpaRepository<Reasons, Long> {
}
