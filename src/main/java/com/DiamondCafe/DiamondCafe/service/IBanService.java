package com.DiamondCafe.DiamondCafe.service;

/**
 * @CREATED 13/05/2023 - 3:24 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
public interface IBanService {
    public  int insert();
    public int updateTrangthai(int soBan, int TrangThai);
    public int delete(int soBan);

}
