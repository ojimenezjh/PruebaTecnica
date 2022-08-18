package com.pic_rrhh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pic_rrhh.dao.DAOEmployee;
import com.pic_rrhh.service.EmployeeService;

@RestController
@RequestMapping("${api.version}/employees")
public class EmployeeController {
	
	 @Autowired
	 private EmployeeService employeeService;
	 
	 	@PreAuthorize("hasRole('Responsable RRHH')")
		@GetMapping("/find")
		public List<DAOEmployee> getEmployees() {
			return employeeService.findAllEmployees();
	  	}
		
	 	@PreAuthorize("hasRole('Responsable de departament')")
		@GetMapping("/findDepartment/{department}")
		public List<DAOEmployee> getEmployeesByDepartment(@PathVariable String department){
			return employeeService.findByDepartment(department);
		}
			
		/*@PostMapping("/adduser")
		public DAOUser addUsuarios(@RequestBody DAOUser user) {
			return  userService.saveUser(user);
		}*/
		
		/*
		@PostMapping("/users/deleteuser/{id}")
		public String deleteUsuario(@PathVariable int id) {
			return usuarioService.deleteUsuarios(id);
		}
		
		@PutMapping("/users/update/{id}")
		public ResponseEntity<Object> updateUsuario(@RequestBody DAOUsuarios usuarioNuevo, @PathVariable int id) {
			
			usuarioService.updateUsuarios(usuarioNuevo, id);
			return ResponseEntity.ok(Boolean.TRUE);
			
		}*/
		

}
