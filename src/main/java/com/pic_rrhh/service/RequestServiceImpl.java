package com.pic_rrhh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pic_rrhh.dao.reqtypes.DAOCustomRequest;
import com.pic_rrhh.dao.reqtypes.DAOSalaryRequest;
import com.pic_rrhh.dao.reqtypes.DAOVacationRequest;
import com.pic_rrhh.dao.reqtypes.ViewCustomRequest;
import com.pic_rrhh.dao.reqtypes.ViewSalaryRequest;
import com.pic_rrhh.dao.reqtypes.ViewVacationRequest;
import com.pic_rrhh.repositories.reqtypes.CustomRequestRepository;
import com.pic_rrhh.repositories.reqtypes.SalaryRequestRepository;
import com.pic_rrhh.repositories.reqtypes.VacationRequestRepository;
import com.pic_rrhh.repositories.reqtypes.ViewCustomRequestRepository;
import com.pic_rrhh.repositories.reqtypes.ViewSalaryRequestRepository;
import com.pic_rrhh.repositories.reqtypes.ViewVacationRequestRepository;

@Service
public class RequestServiceImpl implements RequestService {

	
	@Autowired
	private CustomRequestRepository customRequestRepository;
	
	@Autowired
	private SalaryRequestRepository salaryRequestRepository;
	
	@Autowired
	private VacationRequestRepository vacationRequestRepository;
	
	@Autowired
	private ViewVacationRequestRepository viewVacationRequestRepository;
	
	@Autowired
	private ViewSalaryRequestRepository viewSalaryRequestRepository;
	
	@Autowired
	private ViewCustomRequestRepository viewCustomRequestRepository;
	
	
	// Custom Requests
	@Override
	public DAOCustomRequest saveCustomRequest(DAOCustomRequest newRequest) {
			newRequest.setId(newRequest.getId());
			newRequest.setId_manager(newRequest.getId_manager());
			newRequest.setId_employee(newRequest.getId_employee());
			newRequest.setNote(newRequest.getNote());
			return customRequestRepository.save(newRequest);
	}
	
	@Override
	public ResponseEntity setCustomAcceptedValue(int id, boolean acceptedValue) {
		customRequestRepository.setCustomAcceptedValue(id, acceptedValue);
		return new ResponseEntity(null, HttpStatus.OK);
	}
	
	@Override
	public List<ViewCustomRequest> findAllCustomRequests() {
		return viewCustomRequestRepository.findAll();
	}
	

	@Override
	public List<ViewCustomRequest> findCustomRequestsByDepartment(String department) {
		return viewCustomRequestRepository.findByDepartment(department);
	}
	
	// Salary Requests
	@Override
	public DAOSalaryRequest saveSalaryRequest(DAOSalaryRequest newRequest) {
		newRequest.setId(newRequest.getId());
		newRequest.setId_manager(newRequest.getId_manager());
		newRequest.setId_employee(newRequest.getId_employee());
		newRequest.setNote(newRequest.getNote());
		return salaryRequestRepository.save(newRequest);
	}
	
	@Override
	public ResponseEntity setSalaryAcceptedValue(int id, boolean acceptedValue) {
		salaryRequestRepository.setSalaryAcceptedValue(id, acceptedValue);
		return new ResponseEntity(null, HttpStatus.OK);
	}
	
	@Override
	public List<ViewSalaryRequest> findAllSalaryRequests() {
		return viewSalaryRequestRepository.findAll();
	}
	
	// Vacation requests
	@Override
	public DAOVacationRequest saveVacationRequest(DAOVacationRequest newRequest) {
		newRequest.setId(newRequest.getId());
		newRequest.setId_manager(newRequest.getId_manager());
		newRequest.setId_employee(newRequest.getId_employee());
		newRequest.setNote(newRequest.getNote());
		return vacationRequestRepository.save(newRequest);
	}
	
	@Override
	public ResponseEntity setVacationAcceptedValue(int id, boolean acceptedValue) {
		vacationRequestRepository.setVacationAcceptedValue(id, acceptedValue);
		return new ResponseEntity(null, HttpStatus.OK);
	}

	@Override
	public List<ViewVacationRequest> findAllVacationRequests() {
		return viewVacationRequestRepository.findAll();
	}

	@Override
	public List<ViewVacationRequest> findVacationRequestsByDepartment(String department) {
		return viewVacationRequestRepository.findByDepartment(department);
	}

	@Override
	public List<ViewSalaryRequest> findSalaryRequestsByDepartment(String department) {
		return viewSalaryRequestRepository.findByDepartment(department);
	}
}
