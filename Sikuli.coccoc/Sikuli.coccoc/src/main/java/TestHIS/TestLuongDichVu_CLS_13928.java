package TestHIS;

import org.sikuli.script.Key;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HIS.BacSiChuanDoanHinhAnh;
import HIS.DanhSachBenhNhan;
import HIS.FormKhamBenh;
import HIS.FormKhuVuc;
import HIS.FormVienPhiNgoaiTru;
import HIS.TiepNhanBenhNhan;
import HIS.TiepNhanChuanDoanHinhAnh;
import desktop_Framework.HisActions;
import desktop_Framework.TestLogger;
import desktop_Framework.TienIch;

public class TestLuongDichVu_CLS_13928 extends TiepNhanBenhNhan {

	public String Hoten, NgaySinh, SoCMND, GioiTinh, SoDienThoai, NgheNghiep, DanToc, NhapNhanh, SoNha, NoiLamViec;
	public String NguoiLienHe, SoDienThoaiNguoiLienHe, DoiTuong, UuTien, HinhThuc, LiDo, TenDichVu, ThuTienSau,
			NoiThucHien, KetLuanCuoiCung;
	public static String soTiepNhan;
	public static String soPhieu;
	DanhSachBenhNhan dsbn = new DanhSachBenhNhan();
	FormVienPhiNgoaiTru vpnt = new FormVienPhiNgoaiTru();
	FormKhamBenh kb = new FormKhamBenh();
	TiepNhanChuanDoanHinhAnh tncdha = new TiepNhanChuanDoanHinhAnh();
	BacSiChuanDoanHinhAnh bscdha = new BacSiChuanDoanHinhAnh();

	@BeforeTest
	public void dieukienDauTien() {

		if (khoiDongHIS(HisActions.DUONG_DAN_FILE_CHAY_HIS) == true) {
			dangNhapHIS(FormKhuVuc.ten_dangNhap_TDNT, FormKhuVuc.matKhau_dangNhap_TDNT);
			chonPhongLamViec("Tiếp đón ngoại trú");
			moMenuTiepNhanBenhNhan();
		} else
			setTestcaseStatus("FAIL", "Không thể khởi động ứng dụng HIS !");
	}

