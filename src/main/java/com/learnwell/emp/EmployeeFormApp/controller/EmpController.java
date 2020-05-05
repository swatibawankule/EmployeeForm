package com.learnwell.emp.EmployeeFormApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnwell.emp.EmployeeFormApp.model.Emp;
import com.learnwell.emp.EmployeeFormApp.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	EmpService service;

	@GetMapping("/form")
	public String getForm() {
		return "addeditemp";
	}

	// add emp.
	@RequestMapping("/createEmployee")
	public String save(Emp emp) {
		service.save(emp);
		return "redirect:/viewemp";
	}

	// list empls.
	@RequestMapping("/viewemp")
	public String getAllEmployees(Model model) {
		List<Emp> list = service.getAllEmployees();

		model.addAttribute("employees", list);
		return "listempls";
	}

	// edit emp.
	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable Long id, Model m) {
		Emp emp = service.getEmployeeById(id);
		m.addAttribute("employees", emp);
		return "empeditform";
	}

	// edit save.
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("emp") Emp emp) {
		service.update(emp);
		return "redirect:/viewemp";
	}
	
	// delete emp.
	@RequestMapping(value="/delete/{id}")    
    public String delete(@PathVariable Long id){    
        service.delete(id);    
        return "redirect:/viewemp";    
    }     

}
