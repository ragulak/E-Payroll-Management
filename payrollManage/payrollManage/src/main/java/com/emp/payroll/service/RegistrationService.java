package com.emp.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.payroll.model.Employee;
import com.emp.payroll.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;
	
	public Employee saveUser(Employee emp){
		return repo.save(emp);
		}
	public Employee fetchEmpByEmailId(String email)
	{
		return repo.findByEmailId(email);
	}
	
	public Employee fetchEmpByEmailIdandPassword(String email, String password)
	{
		return repo.findByEmailIdAndPassword(email, password);
	}
	public Employee fetchEmpByEmailIdandmobNo(String email, String mobNo)
	{
		return repo.findByEmailIdAndMobNo(email, mobNo);
	}

}
