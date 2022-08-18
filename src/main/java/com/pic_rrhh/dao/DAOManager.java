package com.pic_rrhh.dao;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Set;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "managers")
@SecondaryTable(name = "employees")
public class DAOManager {
	public DAOManager() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int id_employee;

	private String username;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	private boolean active;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(table = "employees")
	private String name;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(table = "employees")
	private String surnames;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "employees_departments",
			joinColumns = {@JoinColumn(name = "id_employee")},
			inverseJoinColumns = {@JoinColumn(name = "id_department")}
	)

	Set<DAODepartments> departments = new HashSet<>();	
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
		@JoinTable(
				name = "roles_managers",
				joinColumns = {@JoinColumn(name = "id_manager")},
				inverseJoinColumns = {@JoinColumn(name = "id_role")}
		)

	Set<DAORole> roles = new HashSet<>();
}