	@Test(priority = 1)
	public void DichVu_13928_1() {

		// 1.HÀNH CHÍNH
		TestLogger.info("Điền Họ tên :");
		Hoten = "Nguyen Viet Ha" + TienIch.taoRandomChu(5) ;
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

		TenDichVu = "(Hằng test) Khám tổng quát ";
		dienTenDichVu(TenDichVu);
		s.type(Key.TAB);

		sleep(3);
		NoiThucHien = "Khám theo yêu cầu";
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

			setTestcaseStatus("FAIL", "Tiếp nhận Bệnh nhân không thành công !");
		}

	}

	@Test(priority = 2)
	public void DichVu_13928_2() {
		
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
	}

	// dang xuat ra khoi TD01 va dang nhap BS01 de kham cho benh nhan
	@Test(priority = 3)
	public void DichVu_13928_3() {

		clickOn(TiepNhanBenhNhan_HeThong);
		clickOn(TiepNhanBenhNhan_DangXuat);

		clickOn(TiepNhanBenhNhan_HeThong);
		clickOn(TiepNhanBenhNhan_DangNhap);

		dangNhapHIS(HisActions.ten_dangNhap_BS01, HisActions.matKhau_dangNhap_BS01);
		chonPhongLamViec("Khám theo yêu cầu");
		moMenuTiepNhanBenhNhan();

		waitForObjectPresent(HisActions.HIS_MenuKhamBenh, 5);
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
	public void DichVu_13928_4() {
		waitForObjectPresent(FormKhamBenh.FormKhamBenh_doChiSoSinhTon, 5);
		clickOn(FormKhamBenh.FormKhamBenh_doChiSoSinhTon);
		kb.dienBenhManTinh("tieu chay");
		kb.dienDiUng("phan hoa");
		kb.chonNhomMau("a");
		kb.chonYeuToRH("+");
		s.type(Key.TAB);
		TestLogger.info("Do Mach");
		s.type("120");
		s.type(Key.TAB);
		TestLogger.info("Do Huyet Ap");
		s.type("100");
		s.type(Key.TAB);
		s.type("140");
		s.type(Key.TAB);
		TestLogger.info("Do nhiet do");
		s.type("37");
		s.type(Key.TAB);
		TestLogger.info("Do nhip tho");
		s.type("110");
		s.type(Key.TAB);
		TestLogger.info("Do can nang");
		s.type("5");
		s.type(Key.TAB);
		TestLogger.info("Do chieu cao");
		s.type("57");
		// click Luu chỉ số sinh tồn
		clickOn(FormKhamBenh.FormKhamBenh_LuuChiSoSinhTon);
		if (waitForObjectPresent(HisActions.HIS_LOI_UNGDUNG, 2)) {
			s.type(Key.ENTER);
			setTestcaseStatus("FAIL", "Lưu Chỉ số sinh tồn gặp sự cố !");
		} else {
			setTestcaseStatus("PASS", "Đã Lưu được chỉ số sinh tồn ");

		}

	}

	// BS01 kham benh cho benh nhan va de nghi kham CLS
	@Test(priority = 5)
	public void DichVu_13928_5() {
		clickOn(FormKhamBenh.FormKhamBenh_KhamBenh);
		kb.dienLiDoKham("Dau Bung");
		kb.dienTrieuChungLS("Tào tháo đuổi tập 5");
		kb.dienBenhChinhDefault();
		clickOn(FormKhamBenh.FormKhamBenh_Luu);
		if (waitForObjectPresent(HisActions.HIS_LOI_UNGDUNG, 2)) {
			s.type(Key.ENTER);
			setTestcaseStatus("FAIL", "Không thể lưu kết quả khám bệnh , gặp sự cố !");
		} else {
			setTestcaseStatus("PASS", "Đã Lưu được kết quả khám bệnh ! ");

		}

	}

	// BS01 cho benh nhan kham CLS va chi dinh phong de kham

	@Test(priority = 6)
	public void DichVu_13928_6() {
		sleep(5);
		clickOn(FormKhamBenh.FormKhamBenh_ChiDinhCanLamSang);
		sleep(4);
		waitForObjectPresent(FormKhamBenh.FormKhamBenh_ChonMaDichVu, 4);
		kb.chonMaDichVu("CT0006");
		clickToaDo(1248, 240);
		/*moveMouseDownFromLogo(FormKhamBenh.FormKhamBenh_ThuTienSau, 40);
		s.doubleClick();*/
		// Click on button Luu
		clickOn(FormKhamBenh.FormKhamBenh_LuuChiSoSinhTon);
		sleep(3);
		clickOn(FormKhamBenh.FormKhamBenh_In);
		sleep(3);
		waitForObjectPresent(FormKhamBenh.FormKhamBenh_SoPhieu, 5);
		clickOn(FormKhamBenh.FormKhamBenh_SoPhieu);
		s.type("c", Key.CTRL);
		String s1 = getClipboardValue();
		soPhieu = kb.getSophieuTuChuoi(s1);
		s.type(Key.F4, Key.ALT);
		TestLogger.info(soPhieu);
		if (soPhieu.length() > 0) {
			setTestcaseStatus("PASS", "Đã in phiếu chụp CT thành công ");
		} else {
			setTestcaseStatus("FAIL", "Không in thành công ");
		}
	}

	// TNCDHA01 se chup CT cho benh nhan
	@Test(priority = 7)
	public void DichVu_13928_7() {
		thoatTaikhoanvaDangNhapBangTaikhoankhac(HisActions.ten_dangNhap_TNCDHA01, HisActions.matKhau_dangNhap_TNCDHA01);
		chonPhongLamViec("Phòng siêu âm tổng quát");
		tncdha.clickOn(TiepNhanChuanDoanHinhAnh.MenuCanLamSang);
		sleep(2);
		tncdha.hoverImage(TiepNhanChuanDoanHinhAnh.SubMenuChuanDoanHinhAnh);
		sleep(2);
		tncdha.clickOn(TiepNhanChuanDoanHinhAnh.SubMenuTiepNhan);
		waitForObjectPresent(TiepNhanChuanDoanHinhAnh.SoPhieu, 10);
		tncdha.dienSoPhieu(soPhieu);
		sleep(5);
		clickOn(TiepNhanChuanDoanHinhAnh.NutLuu);
		if (waitForObjectPresent(TiepNhanChuanDoanHinhAnh.HoiThoaiCapNhatThanhCong, 5)) {
			s.type(Key.ENTER);
			thoatTaikhoanvaDangNhapBangTaikhoankhac(HisActions.ten_dangNhap_BSCDHA01,
					HisActions.matKhau_dangNhap_BSCDHA01);
			chonPhongLamViec("Phòng siêu âm tổng quát");
			setTestcaseStatus("PASS", "Đã tiếp nhận chụp chuẩn đoán hình ảnh thành công !");
		} else {
			setTestcaseStatus("FAIL", "Không thể tiếp nhận chụp chuẩn đoán hình ảnh thành công !");
		}

	}

	// BSCDHA01 se tao ket luan cho benh nhan
	@Test(priority = 8)
	public void DichVu_13928_8() {
		thoatTaikhoanvaDangNhapBangTaikhoankhac(HisActions.ten_dangNhap_BSCDHA01, HisActions.matKhau_dangNhap_BSCDHA01);
		chonPhongLamViec("Phòng siêu âm tổng quát");
		waitForObjectPresent(TiepNhanChuanDoanHinhAnh.MenuCanLamSang, 6);
		bscdha.clickOn(TiepNhanChuanDoanHinhAnh.MenuCanLamSang);
		sleep(2);
		tncdha.hoverImage(TiepNhanChuanDoanHinhAnh.SubMenuChuanDoanHinhAnh);
		sleep(2);
		bscdha.clickOn(BacSiChuanDoanHinhAnh.SubMenu_KetQua_XQCTMRI);
		bscdha.dienSophieu(soPhieu);
		sleep(5);
		bscdha.dienNguoiThucHienLa_TNCDHA01();
		bscdha.dienNoiDung("Bệnh thông thường , không có gì nghiêm trọng, cho về .");
		KetLuanCuoiCung = "Cho về";
		bscdha.dienKetLuan(KetLuanCuoiCung);
		bscdha.dienDeNghi("Chỉ cần giữ sức khỏe và ăn uống tốt là được ");
		bscdha.clickOn(BacSiChuanDoanHinhAnh.LuuvaDuyet);
		if (waitForObjectPresent(BacSiChuanDoanHinhAnh.KetQuaDuyetThanhCong, 5)) {
			setTestcaseStatus("PASS", "Đã kết luận bệnh thành công sau khi xem Hình ảnh");
		} else {
			setTestcaseStatus("FAIL", "Lỗi lưu kết luận bệnh sau khi xem chuẩn đoán hình ảnh !!");
		}

	}
	// BS01 se dua vao ket ket luan cua bac si BSCDHA01 de dua ra ket luan cuoi
	// cung

	@Test(priority = 9)
	public void DichVu_13928_9() {
		thoatTaikhoanvaDangNhapBangTaikhoankhac(HisActions.ten_dangNhap_BS01, HisActions.matKhau_dangNhap_BS01);
		chonPhongLamViec("Khám theo yêu cầu");
		sleep(5);
		waitForObjectPresent(FormKhamBenh.HIS_MenuKhamBenh, 5);
		kb.clickOn(FormKhamBenh.HIS_MenuKhamBenh);
		sleep(4);
		waitForObjectPresent(FormKhamBenh.FormKhamBenh_KetQuaCanLamSang, 6);
		kb.dienSoTiepNhan(soTiepNhan);
		kb.clickOn(FormKhamBenh.FormKhamBenh_TimKiem);
		if (waitForObjectPresent(FormKhamBenh.FormKhamBenh_soDongBang1, 2)) {
			moveMouseDownFromLogo(DanhSachBenhNhan.DanhSachBenhNhan_NutF5, 93);
			s.doubleClick();
			sleep(6);
			clickOn(FormKhamBenh.FormKhamBenh_KetQuaCanLamSang);
			clickOn(FormKhamBenh.FormKhamBenh_CDHA_TDCN);
			moveMouseDownFromLogo(FormKhamBenh.FormKhamBenh_CDHA_TDCN, 72);
			s.click();
			s.type("c", Key.CTRL);
			String chuoiKetKuan = getClipboardValue();
			TestLogger.info("===== Testcase 9=====");
			TestLogger.info(chuoiKetKuan);
			TestLogger.info(KetLuanCuoiCung);

			if (chuoiKetKuan.contains(KetLuanCuoiCung)) {
				setTestcaseStatus("PASS", "Đã nhận được kết luận từ CLS");
			} else {
				setTestcaseStatus("FAIL", "Không nhận được kết luận từ CLS");
			}
		} else {
			setTestcaseStatus("FAIL", "Không tìm thấy bệnh nhân với mã số Bênh nhân " + soTiepNhan);
		}

	}

	// BS01 ket luan kham : cho ve khong ke toa thuoc
	@Test(priority = 10)
	public void DichVu_13928_10() {
		clickOn(FormKhamBenh.FormKhamBenh_KetLuan);
		moveMouseHorizontallyFromLogo(FormKhamBenh.FormKhamBenh_HuongDieuTri, 296);
		s.click();
		clickOn(FormKhamBenh.FormKhamBenh_HuongDieuTri_ChoVeKhongToa);
		sleep(2);
		clickOn(FormKhamBenh.FormKhamBenh_LuuVaHoanThanh);
		if (waitForObjectPresent(HisActions.HIS_LOI_UNGDUNG, 2)) {
			s.type(Key.ENTER);
			setTestcaseStatus("FAIL", "Không thể lưu kết quả Kết Luận cuối cùng của bác sĩ , đã gặp sự cố !");
		} else {
			setTestcaseStatus("PASS", "Đã Lưu được kết quả kết luận ! ");

		}
	}

	// Thoat khoi tai khoan BS01, dang nhap vao THUNGAN01 de thu tien benh nhan
	// kham dich vu

	@Test(priority = 11)
	public void DichVu_13928_11() {

		// THOAT va dang nhap voi tai khoan THU NGAN 01
		thoatTaikhoanvaDangNhapBangTaikhoankhac(HisActions.ten_dangNhap_THUNGAN01,
				HisActions.matKhau_dangNhap_THUNGAN01);
		// Chon phong lam viec :
		chonPhongLamViec("Viện phí ngoại trú");
		sleep(4);
		TestLogger.info("Thanh Toan Vien Phi ");
		waitForObjectPresent(MenuVienPhi, 5);
		clickOn(HisActions.MenuVienPhi);
		// click on SubMenu Vien Phi
		moveMouseDownFromLogo(HisActions.MenuVienPhi, 30);
		s.click();
		sleep(4);
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
	}

}
