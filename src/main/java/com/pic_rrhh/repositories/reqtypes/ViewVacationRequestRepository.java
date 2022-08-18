package com.pic_rrhh.repositories.reqtypes;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pic_rrhh.dao.reqtypes.ViewVacationRequest;
import com.pic_rrhh.repositories.ReadOnlyRepository;

@Repository
public interface ViewVacationRequestRepository extends ReadOnlyRepository<ViewVacationRequest, Integer> {
	
	List<ViewVacationRequest> findByDepartment(String department);
	
}