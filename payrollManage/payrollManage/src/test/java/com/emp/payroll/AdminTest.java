package com.emp.payroll;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.emp.payroll.model.Admin;
import com.emp.payroll.model.Employee;
import com.emp.payroll.repository.AdminRegistrationRepository;
import com.emp.payroll.repository.AdminRepository;
import com.emp.payroll.repository.RegistrationRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AdminTest {

	@Autowired
	AdminRegistrationRepository adrRepo;
	@Test
	@Order(1)
	public void testcreate() {
		Admin a = new Admin();
		a.setId(10014);
		a.setEmailId("sujith12345@gmail.com");
		a.setPassword("sujith123");
		a.setUserName("sujith");
		adrRepo.save(a);
		assertNotNull(adrRepo.findById(10014).get());

	}
	@Test
	@Order(2)
	public void testReadAll() {
		List<Admin> list = adrRepo.findAll();
		assertThat(list).size().isGreaterThan(0);

	}
	
	@Test
	@Order(3)
	public void testSingleProduct() {
		Admin admin=adrRepo.findById(10000).get();
		assertEquals("admin",admin.getPassword());
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		Admin a=adrRepo.findById(10000).get();
		a.setPassword("sujith1234");
		adrRepo.save(a);
		assertNotEquals("admin",adrRepo.findById(10000).get().getPassword());
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		adrRepo.deleteById(10014);
		assertThat(adrRepo.existsById(10014)).isFalse();
		}
}