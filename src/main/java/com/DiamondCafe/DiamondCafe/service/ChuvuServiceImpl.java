package com.DiamondCafe.DiamondCafe.service;

import com.DiamondCafe.DiamondCafe.model.Chucvu;
import com.DiamondCafe.DiamondCafe.repository.IChucvuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CREATED 16/05/2023 - 3:17 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Service
public class ChuvuServiceImpl implements IChucvuService{
    @Autowired
    private IChucvuRepository iChucvuRepository;
    @Override
    public List<Chucvu> getChucvuList() {
        return iChucvuRepository.getAllChucvu();
    }
}
