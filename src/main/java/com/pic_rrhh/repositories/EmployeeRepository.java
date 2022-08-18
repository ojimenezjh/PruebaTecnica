package com.pic_rrhh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pic_rrhh.dao.DAOEmployee;

@Repository
public interface EmployeeRepository extends JpaRepository<DAOEmployee, Integer> {
	
	@Query(value = "SELECT * FROM employees e INNER JOIN employees_departments ed ON e.id = ed.id_employee INNER JOIN departments d ON d.id = ed.id_department WHERE d.name = ?1 ORDER BY e.id", nativeQuery = true)
	  public List<DAOEmployee> findByDepartment(String department);

}
