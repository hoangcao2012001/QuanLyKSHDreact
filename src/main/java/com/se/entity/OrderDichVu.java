package com.se.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "order_dich_vu")
public class OrderDichVu implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maOrderDichVu;
	Date ngayOrder;
	int soLuong;
	@ManyToOne  @JoinColumn(name = "maDatPhong")
	DatPhong maDatPhong;

	@ManyToOne  @JoinColumn(name = "maDichVu")
	DichVu maDichVu;
	
	
	public int getMaOrderDichVu() {
		return maOrderDichVu;
	}
	public void setMaOrderDichVu(int maOrderDichVu) {
		this.maOrderDichVu = maOrderDichVu;
	}
	public Date getNgayOrder() {
		return ngayOrder;
	}
	public void setNgayOrder(Date ngayOrder) {
		this.ngayOrder = ngayOrder;
	}
	public DatPhong getMaDatPhong() {
		return maDatPhong;
	}
	public void setMaDatPhong(DatPhong maDatPhong) {
		this.maDatPhong = maDatPhong;
	}
	public DichVu getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(DichVu maDichVu) {
		this.maDichVu = maDichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}
