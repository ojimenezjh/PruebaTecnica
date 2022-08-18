package com.pic_rrhh.dao.reqtypes;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;

import java.sql.Date;

import lombok.*;

@Data
@Entity
@Immutable
@Table(name = "view_custom_requests_details")
public class ViewCustomRequest {
	public ViewCustomRequest() {
	}
	@Id
	private int id;

	private int id_manager;
	
	private String username_manager;
	
	private int id_employee;
	
	private String name_employee;
	
	private String surnames_employee;
	
	private String department;
	
	private String note;
	
	private String accepted;
	
	private Date creation_date;
	
	private Date update_date;
}
