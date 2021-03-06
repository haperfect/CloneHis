package TestHIS;

import org.sikuli.script.Key;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HIS.DanhSachBenhNhan;
import HIS.FormKhamBenh;
import HIS.FormKhuVuc;
import HIS.FormVienPhiNgoaiTru;
import HIS.TiepNhanBenhNhan;
import desktop_Framework.HisActions;
import desktop_Framework.TestLogger;
import desktop_Framework.TienIch;

public class TestLuongDichVu_13771 extends TiepNhanBenhNhan {

	public String Hoten, NgaySinh, SoCMND, GioiTinh, SoDienThoai, NgheNghiep, DanToc, NhapNhanh, SoNha, NoiLamViec;
	public String NguoiLienHe, SoDienThoaiNguoiLienHe, DoiTuong, UuTien, HinhThuc, LiDo, TenDichVu, ThuTienSau,
			NoiThucHien;
	public String soTiepNhan, noiDungBenhChinh;
	DanhSachBenhNhan dsbn = new DanhSachBenhNhan();
	FormVienPhiNgoaiTru vpnt = new FormVienPhiNgoaiTru();
	HisActions his = new HisActions();
	FormKhamBenh kb = new FormKhamBenh();

	// Dang nhap bang tai khoan TD01 de tiep don benh nhan vao kham
	@BeforeTest
	public void dieukienDauTien() {

		if (his.khoiDongHIS(HisActions.DUONG_DAN_FILE_CHAY_HIS) == true) {
			his.dangNhapHIS(FormKhuVuc.ten_dangNhap_TDNT, FormKhuVuc.matKhau_dangNhap_TDNT);
			his.chonPhongLamViec("Tiếp đón ngoại trú");
			moMenuTiepNhanBenhNhan();
		} else
			setTestcaseStatus("FAIL", "Không thể khởi động ứng dụng HIS !");
	}

	// Dien thong tin benh nhan va in phieu kham cho benh nhan den kham
	@Test(priority = 1)
	public void DichVu_13771_1() {
		// 1.HÀNH CHÍNH
		TestLogger.info("Điền Họ tên :");
		Hoten = "Nguyen Viet Ha" + TienIch.taoRandomChu(5);
		dienHoTen(Hoten);
		s.type(Key.TAB);
		TestLogger.info("Chọn giới tính Nữ");
		s.type(Key.RIGHT);

		s.type(Key.TAB);
		TestLogger.info("Chọn ngày sinh :");
		NgaySinh = TienIch.getNgayThangNamHienTaicuaMayTinh();
		dienNgaySinh(NgaySinh);
		s.type(Key.TAB);
		s.type(Key.TAB);

		TestLogger.info("Điền số CMND :");
		// SoCMND = TienIch.taoRandomSo(9);
		SoCMND = TienIch.taoRandomTheoGioiHan(100000000, 999999999);
		dienSoCMND(SoCMND);
		s.type(Key.TAB);

		TestLogger.info("Điền số ĐIỆN THOẠI :");
		// SoDienThoai = TienIch.taoRandomSo(11);
		SoDienThoai = "1234567890";
		dienSoDienThoai(SoDienThoai);
		s.type(Key.TAB);

		TestLogger.info("Điền nghề nghiệp :");
		NgheNghiep = "Hưu Trí";
		dienNgheNghiep(NgheNghiep);
		s.type(Key.TAB);

		TestLogger.info("Điền dân tộc :");
		DanToc = "Hoa";
		dienDanToc(DanToc);
		s.type(Key.TAB);

		TestLogger.info("Điền mã nhập nhanh cho thành phố ,quận huyện :");
		dienNhapNhanh("HN1pl1qt");
		s.type(Key.TAB);

		TestLogger.info("Điền số nhà");
		SoNha = TienIch.taoRandomSo(3);
		dienSoNha(SoNha);
		s.type(Key.TAB);

		TestLogger.info("Điền nơi làm việc");
		NoiLamViec = TienIch.taoRandomChu(12);
		dienNoiLamViec(NoiLamViec);
		s.type(Key.TAB);

		TestLogger.info("Điền người liên hệ :");
		NguoiLienHe = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
		dienNguoiLienHe(NguoiLienHe);
		s.type(Key.TAB);

		TestLogger.info("Điền số điện thoại người liên hệ :");
		SoDienThoaiNguoiLienHe = TienIch.taoRandomTheoGioiHan(123456789, 987654321);
		dienSoDienThoaiNguoiLienHe(SoDienThoaiNguoiLienHe);
		s.type(Key.TAB);

		// 2.TIẾP NHẬN
		TestLogger.info("Chọn đối tượng dịch vụ :");
		TenDichVu = "Dịch vụ";
		dienDoiTuong(TenDichVu);
		s.type(Key.TAB);

		UuTien = "Yes";
		chonUuTien(UuTien);
		s.type(Key.TAB);

		TestLogger.info("Chọn hình thức khám :");
		HinhThuc = "Tái khám";
		chonHinhThuc(HinhThuc);
		TestLogger.info("Chọn lí do khám :");
		LiDo = "Chuyển khoa";
		dienLiDo(LiDo);

		dienSoTheBHYT("");

		// 4.ĐĂNG KÍ KHÁM

		TenDichVu = "Khám tai mũi họng";
		dienTenDichVu(TenDichVu);

		sleep(3);
		NoiThucHien = "Khám TMH";
		dienNoiThucHien(NoiThucHien);
		s.type(Key.TAB);

		sleep(3);
		ThuTienSau = "Yes";
		chonThuTienSau(ThuTienSau);

		clickOn(TiepNhanBenhNhan_Luu);

		if (waitForObjectPresent(Phieukham, 5)) {
			s.type(Key.F4, Key.ALT);
			setTestcaseStatus("PASS", "Tiếp nhận Bệnh nhân thành công !");
		} else {

			setTestcaseStatus("FAIL", "Không thể in phiếu khám , Tiếp nhận Bệnh nhân không thành công !");
		}

	}

