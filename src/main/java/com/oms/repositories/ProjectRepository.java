package com.oms.repositories;

import com.oms.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
