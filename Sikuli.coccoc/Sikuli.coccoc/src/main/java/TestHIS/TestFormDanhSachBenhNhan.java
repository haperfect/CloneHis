package TestHIS;

import org.sikuli.script.Key;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HIS.DanhSachBenhNhan;
import HIS.FormKhuVuc;
import HIS.TiepNhanBenhNhan;
import desktop_Framework.HisActions;
import desktop_Framework.TestLogger;
import desktop_Framework.TienIch;

public class TestFormDanhSachBenhNhan extends DanhSachBenhNhan {

	public String Hoten, NgaySinh, SoCMND, GioiTinh, SoDienThoai, NgheNghiep, DanToc, NhapNhanh, SoNha, NoiLamViec;
	public String NguoiLienHe, SoDienThoaiNguoiLienHe, DoiTuong, UuTien, HinhThuc, LiDo, TenDichVu, ThuTienSau,
			NoiThucHien;
	public String soTiepNhan;
	TiepNhanBenhNhan tnbn = new TiepNhanBenhNhan();
    HisActions his = new HisActions();
	
	//@BeforeTest
	public void dieukienDauTien(){
		if (his.khoiDongHIS(HisActions.DUONG_DAN_FILE_CHAY_HIS) == true) {
			his.dangNhapHIS(FormKhuVuc.ten_dangNhap_admin, FormKhuVuc.matKhau_dangNhap_admin);
			his.chonPhongLamViec("Khám TMH");
			moMenuTiepNhanBenhNhan();
		} else
			setTestcaseStatus("FAIL", "Không thể khởi động ứng dụng HIS !");
	}
	
	
	@Test (priority=1)
	public void DanhSachBenhNhan_9880_3() {
		TestLogger.info("Kiểm tra tìm kiếm riêng lẻ ");

		// 1.HÀNH CHÍNH
		TestLogger.info("Điền Họ tên :");
		Hoten = "Nguyen Viet Ha" + TienIch.taoRandomChu(5);
		tnbn.dienHoTen(Hoten);
		s.type(Key.TAB);
		TestLogger.info("Chọn giới tính Nữ");
		s.type(Key.RIGHT);

		s.type(Key.TAB);
		TestLogger.info("Chọn ngày sinh :");
		NgaySinh = TienIch.getNgayThangNamHienTaicuaMayTinh();
		tnbn.dienNgaySinh(NgaySinh);
		s.type(Key.TAB);
		s.type(Key.TAB);

		TestLogger.info("Điền số CMND :");
		// SoCMND = TienIch.taoRandomSo(9);
		SoCMND = TienIch.taoRandomTheoGioiHan(100000000, 999999999);
		tnbn.dienSoCMND(SoCMND);
		s.type(Key.TAB);

		TestLogger.info("Điền số ĐIỆN THOẠI :");
		// SoDienThoai = TienIch.taoRandomSo(11);
		SoDienThoai = "1234567890";
		tnbn.dienSoDienThoai(SoDienThoai);
		s.type(Key.TAB);

		TestLogger.info("Điền nghề nghiệp :");
		NgheNghiep = "Hưu Trí";
		tnbn.dienNgheNghiep(NgheNghiep);
		s.type(Key.TAB);

		TestLogger.info("Điền dân tộc :");
		DanToc = "Hoa";
		tnbn.dienDanToc(DanToc);
		s.type(Key.TAB);

		TestLogger.info("Điền mã nhập nhanh cho thành phố ,quận huyện :");
		tnbn.dienNhapNhanh("HN1pl1qt");
		s.type(Key.TAB);

		TestLogger.info("Điền số nhà");
		SoNha = TienIch.taoRandomSo(3);
		tnbn.dienSoNha(SoNha);
		s.type(Key.TAB);

		TestLogger.info("Điền nơi làm việc");
		NoiLamViec = TienIch.taoRandomChu(12);
		tnbn.dienNoiLamViec(NoiLamViec);
		s.type(Key.TAB);

		TestLogger.info("Điền người liên hệ :");
		NguoiLienHe = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
		tnbn.dienNguoiLienHe(NguoiLienHe);
		s.type(Key.TAB);

		TestLogger.info("Điền số điện thoại người liên hệ :");
		SoDienThoaiNguoiLienHe = TienIch.taoRandomTheoGioiHan(1234567890, 1876543210);
		tnbn.dienSoDienThoaiNguoiLienHe(SoDienThoaiNguoiLienHe);
		s.type(Key.TAB);

		// 2.TIẾP NHẬN
		TestLogger.info("Chọn đối tượng dịch vụ :");
		TenDichVu = "Dịch vụ";
		tnbn.dienDoiTuong(TenDichVu);
		s.type(Key.TAB);

		UuTien = "Yes";
		tnbn.chonUuTien(UuTien);
		s.type(Key.TAB);

		TestLogger.info("Chọn hình thức khám :");
		HinhThuc = "Tái khám";
		tnbn.chonHinhThuc(HinhThuc);
		TestLogger.info("Chọn lí do khám :");
		LiDo = "Chuyển khoa";
		tnbn.dienLiDo(LiDo);

		tnbn.dienSoTheBHYT("");

		// 4.ĐĂNG KÍ KHÁM

		TenDichVu = "Khám tai mũi họng";
		tnbn.dienTenDichVu(TenDichVu);

		sleep(3);
		NoiThucHien = "Khám TMH";
		tnbn.dienNoiThucHien(NoiThucHien);
		s.type(Key.TAB);

		sleep(3);
		ThuTienSau = "Yes";
		tnbn.chonThuTienSau(ThuTienSau);

		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_Luu);
		
