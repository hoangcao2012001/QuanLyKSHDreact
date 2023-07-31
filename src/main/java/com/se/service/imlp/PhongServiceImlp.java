package com.se.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import com.se.dao.PhongDao;

import com.se.entity.Phong;

import com.se.service.PhongService;



@Service
public class PhongServiceImlp implements PhongService {
	
	@Autowired
	private PhongDao dao;

	

	
	
	@Override
	public void deletePhong(String maPhong) {
		dao.deleteById(maPhong);;
		
	}

	@Override
	public List<Phong> FindALLPhongByFalse() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Phong> FindALLPhong() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Phong createPhong(Phong Phong) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Phong);
	}

	@Override
	public Phong savePhong(Phong Phong) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Phong);
	}

	@Override
	public Phong FindPhongById(String theId) {
		// TODO Auto-generated method stub
		return dao.findById(theId).get();
	}

	@Override
	public List<Phong> findALLPhongByFalseWhereMaLoaiPhong(Integer id) {
		// TODO Auto-generated method stub
		return dao.findALLPhongByFalseWhereMaLoaiPhong(id);
	}

	


}
