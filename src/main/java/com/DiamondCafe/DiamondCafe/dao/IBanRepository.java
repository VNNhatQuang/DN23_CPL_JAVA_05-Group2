package com.DiamondCafe.DiamondCafe.dao;

/**
 * @CREATED 13/05/2023 - 3:14 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
public interface IBanRepository {
    public int insert();
    public int updateTrangthai(int soBan, int trangthai);
    public int delete(int status);
}
