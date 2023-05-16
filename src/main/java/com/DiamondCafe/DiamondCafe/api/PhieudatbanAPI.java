package com.DiamondCafe.DiamondCafe.api;

import com.DiamondCafe.DiamondCafe.model.Khachhang;
import com.DiamondCafe.DiamondCafe.model.Phieudatban;
import com.DiamondCafe.DiamondCafe.service.IKhachhangService;
import com.DiamondCafe.DiamondCafe.service.IPhieudatbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @CREATED 10/05/2023 - 4:28 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@RestController
@RequestMapping("/api/phieu-dat-ban")

public class PhieudatbanAPI {
    @Autowired
    private IPhieudatbanService iPhieudatbanService;

    @GetMapping("/")
    public ResponseEntity<List<Phieudatban>> getlistKhachang(){
        List<Phieudatban> result = iPhieudatbanService.getAlllistPhieu();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