	// check lai thong tin benh nhan xem da duoc luu trong danh sach kham benh
	// chua
	@Test(priority = 2)
	public void DichVu_13771_2() {
		TestLogger.info("Check : Bệnh nhân vừa tiếp nhận nằm trong danh sách chờ khám");
		waitForObjectPresent(TiepNhanBenhNhan_DanhSachBenhNhan, 4);
		clickOn(TiepNhanBenhNhan_DanhSachBenhNhan);
		waitForObjectPresent(DanhSachBenhNhan.TitleForm_DanhSachBenhNhan, 4);

		dsbn.dienDieuKienTimKiem(Hoten);

		if (waitForObjectPresent(DanhSachBenhNhan.DanhSachBenhNhan_SoDongBang1, 4)) {
			setTestcaseStatus("PASS", "Bệnh nhân vừa tiếp nhận nằm trong danh sách chờ khám");

		} else {
			setTestcaseStatus("FAIL", "Bệnh nhân vừa tiếp nhận không nằm trong danh sách chờ khám");
		}

		TestLogger.info("- Click double vào bệnh nhân");
		dsbn.clickDupVaoBenhNhanChoKham();
		sleep(3);
		clickOn(TiepNhanBenhNhan_Sua);
		soTiepNhan = getSoTiepNhan();

		TestLogger.info("Expect : Chuyển sang form Tiếp nhận Bệnh nhân,check thông tin bệnh nhân ,"
				+ "Expect : Hiển thị đúng thông tin của bệnh nhân ");
		if (waitForObjectPresent(TiepNhanBenhNhan_MenuHanhChinh, 5)) {
			setTestcaseStatus("PASS", "Đã chuyển sang form Tiếp nhận Bệnh nhân");
		} else {
			setTestcaseStatus("FAIL", "Không chuyển sang form Tiếp nhận Bệnh nhân");
		}

		if (getHoten().equalsIgnoreCase(Hoten)) {
			setTestcaseStatus("PASS", "Hoten");
		} else {
			setTestcaseStatus("FAIL", "Hoten");
		}

		if (getNgaySinh().equalsIgnoreCase(NgaySinh)) {
			setTestcaseStatus("PASS", "NgaySinh");
		} else {
			setTestcaseStatus("FAIL", "NgaySinh");
		}

		if (getSoCMND().equalsIgnoreCase(SoCMND)) {
			setTestcaseStatus("PASS", "SoCMND");
		} else {
			setTestcaseStatus("FAIL", "SoCMND");
		}

		if (getSoDienThoai().equalsIgnoreCase(SoDienThoai)) {
			setTestcaseStatus("PASS", "SoDienThoai");
		} else {
			setTestcaseStatus("FAIL", "SoDienThoai");
		}

		if (getNgheNghiep().equalsIgnoreCase(NgheNghiep)) {
			setTestcaseStatus("PASS", "NgheNghiep");
		} else {
			setTestcaseStatus("FAIL", "NgheNghiep");
		}

		if (getDanToc().equalsIgnoreCase(DanToc)) {
			setTestcaseStatus("PASS", "DanToc");
		} else {
			setTestcaseStatus("FAIL", "DanToc");
		}

		if (getThanhPho().equalsIgnoreCase("Tỉnh Hà Nam")) {
			setTestcaseStatus("PASS", "Tỉnh Hà Nam");
		} else {
			setTestcaseStatus("FAIL", "Tỉnh Hà Nam");
		}

		if (getQuanHuyen().equalsIgnoreCase("Thành phố Phủ Lý")) {
			setTestcaseStatus("PASS", "Thành phố Phủ Lý");
		} else {
			setTestcaseStatus("FAIL", "Thành phố Phủ Lý");
		}

		if (getPhuongXa().equalsIgnoreCase("Phường Quang Trung")) {
			setTestcaseStatus("PASS", "Phường Quang Trung");
		} else {
			setTestcaseStatus("FAIL", "Phường Quang Trung");
		}

		if (getSoNha().equalsIgnoreCase(SoNha)) {
			setTestcaseStatus("PASS", "SoNha");
		} else {
			setTestcaseStatus("FAIL", "SoNha");
		}

		if (getNoiLamViec().equalsIgnoreCase(NoiLamViec)) {
			setTestcaseStatus("PASS", "NoiLamViec");
		} else {
			setTestcaseStatus("FAIL", "NoiLamViec");
		}

		if (getNguoiLienHe().equalsIgnoreCase(NguoiLienHe)) {
			setTestcaseStatus("PASS", "NguoiLienHe");
		} else {
			setTestcaseStatus("FAIL", "NguoiLienHe");
		}

		if (getSoDienThoaiNguoiLienHe().equalsIgnoreCase(SoDienThoaiNguoiLienHe)) {
			setTestcaseStatus("PASS", "SoDienThoaiNguoiLienHe");
		} else {
			setTestcaseStatus("FAIL", "SoDienThoaiNguoiLienHe");
		}

		if (getHinhThuc().equalsIgnoreCase(HinhThuc)) {
			setTestcaseStatus("PASS", "HinhThuc");
		} else {
			setTestcaseStatus("FAIL", "HinhThuc");
		}

		if (getLiDo().equalsIgnoreCase(LiDo)) {
			setTestcaseStatus("PASS", "LiDo");
		} else {
			setTestcaseStatus("FAIL", "LiDo");
		}

		if (getNoiThucHien().equalsIgnoreCase(NoiThucHien)) {
			setTestcaseStatus("PASS", "NoiThucHien");
		} else {
			setTestcaseStatus("FAIL", "NoiThucHien");
		}

	}

