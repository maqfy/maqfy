package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

	@Autowired
	private Repository repo;
	
	public List<menu>listall(String keyword){
		if(keyword != null) {
			return repo.findAll(keyword);
		}
		return repo.findAll();
	}
	
	public void save(menu menu) {
		repo.save(menu);
	}
	
	public menu get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
	
	
	
}
