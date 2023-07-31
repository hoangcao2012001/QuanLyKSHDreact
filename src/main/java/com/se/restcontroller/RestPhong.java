package com.se.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.DatPhong;
import com.se.entity.Phong;
import com.se.service.DatPhongService;
import com.se.service.PhongService;





@RestController
@RequestMapping("/rest/phong")
public class RestPhong {
	@Autowired
	PhongService service;
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Phong> getAll() {
		return service.FindALLPhong();
	}
	@GetMapping("/seachLoai/{id}")
	public List<Phong> getAllPhongbyMaLoaiAnhFalse(@PathVariable("id") Integer id) {
		System.out.print(id);
		return service.findALLPhongByFalseWhereMaLoaiPhong(id);
	}
	@GetMapping("{id}")
	public Phong getOne(@PathVariable("id") String id) {
		return service.FindPhongById(id);
	}
	
	@PostMapping
	public Phong create(@RequestBody Phong auth) {
		return service.createPhong(auth);
	}
	
	@PutMapping("{id}")
	public Phong update(@PathVariable("id") String id, @RequestBody Phong auth) {
		return service.savePhong(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		 service.deletePhong(id);;
	}
}
