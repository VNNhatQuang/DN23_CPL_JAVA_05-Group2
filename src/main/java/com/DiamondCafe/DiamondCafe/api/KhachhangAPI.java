package com.DiamondCafe.DiamondCafe.api;

import com.DiamondCafe.DiamondCafe.model.Khachhang;
import com.DiamondCafe.DiamondCafe.model.Nhanvien;
import com.DiamondCafe.DiamondCafe.model.ServiceResponse;
import com.DiamondCafe.DiamondCafe.service.IKhachhangService;
import com.DiamondCafe.DiamondCafe.service.INhanvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 5:31 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@RestController
@RequestMapping("/api/admin/khachhang")
public class KhachhangAPI {
    @Autowired
    private IKhachhangService iKhachhangService;

    @GetMapping("/")
    public ResponseEntity<List<Khachhang>> getlistKhachang(){
        List<Khachhang> result = iKhachhangService.getlistKhachhang();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> addNewNhanvien(@RequestBody Khachhang kh){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iKhachhangService.save(kh);
        if (result == 1 ) {
            serviceResponse.setMessage("Costumer Information has been save");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable(name = "id") int MaKH){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iKhachhangService.delete(MaKH);
        if (result == 1 ) {
            serviceResponse.setMessage("Costumer Information has been save");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Khachhang kh){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iKhachhangService.update(kh);
        if (result == 1 ) {
            serviceResponse.setMessage("Employee Information has been save");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/kh/{id}")
    public ResponseEntity<Khachhang> getNhanvien(@PathVariable(name = "id") int MaKH){
        Khachhang result = iKhachhangService.getKhachhangbyID(MaKH);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
