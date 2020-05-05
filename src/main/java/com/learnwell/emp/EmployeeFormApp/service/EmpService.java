package com.learnwell.emp.EmployeeFormApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.learnwell.emp.EmployeeFormApp.model.Emp;
import com.learnwell.emp.EmployeeFormApp.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository repo;
	
	
	//save employee.
	public void save(@ModelAttribute("emp") Emp emp) {
		System.out.println("FirstName is: " +emp.getFirstName());
		System.out.println("FirstName is: " +emp.getLastName());
		System.out.println("FirstName is: " +emp.getEmail());
		repo.save(emp);
	}
	
	
	//list all employees.
	public List<Emp> getAllEmployees(){
		List<Emp> result = (List<Emp>) repo.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Emp>();
		}
	}
	
	//get employee by ID.
	public Emp getEmployeeById(Long id){
		Optional<Emp> employee = repo.findById(id);
		
		if(employee.isPresent()) {
			System.out.println("Employee found.");
			return employee.get();
		} else {
			System.out.println("Employee not found.");
			return null;
		}
	}
	
	//update emp.
	public Emp update(Emp emp) {
		
		Optional<Emp> employee = repo.findById(emp.getId());
		
		if(employee.isPresent()) {
			Emp newEntity = employee.get();
			
			newEntity.setEmail(emp.getEmail());
			newEntity.setFirstName(emp.getFirstName());
			newEntity.setLastName(emp.getLastName());

			newEntity = repo.save(newEntity);
			
			return newEntity;
		}else {
			emp = repo.save(emp);
			return emp;
		}
	}
	
	// delete emp.
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
