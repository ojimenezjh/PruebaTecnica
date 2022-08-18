package com.pic_rrhh.service;

import java.util.List;
import java.util.Optional;

import com.pic_rrhh.dao.DAOManager;

public interface ManagerService {

	
	public List<DAOManager> findAllManagers();
	
	public Optional<DAOManager> findById(int id);
	
	public List<DAOManager> findByUsername(String username);

	public DAOManager save(DAOManager newManager);

	public String deleteManagerById(int id);

	public void updateManager (DAOManager newManager, int id);

}