	// Thoat khoi tai khoan TD01 => chuyen sang Tai khoan BS01 de kham cho benh
	// nhan co
	// so tiep don benh nhan da dang ki o tren
	@Test(priority = 3)
	public void DichVu_13771_3() {

		// THOAT va dang nhap voi tai khoan khac
		clickOn(TiepNhanBenhNhan_HeThong);
		clickOn(TiepNhanBenhNhan_DangXuat);
		clickOn(TiepNhanBenhNhan_HeThong);
		clickOn(TiepNhanBenhNhan_DangNhap);

		// Dang nhap voi tai khoan BS01
		dangNhapHIS(FormKhuVuc.ten_dangNhap_BS01, FormKhuVuc.matKhau_dangNhap_BS01);
		chonPhongLamViec("Khám TMH");
		// click len menu Kham Benh
		sleep(3);
		clickOn(HisActions.HIS_MenuKhamBenh);
		waitForObjectPresent(HisActions.HIS_MenuKhamBenh, 3);
		// click sub-menu Kham Benh
		clickToaDo(198, 74);
        sleep(3);
		kb.dienSoTiepNhan(soTiepNhan);
		kb.clickTimKiem();
		if (waitForObjectPresent(FormKhamBenh.FormKhamBenh_soDongBang1, 5)) {
			hoverImage(FormKhamBenh.FormKhamBenh_LamMoi);
			moveMouseDownFromLogo(FormKhamBenh.FormKhamBenh_TimKiem, 95);
			s.doubleClick();
			setTestcaseStatus("PASS", "Đã tìm thấy bệnh nhân đang chờ khám !");
		} else {
			setTestcaseStatus("FAIL", "Không tìm thấy bệnh nhân đang chờ khám !");
		}
	}

