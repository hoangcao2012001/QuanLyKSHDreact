package com.se.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tblLoaiPhong")
public class LoaiPhong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maLoaiPhong;
	
	@Column(name = "tenLoaiPhong")
	private String tenLoaiPhong;

	@Column(name = "moTa")
	private String mota;
	String image;
	@JsonIgnore
	@OneToMany(mappedBy = "maLoaiPhong", fetch = FetchType.EAGER)
	List<Phong> maPhong;

	

	public int getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(int maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public List<Phong> getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(List<Phong> maPhong) {
		this.maPhong = maPhong;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	


	
	
	

	}