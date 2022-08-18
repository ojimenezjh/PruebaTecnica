package com.pic_rrhh.dao;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class DAORole {
	public DAORole() {
	}
	@Id
	private int id;

	private String name;
}