	// BS01 do chi so sinh ton cho benh nhan
	@Test(priority = 4)
	public void DichVu_13771_4() {
		waitForObjectPresent(FormKhamBenh.FormKhamBenh_doChiSoSinhTon, 5);
		clickOn(FormKhamBenh.FormKhamBenh_doChiSoSinhTon);
		kb.dienDiUng("phan hoa");
		kb.dienBenhManTinh("tieu chay");
		clickOn(FormKhamBenh.FormKhamBenh_SuaNhomMau);
		kb.chonNhomMau("a");
		s.type(Key.TAB);
		sleep(2);
		s.type(Key.UP);
		s.type(Key.TAB);
		TestLogger.info("Do Mach");
		s.type("150");
		s.type(Key.TAB);
		TestLogger.info("Do Huyet Ap");
		s.type("40");
		s.type(Key.TAB);
		s.type("180");
		s.type(Key.TAB);
		TestLogger.info("Do nhiet do");
		s.type("38");
		s.type(Key.TAB);
		TestLogger.info("Do nhip tho");
		s.type("120");
		s.type(Key.TAB);
		TestLogger.info("Do can nang");
		s.type("55");
		s.type(Key.TAB);
		TestLogger.info("Do chieu cao");
		s.type("180");
		// click Luu chỉ số sinh tồn
		clickOn(FormKhamBenh.FormKhamBenh_LuuChiSoSinhTon);
		if (waitForObjectPresent(HisActions.HIS_LOI_UNGDUNG, 2)) {
			s.type(Key.ENTER);
			setTestcaseStatus("FAIL", "Lưu Chỉ số sinh tồn gặp sự cố !");
		} else {
			setTestcaseStatus("PASS", "Đã Lưu được chỉ số sinh tồn ");

		}

	}

	// BS kham benh sau khi da do xong cac chi so sinh ton
	@Test(priority = 5)
	public void DichVu_13771_5() {
		clickOn(FormKhamBenh.FormKhamBenh_KhamBenh);
		kb.dienLiDoKham("Dau Bung");
		kb.dienBenhChinhDefault();
		noiDungBenhChinh = kb.getNoiDungBenhChinh();
		clickOn(FormKhamBenh.FormKhamBenh_Luu);
		if (waitForObjectPresent(HisActions.HIS_LOI_UNGDUNG, 2)) {
			s.type(Key.ENTER);
			setTestcaseStatus("FAIL", "Không thể lưu kết quả khám bệnh , gặp sự cố !");
		} else {
			setTestcaseStatus("PASS", "Đã Lưu được kết quả khám bệnh ! ");

		}

	}

