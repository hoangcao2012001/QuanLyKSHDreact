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

import com.se.entity.Customer;
import com.se.entity.DichVu;
import com.se.service.CustomerService;
import com.se.service.DichVuService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/dichvu")
public class RestDichVu {
	@Autowired
	DichVuService service;
	@GetMapping()
	public List<DichVu> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public DichVu getOne(@PathVariable("id") Integer id) {
		
		return service.findDichVuById(id);
	}
	
	@PostMapping
	public DichVu create(@RequestBody DichVu auth) {
		return service.saveDichVu(auth);
	}
	
	@PutMapping("{id}")
	public DichVu update(@PathVariable("id") Integer id, @RequestBody DichVu auth) {
		return service.updateDichVu(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		 service.deleteDichVu(id);;
	}
}
