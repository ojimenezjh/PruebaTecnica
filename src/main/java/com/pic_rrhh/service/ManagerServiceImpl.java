package com.pic_rrhh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pic_rrhh.dao.DAOManager;
import com.pic_rrhh.repositories.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public List<DAOManager> findAllManagers() {
		return managerRepository.findAll();
	}

	@Override
	public Optional<DAOManager> findById(int id) {
		return managerRepository.findById(id);
	}

	@Override
	public DAOManager save(DAOManager newManager) {
		if (newManager != null) {
			newManager.setId(newManager.getId());
			newManager.setId_employee(newManager.getId_employee());
			newManager.setUsername(newManager.getUsername());
			newManager.setActive(true);
			newManager.setPassword(bcryptEncoder.encode(newManager.getPassword()));
			return managerRepository.save(newManager);
		}
		return newManager;
	}

	
	@Override
	public String deleteManagerById(int id) {
		
		if (managerRepository.findById(id).isPresent()) {
			managerRepository.deleteById(id);
			return "Usuario eliminado correctamente.";
		}
		return "Error! El usuario no existe";
	}


	@Override
	public void updateManager(DAOManager newManager, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DAOManager> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


}
