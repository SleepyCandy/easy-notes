package com.example.easynotes.repository;

import com.example.easynotes.model.amSummary;
import com.example.easynotes.model.fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface am_summaryRepository extends JpaRepository<amSummary, Integer> {
    @Query(value = "SELECT * from am_summary a where asset_manage_company_id=?2 and asset_class_id=?1",nativeQuery = true)
    amSummary findfund(int asset_class, int company_id);
}