package com.se.entity;



import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Table(name = "tblDatPhong")
	public class DatPhong implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Integer maDatPhong;
	
		@ManyToOne  @JoinColumn(name = "maKhachHang")
		Customer maKhachHang;
		
		@ManyToOne  @JoinColumn(name = "maPhong")
		Phong maPhong;
		@Temporal(TemporalType.DATE)
		@Column(name = "ngayBD")
		 Date ngayBD;
		@Temporal(TemporalType.DATE)
		@Column(name = "ngayKT")
		 Date ngayKT;
		@Column(name = "gioNhan")
		Date gioNhan;
		Boolean trangThai;
		@JsonIgnore
		@OneToMany(mappedBy = "maDatPhong")
		List<OrderDichVu> maOrderDichVu;
		public Integer getMaDatPhong() {
			return maDatPhong;
		}
		public void setMaDatPhong(Integer maDatPhong) {
			this.maDatPhong = maDatPhong;
		}
		public Date getNgayBD() {
			return ngayBD;
		}
		public void setNgayBD(Date ngayBD) {
			this.ngayBD = ngayBD;
		}
		public Date getNgayKT() {
			return ngayKT;
		}
		public void setNgayKT(Date ngayKT) {
			this.ngayKT = ngayKT;
		}
		public Date getGioNhan() {
			return gioNhan;
		}
		public void setGioNhan(Date gioNhan) {
			this.gioNhan = gioNhan;
		}
		public Customer getMaKhachHang() {
			return maKhachHang;
		}
		public void setMaKhachHang(Customer maKhachHang) {
			this.maKhachHang = maKhachHang;
		}
		public Phong getMaPhong() {
			return maPhong;
		}
		public void setMaPhong(Phong maPhong) {
			this.maPhong = maPhong;
		}
		public void setMaDatPhong(int maDatPhong) {
			this.maDatPhong = maDatPhong;
		}
		public Boolean getTrangThai() {
			return trangThai;
		}
		public void setTrangThai(Boolean trangThai) {
			this.trangThai = trangThai;
		}
		public List<OrderDichVu> getMaOrderDichVu() {
			return maOrderDichVu;
		}
		public void setMaOrderDichVu(List<OrderDichVu> maOrderDichVu) {
			this.maOrderDichVu = maOrderDichVu;
		}
		
	
}