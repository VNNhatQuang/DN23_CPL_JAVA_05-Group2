package com.DiamondCafe.DiamondCafe.controller;

import com.DiamondCafe.DiamondCafe.model.Nhanvien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.DiamondCafe.DiamondCafe.service.INhanvienService;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 10:33 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Controller
@RequestMapping("admin/nhanvien")
public class NhanvienController {
    @Autowired
    private INhanvienService iNhanvienService;


    @GetMapping("")
    public String getlistNhanvien(Model model){
        List<Nhanvien> listNV = iNhanvienService.getlistNV();
        model.addAttribute("listNV" , listNV);
        return "Admin/EmployeeAdmin/index";
    }

    @GetMapping("/add-form")
    public String showAddForm(Model model){
        model.addAttribute("NhanvienModel", new Nhanvien());
        return "Admin/EmployeeAdmin/them";
    }
    @GetMapping("/update-form/{id}")
    public String showEditForm(Model model, @PathVariable("id") String id){
        Nhanvien nv = iNhanvienService.getNhanvienbyID(id);
        model.addAttribute("NhanvienModel", nv);
        return "Admin/EmployeeAdmin/edit";
    }

    @PostMapping("/save")
    public String addNewNhanvien(Model model, @ModelAttribute(name = "NhanvienModel") Nhanvien nv, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message","Thêm nhân viên không thành. Vui lòng thử lại");
            return "Admin/EmployeeAdmin/them";
        }
        iNhanvienService.save(nv);
        model.addAttribute("message","Thêm nhân viên thành công");
        return "redirect:admin/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") String MaNV){
        iNhanvienService.delete(MaNV);
        return "redirect:admin/nhanvien";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute(name = "NhanvienModel") Nhanvien nv, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message" , "Cập nhật không thành. Vui lòng thử lại");
            return "Admin/EmployeeAdmin/edit";
        }
        iNhanvienService.update(nv);
        return "redirect:admin/nhanvien";
    }

}
