package com.pic_rrhh.repositories.reqtypes;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pic_rrhh.dao.reqtypes.ViewCustomRequest;
import com.pic_rrhh.repositories.ReadOnlyRepository;

@Repository
public interface ViewCustomRequestRepository extends ReadOnlyRepository<ViewCustomRequest, Integer> {
	
	List<ViewCustomRequest> findByDepartment(String department);
	
}