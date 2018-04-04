package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.WeightSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightSetRepository extends JpaRepository<WeightSet, Integer> {

}
