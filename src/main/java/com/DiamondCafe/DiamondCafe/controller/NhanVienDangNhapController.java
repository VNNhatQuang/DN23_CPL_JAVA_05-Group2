package com.DiamondCafe.DiamondCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DiamondCafe.DiamondCafe.bean.NhanVien;
import com.DiamondCafe.DiamondCafe.service.NhanVienTaiKhoanService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NhanVienDangNhapController {
	
	@Autowired
	private NhanVienTaiKhoanService tkService;

	// Hiển thị form đăng nhập
	@GetMapping("/")
	public String Login(HttpServletRequest request) {
		return "Employee/TaiKhoan/login";
	}
	
	// Kiểm tra đăng nhập
	@PostMapping("/")
	public String Login(HttpServletRequest request, @RequestParam("MaTK") String MaTK, @RequestParam("MatKhau") String MatKhau) {
		NhanVien tk = tkService.ktdn(MaTK, MatKhau);
		if(tk!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("tk", tk);
			return "redirect:/home";
		}
		else
			return "redirect:/";
	}
	
	// Đăng xuất
	@GetMapping("/logout")
	public String Logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	// Hiển thị form Đổi mật khẩu
	@GetMapping("/doimatkhau")
	public String ChangePassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("tk")!=null) {
			request.setAttribute("mesage", "");
			return "Employee/TaiKhoan/doimatkhau";
		}
		else
			return "redirect:/";
	}
	
	// Đổi mật khẩu
		@PostMapping("/doimatkhau")
		public String ChangePassword(HttpServletRequest request, @ModelAttribute NhanVien nv,String MatKhau, @RequestParam("MatKhauMoi") String MatKhauMoi, @RequestParam("XacNhanMatKhau") String XacNhanMatKhau) {
			HttpSession session = request.getSession();
			NhanVien tk = (NhanVien) session.getAttribute("tk");
			// Check mật khẩu = mật khẩu hiện tại
			if(tkService.ktdn(tk.getMaTK(), nv.getMatKhau())!=null) {
				// Check mật khẩu mới = xác nhận mật khẩu
				if(MatKhauMoi.equals(XacNhanMatKhau)) {
					tkService.DoiMatKhau(tk.getMaTK(), MatKhauMoi);
					request.setAttribute("message", "Đổi mật khẩu thành công!");
					return "Employee/TaiKhoan/doimatkhau";
				}
				else {
					request.setAttribute("message", "Xác nhận mật khẩu thất bại!");
					return "Employee/TaiKhoan/doimatkhau";
				}
			}
			else {
				request.setAttribute("message", "Mật khẩu không trùng khớp với mật khẩu hiện tại!");
				return "Employee/TaiKhoan/doimatkhau";
			}
		}
	
}
