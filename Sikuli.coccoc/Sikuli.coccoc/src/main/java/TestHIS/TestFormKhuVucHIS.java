package TestHIS;

import java.sql.Connection;
import java.sql.SQLException;
import org.sikuli.api.robot.Key;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HIS.FormKhuVuc;
import desktop_Framework.HisActions;
import desktop_Framework.KiemSoatDatabase;
import desktop_Framework.TestLogger;
import desktop_Framework.TienIch;

public class TestFormKhuVucHIS extends HisActions {

	public HisActions his = new HisActions();
	public FormKhuVuc kv = new FormKhuVuc();
	String kituchu = TienIch.taoRandomChu(25);
	int i = 1;

	@BeforeTest
	public void KhoiDongHIS() {

		if (his.khoiDongHIS(HisActions.DUONG_DAN_FILE_CHAY_HIS) == true) {
			setTestcaseStatus("PASS", "Ứng dụng HIS đã khởi động thành công ! ");
		} else {
			setTestcaseStatus("FAIL", "Ứng dụng HIS không khởi động thành công !");
		}
	}

	@Test
	public void KhuVuc_3757_1() {
		TestLogger.info("[Danh sách khu vực_UI/UX]Kiểm tra hiển thị form danh mục Khu vực");
		TestLogger.info("1.Đăng nhập với quyền admin");
		his.dangNhapHIS(FormKhuVuc.ten_dangNhap_admin, FormKhuVuc.matKhau_dangNhap_admin);
		TestLogger.info("2. Click button Danh mục/Hành chính/Khu vực");
		waitForObjectPresent(FormKhuVuc.ChonPhongBanLamViec, 5);
		clickOn(FormKhuVuc.ChonPhongBanLamViec);
		chonPhongLamViec("Khám TMH");
		s.type(Key.TAB);
		s.type(Key.ENTER);
		clickOn(FormKhuVuc.Menu_DanhMuc);
		clickOn(FormKhuVuc.Menu_HanhChinh);
		clickOn(FormKhuVuc.Menu_KhuVuc);
		TestLogger.info("Expect : Confirm form danh mục Khu vực hiển thị các cột thông tin sau:" + "Mã khu vực "
				+ "Tên khu vực " + "Ghi chú " + "Thứ tự " + "Tạm ngưng");
		if (waitForObjectPresent(FormKhuVuc.MaKhuVuc, 3) && (waitForObjectPresent(FormKhuVuc.TenKhuVuc, 3))
				&& (waitForObjectPresent(FormKhuVuc.GhiChu, 3)) && (waitForObjectPresent(FormKhuVuc.GhiChu, 3))
				&& (waitForObjectPresent(FormKhuVuc.ThuTu, 3)) && (waitForObjectPresent(FormKhuVuc.TamNgung, 3))) {
			hoverImage(FormKhuVuc.MaKhuVuc);
			hoverImage(FormKhuVuc.TenKhuVuc);
			hoverImage(FormKhuVuc.GhiChu);
			hoverImage(FormKhuVuc.ThuTu);
			hoverImage(FormKhuVuc.TamNgung);
			setTestcaseStatus("PASS", "Confirm form danh mục Khu vực hiển thị các cột");
		} else {
			setTestcaseStatus("FAIL", "Confirm form danh mục Khu vực hiển thị các cột");

		}

	}

	@Test
	public void KhuVuc_3810_1() {
		TestLogger.info(
				"[Màn hình chi tiết_UI/UX]Kiểm tra màn hình chi tiết của danh sách Khu vực ở trạng thái mặc định");
		TestLogger.info(" 1. Kiểm tra title trên form màn hình chi tiết");
		TestLogger.info("Expect :  Confirm hiển thị title của form màn hình chi tiết là Khu vực");
		if (waitForObjectPresent(FormKhuVuc.title_khuvuc, 4)) {
			clickOn(FormKhuVuc.title_khuvuc);
			setTestcaseStatus("PASS", "Confirm hiển thị title của form màn hình chi tiết là Khu vực");
		} else {
			setTestcaseStatus("FAIL", "Confirm hiển thị title của form màn hình chi tiết là Khu vực");

		}

	}

	@Test
	public void KhuVuc_3812_2() {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Mã khu vực");
		TestLogger.info("2.Kiểm tra việc nhập ký tự đặc biệt @() vào trường Mã khu vực ");
		moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		setClipboardValue("");
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type("*^*^)*(*");
		sleep(2);
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String text = getClipboardValue();

		TestLogger.info("==>>>" + text);
		TestLogger.info("Expect : Confirm không thể nhập ký tự đặc biệt vào trường ký tự");
		if (text.length() == 0) {
			clickOn(FormKhuVuc.form_Makhuvuc_icon_X);
			s.type(Key.ENTER);

			setTestcaseStatus("PASS", "Confirm không thể nhập ký tự đặc biệt vào trường ký tự");
		} else {
			clickOn(FormKhuVuc.form_Makhuvuc_icon_X);
			s.type(Key.ENTER);
			setTestcaseStatus("FAIL", "Confirm không thể nhập ký tự đặc biệt vào trường ký tự");
		}

	}

	@Test
	public void KhuVuc_3812_3() {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Mã khu vực");
		TestLogger.info("3.Kiểm tra việc nhập ký tự chữ vào trường mã khu vực");
		String kituchu = TienIch.taoRandomChu(8);
		kv.nhapKiTuChu(kituchu);
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		kv.closeformKhuVuc();
		if (getClipboardValue().equals(kituchu)) {

			setTestcaseStatus("PASS", "Confirm có thể nhập ký tự chữ và được view lên bình thường, không có lỗi font");
		} else {
			setTestcaseStatus("FAIL", "Confirm có thể nhập ký tự chữ và được view lên bình thường, không có lỗi font");
		}

	}

	@Test
	public void KhuVuc_3812_4() {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Mã khu vực");
		TestLogger.info("4.Confirm có thể nhập ký tự số và được view lên bình thường, không có lỗi font");
		String kituSo = TienIch.taoRandomSo(8);
		kv.nhapKiTuChu(kituSo);
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		kv.closeformKhuVuc();
		if (getClipboardValue().equals(kituSo)) {

			setTestcaseStatus("PASS", "Confirm có thể nhập ký tự chữ và được view lên bình thường, không có lỗi font");
		} else {
			setTestcaseStatus("FAIL", "Confirm có thể nhập ký tự chữ và được view lên bình thường, không có lỗi font");
		}
	}

