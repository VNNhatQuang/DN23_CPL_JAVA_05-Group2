package com.DiamondCafe.DiamondCafe.service;

import com.DiamondCafe.DiamondCafe.model.Phieudatban;
import com.DiamondCafe.DiamondCafe.repository.IKhachhangRepository;
import com.DiamondCafe.DiamondCafe.repository.IPhieudatbanRepository;
import com.DiamondCafe.DiamondCafe.repository.PhieudatbanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CREATED 10/05/2023 - 1:39 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Service
public class PhieudatbanServiceImpl implements IPhieudatbanService {
    @Autowired
    IPhieudatbanRepository iPhieudatbanRepository;
    @Override
    public List<Phieudatban> getAlllistPhieu() {
        return iPhieudatbanRepository.getAlllistPhieu();
    }

    @Override
    public List<Phieudatban> getListPhieubyStatus(int status) {
        return iPhieudatbanRepository.getListPhieubyStatus(status);
    }

    @Override
    public Phieudatban getPhieubyID(int id) {
        return iPhieudatbanRepository.getPhieubyID(id);
    }

    @Override
    public int updateTrangthai(int id, int status) {
        return iPhieudatbanRepository.updateTrangthai(id, status);
    }

    @Override
    public List<Phieudatban> getTimkiemPhieubySDT(String key) {
        return iPhieudatbanRepository.getTimkiemPhieubySDT(key);
    }

    @Override
    public int update(Phieudatban pbh) {
        return iPhieudatbanRepository.update(pbh);
    }

    @Override
    public int save(Phieudatban pbh) {
        return iPhieudatbanRepository.save(pbh);
    }

    @Override
    public int delete(int id) {
        return iPhieudatbanRepository.delete(id);
    }
}
