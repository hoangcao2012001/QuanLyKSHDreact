package com.se.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter @Setter
@Entity
@Table(name = "tblHoaDon")
	public class HoaDon implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		 int maHoaDon;
		Date	gioTraPhong;
		Double tienPhong;
		Boolean trangThai;
		Date ngayThanhToan;
		int maDp;
		
		public int getMaHoaDon() {
			return maHoaDon;
		}
		public void setMaHoaDon(int maHoaDon) {
			this.maHoaDon = maHoaDon;
		}
		public Date getGioTraPhong() {
			return gioTraPhong;
		}
		public void setGioTraPhong(Date gioTraPhong) {
			this.gioTraPhong = gioTraPhong;
		}
		public Double getTienPhong() {
			return tienPhong;
		}
		public void setTienPhong(Double tienPhong) {
			this.tienPhong = tienPhong;
		}
		public Boolean getTrangThai() {
			return trangThai;
		}
		public void setTrangThai(Boolean trangThai) {
			this.trangThai = trangThai;
		}
		public int getMaDp() {
			return maDp;
		}
		public void setMaDp(int maDp) {
			this.maDp = maDp;
		}
		public Date getNgayThanhToan() {
			return ngayThanhToan;
		}
		public void setNgayThanhToan(Date ngayThanhToan) {
			this.ngayThanhToan = ngayThanhToan;
		}
	
}
