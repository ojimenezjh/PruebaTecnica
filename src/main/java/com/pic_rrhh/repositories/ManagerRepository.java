package com.pic_rrhh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pic_rrhh.dao.DAOManager;

@Repository
public interface ManagerRepository extends JpaRepository<DAOManager, Integer> {
	
	  DAOManager findByUsername(String username);

}
