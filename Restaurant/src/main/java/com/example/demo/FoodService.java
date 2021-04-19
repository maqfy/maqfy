package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class FoodService {

	@Autowired
	private Repository repo;
	
	public List<Menu>listall(String keyword){
		
		  if(keyword != null) { 
			  return repo.findAll(keyword); 
			  }
		 
		return repo.findAll();
	}
	
	public void save(Menu menu) {
		repo.save(menu);
	}
	
	public Menu get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public List<Menu> findAll(@RequestParam Optional<String> keyword) {
		// TODO Auto-generated method stub
		return repo.findAll(keyword.orElse(null));
	}


	
	
	
	
	
}
