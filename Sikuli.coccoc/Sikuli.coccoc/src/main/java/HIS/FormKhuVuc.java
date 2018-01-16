package HIS;

import org.sikuli.api.robot.Key;
import desktop_Framework.HisActions;
import desktop_Framework.TestLogger;

public class FormKhuVuc extends HisActions {
    public static String Menu_DanhMuc = "Menu_DanhMuc.png";
    public static String Menu_HanhChinh = "Menu_HanhChinh.png";
    public static String Menu_KhuVuc = "Menu_KhuVuc.png";
    public static String MaKhuVuc = "MaKhuVuc.png";
    public static String TenKhuVuc = "TenKhuVuc.png";
    public static String GhiChu = "GhiChu.png";
    public static String ThuTu = "ThuTu.png";
    public static String TamNgung = "TamNgung.png";
    public static String ChonPhongBanLamViec = "ChonPhongBanLamViec.png" ;
    public static String title_khuvuc = "title_khuvuc.png" ;
    public static String formkhuvuc_makhuvuc = "formkhuvuc_makhuvuc.png" ;
    public static String form_Makhuvuc_icon_X = "form_Makhuvuc_icon_X.png";
    public static String Nut_Luu = "Nut_Luu.png";
    public static String Dialog_MakhuVucDaTontai = "Dialog_MakhuVucDaTontai.png";
    public static String Dialog_MakhuvucDaTonTai_NutDongY = "Dialog_MakhuvucDaTonTai_NutDongY.png";
    public static String CanhBao_MaKhuVuc = "CanhBao_MaKhuVuc.png"; 
    public static String FormEdit_MaKhuVuc_TenKhuVuc = "FormEdit_MaKhuVuc_TenKhuVuc.png";
    public static String Dialog_TenkhuVucKhongDuocDeTrong = "Dialog_TenkhuVucKhongDuocDeTrong.png";
    public static String KhuVuc_ThuTuLenXuong = "KhuVuc_ThuTuLenXuong.png" ;
    public static String FormEdit_MaKhuVuc_Checkbox_uncheck_TamNgung = "FormEdit_MaKhuVuc_Checkbox_uncheck_TamNgung.png" ;
    public static String FormEdit_title_khuvuc = "FormEdit_title_khuvuc.png";
    public static String FormEdit_MaKhuVuc_Checkbox_check_TamNgung= "FormEdit_MaKhuVuc_Checkbox_check_TamNgung.png";
    public static String FormEdit_MaKhuVuc_Dialog_XacNhan ="FormEdit_MaKhuVuc_Dialog_XacNhan.png" ;
    public static String formkhuvuc_Button_Them = "formkhuvuc_Button_Them.png" ;
    public static String FormKhuvuc_MenuThem_NutLuuThem ="FormKhuvuc_MenuThem_NutLuuThem.png";
    public static String FormEdit_MaKhuVuc_Nut_Huy = "FormEdit_MaKhuVuc_Nut_Huy.png";
    public static String MauXanhNhat = "mauxanhnhat.png" ;
    public static String FormKhuVuc_ChiTietManHinhIn ="FormKhuVuc_ChiTietManHinhIn.png";
    public static String FormKhuVuc_Menu_nut_in ="FormKhuVuc_Menu_nut_in.png";
    public static String FormKhuVuc_Menu_Filter ="FormKhuVuc_Menu_Filter.png";
    public static String FormKhuVuc_Menu_Filter_Search ="FormKhuVuc_Menu_Filter_Search.png" ;
    public static String FormKhuVuc_Menu_Filter_KetQua ="FormKhuVuc_Menu_Filter_KetQua.png";
    public static String FormKhuVuc_Menu_Filter_TextValue ="FormKhuVuc_Menu_Filter_TextValue.png";
    public static String FormTimKiem_Nut_Dong ="FormTimKiem_Nut_Dong.png";
    public static String KetQua_SoDongBang1 ="KetQua_SoDongBang1.png";
    public static String FormTimKiem_Nut_X ="FormTimKiem_Nut_X.png";
    public static String Filter_text_value ="Filter_text_value.png";
    public static Integer DanhMucX= 906;
    public static Integer DanhMucY= 51;
    public static String FormEdit_MaKhucVuc_DaTonTai= "FormEdit_MaKhucVuc_DaTonTai.png";

   
    public void nhapkituDacBiet (String kitudacbiet)
    {
    	moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a" , Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kitudacbiet);
		sleep(2);
    }
     
  
  
    public void nhapkituDacBietvaoTenKhuVuc (String kitudacbiet)
    {
    	moveMouseDownFromLogo(FormKhuVuc.TenKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 5);
		hoverImage(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.FormEdit_MaKhuVuc_TenKhuVuc, 100);
		s.click();
		s.type("a" , Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kitudacbiet);
		sleep(2);
    }
    
    
    public void nhapKiTuChu (String kituchu)
    {
    	moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a" , Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kituchu);
		sleep(2);
    }
    
    public String getMaKhuVuc ()
    {
    	s.type("a" , Key.CTRL);
		s.type("c", Key.CTRL);
		String text = getClipboardValue();
		TestLogger.info("==>>>" + text);
		return text ;
    }
    
    public void nhapKiTuSo (String kituso)
    {
    	moveMouseDownFromLogo(FormKhuVuc.MaKhuVuc, 50);
		s.doubleClick();
		waitForObjectPresent(FormKhuVuc.formkhuvuc_makhuvuc, 5);
		hoverImage(FormKhuVuc.formkhuvuc_makhuvuc);
		moveMouseHorizontallyFromLogo(FormKhuVuc.formkhuvuc_makhuvuc, 100);
		s.click();
		s.type("a" , Key.CTRL);
		s.type(Key.BACKSPACE);
		sleep(2);
		s.type(kituso);
		sleep(2);
    }
    
    public void closeformKhuVuc ()
    {
    	clickOn(FormKhuVuc.form_Makhuvuc_icon_X);
		s.type(Key.ENTER);
    }
    

}
