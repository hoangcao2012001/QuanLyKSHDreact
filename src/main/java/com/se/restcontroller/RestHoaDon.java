package com.se.restcontroller;

import java.util.Date;
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
import com.se.entity.HoaDon;
import com.se.service.CustomerService;
import com.se.service.DichVuService;
import com.se.service.HoaDonService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/hoadon")
public class RestHoaDon {
	@Autowired
	HoaDonService service;
	@GetMapping()
	public List<HoaDon> findAll() {
		return service.findAll();
	}
	@GetMapping("/false")
	public List<HoaDon> findHDByFalse() {
		return service.findHDByFalse();
	}
	@GetMapping("/true")
	public List<HoaDon> findHDByTrue() {
		return service.findHDByTrue();
	}
	@GetMapping("{id}")
	public HoaDon getOne(@PathVariable("id") Integer id) {
		return service.findHoaDonById(id);
	}
	@GetMapping("/ngay/{id}")
	public List<HoaDon> getAllByNgayThanhToan(@PathVariable("id") Date ngayTT) {
		return service.findHDByNgayThanhToan(ngayTT);
	}
	
	@PostMapping
	public HoaDon create(@RequestBody HoaDon auth) {
		return service.saveHoaDon(auth);
	}
	
	@PutMapping("{id}")
	public HoaDon update(@PathVariable("id") Integer id, @RequestBody HoaDon auth) {
		return service.updateHoaDon(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		 service.deleteHoaDon(id);;
	}
}
