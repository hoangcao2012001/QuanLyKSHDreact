package com.se.service;

import java.util.List;

import com.se.entity.LoaiPhong;

public interface LoaiPhongService {
	public List<LoaiPhong>  findAll();
	public LoaiPhong findLoaiPhongById(int theId);
	
	public LoaiPhong saveLoaiPhong(LoaiPhong loaiPhong) ;
	public LoaiPhong updateLoaiPhong(LoaiPhong loaiPhong) ;
	public void deleteLoaiPhong(Integer id);
	

	
}
