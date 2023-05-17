package com.DiamondCafe.DiamondCafe.controller;

import com.DiamondCafe.DiamondCafe.bean.Ban;
import com.DiamondCafe.DiamondCafe.model.Phieudatban;
import com.DiamondCafe.DiamondCafe.service.IBanService;
import com.DiamondCafe.DiamondCafe.service.IPhieudatbanService;
import com.DiamondCafe.DiamondCafe.service.NhanVienSoDoChinhService;
import com.DiamondCafe.DiamondCafe.service.PhieudatbanServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CREATED 10/05/2023 - 1:43 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Controller
@RequestMapping("/nhan-vien/phieu-dat-ban")
public class PhieudatbanController
{
    @Autowired
    IPhieudatbanService iphieudatbanService;
    @Autowired
    NhanVienSoDoChinhService isdcService;
    @Autowired
    private IBanService iBanService;

    @GetMapping()
    public String getMainDatCho(Model model){
        List<Phieudatban> listdc = iphieudatbanService.getAlllistPhieu();
        List<Ban> listBan = isdcService.getAllTables();
        model.addAttribute("listTable", listBan);
        model.addAttribute("listPDC", listdc);
        return "Employee/DatCho/index";
    }

    @GetMapping("/new-form/{id}")
    public String getform(Model model, @PathVariable("id") int id){
        Phieudatban pdb = new Phieudatban();
        model.addAttribute("pdbModel",pdb );
        model.addAttribute("Maban", id);
        return "Employee/DatCho/themphieu";
    }
    @GetMapping("/update-form/{id}")
    public String getupdate(Model model,@PathVariable(name = "id") int MaPhieu){
        Phieudatban temp = iphieudatbanService.getPhieubyID(MaPhieu);
        model.addAttribute("pdbModel", temp);
        return "Employee/DatCho/editphieu";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute(name = "pdbModel") Phieudatban pdb, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message","Thêm phiếu đặt bàn không thành. Vui lòng thử lại");
            return "Employee/DatCho/themphieu";
        }
        iphieudatbanService.save(pdb);
        iBanService.updateTrangthai(pdb.getSoBan(), 2);
        model.addAttribute("message","Thêm phiếu đặt bàn thành công");
        return "redirect:/nhan-vien/phieu-dat-ban";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable(name = "id") int MaPhieu){
        iphieudatbanService.delete(MaPhieu);
        return "redirect:/nhan-vien/phieu-dat-ban";
    }

    @PostMapping("/update")
    public String update(Model model,@ModelAttribute(name = "pdbModel") Phieudatban pdb, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message" , "Cập nhật không thành. Vui lòng thử lại");
            return "Employee/DatCho/editphieu";
        }
        iphieudatbanService.update(pdb);
        iBanService.updateTrangthai(pdb.getSoBan(), 2);
        model.addAttribute("message", "Cập nhật thành công mã phiếu " + pdb.getMaPhieu());
        return "redirect:/nhan-vien/phieu-dat-ban";
    }

    @GetMapping("tra-ban/{MaPhieu}-{SoBan}")
    public String Datraban(@PathVariable("MaPhieu") int Maphieu, @PathVariable("SoBan") int SoBan) {
        iBanService.updateTrangthai(
                SoBan,
                Ban.convertTrangthaiName(Ban.status.TRONG
        ));
        iphieudatbanService.updateTrangthai(
                Maphieu,
                Phieudatban.convertTrangthaiStatus(Phieudatban.status.DA_TRA_BAN
        ));
        return "redirect:/nhan-vien/phieu-dat-ban";
    }

    @GetMapping("nhan-ban/{MaPhieu}/{SoBan}")
    public String Nhanban(@PathVariable("MaPhieu") int Maphieu, @PathVariable("SoBan") int SoBan) {
        iBanService.updateTrangthai(
                SoBan,
                Ban.convertTrangthaiName(Ban.status.DANG_HOAT_DONG
        ));
        iphieudatbanService.updateTrangthai(
                Maphieu,
                Phieudatban.convertTrangthaiStatus(Phieudatban.status.DANG_NHAN_BAN
        ));
        return "redirect:/nhan-vien/phieu-dat-ban";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Phieudatban> results = iphieudatbanService.getTimkiemPhieubySDT(query);
        model.addAttribute("listPDC", results);
        return "Employee/DatCho/index :: resultsTable";
    }

    @GetMapping("/clear-filter")
    public String clear(@RequestParam("query") String query, Model model) {
        List<Phieudatban> results = iphieudatbanService.getAlllistPhieu();
        model.addAttribute("listPDC", results);
        return "Employee/DatCho/index :: resultsTable";
    }

}