		if (waitForObjectPresent(TiepNhanBenhNhan.Phieukham, 5)) {
			s.type(Key.F4, Key.ALT);
			setTestcaseStatus("PASS", "Tiếp nhận Bệnh nhân thành công !");
		} else {

			setTestcaseStatus("FAIL", "Tiếp nhận Bệnh nhân không thành công !");
		}
		
		
		TestLogger.info("Check : Bệnh nhân vừa tiếp nhận nằm trong danh sách chờ khám");
		waitForObjectPresent(TiepNhanBenhNhan.TiepNhanBenhNhan_DanhSachBenhNhan, 4);
		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_DanhSachBenhNhan);
		waitForObjectPresent(DanhSachBenhNhan.TitleForm_DanhSachBenhNhan, 4);

		dienDieuKienTimKiemBangHoTen(Hoten);
		s.type(Key.ENTER);
		String soDong= layTextTuAnh(173, 680, 12, 22);
		TestLogger.info("Expect : ");

		if (soDong.trim().equals("1"))
		{
			setTestcaseStatus("PASS", "Hệ thống trả ra đúng với từ khóa tìm kiếm");
		}
		else
		{
			setTestcaseStatus("FAIL", "Hệ thống trả ra đúng với từ khóa tìm kiếm");
		}
	
	}
	
	
	@Test (priority=2)
	public void DanhSachBenhNhan_9880_2() {
		TestLogger.info("Kiểm tra tìm kiếm riêng lẻ ");
		TestLogger.info("Kiểm tra tìm kiếm không ra kết quả");
		dienDieuKienTimKiemBangHoTen(TienIch.taoRandomChu(15));
		s.type(Key.ENTER);
		String soDong= layTextTuAnh(173, 680, 12, 22);
		TestLogger.info("Expect : Hệ thống không thực hiện trả  ra kết quả thoải mãi điều kiện tìm kiếm. Không có bản ghi nào trả ra");

		if (soDong.trim().equals("0"))
		{
			setTestcaseStatus("PASS", "");
		}
		else
		{
			setTestcaseStatus("FAIL", "");
		}
	}
	
	
	
	//@AfterTest
	public void ketThucLuong() {
		dangXuatKhoiTaikhoan();
		thoatUngdungHIS();
	}

}
