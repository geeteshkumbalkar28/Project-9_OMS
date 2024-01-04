package com.oms.repositories;

import com.oms.Entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InterviewRepository extends JpaRepository<Interview, Integer> {
}
