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
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tblDichVu")
public class DichVu implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "maDichVu")
		int maDichVu;

		@Column(name = "tenDichVu")
		String tenDichVu;

		@Column(name = "moTaDv")
		String moTaDV;

		@Column(name = "donGia")
		Double donGia;
		
		@Column(name = "donVi")
		String donVi;
		@Column(name = "ghiChu")
		String ghiChu;
		
		@JsonIgnore
		@OneToMany(mappedBy = "maDichVu", fetch = FetchType.EAGER)
		List<OrderDichVu> maOrderDichVu;
		
		public int getMaDichVu() {
			return maDichVu;
		}
		public void setMaDichVu(int maDichVu) {
			this.maDichVu = maDichVu;
		}
		public String getTenDichVu() {
			return tenDichVu;
		}
		public void setTenDichVu(String tenDichVu) {
			this.tenDichVu = tenDichVu;
		}
		public String getMoTaDV() {
			return moTaDV;
		}
		public void setMoTaDV(String moTaDV) {
			this.moTaDV = moTaDV;
		}
		public Double getDonGia() {
			return donGia;
		}
		public void setDonGia(Double donGia) {
			this.donGia = donGia;
		}
		public String getDonVi() {
			return donVi;
		}
		public void setDonVi(String donVi) {
			this.donVi = donVi;
		}
		public String getGhiChu() {
			return ghiChu;
		}
		public void setGhiChu(String ghiChu) {
			this.ghiChu = ghiChu;
		}
		public List<OrderDichVu> getMaOrderDichVu() {
			return maOrderDichVu;
		}
		public void setMaOrderDichVu(List<OrderDichVu> maOrderDichVu) {
			this.maOrderDichVu = maOrderDichVu;
		}
		
		

}
