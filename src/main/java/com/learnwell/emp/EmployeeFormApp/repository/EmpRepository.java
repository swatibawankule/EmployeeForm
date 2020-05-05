package com.learnwell.emp.EmployeeFormApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learnwell.emp.EmployeeFormApp.model.Emp;

@Repository
public interface EmpRepository extends CrudRepository<Emp, Long>{

}
