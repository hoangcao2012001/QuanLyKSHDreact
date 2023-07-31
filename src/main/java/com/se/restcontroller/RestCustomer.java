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
import com.se.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/customers")
public class RestCustomer {
	@Autowired
	CustomerService service;
	@GetMapping()
	public List<Customer> getAll() {
		return service.FindAll();
	}
	
	@GetMapping("{id}")
	public Customer getOne(@PathVariable("id") String id) {
		
		return service.FindCustomeṛ̣̣̣ById(id);
	}
	
	@PostMapping
	public Customer create(@RequestBody Customer auth) {
		return service.createCustomer(auth);
	}
	
	@PutMapping("{id}")
	public Customer update(@PathVariable("id") String id, @RequestBody Customer auth) {
		return service.saveCustomer(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		 service.deleteCustomerByID(id);;
	}
}
