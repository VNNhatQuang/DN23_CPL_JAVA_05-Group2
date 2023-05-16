package com.DiamondCafe.DiamondCafe.repository;

import com.DiamondCafe.DiamondCafe.model.Khachhang;


import java.util.List;

/**
 * @CREATED 04/05/2023 - 5:06 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
public interface IKhachhangRepository {
    public List<Khachhang> getlistKhachhang();
    public int save(Khachhang nv);
    public int update(Khachhang nv);
    public int delete(int id);
    public Khachhang getKhachhangbyID(int id);
}
