package com.oms.repositories;

import com.oms.Entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;


public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);


}
