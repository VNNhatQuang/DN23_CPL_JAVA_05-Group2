/*
 * package com.DiamondCafe.DiamondCafe.controller;
 * 
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.validation.BindingResult; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.DiamondCafe.DiamondCafe.bean.KhachHang; import
 * com.DiamondCafe.DiamondCafe.bean.NhanVien; import
 * com.DiamondCafe.DiamondCafe.service.IKhachhangService;
 * 
 *//**
	 * @CREATED 04/05/2023 - 5:31 PM
	 * @PROJECT Project
	 * @AUTHOR Kiel
	 *//*
		 * 
		 * @Controller
		 * 
		 * @RequestMapping("admin/khachhang") public class KhachhangController {
		 * 
		 * @Autowired private IKhachhangService iKhachhangService;
		 * 
		 * @GetMapping("/") public String getlistNhanvien(Model model){ List<KhachHang>
		 * listNV = iKhachhangService.getlistKhachhang(); model.addAttribute("listNV" ,
		 * listNV); return "khachhang/list"; }
		 * 
		 * @GetMapping("/add") public String showAddForm(Model model){
		 * model.addAttribute("NhanvienForm", new NhanVien()); return "khachhang/new"; }
		 * 
		 * @PostMapping("/save") public String addNewNhanvien(@RequestBody KhachHang nv,
		 * BindingResult result){ if (result.hasErrors()){ return "nhanvien/new"; }
		 * iKhachhangService.save(nv); return "redirect:/nhanvien/list"; }
		 * 
		 * @GetMapping("/delete/{id}") public String delete(@RequestParam(name = "id")
		 * int MaNV, BindingResult result){ iKhachhangService.delete(MaNV); return
		 * "redirect:/khachang/list"; }
		 * 
		 * @PostMapping ("/update") public String update(Model model , @RequestBody
		 * KhachHang kh, BindingResult result){ iKhachhangService.update(kh); return
		 * "redirect:/khachhang/list"; }
		 * 
		 * }
		 */