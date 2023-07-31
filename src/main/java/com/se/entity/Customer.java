package com.se.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter @Setter
@Table(name = "tbl_customer")
public class Customer implements Serializable{
	@Id
	@Column(name = "ma_khach_hang")
	String maKhachHang;
	@Column(name = "ho_ten")
	 String hoTen;
	@Column(name = "socc")
	 String soCC;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_sinh")
	 Date ngaySinh;	
	@Column(name = "sdt")
	 String sdt;
	@Column(name = "dia_chi")
	 String diaChi;
	@Column(name="`Email`")
	String email;
	String password;
	Boolean isActive;
	Boolean isDisable;
	@Temporal(TemporalType.DATE)
	@Column(name = "Create_date")
	Date createDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "Update_date")
	Date updateDate;
	@JsonIgnore
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	List<Authority> authorities;
	@JsonIgnore
	@OneToMany(mappedBy = "maKhachHang")
	List<DatPhong> maDatPhong;
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	List<Token> Token;
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoCC() {
		return soCC;
	}
	public void setSoCC(String soCC) {
		this.soCC = soCC;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsDisable() {
		return isDisable;
	}
	public void setIsDisable(Boolean isDisable) {
		this.isDisable = isDisable;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<DatPhong> getMaDatPhong() {
		return maDatPhong;
	}
	public void setMaDatPhong(List<DatPhong> maDatPhong) {
		this.maDatPhong = maDatPhong;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
}
