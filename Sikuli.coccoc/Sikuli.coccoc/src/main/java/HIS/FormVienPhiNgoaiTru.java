package HIS;

import org.sikuli.api.robot.Key;

import desktop_Framework.HisActions;

public class FormVienPhiNgoaiTru extends HisActions {
   public static String VienPhiNgoaiTru_SoTN = "VienPhiNgoaiTru_SoTN.png";
   public static String VienPhiNgoaiTru_Luu = "VienPhiNgoaiTru_Luu.png";
   public static String VienPhiNgoaiTru_SoDongBang1 = "VienPhiNgoaiTru_SoDongBang1.png";
   public static String VienPhiNgoaiTru_HoaDon_BoQua="VienPhiNgoaiTru_HoaDon_BoQua.png";
   public static String VienPhiNgoaiTru_HoaDon_QuyenHoaDon="VienPhiNgoaiTru_HoaDon_QuyenHoaDon.png";
   public static String VienPhiNgoaiTru_HoaDon_DongY="VienPhiNgoaiTru_HoaDon_DongY.png";

   public void dienSoTiepNhan (String sotiepnhan)
   {
	   moveMouseHorizontallyFromLogo(VienPhiNgoaiTru_SoTN, 100);
	   s.click();
	   s.type(sotiepnhan);
	   s.type(Key.ENTER);
	   
   }
   
   public void nhapChungTu()
   {
	   if (waitForObjectPresent(VienPhiNgoaiTru_HoaDon_QuyenHoaDon, 3))
	   {
		   // Nhap Quyen Bien Lai 
		   clickToaDo(910, 313);
		   s.type(Key.DOWN);
		   s.type(Key.ENTER);
		   s.type(Key.TAB);
		   
		   // Nhap Quyen Bien Lai 
	
		   s.type(Key.DOWN);
		   s.type(Key.ENTER);
		   s.type(Key.TAB);
		  
		   // Nhap Quyen Tam Ung 
		 
		   s.type(Key.DOWN);
		   s.type(Key.ENTER);
		   s.type(Key.TAB);
		   
		   // Nhap Quyen Hoan Ung 
		 
		   s.type(Key.DOWN);
		   s.type(Key.ENTER);
		   
		   clickOn(VienPhiNgoaiTru_HoaDon_DongY);
		   
	   }
   }
   
   
   
   
   
}
