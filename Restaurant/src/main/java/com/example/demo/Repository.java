package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repository extends JpaRepository<Menu, Long>{

	@Query("SELECT m FROM Menu m WHERE "
			+ "CONCAT (m.id, m.name, m.price)"
			+"LIKE %?1%" )
	public List<Menu>findAll(String keyword);
}
