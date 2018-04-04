package com.example.easynotes.repository;

import com.example.easynotes.model.fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fundRepository extends JpaRepository<fund, Integer> {
}