package com.example.easynotes.repository;

import com.example.easynotes.model.fundSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface fundSumRepository extends JpaRepository<fundSummary, Integer> {
   // fundSummary findByRank_return3m(int id);
    @Query(value="select * from fundSummary where ",nativeQuery = true)
    List<fundSummary> findALL();
}
