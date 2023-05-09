package com.DiamondCafe.DiamondCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Paging;
import com.DiamondCafe.DiamondCafe.service.LoaiMonService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/loaimon")
public class AdminLoaiMonController {
	
	@Autowired
	private LoaiMonService lmService;
	private final int PAGE_SIZE = 5;
	
	@GetMapping
	public String Index(HttpServletRequest request) {
		int page = 1;
		if(request.getParameter("page")!=null)
			page = Integer.parseInt(request.getParameter("page"));
		String searchValue = "";
		if(request.getParameter("searchValue")!=null)
			searchValue = request.getParameter("searchValue");
		int rowCount = lmService.Count(searchValue);
		Paging p = new Paging(page, PAGE_SIZE, rowCount, searchValue);
		request.setAttribute("paging", p);
		request.setAttribute("list", lmService.getList(page, PAGE_SIZE, searchValue));
		return "Admin/LoaiMon/index";
	}
	
	@GetMapping("create")
	public String showFormCreate(HttpServletRequest request) {
		return "Admin/LoaiMon/create";
	}
	
	@PostMapping("add")
	public String Add(HttpServletRequest request, @ModelAttribute LoaiMon loaimon) {
		lmService.Add(loaimon);
		return "redirect:/admin/loaimon";
	}
	
	@GetMapping("edit/{id}")
	public String showFormEdit(HttpServletRequest request, @PathVariable("id") int id) {
		LoaiMon lm = lmService.getLoaiMon(id);
		request.setAttribute("lm", lm);
		return "Admin/LoaiMon/edit";
	}
	
	@PostMapping("update")
	public String Update(HttpServletRequest request, @ModelAttribute LoaiMon loaimon) {
		lmService.Update(loaimon);
		return "redirect:/admin/loaimon";
	}
	
	@GetMapping("delete/{id}")
	public String showFormDelete(HttpServletRequest request, @PathVariable("id") int id) {
		request.setAttribute("lm", lmService.getLoaiMon(id));
		return "Admin/LoaiMon/delete";
	}
	
	@GetMapping("delete/confirm/{id}")
	public String Delete(HttpServletRequest request, @PathVariable("id") int id) {
		lmService.Delete(id);
		return "redirect:/admin/loaimon";
	}
	
}
