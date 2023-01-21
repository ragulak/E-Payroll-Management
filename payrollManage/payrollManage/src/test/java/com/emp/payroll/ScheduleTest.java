package com.emp.payroll;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.payroll.model.Schedule;
import com.emp.payroll.repository.ScheduleRepository;





@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class Schedule1ApplicationTests {
	@Autowired
	ScheduleRepository srepo;
	
	@Test
	@Order(1)
	public void TestSchedule() {
		Schedule s = new Schedule();
		s.setEmpId(1);
		s.setDate("20/10/2023");
		s.setShift("morninig");
		s.setStartingTime("8am");
		s.setEndTime("4pm");
		s.setDuration("9hrs");
		
		
		srepo.save(s);
		assertNotNull(srepo.findById(1L).get());
		
}
	
	@Test
	@Order(2)
	public void TestReadAllSchedule() {
	List<Schedule> list = srepo.findAll();
	assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void TestSingleScedule() {
	
	Schedule schedule = srepo.findById(1L).get();
     assertEquals(1, schedule.getEmpId());
	}
	
	
	
	
	@Test
	@Order(4)
	public void TestUpdateSchedule() {
		Schedule s = srepo.findById(1L).get();
		s.setShift("afternoon");
		srepo.save(s);
		assertNotEquals("morninig", srepo.findById(1L).get().getEmpId());
	}
	
	@Test
	@Order(5)
	public void TestdeleteSchedule() {
		srepo.deleteById(1L);
		assertThat(srepo.existsById(1L)).isFalse();
		
	}
	

	private void assertNotEquals(String string, long empId) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, long empId) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(Schedule schedule) {
		// TODO Auto-generated method stub
		
	}
	
}








