package com.se.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tblPromotion")
public class Promotion implements Serializable{
	@Id
	String maKhuyenMai;
	@Temporal(TemporalType.DATE)
	Date ngayBatDau;
	@Temporal(TemporalType.DATE)
	Date ngayKetThuc;
	Double soTien;
	String moTa;
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public Double getSoTien() {
		return soTien;
	}
	public void setSoTien(Double soTien) {
		this.soTien = soTien;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
