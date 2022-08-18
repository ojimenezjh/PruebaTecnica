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
	 
		@GetMapping("/find")
		public List<DAOManager> getManagers() {
			return managerService.findAllManagers();
	  	}
			
		@GetMapping("/findId/{id}")
		public Optional<DAOManager> getManagersById(@PathVariable int id){
			return managerService.findById(id);
		}
		
		@GetMapping("/findName/{name}")
		public List<DAOManager> getManagersByName(@PathVariable String username){
			return managerService.findByUsername(username);
		}
		
		@PostMapping("/add")
		@PreAuthorize("hasRole('Responsable RRHH')")
		public DAOManager addManagers(@RequestBody DAOManager manager) {
			return  managerService.save(manager);
		}
		
		
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
