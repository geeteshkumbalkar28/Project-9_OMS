package com.oms.repositories;

import com.oms.Entity.Task;
import com.oms.Entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {

}
