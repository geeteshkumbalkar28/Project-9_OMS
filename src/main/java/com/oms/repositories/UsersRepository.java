package com.oms.repositories;

import com.oms.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Integer> {
}
