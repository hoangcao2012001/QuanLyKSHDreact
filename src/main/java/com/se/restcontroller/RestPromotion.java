package com.se.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.Promotion;
import com.se.service.PromotionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/khuyenmai")
public class RestPromotion {
	@Autowired
	PromotionService service;
	@GetMapping()
	public List<Promotion> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Promotion getOne(@PathVariable("id") String id) {
		
		return service.findById(id);
	}
	
	@PostMapping
	public Promotion create(@RequestBody Promotion auth) {
		return service.create(auth);
	}
	
	@PutMapping("{id}")
	public Promotion update(@PathVariable("id") String id, @RequestBody Promotion auth) {
		return service.update(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		 service.delete(id);;
	}
}
