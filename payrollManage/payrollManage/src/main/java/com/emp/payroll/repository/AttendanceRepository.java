package com.emp.payroll.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.emp.payroll.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

}
