package com.pic_rrhh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pic_rrhh.dao.reqtypes.DAOCustomRequest;
import com.pic_rrhh.dao.reqtypes.DAOSalaryRequest;
import com.pic_rrhh.dao.reqtypes.DAOVacationRequest;
import com.pic_rrhh.dao.reqtypes.ViewCustomRequest;
import com.pic_rrhh.dao.reqtypes.ViewSalaryRequest;
import com.pic_rrhh.dao.reqtypes.ViewVacationRequest;
import com.pic_rrhh.service.RequestService;

@RestController
@RequestMapping("${api.version}/requests")
public class RequestController {
	
	 @Autowired
	 private RequestService requestService;
	 
	 	// Custom requests
	 	@PreAuthorize("hasRole('Responsable de departament')")
		@PostMapping("/addCustom")
		public DAOCustomRequest add(@RequestBody DAOCustomRequest request) {
			return requestService.saveCustomRequest(request);
		}
	 	
	 	@PreAuthorize("hasRole('Responsable RRHH')")
	 	@PutMapping("/updateCustom/{id}/{acceptedValue}")
		public ResponseEntity updateCustom(@PathVariable int id, @PathVariable boolean acceptedValue) {
			return requestService.setCustomAcceptedValue(id, acceptedValue);
		}
	 	
		@PreAuthorize("hasRole('Responsable RRHH')")
		@GetMapping("/findCustom")
		 public List<ViewCustomRequest> getCustomRequests() {
			return requestService.findAllCustomRequests();
	  	}
		
	 	@PreAuthorize("hasRole('Responsable de departament')")
		@GetMapping("/findCustomDepartment/{department}")
		 public List<ViewCustomRequest> getCustomRequestsByDepartment(@PathVariable String department) {
			return requestService.findCustomRequestsByDepartment(department);
	  	}
	 	
	 	// Salary Requests
	 	@PreAuthorize("hasRole('Responsable de departament')")
		@PostMapping("/addSalary")
		public DAOSalaryRequest add(@RequestBody DAOSalaryRequest request) {
			return requestService.saveSalaryRequest(request);
		}
	 	
	 	@PreAuthorize("hasRole('Responsable RRHH')")
	 	@PutMapping("/updateSalary/{id}/{acceptedValue}")
		public ResponseEntity updateSalary(@PathVariable int id, @PathVariable boolean acceptedValue) {
			return requestService.setSalaryAcceptedValue(id, acceptedValue);
		}
	 	
	 	@PreAuthorize("hasRole('Responsable RRHH')")
		@GetMapping("/findSalary")
		 public List<ViewSalaryRequest> getSalaryRequests() {
			return requestService.findAllSalaryRequests();
	  	}
	 	
	 	@PreAuthorize("hasRole('Responsable de departament')")
		@GetMapping("/findSalaryDepartment/{department}")
		 public List<ViewSalaryRequest> getSalaryRequestsByDepartment(@PathVariable String department) {
			return requestService.findSalaryRequestsByDepartment(department);
	  	}
	 	
	 	// Vacation Requests
	 	@PreAuthorize("hasRole('Responsable de departament')")
		@PostMapping("/addVacation")
		public DAOVacationRequest add(@RequestBody DAOVacationRequest request) {
			return requestService.saveVacationRequest(request);
		}
	 	
	 	@PreAuthorize("hasRole('Responsable RRHH')")
	 	@PutMapping("/updateVacation/{id}/{acceptedValue}")
		public ResponseEntity updateVacation(@PathVariable int id, @PathVariable boolean acceptedValue) {
			return requestService.setVacationAcceptedValue(id, acceptedValue);
		}

	 	@PreAuthorize("hasRole('Responsable RRHH')")
		@GetMapping("/findVacation")
		 public List<ViewVacationRequest> getVacationRequests() {
			return requestService.findAllVacationRequests();
	  	}
	 	
	 	@PreAuthorize("hasRole('Responsable de departament')")
		@GetMapping("/findVacationDepartment/{department}")
		 public List<ViewVacationRequest> getVacationRequestsByDepartment(@PathVariable String department) {
			return requestService.findVacationRequestsByDepartment(department);
	  	}

}
