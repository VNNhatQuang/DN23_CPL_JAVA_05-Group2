package com.DiamondCafe.DiamondCafe.repository;

import com.DiamondCafe.DiamondCafe.model.Phieudatban;

import java.util.List;

/**
 * @CREATED 09/05/2023 - 10:08 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
public interface IPhieudatbanRepository {
    public List<Phieudatban> getAlllistPhieu();

    public List<Phieudatban> getListPhieubyStatus(int status);

    public Phieudatban getPhieubyID(int id);
    public List<Phieudatban> getTimkiemPhieubySDT(String key);

    public int updateTrangthai(int id, int status);

    public int update(Phieudatban pbh);
    public int save(Phieudatban pbh);
    public int delete(int id);
}
