/*
 * package com.DiamondCafe.DiamondCafe.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.validation.BindingResult; import
 * org.springframework.web.bind.annotation.*;
 * 
 * import com.DiamondCafe.DiamondCafe.bean.NhanVien; import
 * com.DiamondCafe.DiamondCafe.service.INhanvienService;
 * 
 * import java.util.List;
 * 
 *//**
	 * @CREATED 04/05/2023 - 10:33 AM
	 * @PROJECT Project
	 * @AUTHOR Kiel
	 *//*
		 * @Controller
		 * 
		 * @RequestMapping("admin/nhanvien") public class NhanvienController {
		 * 
		 * @Autowired private INhanvienService iNhanvienService;
		 * 
		 * @GetMapping("/") public String getlistNhanvien(Model model){ List<NhanVien>
		 * listNV = iNhanvienService.getlistNV(); model.addAttribute("listNV" , listNV);
		 * return "nhanvien/list"; }
		 * 
		 * @GetMapping("/add") public String showAddForm(Model model){
		 * model.addAttribute("NhanvienForm", new NhanVien()); return "nhanvien/new"; }
		 * 
		 * @PostMapping("/save") public String addNewNhanvien(@RequestBody NhanVien nv,
		 * BindingResult result){ if (result.hasErrors()){ return "nhanvien/new"; }
		 * iNhanvienService.save(nv); return "redirect:/nhanvien/list"; }
		 * 
		 * @GetMapping("/delete") public String delete(@RequestParam(name = "id") String
		 * MaNV){ iNhanvienService.delete(MaNV); return "redirect:/nhanvien/list"; }
		 * 
		 * @RequestMapping("/update/{id}") public String update(Model
		 * model, @RequestParam(name = "id") String MaNV){ NhanVien nv =
		 * iNhanvienService.getNhanvienbyID(MaNV); model.addAttribute("NhanvienForm",
		 * nv); return "/nhanvien/new"; } }
		 */