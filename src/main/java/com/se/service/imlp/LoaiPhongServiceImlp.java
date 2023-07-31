package com.se.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.se.dao.LoaiPhongDao;
import com.se.entity.LoaiPhong;
import com.se.service.LoaiPhongService;



@Service
public class LoaiPhongServiceImlp implements LoaiPhongService {
	
	@Autowired
	private LoaiPhongDao dao;

	@Override
	public LoaiPhong findLoaiPhongById(int theId) {
		// TODO Auto-generated method stub
		return dao.findById(theId).get();
	}

	@Override
	public LoaiPhong saveLoaiPhong(LoaiPhong loaiPhong) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(loaiPhong);
	}

	@Override
	public LoaiPhong updateLoaiPhong(LoaiPhong loaiPhong) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(loaiPhong);
	}

	@Override
	public void deleteLoaiPhong(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<LoaiPhong> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
}
