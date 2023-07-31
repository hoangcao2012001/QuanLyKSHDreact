package com.se.service.imlp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.HoaDonDao;
import com.se.entity.HoaDon;
import com.se.entity.LoaiPhong;
import com.se.service.HoaDonService;






@Service
public class HoaDonServiceImlp   implements HoaDonService {
	
	@Autowired
	private HoaDonDao dao ;

	@Override
	public HoaDon findHoaDonById(int theId) {
		// TODO Auto-generated method stub
		return dao.findById(theId).get();
	}

	@Override
	public HoaDon saveHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(hoaDon);
	}

	

	@Override
	public void deleteHoaDon(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<HoaDon> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public HoaDon updateHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(hoaDon);
	}

	@Override
	public List<HoaDon> findHDByFalse() {
		// TODO Auto-generated method stub
		return dao.findHDByFalse();
	}

	@Override
	public List<HoaDon> findHDByTrue() {
		// TODO Auto-generated method stub
		return dao.findHDByTrue();
	}

	@Override
	public List<HoaDon> findHDByNgayThanhToan(Date ngay) {
		// TODO Auto-generated method stub
		return dao.findHDByNgayThanhToan(ngay);
	}

	
	
	
}
