package com.oms.repositories;

import com.oms.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Client getByClientId(Integer id);
}
