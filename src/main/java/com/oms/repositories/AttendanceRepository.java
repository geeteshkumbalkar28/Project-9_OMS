package com.oms.repositories;

import com.oms.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
}
