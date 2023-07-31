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
import com.se.entity.LoaiPhong;
import com.se.service.CustomerService;
import com.se.service.DichVuService;
import com.se.service.LoaiPhongService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/loaiphong")
public class RestLoaiPhong {
	@Autowired
	LoaiPhongService service;
	@GetMapping()
	public List<LoaiPhong> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public LoaiPhong getOne(@PathVariable("id") Integer id) {
		
		return service.findLoaiPhongById(id);
	}
	
	@PostMapping
	public LoaiPhong create(@RequestBody LoaiPhong auth) {
		return service.saveLoaiPhong(auth);
	}
	
	@PutMapping("{id}")
	public LoaiPhong update(@PathVariable("id") Integer id, @RequestBody LoaiPhong auth) {
		return service.updateLoaiPhong(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		 service.deleteLoaiPhong(id);;
	}
}
