package com.se.service.imlp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.DatPhongDao;
import com.se.entity.DatPhong;
import com.se.service.DatPhongService;





@Service
public class DatPhongServiceImlp  implements DatPhongService {
	
	@Autowired
	private DatPhongDao datPhongDao ;

	@Override
	public DatPhong FindDatPhongById(int theId) {
		// TODO Auto-generated method stub
		return datPhongDao.findById(theId).get();
	}

	@Override
	public DatPhong FindDatPhongByKhachHangId(String maKhachHang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatPhong FindDatPhongBySoCC(String SoCC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatPhong createDatPhong(DatPhong datPhong) {
		datPhong.setTrangThai(true);
		return datPhongDao.saveAndFlush(datPhong);
	}

	@Override
	public DatPhong saveDatPhong(DatPhong datPhong) {
		return datPhongDao.saveAndFlush(datPhong);
		
	}

	@Override
	public void deleteDatPhong(Integer id) {
		datPhongDao.deleteById(id);;
		
	}

	@Override
	public List<DatPhong> FindAll() {
		// TODO Auto-generated method stub
		return datPhongDao.findAll();
	}

	@Override
	public List<DatPhong> findDPByFalseWhereTrangThaiTrue() {
		// TODO Auto-generated method stub
		return datPhongDao.findDPByFalseWhereTrangThaiTrue();
	}

	@Override
	public List<DatPhong> checkDPByNgayBDAndNgayKT(String maPhong, Date ngayBD, Date ngayKT) {
		// TODO Auto-generated method stub
		return datPhongDao.checkDPByNgayBDAndNgayKT(maPhong, ngayBD, ngayKT);
	}

	@Override
	public List<DatPhong> findDPByMaKHAndTrangThai(String maKH) {
		// TODO Auto-generated method stub
		return datPhongDao.findDPByMaKHAndTrangThai(maKH);
	}

	
}
