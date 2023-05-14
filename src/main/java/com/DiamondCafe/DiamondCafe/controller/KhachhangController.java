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
        return "Admin/khachhang/index";
    }

    @GetMapping("/add-form")
    public String showAddForm(Model model){
        model.addAttribute("KhachhangModel", new Nhanvien());
        return "Admin/khachhang/them";
    }
    @GetMapping("/update-form")
    public String showUpdateForm(Model model){
        model.addAttribute("KhachhangModel", new Nhanvien());
        return "Admin/khachhang/edit";
    }

    @PostMapping("/save")
    public String addNewNhanvien(@ModelAttribute (name = "KhachhangModel") Khachhang nv, BindingResult result){
        if (result.hasErrors()){
            return "Admin/khachhang/them";
        }
        iKhachhangService.save(nv);
        return "redirect:admin/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String delete(@RequestParam(name = "id") int MaNV, BindingResult result){
        iKhachhangService.delete(MaNV);
        return "redirect:admin/nhanvien";
    }

    @PostMapping ("/update")
    public String update(Model model , @ModelAttribute (name = "KhachhangModel") Khachhang kh, BindingResult result){
        iKhachhangService.update(kh);
        return "redirect:admin/nhanvien";
    }

}
