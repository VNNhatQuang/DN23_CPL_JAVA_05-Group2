package com.DiamondCafe.DiamondCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DiamondCafe.DiamondCafe.service.NhanVienSoDoChinhService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class NhanVienSoDoChinhController {
	
	@Autowired
	private NhanVienSoDoChinhService sdcService;
	
	// Hiển thị màn hình sơ đồ chính
	@GetMapping
	public String Home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("tk")!=null) {
			request.setAttribute("listTable", sdcService.getAllTables());
			return "Employee/PhieuDatMon/index";
		}
		else
			return "redirect:/";
	}
	
	// Thêm phiếu đặt món
	@GetMapping("themphieu/{id}/{ID_LoaiMon}")
	public String Create(HttpServletRequest request, @PathVariable("id") int id, @PathVariable("ID_LoaiMon") int id_loaimon) {
		request.setAttribute("SoBan", id);
		request.setAttribute("listCategories", sdcService.getAllCategories());
		request.setAttribute("listProduct", sdcService.getListProduct(id_loaimon));
		return "Employee/PhieuDatMon/themphieu";
	}
}
