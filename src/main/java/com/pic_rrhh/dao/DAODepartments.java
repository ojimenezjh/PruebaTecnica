package com.pic_rrhh.dao;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class DAODepartments {
	public DAODepartments() {
	}
	@Id
	private int id;
	
	private String name;
}
