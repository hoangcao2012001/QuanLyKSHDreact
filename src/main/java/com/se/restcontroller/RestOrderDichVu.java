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

import com.se.entity.OrderDichVu;
import com.se.service.OrderDichVuService;
@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderDichVu")
public class RestOrderDichVu {
	@Autowired OrderDichVuService service;
	@GetMapping()
	public List<OrderDichVu> allOrderDichVu() {
		return service.FindALL();
	}

	@GetMapping("{id}")
	public List<OrderDichVu> FindALLOrderByMaDP(@PathVariable("id") Integer id) {
		return service.FindALLOrderByMaDP(id);
	}
	
	@PostMapping
	public OrderDichVu create(@RequestBody OrderDichVu auth) {	
		return service.createOrderDV(auth);
	}
	
	@PutMapping("{id}")
	public OrderDichVu update(@PathVariable("id") Integer id, @RequestBody OrderDichVu auth) {
		return service.updateOrderDV(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		 service.deleteOrderDV(id);;
	}
}
