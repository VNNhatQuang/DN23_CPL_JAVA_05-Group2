package com.DiamondCafe.DiamondCafe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.Mon_Quy;
import com.DiamondCafe.DiamondCafe.dao.MonDao;
import com.DiamondCafe.DiamondCafe.service.MonService;

@Service
public class MonServiceImpl implements MonService {

	@Autowired
	private MonDao monDao;
	
	@Override
	public List<Mon_Quy> GetList(int page, int pageSize, String searchValue) {
		return monDao.GetList(page, pageSize, searchValue);
	}

	@Override
	public List<Mon_Quy> GetAllMon() {
		// TODO Auto-generated method stub
		return monDao.GetAllMon();
	}

	@Override
	public void CreateMon(Mon_Quy m) {
		// TODO Auto-generated method stub
		monDao.CreateMon(m);
	}

	@Override
	public void UpdateMon(Mon_Quy m) {
		// TODO Auto-generated method stub
		monDao.UpdateMon(m);
	}

	@Override
	public void DeleteMon(int maMon) {
		// TODO Auto-generated method stub
		monDao.DeleteMon(maMon);
	}

	@Override
	public Mon_Quy getMon(int id) {
		// TODO Auto-generated method stub
		return monDao.getMon(id);
	}

	@Override
	public int Count(String searchValue) {
		return monDao.Count(searchValue);
	}

}
