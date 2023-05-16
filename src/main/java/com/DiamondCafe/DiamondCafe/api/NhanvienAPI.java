package com.DiamondCafe.DiamondCafe.api;

import com.DiamondCafe.DiamondCafe.model.Nhanvien;
import com.DiamondCafe.DiamondCafe.model.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.DiamondCafe.DiamondCafe.service.INhanvienService;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 1:58 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */

@RestController
@RequestMapping("/api/admin/nhanvien")
public class NhanvienAPI {
    @Autowired
    private INhanvienService iNhanvienService;

    @GetMapping("/")
    public ResponseEntity<List<Nhanvien>> getlistNhanvien(){
        List<Nhanvien> result = iNhanvienService.getlistNV();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> addNewNhanvien(@RequestBody Nhanvien nv){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iNhanvienService.save(nv);
        if (result == 1 ) {
            serviceResponse.setMessage("Employee Information has been save");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable(name = "id") String MaNV){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iNhanvienService.delete(MaNV);
        if (result == 1 ) {
            serviceResponse.setMessage("Employee Information has been save");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Nhanvien nv){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iNhanvienService.update(nv);
        if (result == 1 ) {
            serviceResponse.setMessage("Employee Information has been save");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/nv/{id}")
    public ResponseEntity<Nhanvien> getNhanvien(@PathVariable(name = "id") String MaNV){
        Nhanvien result = iNhanvienService.getNhanvienbyID(MaNV);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
