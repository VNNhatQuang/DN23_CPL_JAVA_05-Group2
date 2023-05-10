package com.DiamondCafe.DiamondCafe.controller;

import com.DiamondCafe.DiamondCafe.model.Phieudatban;
import com.DiamondCafe.DiamondCafe.service.IPhieudatbanService;
import com.DiamondCafe.DiamondCafe.service.PhieudatbanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CREATED 10/05/2023 - 1:43 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Controller
@RequestMapping("/nhanvien/phieu-dat-ban")
public class PhieudatbanController
{
    @Autowired
    IPhieudatbanService iphieudatbanService;

    @GetMapping("/")
    public String getlistphieu(Model model){
        List<Phieudatban> listdh = iphieudatbanService.getAlllistPhieu();
        model.addAttribute("listNV", listdh);
        return "nhanvien/list";
    }

    @GetMapping("/add-form")
    public String getform(Model model){
        model.addAttribute("pdbModel", new Phieudatban());
        return "pheudatban/new";
    }
    @GetMapping("/update-form")
    public String getupdate(Model model,@RequestParam(name = "id") int MaPhieu){
        Phieudatban temp = iphieudatbanService.getPhieubyID(MaPhieu);
        model.addAttribute("pdbModel", temp);
        return "phiedatban/new";
    }

    @PostMapping("/save")
    public String save(Model model, @RequestBody Phieudatban pdb, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message","Thêm phiếu đặt bàn không thành. Vui lòng thử lại");
            return "phieudatban/new";
        }
        iphieudatbanService.save(pdb);
        model.addAttribute("message","Thêm phiếu đặt bàn thành công");
        return "redirect:/phieu-dat-ban/list";
    }

    @GetMapping("/delete")
    public String delete(Model model,@RequestParam(name = "id") int MaPhieu, BindingResult result){
        if (result.hasErrors())
            model.addAttribute("message", "Xóa thất bại. Vui lòng thử lại");
        else
            model.addAttribute("message", "Xóa thành công mã phiếu " + MaPhieu);

        iphieudatbanService.delete(MaPhieu);
        return "redirect:/phieu-dat-ban/list";
    }

    @GetMapping("/update")
    public String update(Model model,@RequestBody Phieudatban pdb, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message" , "Cập nhật không thành. Vui lòng thử lại");
            return "phieudatban/new";
        }
        iphieudatbanService.update(pdb);
        model.addAttribute("message", "Cập nhật thành công mã phiếu " + pdb.getMaPhieu());
        return "redirect:/phieu-dat-ban/list";
    }

}
