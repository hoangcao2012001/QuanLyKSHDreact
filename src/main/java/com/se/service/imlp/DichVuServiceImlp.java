package com.se.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.se.dao.DichVuDao;
import com.se.dao.LoaiPhongDao;
import com.se.entity.DichVu;
import com.se.entity.LoaiPhong;
import com.se.service.DichVuService;
import com.se.service.LoaiPhongService;


@Service
public class DichVuServiceImlp implements DichVuService {
	
	@Autowired
	private DichVuDao dao;

	@Override
	public DichVu findDichVuById(Integer theId) {
		// TODO Auto-generated method stub
		return dao.findById(theId).get();
	}

	@Override
	public DichVu saveDichVu(DichVu dichVu) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(dichVu);
	}

	@Override
	public DichVu updateDichVu(DichVu dichVu) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(dichVu);
	}

	@Override
	public void deleteDichVu(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<DichVu> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
	

}