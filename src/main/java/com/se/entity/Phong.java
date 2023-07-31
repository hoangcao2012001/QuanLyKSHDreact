package com.se.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "tblPhong")
public class Phong implements Serializable{
	@Id
	@Column(name = "maPhong")
	String maPhong;
	@Column(name = "maKhuyenMai")
	String maKhuyenMai;
	@Column(name = "giaPhong")
	Double giaPhong;
	@Column(name = "tinhTrang")
	Boolean tinhTrang;		
	@JsonIgnore
	@OneToMany(mappedBy = "maPhong", fetch = FetchType.EAGER)
	List<DatPhong> maDatPhong;

	@ManyToOne @JoinColumn(name = "maLoaiPhong")
	LoaiPhong maLoaiPhong;
	
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	
	public Double getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(Double giaPhong) {
		this.giaPhong = giaPhong;
	}
	public Boolean getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	public LoaiPhong getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(LoaiPhong maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public List<DatPhong> getMaDatPhong() {
		return maDatPhong;
	}
	public void setMaDatPhong(List<DatPhong> maDatPhong) {
		this.maDatPhong = maDatPhong;
	}

	
	
}
	