package com.emp.payroll.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.emp.payroll.model.Schedule;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

}
