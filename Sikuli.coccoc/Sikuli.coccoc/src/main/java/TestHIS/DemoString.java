package TestHIS;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.sikuli.script.App;
import org.testng.annotations.Test;

import desktop_Framework.HisActions;
import desktop_Framework.TestLogger;
import desktop_Framework.TienIch;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class DemoString extends HisActions{
 
	String chuoi ="Chọn STT Tên dịch vụ Nơi thực hiện Số phiếu Thời gian chỉ định Người chỉ định Nơi chỉ địnhUnchecked 1 (Hằng test) Chụp CT Xquang Tay Phòng CT 170004526 28/11/2017 Bác Sĩ Khám Nội A Khám theo yêu cầu";
	@Test
	public void test1()
	{
		 TestLogger.info("2 so dau cua Nam Hien Tai la : " +TienIch.getNamHienTaicuaMayTinh().substring(2, 4)); //2017
		
	}
	
	@Test
	public void demo2()
	{
		String gioitinh_tron ="gioitinh_tron.png";
		String gioitinh_tronTo ="gioitinh_tronTo.png";
		if (waitForObjectAppearOnRegion(gioitinh_tronTo, gioitinh_tron, 141, 63, 5))
		{
			hoverImage(gioitinh_tron);
		}
		else
		{
			hoverImage(gioitinh_tronTo);
		}
		
	}
	
	
	public String layTextTuAnh(int toadoX,int toadoY,int chieudai, int chieurong)
	{
		  String Textresult= "" ;
		  sleep(3);
		  String imagePath = s.capture(toadoX, toadoY, chieudai, chieurong).getFile();
		   
		  File image = new File(imagePath);
		  File image2 = new File("E:\\anhDaDuocchup.png");
		  try {
		   FileUtils.copyFile(image,image2);
		  } catch (IOException e1) {
		   // TODO Auto-generated catch block
		   e1.printStackTrace();
		  }
		  
		  ITesseract instance = new Tesseract();
		  try {
		   Textresult = instance.doOCR(image2);
		   // Print out the text results
		   System.out.println(Textresult);
		  
		  } catch (Exception e) {   
		   System.out.println("Failed. Could not read the text from image file!");
		  }
		  
		return Textresult;
	
	}
	
	public void setTextinClipBoard ()
	{
		App.setClipboard("");
		App.getClipboard();
	
	}
	
	
}
