package com.se.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se.entity.LoaiPhong;


public interface LoaiPhongDao extends JpaRepository<LoaiPhong, Integer> {

}
