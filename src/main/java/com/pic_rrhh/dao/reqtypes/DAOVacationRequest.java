package com.pic_rrhh.dao.reqtypes;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "vacation_requests")
public class DAOVacationRequest {
	public DAOVacationRequest() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date start_date;
	
	private Date finish_date;
	
	private int id_manager;
	
	private int id_employee;
	
	private String note;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private boolean accepted;
	
	private Date creation_date;
	
	private Date update_date;
	
}
