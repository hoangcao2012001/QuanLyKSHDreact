package com.se.service;

import java.util.Date;
import java.util.List;

import com.se.entity.Customer;
import com.se.entity.DatPhong;





public interface DatPhongService {
	public List<DatPhong> findDPByMaKHAndTrangThai(String maKH);
	public List<DatPhong> FindAll();
	public List<DatPhong> findDPByFalseWhereTrangThaiTrue();
	// tim kiem
	public DatPhong FindDatPhongById(int theId);
	public DatPhong FindDatPhongByKhachHangId(String maKhachHang);
	public DatPhong FindDatPhongBySoCC(String SoCC);

	public DatPhong createDatPhong(DatPhong datPhong) ;
	public DatPhong saveDatPhong(DatPhong datPhong) ;	
	public void deleteDatPhong(Integer id);
	public List<DatPhong> checkDPByNgayBDAndNgayKT(String maPhong, Date ngayBD , Date ngayKT);
	

	
}
