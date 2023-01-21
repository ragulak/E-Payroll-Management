package com.emp.payroll.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.emp.payroll.model.Leave;


@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {

}
