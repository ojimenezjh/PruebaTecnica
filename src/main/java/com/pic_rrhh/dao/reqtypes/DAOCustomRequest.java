package com.pic_rrhh.dao.reqtypes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "custom_requests")
@SecondaryTable(name = "employees")
public class DAOCustomRequest {
	public DAOCustomRequest() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

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
