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
@RequestMapping("/admin/khachhang")
public class KhachhangController {

    @Autowired
    private IKhachhangService iKhachhangService;

    @GetMapping()
    public String getlistNhanvien(Model model){
        List<Khachhang> listNV = iKhachhangService.getlistKhachhang();
        model.addAttribute("listKH" , listNV);
        return "Admin/Customer/customer";
    }

    @GetMapping("/add-form")
    public String showAddForm(Model model){
        model.addAttribute("KhachhangModel", new Khachhang());
        return "Admin/Customer/AddCustomer";
    }
    @GetMapping("/update-form/{id}")
    public String showUpdateForm(Model model, @PathVariable (name = "id") int maKH){
        Khachhang kh = iKhachhangService.getKhachhangbyID(maKH);
        model.addAttribute("KhachhangModel", kh);
        return "Admin/Customer/EditCustomer";
    }

    @PostMapping("/save")
    public String addNewNhanvien(@ModelAttribute (name = "KhachhangModel") Khachhang nv, BindingResult result){
        if (result.hasErrors()){
            return "Admin/Customer/AddCustomer";
        }
        iKhachhangService.save(nv);
        return "redirect:/admin/khachhang";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int MaNV){
        iKhachhangService.delete(MaNV);
        return "redirect:/admin/khachhang";
    }

    @PostMapping ("/update")
    public String update(Model model , @ModelAttribute (name = "KhachhangModel") Khachhang kh, BindingResult result){
        iKhachhangService.update(kh);
        return "redirect:/admin/khachhang";
    }

}
