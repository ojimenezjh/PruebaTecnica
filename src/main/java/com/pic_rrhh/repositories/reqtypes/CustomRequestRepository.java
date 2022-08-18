package com.pic_rrhh.repositories.reqtypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.pic_rrhh.dao.reqtypes.DAOCustomRequest;

@Repository
public interface CustomRequestRepository extends JpaRepository<DAOCustomRequest, Integer> {
	
	@Query(value = "UPDATE custom_requests SET accepted= ?2 WHERE id = ?1", nativeQuery = true)
	  public ResponseEntity<?> setCustomAcceptedValue(int id, boolean acceptedvalue);
	
}