package HIS;

import org.sikuli.script.Key;

import desktop_Framework.CommonActions;

public class BacSiChuanDoanHinhAnh extends CommonActions {
  
	public static String BacSiChuanDoanHinhAnh_SoPhieu = "SoPhieu.png";
	public static String NguoiThucHien ="NguoiThucHien.png";
	public static String MauKetQua ="MauKetQua.png";
	public static String NoiDung ="NoiDung.png";
	public static String KetLuan ="KetLuan.png";
	public static String DeNghi ="DeNghi.png";
	public static String LuuvaDuyet ="LuuvaDuyet.png";
	public static String NguoiThucHien_TNCDHA01 ="NguoiThucHien_TNCDHA01.png";
	public static String KetQuaDuyetThanhCong ="KetQuaDuyetThanhCong.png";
	public static String SubMenu_KetQua_XQCTMRI ="SubMenu_KetQua_XQCTMRI.png";

	
	public void dienSophieu(String sophieukhamChuanDoanHinhAnh)
	{
		moveMouseHorizontallyFromLogo(BacSiChuanDoanHinhAnh_SoPhieu, 100);
		s.click();
		s.type(sophieukhamChuanDoanHinhAnh);
		s.type(Key.ENTER);
	}
	
	public void dienNguoiThucHienLa_TNCDHA01()
	{
		moveMouseHorizontallyFromLogo(NguoiThucHien, 100);
		s.click();
		waitForObjectPresent(NguoiThucHien_TNCDHA01, 5);
		clickOn(NguoiThucHien_TNCDHA01);
	
	}
	
	public void dienNoiDung(String NoiDungKetLuanChuanHinhAnh)
	{
		moveMouseDownFromLogo(NoiDung, 100);
		s.click();
		setClipboardValue(NoiDungKetLuanChuanHinhAnh);
		s.type("v",Key.CTRL);
	}
	
	
	
	public void dienKetLuan(String KetLuanCuaBacSi)
	{
		moveMouseHorizontallyFromLogo(KetLuan, 100);
		s.click();
		s.type("a",Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(KetLuanCuaBacSi);
		s.type("v",Key.CTRL);
	}

	public void dienDeNghi(String DeNghiCuaBacSi)
	{
		moveMouseHorizontallyFromLogo(DeNghi, 100);
		s.click();
		s.type("a",Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(DeNghiCuaBacSi);
		s.type("v",Key.CTRL);
	}
	
	
}
