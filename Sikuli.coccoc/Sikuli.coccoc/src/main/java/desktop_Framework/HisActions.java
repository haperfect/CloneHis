package desktop_Framework;

import org.sikuli.script.App;
import org.sikuli.script.Key;

import HIS.FormKhuVuc;
import HIS.TiepNhanBenhNhan;

public class HisActions extends CommonActions {

	public static final String DUONG_DAN_FILE_CHAY_HIS = "C:\\NCSw\\Hospital@HaNoi\\HIS.exe";
	public static String form_dangNhap_tenDangNhap = "dangnhap_ten.png";
	
	public static String ten_dangNhap_admin = "admin";
	public static String matKhau_dangNhap_admin = "123456";
	
	public static String ten_dangNhap_TDNT = "TD01";
	public static String matKhau_dangNhap_TDNT = "123456";
	
	public static String ten_dangNhap_BS01 = "BS01";
	public static String matKhau_dangNhap_BS01 = "123456";
	
	public static String ten_dangNhap_THUNGAN01 = "THUNGAN01";
	public static String matKhau_dangNhap_THUNGAN01 = "1";
	
	public static String ten_dangNhap_TNCDHA01 = "TNCDHA01";
	public static String matKhau_dangNhap_TNCDHA01 = "123456";
	
	public static String ten_dangNhap_BSCDHA01 = "BSCDHA01";
	public static String matKhau_dangNhap_BSCDHA01 = "123456";
	
	public static String title_dangNhap_thanhCong = "logo_login_thanhcong.png";
	public static String checkbox_dongY = "caidat_checkbox_dongy.png";
	public static String nut_caiDat = "button_caidat.png";
	
	public static String HIS_MenuTiepNhan = "HIS_MenuTiepNhan.png";
	public static String HIS_SubMenuTiepNhanBenhNhan = "HIS_SubMenuTiepNhanBenhNhan.png";
	public static String TiepNhanBenhNhan_MenuHanhChinh = "TiepNhanBenhNhan_MenuHanhChinh.png";
	public static String HIS_MenuKhamBenh = "HIS_MenuKhamBenh.png";

	public static String PhongLamViec = "PhongLamViec.png";
    
	public static String HIS_LOI_UNGDUNG = "HIS_LOI_UNGDUNG.png";
	public static String MenuVienPhi = "MenuVienPhi.png";
	public static String SubMenuThanhToanVienPhi = "SubMenuThanhToanVienPhi.png";
	
	public static String TiepNhanBenhNhan_HeThong ="TiepNhanBenhNhan_HeThong.png";
	public static String TiepNhanBenhNhan_DangXuat ="TiepNhanBenhNhan_DangXuat.png";
	
	public static String TiepNhanBenhNhan_DangNhap ="TiepNhanBenhNhan_DangNhap.png";

	
	public boolean khoiDongHIS(String duongdan) {

		App setup = App.open(duongdan);
		setup.focus();
		if (waitForObjectPresent(form_dangNhap_tenDangNhap, 10)) {

			TestLogger.info("Ứng dụng HIS khởi động thành công !");
			return true;
		} else {
			TestLogger.info("Ứng dụng HIS không khởi động thành công ! ");
			return false;
		}

	}
	
	public void thoatTaikhoanvaDangNhapBangTaikhoankhac(String user,String pass)
	{
		// THOAT va dang nhap voi tai khoan khac
		clickOn(TiepNhanBenhNhan_HeThong);
		clickOn(TiepNhanBenhNhan_DangXuat);
		waitForObjectPresent(TiepNhanBenhNhan_HeThong, 5);
		clickOn(TiepNhanBenhNhan_HeThong);
		clickOn(TiepNhanBenhNhan_DangNhap);

		// Dang nhap voi tai khoan THUNGAN01
		dangNhapHIS(user, pass);
	}

	public void dangXuatKhoiTaikhoan()
	{
		clickOn(TiepNhanBenhNhan_HeThong);
		clickOn(TiepNhanBenhNhan_DangXuat);
		
	}
	
	public boolean dangNhapHIS(String username, String matkhau) {
		moveMouseHorizontallyFromLogo(form_dangNhap_tenDangNhap, 80);
		s.click();
		s.type("a", Key.CTRL);
		s.type(username);
		s.type(Key.TAB);
		s.type(matkhau);
		s.type(Key.TAB);
		s.type(Key.ENTER);
		if (waitForObjectPresent(title_dangNhap_thanhCong, 10)) {
			return true;

		} else {
			return false;
		}
	}

	public void moMenuTiepNhanBenhNhan() {
		if (waitForObjectPresent(TiepNhanBenhNhan_MenuHanhChinh,1)) {
			TestLogger.info("Menu Tiếp Nhận đã được mở !");
		} else {
			TestLogger.info("Mở Menu Tiếp Nhận :");
			waitForObjectPresent(HIS_MenuTiepNhan, 5);
			clickOn(HIS_MenuTiepNhan);
			waitForObjectPresent(HIS_SubMenuTiepNhanBenhNhan, 5);
			clickOn(HIS_SubMenuTiepNhanBenhNhan);
			waitForObjectPresent(TiepNhanBenhNhan.AfterLoading, 15);
			
		}

	}
	
	public void chonPhongLamViec(String phonglamviec)
	{
		/*waitForObjectPresent(PhongLamViec, 5);
		moveMouseHorizontallyFromLogo(PhongLamViec, 100);*/
		s.click();
		s.type("a",Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(phonglamviec);
		s.type("v",Key.CTRL);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		s.type(Key.ENTER);
		
	}
	
	public void thoatUngdungHIS()
	{
		s.type(Key.F4,Key.ALT);
		s.type(Key.F4,Key.ALT);
	}

}
