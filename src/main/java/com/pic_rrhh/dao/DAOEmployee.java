package com.pic_rrhh.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class DAOEmployee {
	public DAOEmployee() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String surnames;
	
	private String identity_document;
	
	private String hire_date;
	
	private String birth_date;
	
	private String job_title;
	
	private String email;
	
	private String phone;
	
	private float salary;
	
	private boolean active;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "employees_departments",
			joinColumns = {@JoinColumn(name = "id_employee")},
			inverseJoinColumns = {@JoinColumn(name = "id_department")}
	)

	Set<DAODepartments> departments = new HashSet<>();
}
