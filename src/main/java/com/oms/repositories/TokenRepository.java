package com.oms.repositories;

import com.oms.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TokenRepository extends JpaRepository<Token, Integer> {
}
