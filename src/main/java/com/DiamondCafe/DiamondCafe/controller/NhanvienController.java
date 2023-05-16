package com.DiamondCafe.DiamondCafe.controller;

import com.DiamondCafe.DiamondCafe.model.Chucvu;
import com.DiamondCafe.DiamondCafe.model.Nhanvien;
import com.DiamondCafe.DiamondCafe.service.IChucvuService;
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
@RequestMapping("/admin/nhanvien")
public class NhanvienController {
    @Autowired
    private INhanvienService iNhanvienService;
    @Autowired
    private IChucvuService iChucvuService;


    @GetMapping()
    public String getlistNhanvien(Model model){
        List<Nhanvien> listNV = iNhanvienService.getlistNV();
        model.addAttribute("listNV" , listNV);
        return "Admin/EmployeeAdmin/index";
    }

    @GetMapping("/add-form")
    public String showAddForm(Model model){
        List<Chucvu> list = iChucvuService.getChucvuList();
        model.addAttribute("NhanvienModel", new Nhanvien());
        model.addAttribute("ListChucvu", list);
        return "Admin/EmployeeAdmin/AddEmployee";
    }
    @GetMapping("/update-form/{id}")
    public String showEditForm(Model model, @PathVariable("id") String id){
        Nhanvien nv = iNhanvienService.getNhanvienbyID(id);
        List<Chucvu> list = iChucvuService.getChucvuList();
        model.addAttribute("NhanvienModel", nv);
        model.addAttribute("ListChucvu", list);
        return "Admin/EmployeeAdmin/EditEmployee";
    }

    @PostMapping("/save")
    public String addNewNhanvien(Model model, @ModelAttribute(name = "NhanvienModel") Nhanvien nv, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message","Thêm nhân viên không thành. Vui lòng thử lại");
            return "Admin/EmployeeAdmin/EditEmployee";
        }
        iNhanvienService.save(nv);
        model.addAttribute("message","Thêm nhân viên thành công");
        return "redirect:/admin/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") String MaNV){
        iNhanvienService.delete(MaNV);
        return "redirect:/admin/nhanvien";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute(name = "NhanvienModel") Nhanvien nv, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message" , "Cập nhật không thành. Vui lòng thử lại");
            return "Admin/EmployeeAdmin/EditEmployee";
        }
        iNhanvienService.update(nv);
        return "redirect:/admin/nhanvien";
    }

}
