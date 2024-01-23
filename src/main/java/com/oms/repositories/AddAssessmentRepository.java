package com.oms.repositories;

import com.oms.Entity.AddAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddAssessmentRepository extends JpaRepository<AddAssessment, Integer> {
}