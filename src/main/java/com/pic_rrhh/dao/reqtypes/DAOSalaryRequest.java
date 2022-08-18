package com.pic_rrhh.dao.reqtypes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "salary_requests")
@SecondaryTable(name = "employees")
public class DAOSalaryRequest {
	public DAOSalaryRequest() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int new_salary;

	private int id_manager;
	
	private int id_employee;
	
	private String note;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private boolean accepted;
	
	private Date creation_date;
	
	private Date update_date;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(table ="employees")
	private String name;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(table ="employees")
	private String surnames;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(table ="employees")
	private String identity_document;
}
