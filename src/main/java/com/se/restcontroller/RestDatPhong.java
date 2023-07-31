package com.se.restcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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

import com.se.entity.DatPhong;
import com.se.service.DatPhongService;




@CrossOrigin("*")
@RestController
@RequestMapping("/rest/datphong")
public class RestDatPhong {
	@Autowired
	DatPhongService service;
	@GetMapping()
	public List<DatPhong> getAll() {
		return service.FindAll();
	}
	@GetMapping("/trangThai")
	public List<DatPhong> findDPByFalseWhereTrangThaiTrue() {
		return service.findDPByFalseWhereTrangThaiTrue();
	}
	@GetMapping("/kh/{maKH}")
	public  List<DatPhong> getAllKHByMaKHAndTrangThai(@PathVariable("maKH") String maKH) {
		return service.findDPByMaKHAndTrangThai(maKH);
	}
	@GetMapping("{id}")
	public DatPhong getOne(@PathVariable("id") Integer id) {
		return service.FindDatPhongById(id);
	}
	@GetMapping("{maPhong}/{ngayBD}/{ngayKT}")
	public List<DatPhong> checkDPByNgayBDandNgayKT(@PathVariable("maPhong") String maPhong,
			@PathVariable("ngayBD") Date ngayBD, @PathVariable("ngayKT") Date ngayKT) {
		return service.checkDPByNgayBDAndNgayKT(maPhong,ngayBD,ngayKT);
	}
	@PostMapping
	public DatPhong create(@RequestBody DatPhong auth) {
		return service.createDatPhong(auth);
	}
	
	@PutMapping("{id}")
	public DatPhong update(@PathVariable("id") Integer id, @RequestBody DatPhong auth) {
		return service.saveDatPhong(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		 service.deleteDatPhong(id);;
	}
}
