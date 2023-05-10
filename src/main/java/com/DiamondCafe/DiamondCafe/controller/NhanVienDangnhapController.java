package com.DiamondCafe.DiamondCafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class NhanVienDangnhapController {

	@GetMapping
	public String login(HttpServletRequest request) {
		
		return "Employee/BanMangVe/index";
	}
	
}
