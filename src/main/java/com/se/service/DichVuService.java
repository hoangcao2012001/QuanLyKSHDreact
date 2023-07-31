package com.se.service;





import java.util.List;

import com.se.entity.DichVu;


public interface DichVuService {
	public List<DichVu> findAll();
	public DichVu findDichVuById(Integer theId);
	public DichVu saveDichVu(DichVu dichVu) ;
	public DichVu updateDichVu(DichVu dichVu) ;
	public void deleteDichVu(Integer id);
	

	
}
