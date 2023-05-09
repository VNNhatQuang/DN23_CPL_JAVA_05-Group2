package com.DiamondCafe.DiamondCafe.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.sql.Date;

/**
 * @CREATED 04/05/2023 - 9:23 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */

@Data
@Getter
@Setter
public class Nhanvien {
    private String MaTK;
    private String Matkhau;
    private String TenNV;
    private Date NgaySinh;
    private String DiaChi;
    private String SDT;
    private String CMT;
    private String ID_ChucVu;

}