	// BS01 ket luan kham : chọn nhập viện, chọn khoa nhập
	@Test(priority = 6)
	public void DichVu_13771_6() {
		clickOn(FormKhamBenh.FormKhamBenh_KetLuan);
		moveMouseHorizontallyFromLogo(FormKhamBenh.FormKhamBenh_HuongDieuTri, 296);
		s.click();
		// Chon Nhap Vien
		waitForObjectPresent(FormKhamBenh.HuongDieuTri_NhapVien, 4);
		clickOn(FormKhamBenh.HuongDieuTri_NhapVien);
		// Chon khoa nhap
		clickToaDo(568, 310);
		clickOn(FormKhamBenh.KhoaNhap_KhoaGayMeHoiSuc);

		clickOn(FormKhamBenh.FormKhamBenh_LuuVaHoanThanh);
		if (waitForObjectPresent(HisActions.HIS_LOI_UNGDUNG, 2)) {
			s.type(Key.ENTER);
			setTestcaseStatus("FAIL", "Không thể lưu kết quả Kết Luận , đã gặp sự cố !");
		} else {
			setTestcaseStatus("PASS", "Đã Lưu được kết quả kết luận ! ");

		}

		// In giay kham benh
		clickOn(FormKhamBenh.FormKhamBenh_NutIn);
		waitForObjectPresent(FormKhamBenh.FormKhamBenh_NutInGiayKhamBenh, 4);
		clickOn(FormKhamBenh.FormKhamBenh_NutInGiayKhamBenh);
		// Neu ton tai giay kham benh , danh PASS va thoat ra man hinh nay
		// nguoc lai danh FAIL khong in ra giay kham benh

	}

	// Khám bệnh - Lịch sử khám bệnh
	@Test(priority = 7)
	public void DichVu_13771_7() {
		setClipboardValue("");
		clickOn(FormKhamBenh.Menu_LichSuKhamBenh);
		moveMouseDownFromLogo(FormKhamBenh.LichSuKhamBenh, 55);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		TestLogger.info(" ==>lich su kham benh : " + getClipboardValue());

		if (getClipboardValue().contains(noiDungBenhChinh)) {
			setTestcaseStatus("PASS", "Đã hiện thị lịch sử khám bệnh của bệnh nhân");
		} else {
			setTestcaseStatus("FAIL", "Không hiện thị lịch sử khám bệnh của bệnh nhân");
		}
	}

	// Thoat khoi tai khoan BS01, dang nhap vao THUNGAN01 de thu tien benh nhan
	// kham dich vu
	@Test(priority = 8)
	public void DichVu_13771_8() {

		// THOAT va dang nhap voi tai khoan THU NGAN 01
		thoatTaikhoanvaDangNhapBangTaikhoankhac(HisActions.ten_dangNhap_THUNGAN01,
				HisActions.matKhau_dangNhap_THUNGAN01);

		// Chon phong lam viec :
		chonPhongLamViec("Viện phí ngoại trú");
		sleep(6);
		TestLogger.info("Thanh Toan Vien Phi ");
		waitForObjectPresent(MenuVienPhi, 5);
		clickOn(HisActions.MenuVienPhi);
		// click on SubMenu Vien Phi
		moveMouseDownFromLogo(HisActions.MenuVienPhi, 30);
		s.click();
		vpnt.nhapChungTu();
		vpnt.dienSoTiepNhan(soTiepNhan);

		if (waitForObjectPresent(FormVienPhiNgoaiTru.VienPhiNgoaiTru_SoDongBang1, 3)) {
			setTestcaseStatus("PASS", "Đã tìm thấy thông tin người cần thanh toán viện phí  ");
			vpnt.clickOn(FormVienPhiNgoaiTru.VienPhiNgoaiTru_Luu);
			if (waitForObjectPresent(HisActions.HIS_LOI_UNGDUNG, 2)) {
				s.type(Key.ENTER);
				setTestcaseStatus("FAIL", "Không thể lưu kết quả thanh toán Viện phí , đã gặp sự cố !");
			} else {
				setTestcaseStatus("PASS", "Đã Lưu được kết quả thanh toán Viện phí ! ");

			}
		} else {
			setTestcaseStatus("FAIL", "Không tìm thấy thông tin người cần thanh toán viện phí ! ");

		}

	}

	@AfterTest
	public void ketThucLuong() {
		dangXuatKhoiTaikhoan();
		thoatUngdungHIS();
	}

}
