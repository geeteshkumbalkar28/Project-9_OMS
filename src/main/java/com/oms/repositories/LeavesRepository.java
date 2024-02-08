package com.oms.repositories;

import com.oms.Entity.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavesRepository extends JpaRepository<Leaves, Integer> {
}
