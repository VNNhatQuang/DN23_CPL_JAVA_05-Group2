package com.DiamondCafe.DiamondCafe.service;

import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.NhanVien;

/**
 * @CREATED 04/05/2023 - 10:10 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
public interface INhanvienService {
    public List<NhanVien> getlistNV();
    public int save(NhanVien nv);
    public int update(NhanVien nv);
    public int delete(String id);
    public NhanVien getNhanvienbyID(String id);

}