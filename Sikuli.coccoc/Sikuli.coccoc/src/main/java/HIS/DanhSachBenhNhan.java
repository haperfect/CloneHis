package HIS;

import org.sikuli.script.Key;

import desktop_Framework.HisActions;

public class DanhSachBenhNhan extends HisActions {
  
	public static String TitleForm_DanhSachBenhNhan ="TitleForm_DanhSachBenhNhan.png";
	public static String DanhSachBenhNhan_DieuKien ="DanhSachBenhNhan_DieuKien.png";
	public static String DanhSachBenhNhan_TimKiem ="DanhSachBenhNhan_TimKiem.png";
	public static String DanhSachBenhNhan_SoDongBang1 ="DanhSachBenhNhan_SoDongBang1.png";
	public static String DanhSachBenhNhan_DaKham = "DanhSachBenhNhan_DaKham.png";
	public static String DanhSachBenhNhan_TrangThai = "DanhSachBenhNhan_TrangThai.png";
	public static String DanhSachBenhNhan_EnterTextToSearch ="DanhSachBenhNhan_EnterTextToSearch.png";
	public static String DanhSachBenhNhan_ChoKetQua ="DanhSachBenhNhan_ChoKetQua.png";
	public static String DanhSanhBenhNhan_ChoKham ="DanhSanhBenhNhan_ChoKham.png";
	public static String DanhSanhBenhNhan_KhoaTiepNhan ="DanhSanhBenhNhan_KhoaTiepNhan.png";
    //toa do Y = 142 de click danh sach
	
	public static String DanhSachBenhNhan_NutF5 ="DanhSachBenhNhan_NutF5.png";

	public void dienDieuKienTimKiem(String duLieuTimKiem)
	{
	    moveMouseHorizontallyFromLogo(DanhSachBenhNhan_DieuKien, 100);
	    s.click();
	    s.type("a",Key.CTRL);
	    s.type(Key.BACKSPACE);
	    s.type(duLieuTimKiem);
	    s.type(Key.ENTER);
	} 
	
	public void dienDieuKienTimKiemBangMaBenhNhan(String maBenhNhan)
	{
	    moveMouseHorizontallyFromLogo(DanhSachBenhNhan_DieuKien, 100);
	    s.click();
	    s.type("a",Key.CTRL);
	    s.type(Key.BACKSPACE);
	    s.type(maBenhNhan);
	
	} 
	
	public void dienDieuKienTimKiemBangHoTen(String hoTen)
	{
	    moveMouseHorizontallyFromLogo(DanhSachBenhNhan_DieuKien, 100);
	    s.click();
	    s.type("a",Key.CTRL);
	    s.type(Key.BACKSPACE);
	    s.type(hoTen);
	} 
	
	
	public void dienDieuKienTimKiemSoTheBHYT(String soTheBaoHiemYTe)
	{
	    moveMouseHorizontallyFromLogo(DanhSachBenhNhan_DieuKien, 100);
	    s.click();
	    s.type("a",Key.CTRL);
	    s.type(Key.BACKSPACE);
	    s.type(soTheBaoHiemYTe);
	} 
	
	public void dienDieuKienTimKiemSoTiepNhan(String soTiepNhan)
	{
	    moveMouseHorizontallyFromLogo(DanhSachBenhNhan_DieuKien, 100);
	    s.click();
	    s.type("a",Key.CTRL);
	    s.type(Key.BACKSPACE);
	    s.type(soTiepNhan);
	}
	
	
	
	
	public void dienKhoaTiepNhan (String khoaTiepNhan)
	{
		    moveMouseHorizontallyFromLogo(DanhSanhBenhNhan_KhoaTiepNhan, 100);
		    s.click();
		    s.type("a",Key.CTRL);
		    s.type(Key.BACKSPACE);
		    s.type(khoaTiepNhan);
		  
	}
	
	

	
	public void clickDupVaoBenhNhanChoKham()
	{
		moveMouseDownFromLogo(DanhSachBenhNhan_TimKiem, 142);
		s.doubleClick();
	}
	

}
