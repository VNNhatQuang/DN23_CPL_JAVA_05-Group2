package com.DiamondCafe.DiamondCafe.controller;

import com.DiamondCafe.DiamondCafe.model.Khachhang;
import com.DiamondCafe.DiamondCafe.model.Nhanvien;
import com.DiamondCafe.DiamondCafe.service.IKhachhangService;
import com.DiamondCafe.DiamondCafe.service.INhanvienService;
import com.DiamondCafe.DiamondCafe.service.KhachhangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 5:31 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */

@Controller
@RequestMapping("admin/khachhang")
public class KhachhangController {

    @Autowired
    private IKhachhangService iKhachhangService;

    @GetMapping("/")
    public String getlistNhanvien(Model model){
        List<Khachhang> listNV = iKhachhangService.getlistKhachhang();
        model.addAttribute("listNV" , listNV);
        return "khachhang/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("NhanvienForm", new Nhanvien());
        return "khachhang/new";
    }

    @PostMapping("/save")
    public String addNewNhanvien(@RequestBody Khachhang nv, BindingResult result){
        if (result.hasErrors()){
            return "nhanvien/new";
        }
        iKhachhangService.save(nv);
        return "redirect:/nhanvien/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@RequestParam(name = "id") int MaNV, BindingResult result){
        iKhachhangService.delete(MaNV);
        return "redirect:/khachang/list";
    }

    @PostMapping ("/update")
    public String update(Model model , @RequestBody Khachhang kh, BindingResult result){
        iKhachhangService.update(kh);
        return "redirect:/khachhang/list";
    }

}
