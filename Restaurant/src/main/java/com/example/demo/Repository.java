package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repository extends JpaRepository<menu, Long>{

	@Query("SELECT m FROM menu m WHERE "
			+ "CONCAT (m.id, m.name, m.price)"
			+"LIKE %?1%")
	public List<menu>findAll(String keyword);
}
