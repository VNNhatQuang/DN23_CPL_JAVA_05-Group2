package com.DiamondCafe.DiamondCafe.service;

import com.DiamondCafe.DiamondCafe.model.Khachhang;
import com.DiamondCafe.DiamondCafe.repository.IKhachhangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 5:18 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Service
public class KhachhangServiceImpl implements IKhachhangService{
    @Autowired
    private IKhachhangRepository khachhangRepository;

    @Override
    public List<Khachhang> getlistKhachhang() {
        return khachhangRepository.getlistKhachhang();
    }

    @Override
    public int save(Khachhang nv) {
        return khachhangRepository.save(nv);
    }

    @Override
    public int update(Khachhang nv) {
        return khachhangRepository.update(nv);
    }

    @Override
    public int delete(int id) {
        return khachhangRepository.delete(id);
    }

    @Override
    public Khachhang getKhachhangbyID(int id) {
        return khachhangRepository.getKhachhangbyID(id);
    }
}
