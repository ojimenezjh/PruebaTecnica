package com.pic_rrhh.repositories.reqtypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.pic_rrhh.dao.reqtypes.DAOVacationRequest;

@Repository
public interface VacationRequestRepository extends JpaRepository<DAOVacationRequest, Integer> {
	
	@Query(value = "UPDATE vacation_requests SET accepted= ?2 WHERE id = ?1", nativeQuery = true)
	  public ResponseEntity setVacationAcceptedValue(int id, boolean acceptedvalue);

}