package com.DiamondCafe.DiamondCafe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.dao.AdminLoaiMonDao;
import com.DiamondCafe.DiamondCafe.service.AdminLoaiMonService;

@Service
public class AdminLoaiMonServiceImpl implements AdminLoaiMonService {

	@Autowired
	private AdminLoaiMonDao lmDao;
	
	@Override
	public List<LoaiMon> getList(int page, int pageSize, String searchValue) {
		// TODO Auto-generated method stub
		return lmDao.getList(page, pageSize, searchValue);
	}

	@Override
	public void Add(LoaiMon lm) {
		// TODO Auto-generated method stub
		lmDao.Add(lm);
	}

	@Override
	public void Update(LoaiMon lm) {
		// TODO Auto-generated method stub
		lmDao.Update(lm);
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		lmDao.Delete(id);
	}

	@Override
	public LoaiMon getLoaiMon(int id) {
		// TODO Auto-generated method stub
		return lmDao.getLoaiMon(id);
	}
	
	@Override
	public int Count(String searchValue) {
		// TODO Auto-generated method stub
		return lmDao.Count(searchValue);
	}

	@Override
	public List<LoaiMon> getAll() {
		// TODO Auto-generated method stub
		return lmDao.getAll();
	}


}