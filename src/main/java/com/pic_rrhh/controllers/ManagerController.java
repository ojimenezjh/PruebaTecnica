package com.pic_rrhh.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pic_rrhh.dao.DAOManager;
import com.pic_rrhh.service.ManagerService;

@RestController
@RequestMapping("${api.version}/managers")
public class ManagerController {
	
	 @Autowired
	 private ManagerService managerService;
	 
		@PreAuthorize("hasRole('Responsable RRHH')")
		@GetMapping("/find")
		public List<DAOManager> getManagers() {
			return managerService.findAllManagers();
	  	}			
		
		@PreAuthorize("hasRole('Responsable RRHH')")
		@PostMapping("/add")
		public DAOManager addManagers(@RequestBody DAOManager manager) {
			return  managerService.save(manager);
		}
		

}
