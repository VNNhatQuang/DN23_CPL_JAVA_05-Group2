$(document).ready(function() {

    // Đóng mở form hội viên
    $(".form-close>i").click(function() {
        $("#member").css('display', 'none');
    });
    $(".btn-HoiVien").click(function() {
        $("#member").css('display', 'flex');
    });


    // Đóng mở form danh sách phiếu đặt món
    $(".form-listOrderTable>.form-close>i").click(function() {
        $("#member").css('display', 'none');
    });
    $(".list-orderTable>.btn-warning").click(function() {
        $("#member").css('display', 'flex');
    });


    // Đóng mở form thêm phiếu đặt món
    $("#form-createOrderTable>.member-list>.form-close>i").click(function() {
        $("#form-createOrderTable").css('display', 'none');
    });
    $(".list-orderTable>.btn-primary").click(function() {
        $("#form-createOrderTable").css('display', 'flex');
    });


    // Đóng mở form sửa phiếu đặt món
    $("#form-createOrderTable>.member-list>.form-close>i").click(function() {
        $("form>h5").html("Thêm phiếu đặt bàn");
        $(".container>.row>.col-4>.btn-primary").attr("value", "Xác nhận đặt");
        $("#form-createOrderTable").css('display', 'none');
    });
    $("td>a>.fa-pen-to-square").click(function() {
        $("form>h5").html("Sửa thông tin đặt bàn");
        $(".container>.row>.col-4>.btn-primary").attr("value", "Lưu");
        $("#form-createOrderTable").css('display', 'flex');
    });


});