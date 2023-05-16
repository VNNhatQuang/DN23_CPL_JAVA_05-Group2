function CheckChangePassword() {

	var newPassword = document.querySelector("input[name='MatKhauMoi']");
	var confirmPassword = document.querySelector("input[name='XacNhanMatKhau']");
	var boxMessage = document.querySelector("#boxMessage");

	if (newPassword.value !== confirmPassword.value) {
		boxMessage.innerHTML = "Xác nhận mật khẩu thất bại";
		return false;
	}
	
	return true;
}


function CheckCategory() {

	var nameCategory = document.querySelector(".form-group>div>input");
	var boxMessage = document.querySelector(".form-group>div>span");

	if (nameCategory == " ") {
		boxMessage.innerHTML = "Tên loại món có chưa ký tự không hợp lệ!";
		return false;
	}
	// Kiểm tra các ký tự không hợp lệ trong tên
    var invalidCharacters = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
    if (invalidCharacters.test(nameCategory)) {
        boxMessage.innerHTML = "Tên loại món có chưa ký tự không hợp lệ!";
        return false;
    }
	
	return true;
}