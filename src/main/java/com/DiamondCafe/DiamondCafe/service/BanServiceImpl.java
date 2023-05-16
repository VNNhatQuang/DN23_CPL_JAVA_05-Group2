package com.DiamondCafe.DiamondCafe.service;

import com.DiamondCafe.DiamondCafe.repository.IBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @CREATED 13/05/2023 - 3:25 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Service
public class BanServiceImpl implements IBanService {
    @Autowired
    private  IBanRepository iBanRepository;
    @Override
    public int insert() {
        return iBanRepository.insert();
    }

    @Override
    public int updateTrangthai(int soBan, int TrangThai) {
        return iBanRepository.updateTrangthai(soBan,TrangThai);
    }

    @Override
    public int delete(int soBan) {
        return iBanRepository.delete(soBan);
    }
}
