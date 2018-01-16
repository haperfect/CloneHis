package TestHIS;

import java.sql.SQLException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HIS.DanhSachBenhNhan;
import HIS.FormChuyenPhongKham;
import HIS.FormKhamBenh;
import HIS.FormKhuVuc;
import HIS.FormVienPhiNgoaiTru;
import HIS.TiepNhanBenhNhan;
import desktop_Framework.HisActions;
import desktop_Framework.TestLogger;
import desktop_Framework.TienIch;

public class TestFormTiepNhanBenhNhan extends TiepNhanBenhNhan {

	public String Hoten, NgaySinh, SoCMND, GioiTinh, SoDienThoai, NgheNghiep, DanToc, NhapNhanh, SoNha, NoiLamViec;
	public String NguoiLienHe, SoDienThoaiNguoiLienHe, DoiTuong, UuTien, HinhThuc, LiDo, TenDichVu, ThuTienSau,
			NoiThucHien;
	public String soTiepNhan;
	HisActions his = new HisActions();
	DanhSachBenhNhan dsbn = new DanhSachBenhNhan();

	@BeforeTest
	public void dieukienDauTien() {
		if (his.khoiDongHIS(HisActions.DUONG_DAN_FILE_CHAY_HIS) == true) {
			his.dangNhapHIS(FormKhuVuc.ten_dangNhap_admin, FormKhuVuc.matKhau_dangNhap_admin);
			his.chonPhongLamViec("Khám TMH");
			moMenuTiepNhanBenhNhan();
		} else
			setTestcaseStatus("FAIL", "Không thể khởi động ứng dụng HIS !");
	}

	@Test(priority = 1)
	public void tiepNhanBenhNhan_9870_1() {

		sleep(3);
		clickToaDo(637, 540);

		TestLogger.info("[Hành chính] Kiểm tra validate trường Họ tên");
		TestLogger.info("1.Kiểm tra giá trị mặc định Text box Họ tên");
		TestLogger.info("Expect : Giá trị mặc định là trống");
		if (getHoten().length() == 0) {
			setTestcaseStatus("PASS", "Giá trị mặc định là trống");
		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định là trống");
		}

	}

