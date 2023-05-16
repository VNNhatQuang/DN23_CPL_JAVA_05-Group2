package com.DiamondCafe.DiamondCafe.service;

import com.DiamondCafe.DiamondCafe.model.Nhanvien;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 10:10 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
public interface INhanvienService {
    public List<Nhanvien> getlistNV();
    public int save(Nhanvien nv);
    public int update(Nhanvien nv);
    public int delete(String id);
    public Nhanvien getNhanvienbyID(String id);

}
