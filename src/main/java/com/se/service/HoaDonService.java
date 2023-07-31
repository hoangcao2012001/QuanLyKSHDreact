package com.se.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.se.entity.HoaDon;
import com.se.entity.LoaiPhong;



public interface HoaDonService {
	public List<HoaDon>  findAll();
	public HoaDon findHoaDonById(int theId);
	public HoaDon saveHoaDon(HoaDon hoaDon) ;
	public HoaDon updateHoaDon(HoaDon hoaDon) ;
	public void deleteHoaDon(Integer id);
	public List<HoaDon> findHDByFalse();
	public List<HoaDon> findHDByTrue();
	public List<HoaDon> findHDByNgayThanhToan(Date ngay);
}
