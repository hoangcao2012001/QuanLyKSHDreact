package com.se.service;

import java.util.List;


import com.se.entity.Phong;

public interface PhongService {
	public List<Phong> FindALLPhong() ;
	public List<Phong> FindALLPhongByFalse() ;
	// tim kiem
	public Phong FindPhongById(String theId);
	
	public Phong createPhong(Phong Phong) ;
	public Phong savePhong(Phong Phong) ;
	public void deletePhong(String maPhong) ;
	List<Phong> findALLPhongByFalseWhereMaLoaiPhong(Integer id);
	

	
}
