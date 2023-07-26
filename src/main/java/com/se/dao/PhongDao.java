package com.se.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.se.entity.Phong;




public interface PhongDao extends JpaRepository<Phong,  String> {
	@Query("SELECT p FROM Phong p WHERE p.maLoaiPhong.maLoaiPhong LIKE ?1 and p.tinhTrang = true")
	List<Phong> findALLPhongByFalseWhereMaLoaiPhong(Integer id);
//	public Phong FindPhongById(int theId);
	
}
