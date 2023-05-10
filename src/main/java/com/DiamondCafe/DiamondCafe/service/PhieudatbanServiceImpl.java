package com.DiamondCafe.DiamondCafe.service;

import com.DiamondCafe.DiamondCafe.model.Phieudatban;
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
    IPhieudatbanService iPhieudatbanService;
    @Override
    public List<Phieudatban> getAlllistPhieu() {
        return iPhieudatbanService.getAlllistPhieu();
    }

    @Override
    public List<Phieudatban> getListPhieubyStatus(int status) {
        return iPhieudatbanService.getListPhieubyStatus(status);
    }

    @Override
    public Phieudatban getPhieubyID(int id) {
        return iPhieudatbanService.getPhieubyID(id);
    }

    @Override
    public int update(Phieudatban pbh) {
        return iPhieudatbanService.update(pbh);
    }

    @Override
    public int save(Phieudatban pbh) {
        return iPhieudatbanService.save(pbh);
    }

    @Override
    public int delete(int id) {
        return iPhieudatbanService.delete(id);
    }
}
