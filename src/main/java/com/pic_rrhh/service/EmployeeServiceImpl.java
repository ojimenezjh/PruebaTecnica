package com.pic_rrhh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pic_rrhh.dao.DAOEmployee;
import com.pic_rrhh.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository userRepository;

	
	@Override
	public List<DAOEmployee> findAllEmployees() {
		return userRepository.findAll();
	}

	
	@Override
	public List<DAOEmployee> findByDepartment(String department) {
		return userRepository.findByDepartment(department);
	}

	
	/*@Override
	public DAOUser save(DAOUser newUser) {
		if (newUser != null) {
			DAOUser user = new DAOUser();
			newUser.setIdUser(newUser.getIdUser());
			newUser.setIdentificator(newUser.getIdentificator());
			newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
			newUser.setName(newUser.getName());
			newUser.setSurname(newUser.getSurname());
			newUser.setPhone(newUser.getPhone());
			newUser.setObservations(newUser.getObservations());
			newUser.setMail(newUser.getMail());
			return userRepository.save(newUser);
		}
		return newUser;
	}*/

	@Override
	public String deleteUserById(int id) {
		
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "Usuario eliminado correctamente.";
		}
		return "Error! El usuario no existe";
	}

	/*@Override
	public void updateUser(DAOUser newUser, int id) {
	
			Optional<DAOUser> user = userRepository.findById(id);
			
			DAOUser userEntity = user.get();

			userEntity.setMail(newUser.getMail());
			userEntity.setName(newUser.getName());
			userEntity.setIdentificator(newUser.getIdentificator());
			userEntity.setPassword(newUser.getPassword());
			userEntity.setSurname(newUser.getSurname());
			
			userRepository.save(userEntity);
		
	}*/


	@Override
	public DAOEmployee save(DAOEmployee newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(DAOEmployee newUser, int id) {
		// TODO Auto-generated method stub
		
	}

	

}
