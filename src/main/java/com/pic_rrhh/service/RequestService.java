package com.pic_rrhh.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pic_rrhh.dao.reqtypes.DAOCustomRequest;
import com.pic_rrhh.dao.reqtypes.DAOSalaryRequest;
import com.pic_rrhh.dao.reqtypes.DAOVacationRequest;
import com.pic_rrhh.dao.reqtypes.ViewCustomRequest;
import com.pic_rrhh.dao.reqtypes.ViewSalaryRequest;
import com.pic_rrhh.dao.reqtypes.ViewVacationRequest;

public interface RequestService {

	// Custom Requests
	public List<ViewCustomRequest> findAllCustomRequests();
	
	public List<ViewCustomRequest> findCustomRequestsByDepartment(String department);
	
	public DAOCustomRequest saveCustomRequest(DAOCustomRequest newRequest);
	
	public ResponseEntity setCustomAcceptedValue(int id, boolean acceptedValue);
	
	// Salary Requests
	public List<ViewSalaryRequest> findAllSalaryRequests();
	
	public List<ViewSalaryRequest> findSalaryRequestsByDepartment(String department);

	public DAOSalaryRequest saveSalaryRequest(DAOSalaryRequest request);
	
	public ResponseEntity setSalaryAcceptedValue(int id, boolean acceptedValue);
	
	// Vacation Requests
	public List<ViewVacationRequest> findAllVacationRequests();
	
	public List<ViewVacationRequest> findVacationRequestsByDepartment(String department);

	public DAOVacationRequest saveVacationRequest(DAOVacationRequest newRequest);
	
	public ResponseEntity setVacationAcceptedValue(int id, boolean acceptedValue);

}
