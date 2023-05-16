package com.DiamondCafe.DiamondCafe.service;

import com.DiamondCafe.DiamondCafe.model.Phieudatban;

import java.util.List;

/**
 * @CREATED 10/05/2023 - 1:37 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
public interface IPhieudatbanService {
    public List<Phieudatban> getAlllistPhieu();

    public List<Phieudatban> getListPhieubyStatus(int status);

    public Phieudatban getPhieubyID(int id);

    public int updateTrangthai(int id, int status);
    public List<Phieudatban> getTimkiemPhieubySDT(String key);

    public int update(Phieudatban pbh);
    public int save(Phieudatban pbh);
    public int delete(int id);
}