	@Test
	public void KhuVuc_3812_5() {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Mã khu vực");
		TestLogger.info("5.Kiểm tra việc để trống trường dữ liệu bắt buộc Mã khu vực");
		kv.nhapKiTuChu("");
		clickOn(FormKhuVuc.Nut_Luu);
		TestLogger.info("Expect : Confirm hệ thống trả về thông báo: Bạn phải nhập thông tin trường Mã khu vực");
		if (waitForObjectPresent(FormKhuVuc.CanhBao_MaKhuVuc, 5)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "hệ thống trả về thông báo: Bạn phải nhập thông tin trường Mã khu vực");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "hệ thống trả về thông báo: Bạn phải nhập thông tin trường Mã khu vực");
		}

	}

	@Test
	public void KhuVuc_3812_6() {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Mã khu vực");
		TestLogger.info("Kiểm tra việc nhập mã khu vực vượt quá maxlength 25 ký tự cho phép (26 ký tự) ");
		kv.nhapKiTuChu(TienIch.taoRandomSovaChu(27));
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 48);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		kv.closeformKhuVuc();
		if (getClipboardValue().length() == 25) {
			setClipboardValue("");
			setTestcaseStatus("PASS", "Confirm chỉ có thể điền 25 kí tự ");
		} else {
			setClipboardValue("");
			setTestcaseStatus("FAIL", "Confirm chỉ có thể điền 25 kí tự ");
		}
	}

	@Test
	public void KhuVuc_3812_7() throws SQLException {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Mã khu vực");
		TestLogger.info("Kiểm tra việc nhập không quá maxlength là 25 ký tự ");
		String kituchu = TienIch.taoRandomChu(25);
		kv.nhapKiTuChu(kituchu);
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		kv.closeformKhuVuc();
		String ch = getClipboardValue();
		TestLogger.info("===> " + ch);
		KiemSoatDatabase db = new KiemSoatDatabase();
		Connection con = db.taoKetNoi(KiemSoatDatabase.URL, KiemSoatDatabase.USERNAME, KiemSoatDatabase.PASSWORD);
		TestLogger.info("===> cot Ma khu vuc : " + db.getMaKhuVuc(con, kituchu));

		if (getClipboardValue().equals(kituchu)) {

			setTestcaseStatus("PASS", "Confirm có thể nhập ký tự chữ và được view lên bình thường, không có lỗi font");
		} else {
			setTestcaseStatus("FAIL", "Confirm có thể nhập ký tự chữ và được view lên bình thường, không có lỗi font");
		}
	}

	@Test
	public void KhuVuc_3812_8() throws SQLException {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Mã khu vực");
		TestLogger.info("Kiểm tra việc trùng mã khu vực");
		kituchu = TienIch.taoRandomChu(25);
		kv.nhapKiTuChu(kituchu);
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		kv.closeformKhuVuc();
		String ch = getClipboardValue();
		TestLogger.info("===> " + ch);
		KiemSoatDatabase db = new KiemSoatDatabase();
		Connection con = db.taoKetNoi(KiemSoatDatabase.URL, KiemSoatDatabase.USERNAME, KiemSoatDatabase.PASSWORD);
		TestLogger.info("===> cot Ma khu vuc : " + db.getMaKhuVuc(con, kituchu));

		if (getClipboardValue().equals(kituchu)) {

			setTestcaseStatus("PASS", "Confirm có thể nhập ký tự chữ và được view lên bình thường, không có lỗi font");
		} else {
			setTestcaseStatus("FAIL", "Confirm có thể nhập ký tự chữ và được view lên bình thường, không có lỗi font");
		}
	}

	@Test
	public void KhuVuc_3812_9() throws SQLException {
		TestLogger.info("Kiểm tra việc trùng mã khu vực");
		TestLogger.info("Expect : Trong trường hợp bị trùng đưa message thông báo lỗi đỏ đã tồn tại mã khu vực này ");
		moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 110);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kituchu);
		sleep(2);
		clickOn(FormKhuVuc.Nut_Luu);
		if (waitForObjectPresent(FormKhuVuc.Dialog_MakhuVucDaTontai, 5)) {
			clickOn(FormKhuVuc.Dialog_MakhuvucDaTonTai_NutDongY);
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "message thông báo lỗi đỏ đã tồn tại mã khu vực");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "message thông báo lỗi đỏ đã tồn tại mã khu vực");
		}
	}

	@Test
	public void KhuVuc_3813_2() throws SQLException {
		TestLogger.info("2. Kiểm tra việc nhập ký tự đặc biệt - vào trường Tên khu vực ");
		TestLogger.info("Expect : Confirm có thể nhập ký tự đặc biệt và được view lên bình thường, không có lỗi font");
		String kitudacbiet = "*()%^^^^";
		setClipboardValue("");
		kv.nhapkituDacBietvaoTenKhuVuc(kitudacbiet);
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		hoverImage(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		if (getClipboardValue().equals(kitudacbiet)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm có thể nhập ký tự đặc biệt");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm có thể nhập ký tự đặc biệt");
		}

	}

	@Test
	public void KhuVuc_3813_3() throws SQLException {
		TestLogger.info("3. Kiểm tra việc để trống trường dữ liệu bắt buộc Tên khu vực ");
		TestLogger.info("Expect : Confirm hiển thị thông báo: Bạn phải nhập thông tin trường Tên khu vực");
		kv.nhapkituDacBietvaoTenKhuVuc("");
		clickOn(FormKhuVuc.Nut_Luu);
		TestLogger.info("Expect : Confirm hệ thống trả về thông báo: Bạn phải nhập thông tin trường Tên khu vực");
		if (waitForObjectPresent(FormKhuVuc.Dialog_TenkhuVucKhongDuocDeTrong, 5)) {
			s.type(Key.ENTER);
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "hệ thống trả về thông báo: Bạn phải nhập thông tin trường Tên khu vực");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "hệ thống trả về thông báo: Bạn phải nhập thông tin trường Tên khu vực");
		}

	}

	@Test
	public void KhuVuc_3813_4() throws SQLException {
		TestLogger.info("4. Kiểm tra việc nhập tên khu vực vượt quá maxlength 255 ký tự cho phép (256 ký tự) ");
		TestLogger.info("Expect :Confirm hiển thị thông báo: Số ký tự nhập quá số ký tự tối đa cho phép");
		kv.nhapkituDacBietvaoTenKhuVuc(TienIch.taoRandomChu(256));
		setClipboardValue("");
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		hoverImage(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("độ dài kí tự : " + getClipboardValue().length());
		if (getClipboardValue().length() == 255) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm không thể nhập quá 255 kí tự");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm không thể nhập quá 255 kí tự");
		}

	}

	@Test
	public void KhuVuc_3813_5() throws SQLException {
		TestLogger.info("5. 5. Kiểm tra việc nhập không quá maxlength là 255 ký tự  ");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		String kitu = TienIch.taoRandomChu(25);
		kv.nhapkituDacBietvaoTenKhuVuc(kitu);
		setClipboardValue("");
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		hoverImage(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		if (getClipboardValue().equals(kitu)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test
	public void KhuVuc_3813_6() throws SQLException {
		TestLogger.info("6. 6. Kiểm tra việc nhập câu lệnh javascript: <script>alert('test')</script>");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		String kitu = "<script>alert('test')</script>";
		kv.nhapkituDacBietvaoTenKhuVuc(kitu);
		setClipboardValue("");
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		hoverImage(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		if (getClipboardValue().equals(kitu)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test
	public void KhuVuc_3813_7() throws SQLException {
		TestLogger.info("7. Kiểm tra việc nhập câu lệnh javascript: <script>alert('test')</script>");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		String kitu = "<h1>test</h1>";
		kv.nhapkituDacBietvaoTenKhuVuc(kitu);
		setClipboardValue("");
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		hoverImage(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		if (getClipboardValue().equals(kitu)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test
	public void KhuVuc_3813_8() throws SQLException {
		TestLogger.info("8. Kiểm tra việc nhập với ngôn ngữ Tiếng Việt có dấu ");
		TestLogger.info(
				"Expect : Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
		setClipboardValue("Quận Đống Đa");
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		hoverImage(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type("v", Key.CTRL);
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		hoverImage(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		if (getClipboardValue().equals("Quận Đống Đa")) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "dữ liệu của trường được view lên bình thường, không bị lỗi font");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "dữ liệu của trường được view lên bình thường, không bị lỗi font");
		}
	}

	@Test
	public void KhuVuc_3815_2() throws SQLException {
		TestLogger.info("2. Kiểm tra việc nhập ký tự đặc biệt @- vào trường Ghi chú");
		TestLogger.info(
				"Expect : Confirm cho phép thêm mới thành công, dữ liệu của trường được view lên bình thường, không bị lỗi font");
		String kitudacbiet = "^()()().";
		setClipboardValue("");
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kitudacbiet);
		sleep(2);
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		if (getClipboardValue().equals(kitudacbiet)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm có thể nhập ký tự đặc biệt");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm có thể nhập ký tự đặc biệt");
		}
	}

	@Test
	public void KhuVuc_3815_3() throws SQLException {
		TestLogger.info("3. Kiểm tra việc để trống trường dữ liệu Ghi chú ");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		String kitudacbiet = "";
		setClipboardValue("");
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kitudacbiet);
		sleep(2);
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		if (getClipboardValue().equals(kitudacbiet)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test
	public void KhuVuc_3815_4() throws SQLException {
		TestLogger.info("4. Kiểm tra việc nhập ghi chú vượt quá maxlength 255 ký tự cho phép (256 ký tự");
		TestLogger.info("Expect : Confirm hiển thị thông báo: Số ký tự nhập quá ký tự tối đa cho phép");
		String kitudacbiet = TienIch.taoRandomSovaChu(256);
		setClipboardValue("");
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kitudacbiet);
		sleep(2);
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		if (getClipboardValue().length() == 255) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm không thể nhấp quá 255 kí tự ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm không thể nhấp quá 255 kí tự");
		}
	}

	@Test
	public void KhuVuc_3815_5() throws SQLException {
		TestLogger.info("5. Kiểm tra việc nhập không quá maxlength là 255 ký tự ");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		String kitudacbiet = TienIch.taoRandomSovaChu(25);
		setClipboardValue("");
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kitudacbiet);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(2);
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 50);
		s.doubleClick();

		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		if (getClipboardValue().equals(kitudacbiet)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test
	public void KhuVuc_3815_6() throws SQLException {
		TestLogger.info("6. Kiểm tra việc nhập câu lệnh javascript: <script>alert(test)</script> ");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		String kitudacbiet = "<script>alert(test)</script>";
		setClipboardValue("");
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kitudacbiet);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(2);
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		if (getClipboardValue().equals(kitudacbiet)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test
	public void KhuVuc_3815_7() throws SQLException {
		TestLogger.info("7. Kiểm tra việc nhập thẻ html: <h1>test</h1>  ");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		String kitudacbiet = "<h1>test</h1> ";
		setClipboardValue("");
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kitudacbiet);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(2);
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		if (getClipboardValue().equals(kitudacbiet)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test
	public void KhuVuc_3815_8() throws SQLException {
		TestLogger.info("8.Kiểm tra việc nhập với ngôn ngữ Tiếng Việt có dấu");
		TestLogger.info("Expect : Confirm cho phép thêm mới thành công");
		setClipboardValue("Xinh duyên dáng");
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type("v", Key.CTRL);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(2);
		moveMouseDownFromLogo(FormKhuVuc.GhiChu, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.Nut_Luu, 5);
		hoverImage(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.Nut_Luu, -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		if (getClipboardValue().equals("Xinh duyên dáng")) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm cho phép thêm mới thành công ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm cho phép thêm mới thành công");
		}
	}

	@Test
	public void KhuVuc_3816_1() throws SQLException {
		TestLogger.info("1.Kiểm tra giá trị mặc định ");
		TestLogger.info("Expect : Confirm giá trị mặc định trường Thứ tự là 1");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		if (getClipboardValue().equals("1")) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm giá trị mặc định trường Thứ tự là 1");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm giá trị mặc định trường Thứ tự là 1");
		}
	}

	@Test
	public void KhuVuc_3816_2() throws SQLException {
		TestLogger.info("2.Kiểm tra việc nhập ký tự đặc biệt - vào trường Thứ tự ");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		setClipboardValue("");
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.doubleClick();
		s.type("^^^");
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("Expect : ");
		if (getClipboardValue().equals("1")) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm không thể nhập ký tự đặc biệt vào trường thứ tự");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm không thể nhập ký tự đặc biệt vào trường thứ tự");
		}

	}

	@Test
	public void KhuVuc_3816_3() throws SQLException {
		TestLogger.info("3.Kiểm tra việc nhập ký tự chữ cái vào trường Thứ tự ");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		setClipboardValue("");
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.doubleClick();
		s.type(TienIch.taoRandomChu(6));
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("Expect : ");
		if (getClipboardValue().equals("1")) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm không thể nhập ký tự đặc biệt vào trường thứ tự");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm không thể nhập ký tự đặc biệt vào trường thứ tự");
		}
	}

	@Test
	public void KhuVuc_3816_4() throws SQLException {
		TestLogger.info("4.Kiểm tra việc để trống trường dữ liệu Thứ tự ");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		setClipboardValue("");
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.doubleClick();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type("");
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("Expect : ");
		if (getClipboardValue().equals("1")) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm không thể nhập ký tự đặc biệt vào trường thứ tự");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm không thể nhập ký tự đặc biệt vào trường thứ tự");
		}
	}

	@Test
	public void KhuVuc_3816_5() throws SQLException {
		TestLogger.info("5.Kiểm tra việc nhập number vào trường Thứ tự ");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		setClipboardValue("");
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		String soRandom = TienIch.taoRandomSo(6);
		s.type(soRandom);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(7);
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("Expect : Confirm hệ thống cho phép thêm mới thành công");
		if (getClipboardValue().equals(soRandom)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm hệ thống cho phép thêm mới thành công");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm hệ thống cho phép thêm mới thành công");
		}
	}

	@Test
	public void KhuVuc_3816_6() throws SQLException {
		TestLogger.info("6.Kiểm tra việc nhập vượt quá maxlength 6 ký tự cho phép (7 ký tự)");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		setClipboardValue("");
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		String soRandom = TienIch.taoRandomTheoGioiHan(1000000, 9999999);
		s.type(soRandom);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(7);
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("Expect : Không thể nhập quá 6 kí tự ");
		if (getClipboardValue().length() == 6) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Không thể nhập quá 6 kí tự ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Không thể nhập quá 6 kí tự ");
		}
	}

	@Test
	public void KhuVuc_3816_7() throws SQLException {
		TestLogger.info("7.Kiểm tra việc nhập không vượt quá maxlength 6 ký tự cho phép ");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		setClipboardValue("");
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		String soRandom = TienIch.taoRandomTheoGioiHan(100000, 999999);
		s.type(soRandom);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(7);
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("Expect : Confirm hệ thống cho phép thêm mới thành công");
		if (getClipboardValue().equals(soRandom)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm hệ thống cho phép thêm mới thành công ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm hệ thống cho phép thêm mới thành công ");
		}
	}

	@Test
	public void KhuVuc_3816_8() throws SQLException {
		TestLogger.info("8.Kiểm tra nhập trùng trường thứ tự");
		TestLogger.info("Expect : Hệ thống cho phép nhập trùng ");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		setClipboardValue("");
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		String soRandom = TienIch.taoRandomTheoGioiHan(100000, 999999);
		s.type(soRandom);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(7);

		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 100);
		s.doubleClick();
		setClipboardValue("");
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(soRandom);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(7);
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.KhuVuc_ThuTuLenXuong, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.KhuVuc_ThuTuLenXuong, -40);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("Expect : Confirm hệ thống cho phép thêm mới thành công");
		if (getClipboardValue().equals(soRandom)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", " Hệ thống cho phép nhập trùng ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", " Hệ thống cho phép nhập trùng");
		}

	}

	@Test
	public void KhuVuc_3818_1() throws SQLException {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Tạm ngưng");
		TestLogger.info("Expect : Confirm giá trị mặc định default không check tạm ngưng ");
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		s.doubleClick();
		if (waitForObjectAppearOnRegion(FormKhuVuc.FormEdit_title_khuvuc,
				FormKhuVuc.FormEdit_MaKhuVuc_Checkbox_uncheck_TamNgung, 129, 246, 5)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm giá trị mặc định default không check tạm ngưng ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm giá trị mặc định default không check tạm ngưng ");
		}
	}

	@Test
	public void KhuVuc_3818_2() throws SQLException {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Tạm ngưng");
		TestLogger.info("2. Kiểm tra việc check vao checkbox tại trường tạm ngưng ");
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		s.doubleClick();
		waitForObjectAppearOnRegion(FormKhuVuc.FormEdit_title_khuvuc,
				FormKhuVuc.FormEdit_MaKhuVuc_Checkbox_uncheck_TamNgung, 133, 250, 5);
		clickOnRegion(FormKhuVuc.FormEdit_title_khuvuc, FormKhuVuc.FormEdit_MaKhuVuc_Checkbox_uncheck_TamNgung, 129,
				248);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(4);
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		s.doubleClick();
		TestLogger.info("Expect : Confirm hệ thống cho phép check trường tạm ngưng ");
		if (waitForObjectAppearOnRegion(FormKhuVuc.FormEdit_title_khuvuc,
				FormKhuVuc.FormEdit_MaKhuVuc_Checkbox_check_TamNgung, 133, 250, 5)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", " Confirm hệ thống cho phép check trường tạm ngưng ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", " Confirm hệ thống không cho phép check trường tạm ngưng ");
		}
	}

	@Test
	public void KhuVuc_3818_3() throws SQLException {
		TestLogger.info("[Màn hình chi tiết_Validate]Kiểm tra Validate trường Tạm ngưng");
		TestLogger.info("3.Kiểm tra việc check tại trường tạm ngưng ");
		TestLogger.info("Expect : Confirm hệ thống cho phép check trường tạm ngưng ");
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		s.doubleClick();
		waitForObjectAppearOnRegion(FormKhuVuc.FormEdit_title_khuvuc,
				FormKhuVuc.FormEdit_MaKhuVuc_Checkbox_check_TamNgung, 133, 250, 5);
		clickOnRegion(FormKhuVuc.FormEdit_title_khuvuc, FormKhuVuc.FormEdit_MaKhuVuc_Checkbox_check_TamNgung, 129, 248);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(4);
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		s.doubleClick();
		TestLogger.info("Expect : Confirm hệ thống cho phép check trường tạm ngưng ");
		if (waitForObjectAppearOnRegion(FormKhuVuc.FormEdit_title_khuvuc,
				FormKhuVuc.FormEdit_MaKhuVuc_Checkbox_uncheck_TamNgung, 133, 250, 5)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", " Confirm hệ thống cho phép check trường tạm ngưng ");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", " Confirm hệ thống không cho phép check trường tạm ngưng ");
		}
	}

	@Test
	public void KhuVuc_3828_1() throws SQLException {
		TestLogger.info(
				"[Màn hình chi tiết_ Control]Kiểm tra tính năng đóng form khi click button 'x' trên form Màn hình chi tiết");
		TestLogger.info("1.Thực hiện click button x");
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.form_Makhuvuc_icon_X, 5);
		clickOn(FormKhuVuc.form_Makhuvuc_icon_X);
		TestLogger.info("Expect : Confirm form Màn hình chi tiết được đóng lại");
		if (waitforObjectNotexist(FormKhuVuc.form_Makhuvuc_icon_X, 1)) {
			setTestcaseStatus("PASS", "Confirm form Màn hình chi tiết được đóng lại");
		} else {
			setTestcaseStatus("FAIL", "Confirm form Màn hình chi tiết được đóng lại");
		}

	}

	@Test
	public void KhuVuc_3828_2() throws SQLException {
		TestLogger.info(
				"[Màn hình chi tiết_ Control]Kiểm tra tính năng đóng form khi click button 'x' trên form Màn hình chi tiết");
		TestLogger.info("2. Trên màn hình chi tiết, dữ liệu đã được sửa hoặc thêm mới và Thực hiện click button x ");
		setClipboardValue("");
		moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String chuoi = TienIch.taoRandomChu(4);
		s.type(chuoi);
		waitForObjectPresent(FormKhuVuc.form_Makhuvuc_icon_X, 5);
		clickOn(FormKhuVuc.form_Makhuvuc_icon_X);
		TestLogger.info(
				"Confirm hệ thống hiển thị popup Dữ liệu sẽ không được lưu, bạn có muốn tiếp tục đóng hay không?Button: Yes, No");

		if (waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_Dialog_XacNhan, 5)) {
			s.type(Key.ENTER);
			setTestcaseStatus("PASS", "bạn có muốn tiếp tục đóng hay không?Button: Yes, No");
		} else {
			s.type(Key.ENTER);
			setTestcaseStatus("FAIL", "bạn có muốn tiếp tục đóng hay không?Button: Yes, No");

		}

	}

	@Test
	public void KhuVuc_3828_3() throws SQLException {
		TestLogger.info(
				"[Màn hình chi tiết_ Control]Kiểm tra tính năng đóng form khi click button 'x' trên form Màn hình chi tiết");
		TestLogger.info("3. Màn hình hiển thị popup Dữ liệu sẽ không được lưu, bạn có muốn tiếp tục đóng hay không?");
		TestLogger.info("1. Thực hiện click button Yes");
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		setClipboardValue("");
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		String chuoi = TienIch.taoRandomChu(4);
		s.type(chuoi);
		waitForObjectPresent(FormKhuVuc.form_Makhuvuc_icon_X, 5);
		clickOn(FormKhuVuc.form_Makhuvuc_icon_X);
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_Dialog_XacNhan, 5);
		TestLogger.info("2. Thực hiện click button No");
		s.type(Key.RIGHT);
		s.type(Key.ENTER);
		if (waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_Dialog_XacNhan, 5)) {
			setTestcaseStatus("PASS", "Confirm màn hình chi tiết không được đóng lại");
		} else {
			setTestcaseStatus("FAIL", "Confirm màn hình chi tiết không được đóng lại");

		}
		hoverImage(FormKhuVuc.Nut_Luu);
		waitForObjectPresent(FormKhuVuc.form_Makhuvuc_icon_X, 5);
		clickOn(FormKhuVuc.form_Makhuvuc_icon_X);
		s.type(Key.ENTER);
		moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("Confirm Màn hình chi tiết được đóng lại và dữ liệu không được lưu");
		if (getClipboardValue().equals(chuoi)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Dữ liệu được lưu");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Dữ liệu không được lưu");
		}

	}

	@Test
	public void KhuVuc_3831_1() throws SQLException {
		TestLogger.info("[Màn hình chi tiết_Lưu_Thêm]Kiểm tra việc thêm mới khu vực khi click button Lưu ");
		TestLogger.info("1. Điền các thông tin các trường để thỏa mãn các điều kiện");
		sleep(3);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		TestLogger.info("2. Click button Lưu ");
		TestLogger.info(
				"Expect : Bản ghi vừa thêm mới sẽ được lưu vào hệ thống và hiển thị lên đầu tiên theo thứ tự trong danh mục");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		String makhuvuc = TienIch.taoRandomChu(5);
		s.type(makhuvuc);
		s.type(Key.TAB);
		s.type(TienIch.taoRandomChu(12));
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		setClipboardValue("");
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		if (getClipboardValue().equals(makhuvuc)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS",
					"Bản ghi vừa thêm mới sẽ được lưu vào hệ thống và hiển thị lên đầu tiên theo thứ tự trong danh mục");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL",
					"Bản ghi vừa thêm mới sẽ được lưu vào hệ thống và hiển thị lên đầu tiên theo thứ tự trong danh mục");
		}

	}

	@Test
	public void KhuVuc_3832_1() throws SQLException {
		TestLogger.info(
				"[Màn hình chi tiết_Lưu_Sửa]Kiểm tra việc update thành công khi không thay đổi trường dữ liệu nào");
		TestLogger.info("1.Không chỉnh sửa trường dữ liệu nào");
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		setClipboardValue("");
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String makhuvuc = getClipboardValue();
		TestLogger.info("2. Click button Lưu");
		clickOn(FormKhuVuc.Nut_Luu);
		TestLogger.info("Expect : Giữ nguyên dữ liệu vừa chỉnh sửa.  ");
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		if (getClipboardValue().equals(makhuvuc)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Giữ nguyên dữ liệu vừa chỉnh sửa.");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Giữ nguyên dữ liệu vừa chỉnh sửa.");
		}
	}

	@Test
	public void KhuVuc_3834() throws SQLException {
		TestLogger.info("[Màn hình chi tiết_Lưu_Sửa]Kiểm tra việc update thành công khi click vào button Lưu");
		TestLogger.info("1.Các trường cập nhật dữ liệu thỏa mãn các điều kiện");
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		setClipboardValue("");
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		String chuoi = TienIch.taoRandomChu(4);
		s.type(chuoi);
		TestLogger.info("2. Click button Lưu ");
		clickOn(FormKhuVuc.Nut_Luu);
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		setClipboardValue("");
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		TestLogger.info("Expect :  2. Bản ghi vừa sửa sẽ được lưu vào hệ thống ");
		if (getClipboardValue().equals(chuoi)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Bản ghi vừa sửa sẽ được lưu vào hệ thống");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Bản ghi vừa sửa sẽ được lưu vào hệ thống");
		}

	}

	@Test
	public void KhuVuc_3836() throws SQLException {
		TestLogger.info(
				"[Màn hình chi tiết_Lưu&Tiếp tục_Thêm]Kiểm tra việc thêm mới khu vực khi click button Lưu & Tiếp tục");
		TestLogger.info("1.Các trường cập nhật dữ liệu thỏa mãn các điều kiện");
		TestLogger.info(
				"Expect :- Bản ghi vừa thêm mới sẽ được lưu vào hệ thống và hiển thị lên đầu tiên trong danh mục");
		TestLogger.info("- Form thêm mới vẫn được hiển thị và làm mới");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_Button_Them, 5);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		TestLogger.info("2. Click button Lưu ");
		TestLogger.info(
				"Expect : Bản ghi vừa thêm mới sẽ được lưu vào hệ thống và hiển thị lên đầu tiên theo thứ tự trong danh mục");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		String makhuvuc = TienIch.taoRandomChu(5);
		s.type(makhuvuc);
		s.type(Key.TAB);
		s.type(TienIch.taoRandomChu(12));
		clickOn(FormKhuVuc.FormKhuvuc_MenuThem_NutLuuThem);
		if (waitForObjectPresent(FormKhuVuc.FormKhuvuc_MenuThem_NutLuuThem, 3)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Form thêm mới vẫn được hiển thị và làm mới");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Form thêm mới vẫn được hiển thị và làm mới");
		}

		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		setClipboardValue("");
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		if (getClipboardValue().equals(makhuvuc)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS",
					"Bản ghi vừa thêm mới sẽ được lưu vào hệ thống và hiển thị lên đầu tiên theo thứ tự trong danh mục");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL",
					"Bản ghi vừa thêm mới sẽ được lưu vào hệ thống và hiển thị lên đầu tiên theo thứ tự trong danh mục");
		}

	}

	@Test
	public void KhuVuc_3837() throws SQLException {
		TestLogger.info(
				"[Màn hình chi tiết_Hủy bỏ]Kiểm tra tính năng hủy bỏ trên form khi thực hiện click button Hủy bỏ");
		TestLogger.info("1. Click button Hủy bỏ ");
		TestLogger.info("Expect : 1.Confirm form Màn hình chi tiết được đóng lại và dữ liệu không được lưu");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_Button_Them, 5);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		String makhuvuc = TienIch.taoRandomChu(5);
		s.type(makhuvuc);
		s.type(Key.TAB);
		s.type(TienIch.taoRandomChu(12));
		clickOn(FormKhuVuc.FormEdit_MaKhuVuc_Nut_Huy);
		s.type(Key.ENTER);
		moveMouseDownFromLogo(FormKhuVuc.TamNgung, 45);
		setClipboardValue("");
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		if (getClipboardValue().equals(makhuvuc)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm form Màn hình chi tiết được đóng lại và dữ liệu không được lưu");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm form Màn hình chi tiết được đóng lại và dữ liệu không được lưu");
		}

	}

	@Test
	public void KhuVuc_3839() throws SQLException {
		TestLogger.info(
				"[Danh sách khu vực_Validate]Kiểm tra việc không thể trực tiếp nhập thêm mới hay sửa trên datagridview danh mục Khu vực");
		TestLogger.info("Expect : Confirm không cho phép nhập thêm mới hay xóa, sửa dữ liệu trên datagridview ");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.click();
		setClipboardValue("");
		String makhuvuc = TienIch.taoRandomChu(5);
		s.type(makhuvuc);
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);

		if (getClipboardValue().equals(makhuvuc)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm không cho phép nhập thêm mới hay xóa, sửa dữ liệu trên datagridview");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS",
					"Bản ghi vừa thêm mới sẽ được lưu vào hệ thống và hiển thị lên đầu tiên theo thứ tự trong danh mục");
		}

	}

	@Test
	public void KhuVuc_3840() throws SQLException {
		TestLogger.info(
				"[Danh sách khu vực_Validate]Kiểm tra việc hiển thị màu chọn khi người dùng thực hiện bất kỳ thao tác nào trên màn hình");
		TestLogger.info("1.Click ô bất kỳ trong danh mục Khu vực");
		moveMouseDownFromLogo(FormKhuVuc.ThuTu, 45);
		s.click();
		TestLogger.info("Expect : Confirm cả dòng dữ liệu được thay đổi màu sắc là đã chọn");
		if (waitForObjectPresent(FormKhuVuc.MauXanhNhat, 4)) {
			setTestcaseStatus("PASS", "Confirm cả dòng dữ liệu được thay đổi màu sắc là đã chọn");
		} else {
			setTestcaseStatus("FAIL", "Confirm cả dòng dữ liệu được thay đổi màu sắc là đã chọn");
		}
	}

	@Test
	public void KhuVuc_3842() throws SQLException {
		TestLogger
				.info("[Danh sách khu vực_In]Kiểm tra hiển thị màn hình In khi click vào button In tại thanh toolbar");
		TestLogger.info("Click button In");
		waitForObjectPresent(FormKhuVuc.FormKhuVuc_Menu_nut_in, 4);
		clickOn(FormKhuVuc.FormKhuVuc_Menu_nut_in);
		TestLogger.info("Expect : 2. Confirm hiển thị chi tiết màn hình in");
		if (waitForObjectPresent(FormKhuVuc.FormKhuVuc_ChiTietManHinhIn, 4)) {
			s.type(Key.F4, Key.ALT);
			setTestcaseStatus("PASS", "hiển thị chi tiết màn hình in");
		} else {
			s.type(Key.F4, Key.ALT);
			setTestcaseStatus("FAIL", "hiển thị chi tiết màn hình in");
		}

	}

	@Test
	public void KhuVuc_3851_1() throws SQLException {
		TestLogger.info(
				"[Danh sách khu vực_Tìm kiếm]Kiểm tra chức năng tìm kiếm trên màn hình datagridview danh sách Khu vực");
		TestLogger.info("Kiểm tra tìm kiếm theo Mã khu vực");
		TestLogger.info("Expect : Confirm hệ thống hiển thị dữ liệu ứng với từ khóa tìm kiếm.");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_Button_Them, 5);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		String makhuvuc = "ZZZZZ" + TienIch.taoRandomSovaChu(6);
		s.type(makhuvuc);
		s.type(Key.TAB);
		s.type(TienIch.taoRandomChu(12));
		s.type(Key.TAB);
		String ghichu = "ghichu" + TienIch.taoRandomSovaChu(6);
		s.type(ghichu);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(3);
		hoverImage(FormKhuVuc.MaKhuVuc);
		clickOn(FormKhuVuc.FormKhuVuc_Menu_Filter);
		clickOn(FormKhuVuc.FormKhuVuc_Menu_Filter_Search);
		s.type(makhuvuc);
		if (waitForObjectAppearOnRegion(FormKhuVuc.FormKhuVuc_Menu_Filter_TextValue,
				FormKhuVuc.FormKhuVuc_Menu_Filter_KetQua, 59, 95, 5)) {
			clickOnRegion(FormKhuVuc.FormKhuVuc_Menu_Filter_TextValue, FormKhuVuc.FormKhuVuc_Menu_Filter_KetQua, 59,
					95);
			clickOn(FormKhuVuc.FormTimKiem_Nut_Dong);
			if (waitForObjectPresent(FormKhuVuc.KetQua_SoDongBang1, 3)) {
				clickOnRegion(FormKhuVuc.KetQua_SoDongBang1, FormKhuVuc.FormTimKiem_Nut_X, 237, 84);
				setTestcaseStatus("PASS", "Confirm hệ thống hiển thị dữ liệu ứng với từ khóa tìm kiếm.");

			} else {
				setTestcaseStatus("FAIL", "Confirm hệ thống không hiển thị dữ liệu ứng với từ khóa tìm kiếm.");

			}

		} else {
			setTestcaseStatus("FAIL", " Không show dữ liệu tìm kiếm trong hộp search .");
		}

	}

	@Test
	public void KhuVuc_3852_2() throws SQLException {
		TestLogger.info(
				"[Danh sách khu vực_Tìm kiếm]Kiểm tra chức năng tìm kiếm trên màn hình datagridview danh sách Khu vực");
		TestLogger.info("Kiểm tra tìm kiếm theo Tên khu vực");
		TestLogger.info("Expect : Confirm hệ thống hiển thị dữ liệu ứng với từ khóa tìm kiếm.");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_Button_Them, 5);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		String makhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(6);
		s.type(makhuvuc);
		s.type(Key.TAB);
		String tenkhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(6);
		s.type(tenkhuvuc);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(3);
		hoverImage(FormKhuVuc.TenKhuVuc);
		clickOn(FormKhuVuc.FormKhuVuc_Menu_Filter);
		clickOn(FormKhuVuc.FormKhuVuc_Menu_Filter_Search);
		s.type(tenkhuvuc);
		if (waitForObjectAppearOnRegion(FormKhuVuc.FormKhuVuc_Menu_Filter_TextValue,
				FormKhuVuc.FormKhuVuc_Menu_Filter_KetQua, 59, 95, 5)) {
			clickOnRegion(FormKhuVuc.FormKhuVuc_Menu_Filter_TextValue, FormKhuVuc.FormKhuVuc_Menu_Filter_KetQua, 59,
					95);
			clickOn(FormKhuVuc.FormTimKiem_Nut_Dong);
			if (waitForObjectPresent(FormKhuVuc.KetQua_SoDongBang1, 3)) {
				clickOnRegion(FormKhuVuc.KetQua_SoDongBang1, FormKhuVuc.FormTimKiem_Nut_X, 237, 84);
				setTestcaseStatus("PASS", "Confirm hệ thống hiển thị dữ liệu ứng với từ khóa tìm kiếm.");

			} else {
				setTestcaseStatus("FAIL", "Confirm hệ thống không hiển thị dữ liệu ứng với từ khóa tìm kiếm.");

			}

		} else {
			setTestcaseStatus("FAIL", " Không show dữ liệu tìm kiếm trong hộp search .");
		}
	}

	@Test
	public void KhuVuc_3852_3() throws SQLException {
		TestLogger.info(
				"[Danh sách khu vực_Tìm kiếm]Kiểm tra chức năng tìm kiếm trên màn hình datagridview danh sách Khu vực");
		TestLogger.info("Kiểm tra tìm kiếm theo ghi chú");
		TestLogger.info("Expect : Confirm hệ thống hiển thị dữ liệu ứng với từ khóa tìm kiếm.");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_Button_Them, 5);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		String makhuvuc = "VTV3" + TienIch.taoRandomSovaChu(6);
		s.type(makhuvuc);
		s.type(Key.TAB);
		s.type(TienIch.taoRandomChu(12));
		s.type(Key.TAB);
		String ghichu = "ghichu" + TienIch.taoRandomSovaChu(6);
		s.type(ghichu);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(5);
		hoverImage(FormKhuVuc.GhiChu);
		clickOn(FormKhuVuc.FormKhuVuc_Menu_Filter);
		clickOn(FormKhuVuc.Filter_text_value);
		clickOn(FormKhuVuc.FormKhuVuc_Menu_Filter_Search);
		s.type(ghichu);
		if (waitForObjectAppearOnRegion(FormKhuVuc.FormKhuVuc_Menu_Filter_TextValue,
				FormKhuVuc.FormKhuVuc_Menu_Filter_KetQua, 59, 95, 5)) {
			clickOnRegion(FormKhuVuc.FormKhuVuc_Menu_Filter_TextValue, FormKhuVuc.FormKhuVuc_Menu_Filter_KetQua, 59,
					95);
			clickOn(FormKhuVuc.FormTimKiem_Nut_Dong);
			if (waitForObjectPresent(FormKhuVuc.KetQua_SoDongBang1, 3)) {
				clickOnRegion(FormKhuVuc.KetQua_SoDongBang1, FormKhuVuc.FormTimKiem_Nut_X, 237, 84);
				setTestcaseStatus("PASS", "Confirm hệ thống hiển thị dữ liệu ứng với từ khóa tìm kiếm.");

			} else {
				setTestcaseStatus("FAIL", "Confirm hệ thống không hiển thị dữ liệu ứng với từ khóa tìm kiếm.");

			}

		} else {
			setTestcaseStatus("FAIL", " Không show dữ liệu tìm kiếm trong hộp search .");
		}

	}

	@Test
	public void KhuVuc_3853_1() throws SQLException {
		TestLogger.info(
				"[Danh sách khu vực_Sắp xếp]Kiểm tra tiện ích khi click vào đầu mỗi cột trên gridview thì dữ liệu được sắp xếp theo thứ tự tăng hoặc giảm dần ");
		TestLogger.info("Confirm hệ thống có thể sắp xếp tăng dần, giảm dần trường Mã tên khu vực");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_Button_Them, 5);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		String makhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(2);
		s.type(makhuvuc);
		s.type(Key.TAB);
		String tenkhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(2);
		s.type(tenkhuvuc);
		s.type(Key.TAB);
		String ghichu = "ZZZZghichu" + TienIch.taoRandomSovaChu(6);
		s.type(ghichu);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(3);
		clickOn(FormKhuVuc.TenKhuVuc);
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 45);
		setClipboardValue("");
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		kv.closeformKhuVuc();
		if (getClipboardValue().startsWith("ZZZZ") || (getClipboardValue().startsWith("zzzz"))) {
			clickOn(FormKhuVuc.TenKhuVuc);
			setTestcaseStatus("PASS", "Confirm hệ thống có thể sắp xếp tăng dần, giảm dần trường Mã khu vực");
		} else {
			clickOn(FormKhuVuc.TenKhuVuc);
			setTestcaseStatus("FAIL", "Confirm hệ thống có thể sắp xếp tăng dần, giảm dần trường Mã khu vực");
		}

	}

	@Test
	public void KhuVuc_3853_2() throws SQLException {
		TestLogger.info(
				"[Danh sách khu vực_Sắp xếp]Kiểm tra tiện ích khi click vào đầu mỗi cột trên gridview thì dữ liệu được sắp xếp theo thứ tự tăng hoặc giảm dần ");
		TestLogger.info("Confirm hệ thống có thể sắp xếp tăng dần, giảm dần trường Mã khu vực");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_Button_Them, 5);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		String makhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(2);
		s.type(makhuvuc);
		s.type(Key.TAB);
		String tenkhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(2);
		s.type(tenkhuvuc);
		s.type(Key.TAB);
		String ghichu = "ZZZZghichu" + TienIch.taoRandomSovaChu(6);
		s.type(ghichu);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(3);
		clickOn(FormKhuVuc.TenKhuVuc);
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 45);
		setClipboardValue("");
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		kv.closeformKhuVuc();
		if (getClipboardValue().startsWith("ZZZZ") || (getClipboardValue().startsWith("zzzz"))) {
			clickOn(FormKhuVuc.TenKhuVuc);
			setTestcaseStatus("PASS", "Confirm hệ thống có thể sắp xếp tăng dần, giảm dần trường Mã khu vực");
		} else {
			clickOn(FormKhuVuc.TenKhuVuc);
			setTestcaseStatus("FAIL", "Confirm hệ thống có thể sắp xếp tăng dần, giảm dần trường Mã khu vực");
		}

	}

	@Test
	public void KhuVuc_3853_3() throws SQLException {
		TestLogger.info(
				"[Danh sách khu vực_Sắp xếp]Kiểm tra tiện ích khi click vào đầu mỗi cột trên gridview thì dữ liệu được sắp xếp theo thứ tự tăng hoặc giảm dần ");
		TestLogger.info("Confirm hệ thống có thể sắp xếp tăng dần, giảm dần trường Mã khu vực");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_Button_Them, 5);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		String makhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(2);
		s.type(makhuvuc);
		s.type(Key.TAB);
		String tenkhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(2);
		s.type(tenkhuvuc);
		s.type(Key.TAB);
		String ghichu = "ZZZZ" + TienIch.taoRandomSovaChu(6);
		s.type(ghichu);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(3);
		clickOn(FormKhuVuc.TenKhuVuc);
		moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 45);
		setClipboardValue("");
		s.click();
		s.type(Key.HOME, Key.CTRL);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		kv.closeformKhuVuc();
		if (getClipboardValue().startsWith("ZZZZ") || (getClipboardValue().startsWith("zzzz"))) {
			clickOn(FormKhuVuc.TenKhuVuc);
			setTestcaseStatus("PASS", "Confirm hệ thống có thể sắp xếp tăng dần, giảm dần trường Mã khu vực");
		} else {
			clickOn(FormKhuVuc.TenKhuVuc);
			setTestcaseStatus("FAIL", "Confirm hệ thống có thể sắp xếp tăng dần, giảm dần trường Mã khu vực");
		}

	}

	@Test
	public void KhuVuc_3858_1() throws SQLException {
		TestLogger.info("[Danh sách khu vực_Sửa]Kiểm tra validate trường Mã khu vực trên form Sửa");
		TestLogger.info("Kiểm tra xem thông tin bản ghi vừa được thêm mới ");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_Button_Them, 5);
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		String makhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(2);
		s.type(makhuvuc);
		s.type(Key.TAB);
		String tenkhuvuc = "ZZZZ" + TienIch.taoRandomSovaChu(2);
		s.type(tenkhuvuc);
		s.type(Key.TAB);
		String ghichu = "ZZZZ" + TienIch.taoRandomSovaChu(6);
		s.type(ghichu);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(3);
		setClipboardValue("");
		clickOn(FormKhuVuc.formkhuvuc_Button_Them);
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		s.type(makhuvuc);
		s.type(Key.TAB);
		s.type(tenkhuvuc);
		s.type(Key.TAB);
		s.type(ghichu);
		clickOn(FormKhuVuc.Nut_Luu);
		sleep(3);
		TestLogger.info(
				"Expect : Confirm hệ thống không cho phép sửa Mã khu vực trong trường hợp mã khu vực đã được sử dụng");
		if (waitForObjectPresent(FormKhuVuc.FormEdit_MaKhucVuc_DaTonTai, 4)) {
			s.type(Key.ENTER);
			clickOn(FormKhuVuc.FormEdit_MaKhuVuc_Nut_Huy);
			s.type(Key.ENTER);
			setTestcaseStatus("PASS",
					"Confirm hệ thống không cho phép sửa Mã khu vực trong trường hợp mã khu vực đã được sử dụng");
		} else {
			s.type(Key.ENTER);
			clickOn(FormKhuVuc.FormEdit_MaKhuVuc_Nut_Huy);
			s.type(Key.ENTER);
			setTestcaseStatus("FAIL",
					"Confirm hệ thống không cho phép sửa Mã khu vực trong trường hợp mã khu vực đã được sử dụng");
		}
	}

	@Test
	public void KhuVuc_4572_1() throws SQLException {
		TestLogger.info("[Danh sách_Phím tắt]Kiểm tra tính năng sử dụng phím tắt trên màn hình Danh sách");
		TestLogger.info(" Trên màn hình Danh sách, kiểm tra việc hiển thị khi nhấn các tổ hợp phím sau Ctrl + N");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		s.click();
		s.type("n", Key.CTRL);
		TestLogger.info("Expect : Confirm hiển thị màn hình Thêm mới");
		if (waitForObjectPresent(FormKhuVuc.FormKhuvuc_MenuThem_NutLuuThem, 4)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm hiển thị màn hình Thêm mới");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm hiển thị màn hình Thêm mới");
		}

	}

	@Test
	public void KhuVuc_4572_2() throws SQLException {
		TestLogger.info("[Danh sách_Phím tắt]Kiểm tra tính năng sử dụng phím tắt trên màn hình Danh sách");
		TestLogger.info(" Trên màn hình Danh sách, kiểm tra việc hiển thị khi nhấn các tổ hợp phím sau Ctrl + E");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		s.click();
		s.type("e", Key.CTRL);
		TestLogger.info("Expect : Confirm hiển thị màn hình Thêm mới");
		if (waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_Nut_Huy, 4)) {
			kv.closeformKhuVuc();
			setTestcaseStatus("PASS", "Confirm hiển thị màn hình Sửa dữ liệu");
		} else {
			kv.closeformKhuVuc();
			setTestcaseStatus("FAIL", "Confirm hiển thị màn hình Sửa dữ liệu");
		}

	}

	@Test
	public void KhuVuc_4572_3() throws SQLException {
		TestLogger.info("[Danh sách_Phím tắt]Kiểm tra tính năng sử dụng phím tắt trên màn hình Danh sách");
		TestLogger.info(" Trên màn hình Danh sách, kiểm tra việc hiển thị khi nhấn các tổ hợp phím sau Ctrl + F4 ");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		s.click();
		s.type("n", Key.CTRL);
		s.type(Key.F4, Key.CTRL);
		s.type(Key.ENTER);
		TestLogger.info("Expect :  Confirm đóng tab đang mở");
		if (waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_Nut_Huy, 1)) {

			setTestcaseStatus("FAIL", " Confirm khong đóng tab đang mở");
		} else {

			setTestcaseStatus("PASS", " Confirm đóng tab đang mở");
		}

	}

	@Test
	public void KhuVuc_4572_4() throws SQLException {
		TestLogger.info("[Danh sách_Phím tắt]Kiểm tra tính năng sử dụng phím tắt trên màn hình Danh sách");
		TestLogger.info(" Trên màn hình Danh sách, kiểm tra việc hiển thị khi nhấn các tổ hợp phím sau Ctrl + F4 ");
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		s.click();
		s.type("n", Key.CTRL);
		s.type(Key.F4, Key.ALT);
		s.type(Key.ENTER);
		TestLogger.info("Expect :  Confirm đóng tab đang mở");
		if (waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_Nut_Huy, 1)) {

			setTestcaseStatus("FAIL", " Confirm khong đóng tab đang mở");
		} else {

			setTestcaseStatus("PASS", " Confirm đóng tab đang mở");
		}
	}
	
	
	

}
