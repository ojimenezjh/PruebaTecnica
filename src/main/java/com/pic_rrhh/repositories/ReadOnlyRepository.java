package com.pic_rrhh.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReadOnlyRepository<T,ID> extends JpaRepository<T, ID> {
	List<T> findAll();
	Optional<T> findById(ID id); 
}
