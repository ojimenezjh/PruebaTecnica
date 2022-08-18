package com.pic_rrhh.service;

import java.util.List;

import com.pic_rrhh.dao.DAOEmployee;


public interface EmployeeService {

	
	public List<DAOEmployee> findAllEmployees();
	
	public List<DAOEmployee> findByDepartment(String department);
	
	public DAOEmployee save(DAOEmployee newUser);

	public String deleteUserById(int id);

	public void updateUser(DAOEmployee newUser, int id);

}
