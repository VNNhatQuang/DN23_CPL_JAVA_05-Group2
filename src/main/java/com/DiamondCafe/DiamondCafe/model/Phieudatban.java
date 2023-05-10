package com.DiamondCafe.DiamondCafe.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * @CREATED 09/05/2023 - 9:58 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Data
@Getter
@Setter
public class Phieudatban {
    private int MaPhieu;
    private String TenNguoiDat;
    private Date NgayDat;
    private String SDT;
    private String GioBatdau;
    private int SoBan;
    private int Trangthai;
}