	@Test(priority = 2)
	public void tiepNhanBenhNhan_9870_2() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Họ tên");
		TestLogger.info("2.Kiểm tra việc nhập ký tự đặc biệt ^^ vào trường Họ tên");
		TestLogger.info("Expect : Confirm có thể nhập ký tự đặc biệt và được view lên bình thường, không có lỗi font");
		dienHoTen("nguyen viet ^^");
		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);
		if (getHoten().equalsIgnoreCase("nguyen viet ^^")) {

			setTestcaseStatus("PASS",
					"Confirm có thể nhập ký tự đặc biệt và được view lên bình thường, không có lỗi font");
		} else {
			setTestcaseStatus("FAIL",
					"Confirm có thể nhập ký tự đặc biệt và được view lên bình thường, không có lỗi font");
		}

	}

	@Test(priority = 3)
	public void tiepNhanBenhNhan_9870_3() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Họ tên");
		TestLogger.info("3.Kiểm tra việc để trống trường dữ liệu Họ tên");
		TestLogger.info("Expect : Hiển thị thông báo Họ tên không được để trống, và không cho phép Lưu");
		dienHoTen("");
		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_Luu);

		if (waitForObjectPresent(CanhBaoHoTen, 5)) {
			s.type(Key.ENTER);
			setTestcaseStatus("PASS", "Hiển thị thông báo Họ tên không được để trống, và không cho phép Lưu");
		} else {
			setTestcaseStatus("FAIL", "Hiển thị thông báo Họ tên không được để trống, và không cho phép Lưu");
		}
	}

	@Test(priority = 4)
	public void tiepNhanBenhNhan_9870_4() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Họ tên");
		TestLogger.info("4.Kiểm tra việc nhập Họ tê  vượt quá maxlength 500 ký tự cho phép (256 ký tự)");
		TestLogger.info("Expect : Confirm từ ký tự 256 trở đi sẽ không nhận giá trị");
		dienHoTen(TienIch.taoRandomChu(502));
		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);
		if (getHoten().length() == 500) {
			TestLogger.info("==> " + getHoten().length());
			setTestcaseStatus("PASS", "Confirm từ ký tự 501 trở đi sẽ không nhận giá trị");
		} else {
			TestLogger.info("==> " + getHoten().length());
			setTestcaseStatus("FAIL", "Confirm từ ký tự 500 trở đi sẽ không nhận giá trị");
		}
	}

	@Test(priority = 5)
	public void tiepNhanBenhNhan_9870_5() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Họ tên");
		TestLogger.info("5.Kiểm tra việc nhập không quá maxlength là 500 ký tự ");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		dienHoTen(TienIch.taoRandomChu(500));
		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);
		if (getHoten().length() == 500) {
			TestLogger.info("==> " + getHoten().length());
			setTestcaseStatus("PASS", "Confirm từ ký tự 500 trở đi sẽ không nhận giá trị");
		} else {
			TestLogger.info("==> " + getHoten().length());
			setTestcaseStatus("FAIL", "Confirm từ ký tự 500 trở đi sẽ không nhận giá trị");
		}
	}

	@Test(priority = 6)
	public void tiepNhanBenhNhan_9870_6() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Họ tên");
		TestLogger.info("6.Kiểm tra việc nhập không quá maxlength là 500 ký tự ");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		dienHoTen(TienIch.taoRandomChu(255));
		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);
		if (getHoten().length() == 255) {
			TestLogger.info("==> " + getHoten().length());
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công");
		} else {
			TestLogger.info("==> " + getHoten().length());
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test(priority = 7)
	public void tiepNhanBenhNhan_9870_7() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Họ tên");
		TestLogger.info("7.Kiểm tra việc nhập câu lệnh javascript: <script>alert(test)</script>");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		dienHoTen("<script>alert(test)</script>");
		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);
		if (getHoten().equalsIgnoreCase("<script>alert(test)</script>")) {
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công");
		} else {
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test(priority = 8)
	public void tiepNhanBenhNhan_9907_1() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Ngày sinh");
		TestLogger.info("Kiểm tra giá trị mặc định");
		dienHoTen("Nguyễn Việt Hà");
		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);
		TestLogger.info("Expect : Mặc định là trống ");

		if (getNgaySinh().length() == 0) {
			setTestcaseStatus("PASS", "Mặc định là trống");
		} else {
			setTestcaseStatus("FAIL", "Mặc định là trống");
		}
	}

	@Test(priority = 9)
	public void tiepNhanBenhNhan_9907_2() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Ngày sinh");
		TestLogger.info("Kiểm tra giá trị mặc định");
		dienHoTen("Nguyễn Việt Hà");
		clickOn(TiepNhanBenhNhan.TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);
		TestLogger.info("Expect : Mặc định là trống ");
		if (getNgaySinh().length() == 0) {
			setTestcaseStatus("PASS", "Mặc định là trống");
		} else {
			setTestcaseStatus("FAIL", "Mặc định là trống");
		}
	}

	@Test(priority = 10)
	public void tiepNhanBenhNhan_9930_1() throws SQLException {

		TestLogger.info("[Hành chính] Kiểm tra validate trường số CMND");
		TestLogger.info("Expect : Giá trị mặc định là trống");
		if (getSoCMND().length() == 0) {
			setTestcaseStatus("PASS", "Giá trị mặc định là trống");
		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định là trống");
		}

	}

	@Test(priority = 11)
	public void tiepNhanBenhNhan_9930_2() throws SQLException {

		TestLogger.info("[Hành chính] Kiểm tra validate trường số CMND");
		TestLogger.info("Kiểm tra nhập giá trị là chữ");
		TestLogger.info("Expect : Cho phép nhập lưu");
		sleep(3);
		dienSoCMND("chet12345678");
		clickOn(TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);

		if (getSoCMND().equals("chet12345678")) {
			setTestcaseStatus("PASS", "Cho phép nhập lưu");
		} else {
			setTestcaseStatus("FAIL", "Cho phép nhập lưu");
		}

	}

	@Test(priority = 12)
	public void tiepNhanBenhNhan_9930_3() throws SQLException {

		TestLogger.info("[Hành chính] Kiểm tra validate trường số CMND");
		TestLogger.info("Kiểm tra nhập giá trị là số");
		TestLogger.info("Expect : Cho phép nhập lưu");
		sleep(3);
		dienSoCMND("12345678");
		clickOn(TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);

		if (getSoCMND().equals("12345678")) {
			setTestcaseStatus("PASS", "Cho phép nhập lưu số");
		} else {
			setTestcaseStatus("FAIL", "Cho phép nhập lưu số ");
		}
	}

	@Test(priority = 13)
	public void tiepNhanBenhNhan_9930_4() throws SQLException {

		TestLogger.info("[Hành chính] Kiểm tra validate trường số CMND");
		TestLogger.info("Kiểm tra việc nhập ký tự đặc biệt ^^^^");
		TestLogger.info("Expect : không cho phép nhập lưu");
		sleep(3);
		dienSoCMND("^^^^");
		clickOn(TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);

		if (getSoCMND().length() == 0) {
			setTestcaseStatus("PASS", "Không cho phép nhập lưu số");
		} else {
			setTestcaseStatus("FAIL", "Vẫn cho phép nhập lưu số ");
		}
	}

	@Test(priority = 14)
	public void tiepNhanBenhNhan_9930_5() throws SQLException {

		TestLogger.info("[Hành chính] Kiểm tra validate trường số CMND");
		TestLogger.info("Kiểm tra nhập ký tự tr 9 hoặc 12 ký tự");
		TestLogger.info("Expect : Cho phép nhập lưu");
		sleep(3);
		dienSoCMND(TienIch.taoRandomSovaChu(9));
		clickOn(TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);

		if (getSoCMND().length() == 9) {
			setTestcaseStatus("PASS", "Cho phép nhập lưu số");
		} else {
			setTestcaseStatus("FAIL", "Không cho phép nhập lưu số ");
		}

		dienSoCMND(TienIch.taoRandomSovaChu(12));
		clickOn(TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);

		if (getSoCMND().length() == 12) {
			setTestcaseStatus("PASS", "Cho phép nhập lưu số");
		} else {
			setTestcaseStatus("FAIL", "Không cho phép nhập lưu số ");
		}
	}

	@Test(priority = 15)
	public void tiepNhanBenhNhan_9930_6() throws SQLException {

		TestLogger.info("[Hành chính] Kiểm tra validate trường số CMND");
		TestLogger.info("Kiểm tra nhập ký tự > 12 ký tự");
		TestLogger.info("Expect : Chặn luôn kể từ ký tự thứ 13");
		sleep(3);
		dienSoCMND(TienIch.taoRandomSovaChu(13));
		clickOn(TiepNhanBenhNhan_Luu);
		s.type(Key.ENTER);

		if (getSoCMND().length() == 12) {
			setTestcaseStatus("PASS", "Chặn luôn kể từ ký tự thứ 13");
		} else {
			setTestcaseStatus("FAIL", "Chặn luôn kể từ ký tự thứ 13 ");
		}

	}

	@Test(priority = 16)
	public void tiepNhanBenhNhan_9930_7() throws SQLException {

		TestLogger.info("[Hành chính] Kiểm tra validate trường số CMND");
		TestLogger.info("Kiểm tra nhập ký tự < 9 ký tự");
		TestLogger.info("Expect : Thông báo số đt không hợp lệ");
		sleep(3);
		dienSoCMND(TienIch.taoRandomSovaChu(8));
		clickOn(TiepNhanBenhNhan_Luu);

		if (waitForObjectPresent(Hochieu_cmnd, 4)) {
			s.type(Key.ENTER);
			setTestcaseStatus("PASS", "Thông báo số CMND không hợp lệ");
		} else {
			setTestcaseStatus("FAIL", "Thông báo số CMND không hợp lệ ");
		}

	}

	@Test(priority = 17)
	public void tiepNhanBenhNhan_10010_1() throws SQLException {

		TestLogger.info("Kiểm tra giá trị mặc định Text box Số nhà");
		TestLogger.info("Giá trị mặc định là trống");
		if (getSoNha().length() == 0) {
			setTestcaseStatus("PASS", "Giá trị mặc định là trống");
		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định là trống");
		}

	}

	@Test(priority = 18)
	public void tiepNhanBenhNhan_10010_2() throws SQLException {

		TestLogger.info("Kiểm tra việc nhập ký tự đặc biệt ^^^*- vào trường Số nhà");
		TestLogger.info("Confirm có thể nhập ký tự đặc biệt và được view lên bình thường, không có lỗi font");
		dienSoNha("So nha ^^^^");
		if (getSoNha().equals("So nha ^^^^")) {

			setTestcaseStatus("PASS",
					"Confirm có thể nhập ký tự đặc biệt và được view lên bình thường, không có lỗi font");
		} else {
			setTestcaseStatus("FAIL",
					"Confirm có thể nhập ký tự đặc biệt và được view lên bình thường, không có lỗi font");
		}

	}

	@Test(priority = 18)
	public void tiepNhanBenhNhan_10010_3() throws SQLException {

		TestLogger.info("Kiểm tra việc nhập Số nhà vượt quá maxlength 30 ký tự cho phép (31 ký tự) ");
		dienSoNha(TienIch.taoRandomSovaChu(31));
		TestLogger.info("Confirm từ ký tự 31 trở đi sẽ không nhận giá trị");
		if (getSoNha().length() == 30) {
			setTestcaseStatus("PASS", "ký tự 31 trở đi sẽ không nhận giá trị");
		} else {
			setTestcaseStatus("FAIL", "ký tự 31 trở đi sẽ không nhận giá trị");
		}

	}

	@Test(priority = 19)
	public void tiepNhanBenhNhan_10010_4() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Số nhà");
		TestLogger.info("4.Kiểm tra việc nhập Số nhà vượt quá maxlength 30 ký tự cho phép (31 ký tự)");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = TienIch.taoRandomSo(31);
		dienSoNha(SoNha);
		clickOn(TiepNhanBenhNhan_Luu);
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

		if (getSoNha().length() >= 31) {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL", "SoNha vẫn nhận hơn 30 kí tự");
		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("PASS", "SoNha không nhận hơn 30 kí tự ");
		}
	}

	@Test(priority = 20)
	public void tiepNhanBenhNhan_10010_5() {
		TestLogger.info("Kiểm tra việc nhập với ngôn ngữ Tiếng Việt có dấu ");
		TestLogger.info(
				"5.Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");

		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		clickOn(TiepNhanBenhNhan_Luu);
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
		if (getSoNha().equals("Số 78 Hàng Ngang")) {
			setTestcaseStatus("PASS",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);

		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
		}
	}

	@Test(priority = 21)
	public void tiepNhanBenhNhan_10028_1() {
		TestLogger.info("[Tiếp nhận] Kiểm tra Validate checkbox Ưu tiên");
		TestLogger.info("Giá trị mặc định của  checkbox");
		TestLogger.info("Expect : Mặc định uncheck");
		if (waitForObjectAppearOnRegion(TiepNhanBenhNhan_DoiTuong, TiepNhanBenhNhan_UuTien_Unchecked, 306, 32, 3)) {
			setTestcaseStatus("PASS", "Mặc định uncheck");
		} else {
			setTestcaseStatus("FAIL", "Mặc định là khác uncheck");
		}

	}

	@Test(priority = 22)
	public void tiepNhanBenhNhan_10028_2() {
		TestLogger.info("Kiểm tra việc CHECK check box ");
		TestLogger.info("Expect : Cho phép check chọn check box");
		clickOn(TiepNhanBenhNhan_UuTien);
		if (waitForObjectAppearOnRegion(TiepNhanBenhNhan_DoiTuong, TiepNhanBenhNhan_UuTien_Unchecked, 306, 32, 3)) {
			setTestcaseStatus("FAIL", "Không Cho phép check chọn check box");
		} else {
			setTestcaseStatus("PASS", "Đã thay đổi được trạng thái checkbox");
		}

	}

	@Test(priority = 23)
	public void tiepNhanBenhNhan_9972_1() {
		TestLogger.info("Kiểm tra giá trị mặc định Text box Nơi làm việc ");
		TestLogger.info("Expect : Giá trị mặc định là trống");
		if (getNoiLamViec().length() == 0) {
			setTestcaseStatus("PASS", "Giá trị mặc định là trống");

		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định không là trống");
		}
	}

	@Test(priority = 23)
	public void tiepNhanBenhNhan_9972_2() {
		TestLogger.info("Kiểm tra việc nhập ký tự đặc biệt ^^^ - vào trường Nơi làm việc");
		TestLogger.info("Confirm có thể nhập ký tự đặc biệt và được view lên bình thường, không có lỗi font");

		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Số ^^^^^^^^");
		clickOn(TiepNhanBenhNhan_Luu);

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
		if (getNoiLamViec().equals("Số ^^^^^^^^")) {
			setTestcaseStatus("PASS",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);

		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
		}

	}

	@Test(priority = 24)
	public void tiepNhanBenhNhan_9972_4_5() {
		TestLogger.info("Kiểm tra việc nhập Nơi làm việc  vượt quá maxlength 255 ký tự cho phép (256 ký tự)");
		dienNoiLamViec(TienIch.taoRandomChu(256));
		TestLogger.info("Confirm từ ký tự 256 trở đi sẽ không nhận giá trị");
		if (getNoiLamViec().length() > 255) {
			setTestcaseStatus("FAIL", "từ ký tự 256 trở đi sẽ không nhận giá trị");

		} else {
			setTestcaseStatus("PASS", "từ ký tự 256 trở đi sẽ không nhận giá trị");
		}

	}

	@Test(priority = 25)
	public void tiepNhanBenhNhan_9972_6() {
		TestLogger.info("Kiểm tra việc nhập với ngôn ngữ Tiếng Việt có dấu");
		TestLogger.info(
				"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");

		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Số 72 ngõ Đống Đa");
		clickOn(TiepNhanBenhNhan_Luu);

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
		if (getNoiLamViec().equals("Số 72 ngõ Đống Đa")) {
			setTestcaseStatus("PASS",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);

		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
		}

	}

	@Test(priority = 26)
	public void tiepNhanBenhNhan_9976_1() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Người liên hệ");
		TestLogger.info("Kiểm tra giá trị mặc định Text box Người liên hệ");
		TestLogger.info("Expect : Giá trị mặc định là trống");
		if (getNguoiLienHe().length() == 0) {
			setTestcaseStatus("PASS", "Giá trị mặc định là trống");
		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định hiện không trống !");
		}
	}

	@Test(priority = 27)
	public void tiepNhanBenhNhan_9976_2() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Người liên hệ");
		TestLogger.info("Kiểm tra việc nhập ký tự đặc biệt vào trường Người liên hệ");
		TestLogger.info("Confirm có thể nhập ký tự đặc biệt và được view lên bình thường, không có lỗi font");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Số ^^^^^^^^");
		dienNguoiLienHe("Liên Hệ ^^^^");
		clickOn(TiepNhanBenhNhan_Luu);

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
		if (getNguoiLienHe().equals("Liên Hệ ^^^^")) {
			setTestcaseStatus("PASS",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);

		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
		}

	}

	@Test(priority = 28)
	public void tiepNhanBenhNhan_9976_4() {
		TestLogger.info("Kiểm tra việc nhập Người liên hệ  vượt quá maxlength 100 ký tự cho phép (101 ký tự)   ");
		TestLogger.info("Confirm từ ký tự 101 trở đi sẽ không nhận giá trị");
		dienNguoiLienHe(TienIch.taoRandomChu(101));
		if (getNguoiLienHe().length() == 100) {
			setTestcaseStatus("PASS", "Ký tự 101 trở đi sẽ không nhận giá trị");
		} else {
			setTestcaseStatus("FAIL", "Ký tự thứ 101 trở đi vẫn nhận giá trị");
		}
	}

	@Test(priority = 29)
	public void tiepNhanBenhNhan_9976_5() {
		TestLogger.info("Kiểm tra việc nhập không quá maxlength là 100 ký tự ");
		TestLogger.info("Confirm cho phép thêm mới thành công");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Số ^^^^^^^^");
		dienNguoiLienHe(TienIch.taoRandomSovaChu(100));
		clickOn(TiepNhanBenhNhan_Luu);

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
		if (getNguoiLienHe().length() == 100) {
			setTestcaseStatus("PASS",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);

		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
		}

	}

	@Test(priority = 30)
	public void tiepNhanBenhNhan_9976_6() {
		TestLogger.info("Kiểm tra việc nhập không quá maxlength là 100 ký tự ");
		TestLogger.info("Confirm cho phép thêm mới thành công");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Số ^^^^^^^^");
		dienNguoiLienHe("Nguyễn Công");
		clickOn(TiepNhanBenhNhan_Luu);

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
		if (getNguoiLienHe().equals("Nguyễn Công")) {
			setTestcaseStatus("PASS",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);

		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL",
					"Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
		}

	}

	@Test(priority = 31)
	public void tiepNhanBenhNhan_9865_1() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Giới tính");
		TestLogger.info("Kiểm tra giá trị radio button Giới tính");
		TestLogger.info("3 giá trị Nam, Nữ, Không xác định");
		if (waitForObjectPresent(TiepNhanBenhNhan_GioiTinhNamNuKhongXacDinh, 5)) {
			setTestcaseStatus("PASS", "Show 3 giá trị Nam, Nữ, Không xác định");
		} else {
			setTestcaseStatus("FAIL", "Không show 3 giá trị Nam, Nữ, Không xác định");

		}
	}

	@Test(priority = 32)
	public void tiepNhanBenhNhan_9865_2() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Giới tính");
		TestLogger.info("Kiểm tra giá trị mặc định ");
		TestLogger.info("Expect : Mặc định giới tính nam");
		if (waitForObjectAppearOnRegion(TiepNhanBenhNhan_HoTen, TiepNhanBenhNhan_GioiTinh_Radio_Checked, 357, 29, 5)) {
			setTestcaseStatus("PASS", "Mặc định giới tính nam");
		} else {
			setTestcaseStatus("FAIL", "Giá trị giới tính mặc định không phải là nam");
		}

	}

	@Test(priority = 33)
	public void tiepNhanBenhNhan_9865_3() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Giới tính");
		TestLogger.info("Kiểm tra chọn lại giá trị khác giá trị mặc định Nam ");
		TestLogger.info("Expect : Cho phép lưu giới tính Nữ, và Không xác định");
		clickOn(TiepNhanBenhNhan_GioiTinhNu);
		if (waitForObjectAppearOnRegion(TiepNhanBenhNhan_HoTen, TiepNhanBenhNhan_GioiTinh_Radio_Checked, 357, 29, 5)) {
			setTestcaseStatus("FAIL", "Cho phép lưu giới tính Nữ, và Không xác định");
		} else {
			setTestcaseStatus("PASS", "Cho phép lưu giới tính Nữ, và Không xác định");
		}
	}

	@Test(priority = 34)
	public void tiepNhanBenhNhan_9977_1() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường SĐT liên hệ");
		TestLogger.info("Kiểm tra giá trị mặc định trường SĐT liên hệ");
		TestLogger.info("Expect : Giá trị mặc định là trống");

		if (getSoDienThoaiNguoiLienHe().length() == 0) {
			setTestcaseStatus("PASS", "Giá trị mặc định là trống");
		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định là không trống");
		}

	}

	@Test(priority = 35)
	public void tiepNhanBenhNhan_9977_2() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường SĐT liên hệ");
		TestLogger.info("Kiểm tra nhập giá trị là chữ");
		TestLogger.info("Expect : Không cho phép nhập");
		dienSoDienThoaiNguoiLienHe(TienIch.taoRandomChu(12));
		if (getSoDienThoaiNguoiLienHe().length() > 0) {
			setTestcaseStatus("FAIL", "Vẫn cho phép nhập");
		} else {
			setTestcaseStatus("PASS", "Không cho phép nhập");
		}
	}

	@Test(priority = 36)
	public void tiepNhanBenhNhan_9977_3() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường SĐT liên hệ");
		TestLogger.info("Kiểm tra nhập giá trị là chữ");
		TestLogger.info("Expect : Cho phép nhập lưu");
		dienSoDienThoaiNguoiLienHe(TienIch.taoRandomSo(12));
		if (getSoDienThoaiNguoiLienHe().length() == 12) {
			setTestcaseStatus("PASS", "Cho phép nhập lưu");
		} else {
			setTestcaseStatus("FAIL", "Không cho phép nhập");
		}
	}

	@Test(priority = 37)
	public void tiepNhanBenhNhan_9977_4_5() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường SĐT liên hệ");
		TestLogger.info("Kiểm tra việc nhập ký tự đặc biệt ^^^^ ()...");
		TestLogger.info("Expect : cho phép nhập");
		dienSoDienThoaiNguoiLienHe("^^^^^^^^^");
		if (getSoDienThoaiNguoiLienHe().equals("^^^^^^^^^")) {
			setTestcaseStatus("PASS", "cho phép nhập");
		} else {
			setTestcaseStatus("FAIL", "không cho phép nhập");
		}
	}

	@Test(priority = 38)
	public void tiepNhanBenhNhan_9977_6() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường SĐT liên hệ");
		TestLogger.info("Kiểm tra nhập ký tự số và ký tự vượt quá 20 ký tự");
		TestLogger.info("Expect : Chặn luôn kể từ ký tự thứ 21");
		dienSoDienThoaiNguoiLienHe(TienIch.taoRandomSo(21));
		if (getSoDienThoaiNguoiLienHe().length() == 20) {
			setTestcaseStatus("PASS", " chặn luôn từ kí tự thứ 21");
		} else {
			setTestcaseStatus("FAIL", "không chặn từ thế kỉ 21 ");
		}
	}

	@Test(priority = 39)
	public void tiepNhanBenhNhan_9977_7() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường SĐT liên hệ");
		TestLogger.info("Kiểm tra nhập ký tự  <10 ký tự");
		TestLogger.info("Expect : Thông báo số điện thoại không đúng định dạng ");
		dienSoDienThoaiNguoiLienHe(TienIch.taoRandomSo(9));
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Số ^^^^^^^^");
		dienNguoiLienHe("Liên Hệ ^^^^");
		dienSoDienThoaiNguoiLienHe(TienIch.taoRandomSo(9));
		clickOn(TiepNhanBenhNhan_Luu);

		if (waitForObjectPresent(TiepNhanBenhNhan_MessageLoi, 3)) {
			setTestcaseStatus("PASS", "Thông báo số điện thoại không đúng định dạng");
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);

		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL", "Không thông báo số điện thoại không đúng định dạng");
		}
	}

	@Test(priority = 40)
	public void tiepNhanBenhNhan_10656_1() {
		TestLogger.info("Kiểm tra giá trị mặc định Text box Nhập nhanh");
		TestLogger.info("Giá trị mặc định là trống");
		if (getNhapNhanh().length() == 0) {
			setTestcaseStatus("PASS", "Giá trị mặc định là trống");
		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định là không phải là trống");
		}
	}

	@Test(priority = 41)
	public void tiepNhanBenhNhan_10656_4() {
		TestLogger.info("Kiểm tra giá trị mặc định Text box Nhập nhanh");
		TestLogger.info("Kiểm tra việc nhập Nhập nhanh nằm ngoài khoảng [4, 12] ký tự. Ví dụ nhập 3 hoặc 13 ký tự");
		TestLogger.info("Không cho phép Lưu, và không load tự động ra thông tin tương ứng ");
		dienNhapNhanh("ACB");
		s.type(Key.ENTER);
		if (getThanhPho().equalsIgnoreCase("Cao Bằng")) {
			setTestcaseStatus("FAIL", "Vẫn cho phép load tự động ");
		} else {
			setTestcaseStatus("PASS", "Không cho phép load tự động");
		}

	}

	@Test(priority = 42)
	public void tiepNhanBenhNhan_10656_5_7() {
		TestLogger.info("Kiểm tra giá trị mặc định Text box Nhập nhanh");
		TestLogger.info(
				"Kiểm tra việc nhập giá trị hợp lệ  trong khoảng [4, 12] ký tự. Và ký tự viết tắt đã được quy định trong danh mục Tỉnh/ thành phố, Quận/ huyện, Phường/ xã");
		TestLogger.info(
				"Cho phép tự động load ra theo thứ tự Tỉnh/ thành phố, Quận/ huyện, Phường/ xã tương ứng với tên viết tắt đã khai báo");
		dienNhapNhanh("HN1pl1qt");
		s.type(Key.ENTER);
		if (getThanhPho().equalsIgnoreCase("Tỉnh Hà Nam")) {
			setTestcaseStatus("PASS", "nhập nhanh cho quận huyện là đúng ");

			if (getQuanHuyen().equals("Thành phố Phủ Lý")) {
				setTestcaseStatus("PASS", "nhập nhanh cho quận huyện là đúng ");

				if (getPhuongXa().equals("Phường Quang Trung")) {

					setTestcaseStatus("PASS", "nhập nhanh cho phường xã là đúng");
				} else {
					setTestcaseStatus("FAIL", "nhập nhanh cho phường xã là sai");
				}

			} else {
				setTestcaseStatus("FAIL", "nhập nhanh cho quận huyện là sai ");
			}
		} else {
			setTestcaseStatus("FAIL", "nhập nhanh cho thành phố  là sai ");
		}

	}

	@Test(priority = 43)
	public void tiepNhanBenhNhan_10086_1() {
		TestLogger.info("[Tiếp nhận] Kiểm tra validate combobox Lý do");
		TestLogger.info("Kiểm tra giá trị mặc định");
		TestLogger.info("Expect : Giá trị mặc định Khám bệnh");
		if (getLiDo().equals("Khám bệnh")) {
			setTestcaseStatus("PASS", "Giá trị mặc định Khám bệnh");
		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định Khám bệnh");
		}
	}

	@Test(priority = 44)
	public void tiepNhanBenhNhan_10086_2() {
		TestLogger.info("[Tiếp nhận] Kiểm tra validate combobox Lý do");
		TestLogger.info("Kiểm tra bỏ trống trường Lý do");
		TestLogger.info("Expect : Hiển thị thông báo trường Lý do không được để trống");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Số ^^^^^^^^");
		dienNguoiLienHe("Liên Hệ ^^^^");
		dienLiDo("");
		clickOn(TiepNhanBenhNhan_Luu);

		if (waitForObjectPresent(TiepNhanBenhNhan_MessageLoi, 3)) {
			setTestcaseStatus("PASS", "Hiển thị thông báo trường Lý do không được để trống");
		} else {
			setTestcaseStatus("FAIL", "Hiển thị thông báo trường Lý do không được để trống");
		}

	}

	@Test(priority = 45)
	public void tiepNhanBenhNhan_10086_3() {
		TestLogger.info("[Tiếp nhận] Kiểm tra validate combobox Lý do");
		TestLogger.info("Kiểm tra cho phép nhập giá trị tìm kiếm trong combobox");
		TestLogger.info(
				"Expect : Cho phép nhập giá trị tìm kiếm trong combobox thành công, kết quả tra ra ứng với từ khóa tìm kiếm trong combobox.");
		dienLiDo("Nhập viện");

		if (getLiDo().equals("Nhập viện")) {
			setTestcaseStatus("PASS",
					"Cho phép nhập giá trị tìm kiếm trong combobox thành công, kết quả tra ra ứng với từ khóa tìm kiếm trong combobox");
		} else {
			setTestcaseStatus("FAIL",
					"Cho phép nhập giá trị tìm kiếm trong combobox thành công, kết quả tra ra ứng với từ khóa tìm kiếm trong combobox");
		}

	}

	@Test(priority = 46)
	public void tiepNhanBenhNhan_10164_1() {
		TestLogger.info("[BHYT] Kiểm tra validate combobox Nơi giới thiệu");
		TestLogger.info("Kiểm tra mặc định trường Nơi giới thiệu khi chọn Đối tượng BHYT + Hình thức là Tự đến");
		dienDoiTuong("BHYT 100");
		chonHinhThuc("Tự đến");
		dienNoiGioiThieu("ABCD");
		TestLogger.info("Expect : Disable trường Nơi giới thiệu và không cho phép nhập");
		if (getNoiGioiThieu().length() > 0) {
			setTestcaseStatus("FAIL", "Disable trường Nơi giới thiệu và không cho phép nhập");
		} else {
			setTestcaseStatus("PASS", "Disable trường Nơi giới thiệu và không cho phép nhập");
		}

	}

	@Test(priority = 47)
	public void tiepNhanBenhNhan_10164_2() {
		TestLogger.info("[BHYT] Kiểm tra validate combobox Nơi giới thiệu");
		TestLogger.info(
				"Kiểm tra mặc định trường Nơi giới thiệu khi chọn đối tượng là BHYT + Hình thức đến khám là Cơ quan Y tế giới thiệu");
		dienDoiTuong("BHYT 100");
		chonHinhThuc("Cơ quan y tế giới thiệu");
		TestLogger.info("Expect : Enable trường Nơi giới thiệu, và mặc định giá trị trong combobox là Blank");
		if (getNoiGioiThieu().length() == 0) {
			setTestcaseStatus("PASS", "Enable trường Nơi giới thiệu, và mặc định giá trị trong combobox là Blank");
		} else {
			setTestcaseStatus("FAIL", "Enable trường Nơi giới thiệu, và mặc định giá trị trong combobox là Blank");
		}

	}

	@Test(priority = 48)
	public void tiepNhanBenhNhan_10164_4() {
		TestLogger.info("[BHYT] Kiểm tra validate combobox Nơi giới thiệu");
		TestLogger.info("Kiểm tra bỏ trống combobox Nơi giới thiệu khi trường Nơi giới thiệu Enable");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Nơi làm việc ^^^^^^^^");
		dienNguoiLienHe("Người Liên Hệ ^^^^");
		dienLiDo("Khám bệnh");
		dienDoiTuong("BHYT 100");
		chonHinhThuc("Cơ quan y tế giới thiệu");
		clickOn(TiepNhanBenhNhan_Luu);
		if (waitForObjectPresent(TiepNhanBenhNhan_MessageLoi, 3)) {
			s.type(Key.ENTER);
			setTestcaseStatus("PASS",
					"Hiển thị thông tin:”Bạn phải nhập Nơi giới thiệu!” và focus chuột vào ô cần nhập");
		} else {
			setTestcaseStatus("FAIL",
					"Hiển thị thông tin:”Bạn phải nhập Nơi giới thiệu!” và focus chuột vào ô cần nhập");
		}

	}

	@Test(priority = 49)
	public void tiepNhanBenhNhan_10164_8() {
		TestLogger.info("[BHYT] Kiểm tra cho phép nhập giá trị tìm kiếm trong combobox");
		TestLogger.info(
				"Cho phép nhập giá trị tìm kiếm trong combobox thành công. kết quả tra ra ứng với từ khóa tìm kiếm trong combobox.");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Nơi làm việc ^^^^^^^^");
		dienNguoiLienHe("Người Liên Hệ ^^^^");
		dienLiDo("Khám bệnh");
		dienDoiTuong("BHYT 100");
		chonHinhThuc("Cơ quan y tế giới thiệu");
		dienNoiGioiThieu("Bệnh viện 108");

		if (getNoiGioiThieu().equals("Bệnh viện 108")) {
			setTestcaseStatus("PASS",
					"Cho phép nhập giá trị tìm kiếm trong combobox thành công. kết quả tra ra ứng với từ khóa tìm kiếm trong combobox.");
		} else {
			setTestcaseStatus("FAIL",
					"Cho phép nhập giá trị tìm kiếm trong combobox thành công. kết quả tra ra ứng với từ khóa tìm kiếm trong combobox.");
		}

	}

	@Test(priority = 50)
	public void tiepNhanBenhNhan_10193_3() {
		TestLogger.info("[BHYT] Kiểm tra cho phép nhập giá trị tìm kiếm trong combobox");
		TestLogger.info(
				"Kiểm tra mặc định trường Số tuyến chuyển  khi chọn đối tượng là BHYT + Hình thức đến khám là Cơ quan Y tế giới thiệu");
		dienDoiTuong("BHYT 100");
		chonHinhThuc("Cơ quan y tế giới thiệu");
		TestLogger.info("Expect : Enable trường Nơi giới thiệu, và mặc định giá trị trong combobox là Blank");
		if (getSoTuyenChuyen().length() == 0) {
			setTestcaseStatus("PASS", "Enable trường Số tuyến chuyển  và mặc định giá trị trong combobox là Blank");
		} else {
			setTestcaseStatus("FAIL", "Enable trường Số tuyến chuyển  và mặc định giá trị trong combobox là Blank");
		}
	}

	@Test(priority = 51)
	public void tiepNhanBenhNhan_10193_4() {
		TestLogger.info("[BHYT] Kiểm tra cho phép nhập giá trị tìm kiếm trong combobox");
		TestLogger.info("Kiểm tra việc nhập ký tự đặc biệt ^^^ - vào trường Số tuyến chuyển");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Nơi làm việc ^^^^^^^^");
		dienNguoiLienHe("Người Liên Hệ ^^^^");
		dienLiDo("Khám bệnh");
		dienDoiTuong("BHYT 100");
		chonHinhThuc("Cơ quan y tế giới thiệu");
		dienNoiGioiThieu("Bệnh viện 108");
		dienSoTuyenChuyen("^^^^^^^^^^");

		if (getSoTuyenChuyen().equals("^^^^^^^^^^")) {
			setTestcaseStatus("PASS", "Cho nhập ký tự đặc biệt ");
		} else {
			setTestcaseStatus("FAIL", "Cho nhập ký tự đặc biệt ");
		}

	}

	@Test(priority = 52)
	public void tiepNhanBenhNhan_10193_5() {
		TestLogger.info("[BHYT] Kiểm tra cho phép nhập giá trị tìm kiếm trong combobox");
		TestLogger.info("Kiểm tra bỏ trống combobox Số tuyến chuyển khi trường Số tuyến chuyển Enable");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Nơi làm việc ^^^^^^^^");
		dienNguoiLienHe("Người Liên Hệ ^^^^");
		dienLiDo("Khám bệnh");
		dienDoiTuong("BHYT 100");
		chonHinhThuc("Cơ quan y tế giới thiệu");
		dienNoiGioiThieu("Bệnh viện 108");
		clickOn(TiepNhanBenhNhan_Luu);
		TestLogger.info("Hiển thị thông tin:”Bạn phải nhập số tuyến chuyển!” và focus chuột vào ô cần nhập");
		if (waitForObjectPresent(TiepNhanBenhNhan_MessageLoi, 3)) {
			s.type(Key.ENTER);
			setTestcaseStatus("PASS", "Hiển thị thông tin:”Bạn phải nhập số tuyến chuyển");
		} else {
			setTestcaseStatus("FAIL", "Hiển thị thông tin:”Bạn phải nhập số tuyến chuyển");
		}
	}

	@Test(priority = 53)
	public void tiepNhanBenhNhan_10193_9() {
		TestLogger.info("[BHYT] Kiểm tra cho phép nhập giá trị tìm kiếm trong combobox");
		TestLogger.info("Kiểm tra việc nhập Số tuyến chuyển  vượt quá maxlength 10 ký tự cho phép (11 ký tự)  ");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Nơi làm việc ^^^^^^^^");
		dienNguoiLienHe("Người Liên Hệ ^^^^");
		dienLiDo("Khám bệnh");
		dienDoiTuong("BHYT 100");
		chonHinhThuc("Cơ quan y tế giới thiệu");
		dienNoiGioiThieu("Bệnh viện 108");
		dienSoTuyenChuyen(TienIch.taoRandomChu(11));
		if (getSoTuyenChuyen().length() == 10) {
			setTestcaseStatus("PASS", "Số tuyến chuyển không vượt quá maxlength 10 ký tự");
		} else {
			setTestcaseStatus("FAIL", "Số tuyến chuyển vượt quá maxlength 10 ký tự");
		}

	}

	@Test(priority = 54)
	public void tiepNhanBenhNhan_10193_10() {
		TestLogger.info("[BHYT] Kiểm tra cho phép nhập giá trị tìm kiếm trong combobox");
		TestLogger.info(
				"Kiểm tra thông tin đang Enable sau đó chọn lại Hình thức (Tự đến...) hoặc chọn Đối tượng ( khác đối tượng BHYT) ");
		TestLogger.info("Điền Họ tên :");
		Hoten = TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(6) + " " + TienIch.taoRandomChu(3);
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
		SoDienThoai = TienIch.taoRandomTheoGioiHan(1000008900, 1234567890);
		dienSoDienThoai("1234567890");
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
		SoNha = "Số 78 Hàng Ngang";
		dienSoNha(SoNha);
		dienNoiLamViec("Nơi làm việc ^^^^^^^^");
		dienNguoiLienHe("Người Liên Hệ ^^^^");
		dienLiDo("Khám bệnh");
		dienDoiTuong("BHYT 100 ");
		chonHinhThuc("Cơ quan y tế giới thiệu");
		dienNoiGioiThieu("Bệnh viện 108");
		dienSoTuyenChuyen(TienIch.taoRandomChu(11));
		dienDoiTuong("Dịch vụ");
		dienNoiGioiThieu("ABCD");

		TestLogger.info("Expect : Trường thông tin bị Disable lại  ");

		if (getNoiGioiThieu().equals("Bệnh viện 108")) {
			clickOn(TiepNhanBenhNhan_BoQua);
			waitForObjectPresent(TiepNhanBenhNhan_Them, 5);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL", "Trường thông tin bị Disable lại");
		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			waitForObjectPresent(TiepNhanBenhNhan_Them, 5);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("PASS", "Trường thông tin bị Disable lại");
		}

	}

	@Test(priority = 55)
	public void tiepNhanBenhNhan_9915_1() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Năm sinh");
		TestLogger.info("Kiểm tra giá trị mặc định ");
		if (getNamSinh().length() == 0) {
			setTestcaseStatus("PASS", "Mặc định là trống");
		} else {
			setTestcaseStatus("FAIL", "Mặc định là trống");
		}

	}

	@Test(priority = 56)
	public void tiepNhanBenhNhan_9915_2() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Năm sinh");
		dienHoTen("Nguyen Viet C");
		dienNamSinh("");
		clickOn(TiepNhanBenhNhan_Luu);
		if (waitForObjectPresent(TiepNhanBenhNhan_MessageLoi, 5)) {
			setTestcaseStatus("PASS", "Hiển thị cảnh báo Năm sinh không được bỏ trống");
		} else {
			setTestcaseStatus("FAIL", "Hiển thị cảnh báo Năm sinh không được bỏ trống");
		}
	}

	@Test(priority = 57)
	public void tiepNhanBenhNhan_9915_7() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Năm sinh");
		dienHoTen("Nguyen Viet C");
		dienNamSinh("5");
		if (getNamSinh().equals("2012") || (getNamSinh().equals("2013"))) {
			setTestcaseStatus("PASS", "Tự động tính năm sinh theo tuổi (Năm sinh = năm hiện tại - số tuổi)");
		} else {
			setTestcaseStatus("FAIL", "Tự động tính năm sinh theo tuổi (Năm sinh = năm hiện tại - số tuổi)");
		}

	}

	@Test(priority = 58)
	public void tiepNhanBenhNhan_9915_9() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Năm sinh");
		dienHoTen("Nguyen Viet C");
		TestLogger.info(
				"Kiểm tra nhập ký tự chữ và ký tự đặc biệt  (, - ..) (loại trừ được trường hợp nhập số âm và số thập phân)");
		dienNamSinh("^^^^^");
		TestLogger.info("Chặn luôn, không cho phép nhập");
		getNamSinh();
		if (getNamSinh().equals("0")) {

			setTestcaseStatus("PASS", "Chặn luôn, không cho phép nhập");
		} else {
			setTestcaseStatus("FAIL", "không chặn luôn, vẫn cho phép nhập");
		}
	}

	@Test(priority = 59)
	public void tiepNhanBenhNhan_9915_6() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Năm sinh");
		TestLogger.info("Kiểm tra tự động load năm sinh từ trường ngày sinh");

		dienHoTen("Nguyen Viet C");
		dienNgaySinh("2321984");
		TestLogger.info(
				"Tự động lấy năm sinh từ trường ngày sinh. Sau mỗi lần chọn lại ngày sinh, năm sinh sẽ thay đổi theo");
		if (getNamSinh().equals("1984")) {
			setTestcaseStatus("PASS",
					"Tự động lấy năm sinh từ trường ngày sinh. Sau mỗi lần chọn lại ngày sinh, năm sinh sẽ thay đổi theo");
		} else {
			setTestcaseStatus("FAIL",
					"Tự động lấy năm sinh từ trường ngày sinh. Sau mỗi lần chọn lại ngày sinh, năm sinh sẽ thay đổi theo");
		}

	}

	@Test(priority = 60)
	public void tiepNhanBenhNhan_9855_1() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Mã BN");
		TestLogger.info("Kiểm tra giá trị mặc định");
		TestLogger.info("Expect : Mặc định giá trị Disable, không cho phép nhập ");
		dienMaBenhNhan("sssss");
		if (getMaBenhNhan().length() > 0) {
			setTestcaseStatus("FAIL", "Mặc định giá trị Disable, không cho phép nhập");
		} else {
			setTestcaseStatus("PASS", "Mặc định giá trị Disable, không cho phép nhập");
		}

	}

	@Test(priority = 61)
	public void tiepNhanBenhNhan_9855_2() {
		TestLogger.info("[Hành chính] Kiểm tra validate trường Mã BN");
		TestLogger.info("Kiểm tra quy tắc sinh tự động Mã BN khi bấm Lưu");
		TestLogger.info(
				"Expect :  - Khi bấm Lưu, hệ thống tự động sinh mã BN - Gồm 8 ký tự, trong đó 2 ký tự đầu là năm 6 ký tự sau sẽ tự tăng");
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
		SoDienThoaiNguoiLienHe = TienIch.taoRandomTheoGioiHan(1111111100, 1222222200);
		dienSoDienThoaiNguoiLienHe("1519222321");
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
		String maBenhNhan = getMaBenhNhan();
		TestLogger.info("Do dai cua Ma Benh Nhan la  : " + maBenhNhan.length());
		TestLogger.info("2 so dau cua Nam Hien Tai la : " + TienIch.getNamHienTaicuaMayTinh().substring(2, 4)); // 2017
		if (maBenhNhan.length() == 8 && maBenhNhan.startsWith(TienIch.getNamHienTaicuaMayTinh().substring(0, 1))) {
			clickOn(TiepNhanBenhNhan_Sua);
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("PASS", "");
		} else {
			clickOn(TiepNhanBenhNhan_Sua);
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL", "");
		}
	}

	@Test(priority = 62)
	public void tiepNhanBenhNhan_9943_1() {
		TestLogger.info("[Hành chính] Kiểm tra validate combobox Tỉnh/ Thành phố");
		TestLogger.info("Kiểm tra giá trị mặc định");
		TestLogger.info("Expect : Giá trị mặc định Hà Nội");
		if (getThanhPho().equalsIgnoreCase("Thành phố Hà Nội")) {
			setTestcaseStatus("PASS", "Giá trị mặc định Hà Nội");
		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định Hà Nội");
		}

	}

	@Test(priority = 63)
	public void tiepNhanBenhNhan_9943_2() {
		TestLogger.info("[Hành chính] Kiểm tra validate combobox Tỉnh/ Thành phố");
		TestLogger.info("Kiểm tra bỏ trống trường Tỉnh/ TP");
		TestLogger.info("Hiển thị thông báo trường Tỉnh/ TP không được để trống");
		dienHoTen("Nguyen Viet Ha");
		dienNamSinh("2017");
		clickOn(TiepNhanBenhNhan_Luu);
		if (waitForObjectPresent(TiepNhanBenhNhan_MessageLoi, 2)) {
			s.type(Key.ENTER);
			setTestcaseStatus("PASS", "Hiển thị thông báo trường Tỉnh/ TP không được để trống");
		} else {
			setTestcaseStatus("FAIL", "Hiển thị thông báo trường Tỉnh/ TP không được để trống");

		}

	}

	@Test(priority = 64)
	public void tiepNhanBenhNhan_9943_3() {
		TestLogger.info("[Hành chính] Kiểm tra validate combobox Tỉnh/ Thành phố");
		TestLogger.info("Kiểm tra cho phép nhập giá trị tìm kiếm trong combobox");
		TestLogger
				.info("Expect:- Cho phép nhập giá trị tìm kiếm trong combobox thành công. kết quả tra ra ứng với từ khóa tìm kiếm trong combobox."
						+ "- Nhập giá trị viết tắt của tên Tỉnh thành, hiển thị ra Tỉnh thành");
		dienThanhPho("Tỉnh Bắc Giang");
		s.type(Key.ENTER);
		if (getThanhPho().equals("Tỉnh Bắc Giang")) {
			setTestcaseStatus("PASS", "kết quả tra ra ứng với từ khóa tìm kiếm trong combobox");
		} else {
			setTestcaseStatus("FAIL", "kết quả tra ra ứng với từ khóa tìm kiếm trong combobox");
		}

		dienThanhPho("BG");
		s.type(Key.ENTER);
		if (getThanhPho().equals("Tỉnh Bắc Giang")) {
			setTestcaseStatus("PASS", "kết quả tra ra ứng với từ khóa tìm kiếm trong combobox");
		} else {
			setTestcaseStatus("FAIL", "kết quả tra ra ứng với từ khóa tìm kiếm trong combobox");
		}

	}

	@Test(priority = 65)
	public void tiepNhanBenhNhan_9939_1() {
		TestLogger.info("[Hành chính] Kiểm tra validate combobox Dân tộc");
		TestLogger.info("Kiểm tra giá trị mặc định");
		TestLogger.info("Expect : Giá trị mặc định Kinh");

		if (getDanToc().equals("Kinh")) {
			setTestcaseStatus("PASS", "Giá trị mặc định Kinh");
		} else {
			setTestcaseStatus("FAIL", "Giá trị mặc định Kinh");
		}

	}

	@Test(priority = 66) // tu thu 3
	public void tiepNhanBenhNhan_9939_7() {
		TestLogger.info("[Hành chính] Kiểm tra validate combobox Dân tộc");
		TestLogger.info("Kiểm tra cho phép nhập giá trị tìm kiếm trong combobox");
		TestLogger.info(
				"Expect : Cho phép nhập giá trị tìm kiếm trong combobox thành công,kết quả tra ra ứng với từ khóa tìm kiếm trong combobox.");
		dienDanToc("hoa");
		if (getDanToc().equals("Hoa")) {
			setTestcaseStatus("PASS", "");
		} else {
			setTestcaseStatus("FAIL", "");
		}

	}

	@Test(priority = 67)
	public void tiepNhanBenhNhan_14479_1() {
		TestLogger.info("Kiểm tra tự động load ra Hình thức đến khám");
		TestLogger.info("Khi nhập mã ĐKKCB / quét số thẻ BHYT mà mã ĐKKCB trùng với bệnh viện đang cấu hình");
		dienDoiTuong("BHYT 100");
		dienSoTheBHYT("SV401" + TienIch.taoRandomSo(10));
		dienMaDKKCB("01005");
		TestLogger.info("Expect :Hiển thị hình thức là Tự đến ");
		if (getHinhThuc().equals("Tự đến")) {
			setTestcaseStatus("PASS", "Hiển thị hình thức là Tự đến ");
		} else {
			setTestcaseStatus("FAIL", "Hiển thị hình thức là Tự đến ");
		}

		dienMaDKKCB("01043");
		TestLogger.info("Expect :Hiển thị hình thức là Cơ quan y tế giới thiệu ");
		if (getHinhThuc().equals("Cơ quan y tế giới thiệu")) {
			setTestcaseStatus("PASS", "Hiển thị hình thức là Cơ quan y tế giới thiệu ");
		} else {
			setTestcaseStatus("FAIL", "Hiển thị hình thức là Cơ quan y tế giới thiệu ");
		}

	}

	@Test(priority = 68)
	public void tiepNhanBenhNhan_12573_1() {
		TestLogger.info("Kiểm tra validate trường Đơn giá BHYT - Check BHYT chi trả cho ngoại trú");
		TestLogger.info("Kiểm tra giá trị hiển thị tại cột Đơn giá BHYT khi đã chọn dịch vụ nhưng đối tượng khác BHYT");
		dienDoiTuong("Dịch vụ");
		dienTenDichVu("Khám tai mũi họng");
		dienNoiThucHien("Khám TMH");
		TestLogger.info("Expect : Đơn giá BHYT = 0");
		clickToaDo(1033, 383);

		String giaTriTien = layTextTuAnh(1172, 532, 70, 19);
		TestLogger.info("Gia Tri Tien BHYT chi tra :" + giaTriTien);
		TestLogger.info("do dai:" + giaTriTien.length());
		System.out.println("0" + giaTriTien.charAt(0));
		System.out.println("1" + giaTriTien.charAt(1));
		System.out.println("2" + giaTriTien.charAt(2));

		if (giaTriTien.charAt(0) == '0') {
			sleep(2);
			clickToaDo(1358, 383);
			setTestcaseStatus("PASS", "Đơn giá BHYT = 0");
		} else {
			clickToaDo(1358, 383);
			setTestcaseStatus("FAIL", "Đơn giá BHYT = 0");
		}
	}

	@Test(priority = 69)
	public void tiepNhanBenhNhan_12573_3() {
		TestLogger.info("Kiểm tra validate trường Đơn giá BHYT - Check BHYT chi trả cho ngoại trú");
		TestLogger.info(
				"Đơn giá BHYT của dịch vụ được lấy tương ứng trong danh mục giá BHYT hiện hành của dịch vụ (item 8136)");
		dienDoiTuong("BHYT 100");
		dienTenDichVu("Khám tai mũi họng");
		dienNoiThucHien("Khám TMH");
		TestLogger.info(
				"Expect :Đơn giá BHYT của dịch vụ được lấy tương ứng trong danh mục giá BHYT hiện hành của dịch vụ");
		clickToaDo(1033, 383);
		String giaTriTien = layTextTuAnh(988, 531, 76, 20);
		TestLogger.info("Gia Tri Tien BHYT chi tra :" + giaTriTien);
		TestLogger.info("do dai:" + giaTriTien.trim().length());

		if (giaTriTien.trim().equals("195.000")) {
			sleep(2);
			clickToaDo(1358, 383);
			setTestcaseStatus("PASS",
					"Đơn giá BHYT của dịch vụ được lấy tương ứng trong danh mục giá BHYT hiện hành của dịch vụ");
		} else {
			clickToaDo(1358, 383);
			setTestcaseStatus("FAIL",
					"Đơn giá BHYT của dịch vụ được lấy tương ứng trong danh mục giá BHYT hiện hành của dịch vụ");
		}

		// check voi BHYT 80 phan tram
		TestLogger.info("Kiểm tra validate trường Đơn giá BHYT - Check BHYT chi trả cho ngoại trú");
		TestLogger.info(
				"Đơn giá BHYT của dịch vụ được lấy tương ứng trong danh mục giá BHYT hiện hành của dịch vụ (item 8136)");
		dienDoiTuong("BHYT 95%");
		clickToaDo(1033, 383);
		giaTriTien = layTextTuAnh(1246, 531, 90, 20);
		TestLogger.info("Gia Tri Tien BHYT chi tra :" + giaTriTien);
		TestLogger.info("do dai:" + giaTriTien.trim().length());

		if (giaTriTien.trim().equals("0")) {
			sleep(2);
			clickToaDo(1358, 383);
			setTestcaseStatus("PASS", "Đơn giá BHYT của dịch vụ được lấy tương ứng trong danh mục giá BHYT 80");
		} else {
			clickToaDo(1358, 383);
			setTestcaseStatus("FAIL", "Đơn giá BHYT của dịch vụ được lấy tương ứng trong danh mục giá BHYT 80");
		}

	}

	@Test(priority = 70)
	public void tiepNhanBenhNhan_9858_1() {
		TestLogger.info("Kiểm tra giá trị mặc định");
		TestLogger.info("Mặc định giá trị trống, không cho phép nhập");
		dienSoTiepNhan("2321323434");
		if (getSoTiepNhan().length() > 0) {
			setTestcaseStatus("FAIL", "Mặc định giá trị trống, không cho phép nhập");
		} else {
			setTestcaseStatus("PASS", "Mặc định giá trị trống, không cho phép nhập");
		}
	}

	@Test(priority = 71)
	public void tiepNhanBenhNhan_9858_2() {
		TestLogger.info("Kiểm tra quy tắc sinh tự động sinh số TN khi bấm Lưu");
		TestLogger.info(" Khi bấm Lưu, hệ thống tự động sinh số TN - Gồm 10 ký tự: ");

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
		dienSoDienThoaiNguoiLienHe("1234567890");
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

		if (waitForObjectPresent(Phieukham, 2)) {
			s.click();
			s.type(Key.F4, Key.ALT);
		}

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
		if (soTiepNhan.length() == 10) {
			setTestcaseStatus("PASS", "");
		} else {
			setTestcaseStatus("FAIL", "");
		}
		String sub = soTiepNhan.substring(0, 2);
		String sub2 = getNamHienTaicuaMayTinh().toString().substring(2, 4);
		TestLogger.info("sub : " + sub + "sub2 : " + getNamHienTaicuaMayTinh().toString().substring(2, 4));
		if (soTiepNhan.substring(0, 2).equals(sub2)) {
			setTestcaseStatus("PASS", "+ 2 ký tự đầu là 2 số cuối của năm");
		} else {
			setTestcaseStatus("FAIL", "+ 2 ký tự đầu là 2 số cuối của năm");
		}

		TestLogger.info("Expect :  + 2 ký tự tiếp theo là tháng");

		TestLogger.info("thang cua so tiep nhan : " + soTiepNhan.substring(2, 4));
		TestLogger.info("thang hien tai ==>" + getThangHienTaicuaMayTinh());
		if (soTiepNhan.substring(2, 4).equals(getThangHienTaicuaMayTinh())) {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);

			setTestcaseStatus("PASS", "+ 2 ký tự tiếp theo là tháng");
		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);

			setTestcaseStatus("FAIL", "+ 2 ký tự tiếp theo là tháng");
		}

	}

	@Test(priority = 72)
	public void tiepNhanBenhNhan_11250_1() {
		TestLogger
				.info("[Tiếp nhận BN chung] Kiểm tra chức năng Hủy (nút xóa trên grid Đăng ký khám) khi đã thanh toán");
		TestLogger.info("Không cho phép xóa");
		sleep(2);
		// click danh sach benh nhan
		clickToaDo(75, 685);

		do {
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			sleep(3);

		} while (waitForObjectPresent(DanhSachBenhNhan.DanhSachBenhNhan_TrangThai, 1) != true);

		hoverImage(DanhSachBenhNhan.DanhSachBenhNhan_TrangThai);
		clickToaDo(1361, 156);
		clickOn(DanhSachBenhNhan.DanhSachBenhNhan_EnterTextToSearch);
		doubleClick(DanhSachBenhNhan.DanhSachBenhNhan_ChoKetQua);
		moveMouseDownFromLogo(DanhSachBenhNhan.DanhSachBenhNhan_TimKiem, 142);
		s.doubleClick();
		clickOn(TiepNhanBenhNhan_Sua);
		if (waitForObjectPresent(TiepNhanBenhNhan_MessageLoi, 1)) {
			s.type(Key.ENTER);

			setTestcaseStatus("PASS", "Không cho phép xóa");
		} else {
			setTestcaseStatus("FAIL", "Không cho phép xóa");
		}

	}

	@Test(priority = 73)
	public void tiepNhanBenhNhan_11250_2() {
		TestLogger.info("Kiểm tra xóa dịch vụ khi Grid có cả dịch vụ đã thanh toán và dịch vụ chưa thanh toán");
		TestLogger.info("Chỉ cho phép xóa dịch vụ chưa thanh toán");
		clickToaDo(75, 685);
		do {
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			clickToaDo(1357, 717);
			sleep(3);

		} while (waitForObjectPresent(DanhSachBenhNhan.DanhSachBenhNhan_TrangThai, 1) != true);

		hoverImage(DanhSachBenhNhan.DanhSachBenhNhan_TrangThai);
		clickToaDo(1361, 156);
		clickOn(DanhSachBenhNhan.DanhSachBenhNhan_EnterTextToSearch);

		doubleClick(DanhSachBenhNhan.DanhSanhBenhNhan_ChoKham);

		moveMouseDownFromLogo(DanhSachBenhNhan.DanhSachBenhNhan_TimKiem, 142);
		s.doubleClick();
		clickOn(TiepNhanBenhNhan_Sua);
		if (!waitForObjectPresent(TiepNhanBenhNhan_MessageLoi, 1)) {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("PASS", "Cho phép xóa");
		} else {

			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL", "Không cho phép xóa");
		}
	}

	@Test(priority = 74)
	public void tiepNhanBenhNhan_10289_1() {
		TestLogger.info("[Đăng ký khám] Kiểm tra validate trường Đơn giá doanh thu");
		TestLogger.info("Kiểm tra giá trị mặc định khi chưa chọn dịch vụ");
		// lay gia tri mac dinh cua don gia doanh thu
		String giaDoanhThu = layTextTuAnh(758, 531, 110, 17);
		TestLogger.info("Expect : Mặc định giá trị trống");
		if (giaDoanhThu.length() == 0) {
			setTestcaseStatus("PASS", "Mặc định giá trị trống");
		} else {
			setTestcaseStatus("FAIL", "Mặc định giá trị trống");
		}

	}

	@Test(priority = 75)
	public void tiepNhanBenhNhan_10289_2() {
		TestLogger.info("[Đăng ký khám] Kiểm tra validate trường Đơn giá doanh thu");
		TestLogger.info("Kiểm tra giá trị Đơn giá doanh thu theo đối tượng là Dịch vụ");
		dienDoiTuong("Dịch vụ");
		dienTenDichVu("Khám tai mũi họng");
		dienNoiThucHien("Khám TMH");
		// get don gia Doanh Thu

		String giaDoanhThu = layTextTuAnh(758, 531, 110, 17);
		clickToaDo(1033, 383);

		// get gia Benh nhan phai tra tien

		String giaBenhNhanPhaiChiTra = layTextTuAnh(1247, 532, 91, 20);

		if (giaDoanhThu.trim().equals(giaBenhNhanPhaiChiTra.trim())) {
			setTestcaseStatus("PASS", " Đơn giá doanh thu bằng giá Bệnh Nhân thanh toán phải trả ");
		} else {
			setTestcaseStatus("FAIL", " Đơn giá doanh thu bằng giá Bệnh Nhân thanh toán phải trả ");
		}

	}

	@Test(priority = 76)
	public void tiepNhanBenhNhan_10289_3() {
		TestLogger.info("[Đăng ký khám] Kiểm tra validate trường Đơn giá doanh thu");
		TestLogger.info(
				"Kiểm tra giá trị Đơn giá doanh thu theo đối tượng là Yêu cầu hoặc đối tượng khác được thiết lập thêm tùy nghiệp vụ của bệnh viện từng thời kỳ ");
		TestLogger.info("[Đăng ký khám] Kiểm tra validate trường Đơn giá doanh thu");
		TestLogger.info("Kiểm tra giá trị Đơn giá doanh thu theo đối tượng là Dịch vụ");
		dienDoiTuong("Yêu cầu");
		dienTenDichVu("Khám tai mũi họng");
		dienNoiThucHien("Khám TMH");
		// get don gia Doanh Thu

		String giaDoanhThu = layTextTuAnh(758, 531, 110, 17);
		clickToaDo(1033, 383);

		// get gia Benh nhan phai tra tien

		String giaBenhNhanPhaiChiTra = layTextTuAnh(1247, 532, 91, 20);

		if (giaDoanhThu.trim().equals(giaBenhNhanPhaiChiTra.trim())) {
			setTestcaseStatus("PASS", " Đơn giá doanh thu bằng giá Bệnh Nhân thanh toán phải trả ");
		} else {
			setTestcaseStatus("FAIL", " Đơn giá doanh thu bằng giá Bệnh Nhân thanh toán phải trả ");
		}

	}

	@Test(priority = 77)
	public void tiepNhanBenhNhan_10289_4() {
		TestLogger.info("[Đăng ký khám] Kiểm tra validate trường Đơn giá doanh thu");
		TestLogger.info("Kiểm tra giá trị Đơn giá doanh thu theo đối tượng là BHYT");
		dienDoiTuong("BHYT 100");
		dienTenDichVu("Khám tai mũi họng");
		dienNoiThucHien("Khám TMH");
		// get don gia Doanh Thu

		String giaDoanhThu = layTextTuAnh(758, 531, 110, 17);
		clickToaDo(1033, 383);

		int donGiaDoanhThu = Integer.valueOf(giaDoanhThu.trim().replace(".", "").replaceAll("\\s+", ""));

		// get don gia Bao Hiem Y Te

		String GiaBaoHiemYTe = layTextTuAnh(987, 530, 76, 22);
		int donGiaBaoHiemYTe = Integer.valueOf(GiaBaoHiemYTe.trim().replace(".", "").replaceAll("\\s+", ""));

		// gia benh nhan phai chi tra
		String giaBenhNhanPhaiChiTra = layTextTuAnh(1247, 532, 91, 20);

		int donGiaBenhNhanPhaiChiTra = Integer
				.valueOf(giaBenhNhanPhaiChiTra.trim().replace(".", "").replaceAll("\\s+", ""));
		// if đơn giá doanh thu = Đơn giá bảo hiểm y Tế

		if (donGiaDoanhThu <= donGiaBaoHiemYTe) {
			Assert.assertEquals(donGiaBenhNhanPhaiChiTra, 0);
			setTestcaseStatus("PASS", "  Nếu dv không thu chênh lệch: Đơn giá doanh thu = Đơn giá BHYT");
		} else {

			setTestcaseStatus("FAIL", "  Nếu dv không thu chênh lệch: Đơn giá doanh thu = Đơn giá BHYT ");
		}

		if (donGiaDoanhThu > donGiaBaoHiemYTe) {
			Assert.assertEquals(donGiaBenhNhanPhaiChiTra, donGiaDoanhThu - donGiaBaoHiemYTe);
			clickToaDo(1357, 383);
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("PASS", "  Nếu dv có thu chênh lệch: Đơn giá doanh thu > Đơn giá BHYT");
		} else {
			clickToaDo(1357, 383);
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL", "  Nếu dv có thu chênh lệch: Đơn giá doanh thu > Đơn giá BHYT ");
		}

	}

	@Test(priority = 78)
	public void tiepNhanBenhNhan_10272_1() {
		TestLogger.info("[Nghiệp vụ]Kiểm tra Validate checkbox Thu tiền sau");
		TestLogger.info("Giá trị mặc định của  checkbox");
		sleep(2);
		dienTenDichVu("Vận chuyển cấp cứu");
		TestLogger.info("Expect : Mặc định uncheck");
		if (findObjectInToaDo(TiepNhanBenhNhan_ThuTienSau_Uncheck, 652, 531, 52, 20)) {
			setTestcaseStatus("PASS", "Mặc định uncheck");
		} else {
			setTestcaseStatus("FAIL", "Mặc định lại là có check");
		}

	}

	@Test(priority = 79)
	public void tiepNhanBenhNhan_10272_2() {
		TestLogger.info("[Nghiệp vụ]Kiểm tra Validate checkbox Thu tiền sau");
		dienTenDichVu("Vận chuyển cấp cứu");
		TestLogger.info("Kiểm tra việc CHECK chọn check box 1 dịch vụ");
		clickToaDo(679, 540);
		hoverImage(TiepNhanBenhNhan_DanToc);

		if (findObjectInToaDo(TiepNhanBenhNhan_ThuTienSau_Uncheck, 652, 531, 52, 20)) {
			setTestcaseStatus("FAIL", "Không cho phép check chọn check box");
		} else {
			setTestcaseStatus("PASS", "Cho phép check chọn check box");
		}

	}

	@Test(priority = 80)
	public void tiepNhanBenhNhan_10272_5() {
		TestLogger.info("[Nghiệp vụ]Kiểm tra Validate checkbox Thu tiền sau");
		TestLogger.info("Check box thu tiền sau khi chưa bấm Lưu ");

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
		dienSoDienThoaiNguoiLienHe("1234567890");
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

		dienTenDichVu2("Khám tai mũi họng");

		TestLogger.info(
				"Expect : Khi chưa bấm Lưu, nếu dv đầu tiên chọn check thì các dv sau cũng tự động chọn check. Và ngược lại  nếu dv đầu tiên chọn uncheck thì các dv sau cũng tự động chọn uncheck");
		if (findObjectInToaDo(TiepNhanBenhNhan_ThuTienSau_Uncheck, 647, 553, 52, 20)) {
			setTestcaseStatus("FAIL",
					"Khi chưa bấm Lưu, nếu dv đầu tiên chọn check thì các dv sau cũng tự động chọn check. Và ngược lại  nếu dv đầu tiên chọn uncheck thì các dv sau cũng tự động chọn uncheck");
		} else {
			setTestcaseStatus("PASS",
					"Khi chưa bấm Lưu, nếu dv đầu tiên chọn check thì các dv sau cũng tự động chọn check. Và ngược lại  nếu dv đầu tiên chọn uncheck thì các dv sau cũng tự động chọn uncheck");
		}

	}

	@Test(priority = 81)
	public void tiepNhanBenhNhan_10272_6() {
		TestLogger.info("[Nghiệp vụ]Kiểm tra Validate checkbox Thu tiền sau");
		TestLogger.info("Check box thu tiền sau khi đã bấm Lưu ");
		TestLogger
				.info("Expect : Khi đã bấm Lưu, dv chọn sau chọn check/ uncheck không tự động giống với dv chọn trước");
		clickOn(TiepNhanBenhNhan_Luu);
		if (waitForObjectPresent(Phieukham, 6)) {
			s.click();
			s.type(Key.F4, Key.ALT);
		}
		if (waitForObjectPresent(FormKhamBenh.PhieuChiDinh, 5)) {
			s.click();
			s.type(Key.F4, Key.ALT);
		}
		clickOn(TiepNhanBenhNhan_DanhSachBenhNhan);
		waitForObjectPresent(DanhSachBenhNhan.TitleForm_DanhSachBenhNhan, 4);
		clickOn(DanhSachBenhNhan.TitleForm_DanhSachBenhNhan);

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
		dienTenDichVu3("Khám tiêu hóa");
		if (findObjectInToaDo(TiepNhanBenhNhan_ThuTienSau_Uncheck, 646, 576, 52, 20)) {

			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("PASS",
					"Khi đã bấm Lưu, dv chọn sau chọn check/ uncheck không tự động giống với dv chọn trước");
		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			sleep(2);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL",
					"Khi đã bấm Lưu, dv chọn sau chọn check/ uncheck không tự động giống với dv chọn trước");
		}

	}

	@Test(priority = 82)
	public void tiepNhanBenhNhan_10339_2() {
		TestLogger.info("[Đăng ký khám] Kiểm tra validate trường Bệnh nhân thanh toán");
		TestLogger.info("Kiểm tra giá trị khi chọn dịch vụ :");
		dienDoiTuong("Dịch vụ");
		dienTenDichVu("(Honglee) Khám nội tiết");
		dienTenDichVu2("");
		clickToaDo(1030, 382);
		// get Thanh Tien Doanh Thu
		String thanhTienDoanhThu = layTextTuAnh(886, 531, 99, 18);
		TestLogger.info(thanhTienDoanhThu.trim());
		// get Benh Nhan Thanh Toan
		String benhNhanThanhToan = layTextTuAnh(1252, 531, 83, 20);
		TestLogger.info(benhNhanThanhToan.trim());
		if (thanhTienDoanhThu.trim().equals(benhNhanThanhToan.trim())) {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("PASS", "Đối tượng Dịch vụ: BN thanh toán = Thành tiền doanh thu ");
		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			setTestcaseStatus("FAIL", "Đối tượng Dịch vụ: BN thanh toán = Thành tiền doanh thu ");
		}

	}

	@Test(priority = 83)
	public void tiepNhanBenhNhan_10339_3() {
		TestLogger.info("[Đăng ký khám] Kiểm tra validate trường Bệnh nhân thanh toán");
		TestLogger.info("Kiểm tra giá trị khi chọn dịch vụ BHYT : ");

		dienDoiTuong("BHYT 95 ");
		dienTenDichVu("(Hằng test) Khám tổng quát ");
		clickToaDo(1030, 382);
		// get Thanh Tien Doanh Thu
		String TienDoanhThu = layTextTuAnh(886, 531, 99, 18);

		int thanhTienDoanhThu = Integer.valueOf(TienDoanhThu.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("thanhTienDoanhThu 1 : " + thanhTienDoanhThu);

		// get Don Gia Bao Hiem Y Te
		/*
		 * String GiaBaoHiemYTe = layTextTuAnh(993, 531, 68, 18); int
		 * donGiaBaoHiemYTe = Integer.valueOf(GiaBaoHiemYTe.trim().replace(".",
		 * "").replaceAll("\\s+", "")); TestLogger.info("donGiaBaoHiemYTe 2 : "
		 * + donGiaBaoHiemYTe);
		 */

		// get Thanh Tien Bao Hiem Y Te
		String TienBaoHiemYTe = layTextTuAnh(1075, 531, 91, 18);
		int thanhTienBaoHiemYTe = Integer.valueOf(TienBaoHiemYTe.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("thanhTienBaoHiemYTe 3 : " + thanhTienBaoHiemYTe);
		// get Bao Hiem Y Te chi tra
		String BaoHiemYTeChiTra = layTextTuAnh(1179, 531, 61, 19);
		int thanhTienBaoHiemYTeChiTra = Integer
				.valueOf(BaoHiemYTeChiTra.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("thanhTienBaoHiemYTeChiTra 4 : " + thanhTienBaoHiemYTeChiTra);
		// get Benh nhan Thanh Toan
		String BenhNhanThanhToan = layTextTuAnh(1254, 531, 81, 19);
		int thanhTienBenhNhanThanhToan = Integer
				.valueOf(BenhNhanThanhToan.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("thanhTienBenhNhanThanhToan 5 : " + thanhTienBenhNhanThanhToan);

		if (thanhTienDoanhThu <= thanhTienBaoHiemYTe) {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			Assert.assertEquals(thanhTienBenhNhanThanhToan, thanhTienBaoHiemYTe - thanhTienBaoHiemYTeChiTra);
		} else {
			clickOn(TiepNhanBenhNhan_BoQua);
			s.type(Key.ENTER);
			clickOn(TiepNhanBenhNhan_Them);
			Assert.assertEquals(thanhTienBenhNhanThanhToan,
					(thanhTienDoanhThu - thanhTienBaoHiemYTe) + (thanhTienBaoHiemYTe - thanhTienBaoHiemYTeChiTra));
		}

	}

	@Test(priority = 84)
	public void tiepNhanBenhNhan_10338_3() {

		TestLogger.info("[Đăng ký khám] Kiểm tra validate trường Thành tiền BHYT ");
		TestLogger.info("Kiểm tra giá trị khi chọn dịch vụ không có giá tại cột Đơn giá BHYT: ");
		dienDoiTuong("BHYT 95 ");
		dienTenDichVu("Vận chuyển cấp cứu");

		// get Thanh Tien Bao Hiem Y Te
		String TienBaoHiemYTe = layTextTuAnh(1075, 531, 91, 18);
		int thanhTienBaoHiemYTe = Integer.valueOf(TienBaoHiemYTe.trim().replace(".", "").replaceAll("\\s+", ""));
		if (thanhTienBaoHiemYTe == 0) {
			setTestcaseStatus("PASS", "Hiển thị dữ liệu blank");
		} else {
			setTestcaseStatus("FAIL", "Hiển thị dữ liệu blank");
		}

	}

	@Test(priority = 84)
	public void tiepNhanBenhNhan_11583_1() {

		TestLogger.info("(Chờ confirm) [Tiếp nhận BN chung] Chọn bệnh nhân từ form Danh sách BN");
		TestLogger.info("Chọn 1 bệnh nhân từ danh sách bệnh nhân - TH bệnh nhân có 1 số tiếp nhận");
		TestLogger.info(
				"Expect : (pass) Load đầy đủ và chính xác các thông tin đã khai báo của BN từ màn hình tiếp nhận. Thông tin BN hiển thị ở dạng chỉ cho View và không cho phép sửa");

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
		SoDienThoaiNguoiLienHe = TienIch.taoRandomTheoGioiHan(1234567890, 1876543211);
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

			setTestcaseStatus("FAIL", "Tiếp nhận Bệnh nhân không thành công !");
		}

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

	@Test(priority = 85)
	public void tiepNhanBenhNhan_10520_2() {
		TestLogger.info("[Phòng khám] Kiểm tra validate cột Tổng số");
		// click để mở rộng cửa sổ phòng khám
		moRongKhungPhongKham();
		// get tổng số bệnh nhân tại phòng khám tai mũi họng hiện tại khi chưa
		// tiếp nhận thêm
		String SoBenhNhan = layTextTuAnh(1218, 124, 54, 20);

		int tongSoBenhNhan = Integer.valueOf(SoBenhNhan.trim().replace(".", "").replaceAll("\\s+", ""));

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
		SoDienThoaiNguoiLienHe = TienIch.taoRandomTheoGioiHan(1234567890, 1876543211);
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

			setTestcaseStatus("FAIL", "Tiếp nhận Bệnh nhân không thành công !");
		}

		TestLogger.info("Kiểm tra hiển thị cột Tổng số khi đã có thông tin về số lượt của BN khám trong ngày");

		TestLogger.info("Expect : Hiển thị chính xác số lượng BN khám trong ngày hiện thời");
		// get tổng số bệnh nhân tại phòng khám tai mũi họng hiện tại khi chưa
		// tiếp nhận thêm
		String SoBenhNhanSauKhiTiepNhanThem = layTextTuAnh(1218, 124, 54, 20);

		int tongSoBenhNhanSauKhiTiepNhanThem = Integer
				.valueOf(SoBenhNhanSauKhiTiepNhanThem.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("==> " + tongSoBenhNhanSauKhiTiepNhanThem);
		if (tongSoBenhNhanSauKhiTiepNhanThem - tongSoBenhNhan == 1) {
			thuHepKhungPhongKham();
			setTestcaseStatus("PASS", "Hiển thị chính xác số lượng BN khám trong ngày hiện thời");
		} else {
			thuHepKhungPhongKham();
			setTestcaseStatus("FAIL", "Hiển thị chính xác số lượng BN khám trong ngày hiện thời");
		}
	}

	@Test(priority = 86)
	public void tiepNhanBenhNhan_10520_3() {
		TestLogger.info("[Phòng khám] Kiểm tra validate cột Tổng số");
		TestLogger.info(
				"Kiểm tra BN đang chờ khám hủy dịch vụ khám thành công (Bác sĩ Hủy dịch vụ tại màn hình của bác sĩ)");
		TestLogger.info("Expect : Tổng số sẽ trừ đi số bệnh nhân hủy dịch vụ ");
		moRongKhungPhongKham();
		// get tổng số bệnh nhân tại phòng khám tai mũi họng hiện tại khi chưa
		// tiếp nhận thêm
		String SoBenhNhan = layTextTuAnh(1218, 124, 54, 20);

		int tongSoBenhNhan = Integer.valueOf(SoBenhNhan.trim().replace(".", "").replaceAll("\\s+", ""));

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
		SoDienThoaiNguoiLienHe = TienIch.taoRandomTheoGioiHan(1234567890, 1876543211);
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

			setTestcaseStatus("FAIL", "Tiếp nhận Bệnh nhân không thành công !");
		}

		TestLogger.info("Kiểm tra hiển thị cột Tổng số khi đã có thông tin về số lượt của BN khám trong ngày");

		TestLogger.info("Expect : Hiển thị chính xác số lượng BN khám trong ngày hiện thời");
		// get tổng số bệnh nhân tại phòng khám tai mũi họng hiện tại khi chưa
		// tiếp nhận thêm
		String SoBenhNhanSauKhiTiepNhanThem = layTextTuAnh(1218, 124, 54, 20);

		int tongSoBenhNhanSauKhiTiepNhanThem = Integer
				.valueOf(SoBenhNhanSauKhiTiepNhanThem.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("==> " + tongSoBenhNhanSauKhiTiepNhanThem);
		if (tongSoBenhNhanSauKhiTiepNhanThem - tongSoBenhNhan == 1) {

			setTestcaseStatus("PASS", "Hiển thị chính xác số lượng BN khám trong ngày hiện thời");
		} else {

			setTestcaseStatus("FAIL", "Hiển thị chính xác số lượng BN khám trong ngày hiện thời");
		}

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
		// xoa dich vu
		clickToaDo(31, 539);

		clickOn(TiepNhanBenhNhan_Luu);
		String SoBenhNhanSauKhiBoDichVu = layTextTuAnh(1218, 124, 54, 20);

		int tongSoBenhNhanSauKhiBoDichVu = Integer
				.valueOf(SoBenhNhanSauKhiBoDichVu.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("==> " + tongSoBenhNhanSauKhiBoDichVu);

		if (tongSoBenhNhanSauKhiBoDichVu == tongSoBenhNhan) {
			thuHepKhungPhongKham();

			setTestcaseStatus("PASS", "Tổng số sẽ trừ đi số bệnh nhân hủy dịch vụ");

		} else {
			thuHepKhungPhongKham();
			setTestcaseStatus("FAIL", "Tổng số sẽ trừ đi số bệnh nhân hủy dịch vụ");
		}

	}

	@Test(priority = 87)
	public void tiepNhanBenhNhan_10504_2() {
		TestLogger.info("[Phòng khám] Kiểm tra validate cột Chờ");

		// click để mở rộng cửa sổ phòng khám
		moRongKhungPhongKham();
		// get tổng số bệnh nhân tại phòng khám tai mũi họng hiện tại khi chưa
		// tiếp nhận thêm
		String SoBenhNhanCho = layTextTuAnh(1291, 123, 52, 17);

		int tongSoBenhNhanCho = Integer.valueOf(SoBenhNhanCho.trim().replace(".", "").replaceAll("\\s+", ""));

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
		SoDienThoaiNguoiLienHe = TienIch.taoRandomTheoGioiHan(1234567890, 1876543211);
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

			setTestcaseStatus("FAIL", "Tiếp nhận Bệnh nhân không thành công !");
		}

		TestLogger.info("Kiểm tra hiển thị cột Tổng số khi đã có thông tin về số lượt của BN khám trong ngày");

		TestLogger.info("Kiểm tra hiển thị cột Chờ khi đã có thông tin về số lượt của BN chờ khám trong ngày");
		// get tổng số bệnh nhân đang chờ tại tại phòng khám tai mũi họng hiện
		// tại khi đã tiếp nhận thêm
		String SoBenhNhanSauKhiTiepNhanThem = layTextTuAnh(1291, 123, 52, 17);

		int tongSoBenhNhanSauKhiTiepNhanThem = Integer
				.valueOf(SoBenhNhanSauKhiTiepNhanThem.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("==> " + tongSoBenhNhanSauKhiTiepNhanThem);
		if (tongSoBenhNhanSauKhiTiepNhanThem - tongSoBenhNhanCho >= 1) {
			thuHepKhungPhongKham();
			setTestcaseStatus("PASS", "Expect : Hiển thị chính xác số lượng BN chờ khám trong ngày hiện thời");
		} else {
			thuHepKhungPhongKham();
			setTestcaseStatus("FAIL", "Expect : Hiển thị chính xác số lượng BN chờ khám trong ngày hiện thời");
		}

	}

	@Test(priority = 88)
	public void tiepNhanBenhNhan_10504_3() {
		TestLogger.info("[Phòng khám] Kiểm tra validate cột Chờ");
		TestLogger.info("Kiểm tra BN đang chờ khám hủy dịch vụ khám");
		moRongKhungPhongKham();
		// get tổng số bệnh nhân tại phòng khám tai mũi họng hiện tại khi bac si
		// chưa bỏ dịch vụ
		String SoBenhNhanCho = layTextTuAnh(1291, 123, 52, 17);

		int tongSoBenhNhanCho = Integer.valueOf(SoBenhNhanCho.trim().replace(".", "").replaceAll("\\s+", ""));

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
		SoDienThoaiNguoiLienHe = TienIch.taoRandomTheoGioiHan(1234567890, 1876543211);
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

			setTestcaseStatus("FAIL", "Tiếp nhận Bệnh nhân không thành công !");
		}

		TestLogger.info("Kiểm tra hiển thị cột Tổng số khi đã có thông tin về số lượt của BN khám trong ngày");

		TestLogger.info("Expect : Hiển thị chính xác số lượng BN khám trong ngày hiện thời");
		// get tổng số bệnh nhân tại phòng khám tai mũi họng hiện tại khi chưa
		// xóa dịch vụ
		String SoBenhNhanSauKhiChuaXoaDichVu = layTextTuAnh(1291, 123, 52, 17);

		int tongSoBenhNhanSauKhiTiepNhanThem = Integer
				.valueOf(SoBenhNhanSauKhiChuaXoaDichVu.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("==> " + tongSoBenhNhanSauKhiTiepNhanThem);
		if (tongSoBenhNhanSauKhiTiepNhanThem - tongSoBenhNhanCho == 1) {

			setTestcaseStatus("PASS", "Hiển thị chính xác số lượng BN khám trong ngày hiện thời");
		} else {

			setTestcaseStatus("FAIL", "Hiển thị chính xác số lượng BN khám trong ngày hiện thời");
		}

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
		// xoa dich vu
		clickToaDo(31, 539);

		clickOn(TiepNhanBenhNhan_Luu);
		String SoBenhNhanSauKhiBoDichVu = layTextTuAnh(1291, 123, 52, 17);

		int tongSoBenhNhanSauKhiBoDichVu = Integer
				.valueOf(SoBenhNhanSauKhiBoDichVu.trim().replace(".", "").replaceAll("\\s+", ""));
		TestLogger.info("==> " + tongSoBenhNhanSauKhiBoDichVu);

		if (tongSoBenhNhanSauKhiBoDichVu == tongSoBenhNhanCho) {
			thuHepKhungPhongKham();

			setTestcaseStatus("PASS", "Cột Chờ sẽ trừ đi số lượt bệnh nhân hủy dịch vụ ");

		} else {
			thuHepKhungPhongKham();
			setTestcaseStatus("FAIL", "Cột Chờ sẽ trừ đi số lượt bệnh nhân hủy dịch vụ ");
		}

	}

	@Test(priority = 89)
	public void tiepNhanBenhNhan_10504_4() {
		
		// click để mở rộng cửa sổ phòng khám
		moRongKhungPhongKham();
		// get tổng số bệnh nhân tại phòng khám tai mũi họng hiện tại khi chưa
		// tiếp nhận thêm
		String TongSoBenhNhanKhiChuaChuyenDichVu = layTextTuAnh(1219, 123, 52, 17);

		int tongSoBenhNhan = Integer
				.valueOf(TongSoBenhNhanKhiChuaChuyenDichVu.trim().replace(".", "").replaceAll("\\s+", ""));

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
		SoDienThoaiNguoiLienHe = TienIch.taoRandomTheoGioiHan(1234567890, 1876543211);
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

			setTestcaseStatus("FAIL", "Tiếp nhận Bệnh nhân không thành công !");
		}

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

		// click len Menu Tiep Nhan
		clickOn(HisActions.HIS_MenuTiepNhan);
		clickOn(TiepNhanBenhNhan_ChuyenPhongKham);
		s.type(soTiepNhan);
		s.type(Key.ENTER);
		clickOn(FormChuyenPhongKham.FormChuyenPhongKham_Sua);
		clickToaDo(476, 217);
		s.type(Key.DOWN);
		s.type(Key.ENTER);
	}

	@AfterTest
	public void ketThucLuong() {
		dangXuatKhoiTaikhoan();
		thoatUngdungHIS();
	}

}
