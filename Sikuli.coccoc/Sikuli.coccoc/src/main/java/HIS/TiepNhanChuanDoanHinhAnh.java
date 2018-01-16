package HIS;

import org.sikuli.script.Key;

import desktop_Framework.CommonActions;

public class TiepNhanChuanDoanHinhAnh extends CommonActions {
    
	
	public static String MenuCanLamSang ="MenuCanLamSang.png";
	public static String SubMenuChuanDoanHinhAnh ="SubMenuChuanDoanHinhAnh.png";
	public static String SubMenuTiepNhan ="SubMenuTiepNhan.png";

	public static String SoPhieu ="SoPhieu.png";
	public static String NutLuu ="NutLuu.png";
	public static String HoiThoaiCapNhatThanhCong ="HoiThoaiCapNhatThanhCong.png";

	
	public void dienSoPhieu(String sophieu)
	{
		moveMouseHorizontallyFromLogo(SoPhieu, 100);
		s.click();
		s.type(sophieu);
		s.type(Key.ENTER);
	}
	
	
}
