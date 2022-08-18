package com.pic_rrhh.repositories.reqtypes;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pic_rrhh.dao.reqtypes.ViewSalaryRequest;
import com.pic_rrhh.repositories.ReadOnlyRepository;

@Repository
public interface ViewSalaryRequestRepository extends ReadOnlyRepository<ViewSalaryRequest, Integer> {
	
	List<ViewSalaryRequest> findByDepartment(String department);
	
}