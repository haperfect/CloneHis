package desktop_Framework;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.SkipException;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class CommonActions extends TienIch {
	private static URL resource = null;
	private static String tr2 = null;
	private static String spath = null;
	public int timeoutOffer = 1;
	public static Screen s = new Screen();
  

	
	/*
	 * ________________________ SYSTEM SECTION_______________________________
	 */

	/**
	 * getResource: Return absolute path to file (image, excel ... in resource folder
	 * @param resourceName  name of resource want to get absolute path
	 * 
	 * @author hanv
	 * @updater: hanv
	 * 
	 */
	public String getResource(String resourceName) {
		resource = CommonActions.class.getProtectionDomain().getCodeSource().getLocation();

		tr2 = resource.toString().replace("file:/", "").replace("%20", " ").replace("/", "\\").replace("target", "@");
		int l = tr2.indexOf("@");
		spath = tr2.substring(0, l).replace("@", "") + "src\\main\\resources\\"+ resourceName;

		return spath;
	}
	 
	
	/**
	 * Get clipboard
	 * @return contain of clipboard as string
	 */
	public String getClipboardValue(){
		String result = "";
		try {
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			result = (String) clipboard.getData(DataFlavor.stringFlavor);
			
		} catch (UnsupportedFlavorException | IOException e) {
			TestLogger.error(e.toString());
		}
		return result;
	}
	
	/**
	 * Set clipboard contains
	 * @param contains The string will become clipboard 
	 */
	public void setClipboardValue(String contains){
		TestLogger.info("Set clipboard contains is " + contains);
		StringSelection clipboardValue = new StringSelection(contains);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		clipboard.setContents(clipboardValue, clipboardValue);
	}
	
	/**
	 * Get Absolute File Path 
	 * @author hanv
	 * @param file represent a File object 
	 * @return a String , represent Absolute File Path of file 
	 */ 
	public static String getAbsoluteFilePath(File file) {
		String path = null;
		if (file.exists()) {
			path = file.getAbsolutePath();
			System.out.println(path.toString());
		} else {
			System.out.println("this file is not avaiable ");
		}

		return path;
	}
	
	public void clickToaDo(int X, int Y)
	{
		Location toado = new Location(X, Y);
		try {
			s.click(toado);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * copy folder and all files contains
	 */
	public void copyFolder(File src, File dest) {
		if (src.isDirectory()) {
			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
			}
			// list all the directory contents
			String files[] = src.list();
			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}
		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			try {
				InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dest);
				byte[] buffer = new byte[1024];
				int length;
				// copy the file content in bytes
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				// error, just exit
				System.exit(0);
			}
		}
	}

	/**
	 * executeFile: Execute the exe file
	 * 
	 * @author hanv
	 * @param path Path to exe file
	 */
	public void executeFile(String path) {
		TestLogger.info("-- Execute exe file: " + path);
		File file = new File(path);
		if (!file.exists()) {
			TestLogger.warn("The file " + path + " does not exist");
		} else {
			try {
				Runtime.getRuntime().exec(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Check
	 * 
	 * @author hanv
	 * @date 21/1/2016
	 * 
	 */
	public boolean getDiff(File dirA, File dirB, boolean isIndentical){

		File[] fileList1 = dirA.listFiles();
		File[] fileList2 = dirB.listFiles();
		Arrays.sort(fileList1);
		Arrays.sort(fileList2);
		HashMap<String, File> map1;
		if (fileList1.length < fileList2.length) {
			map1 = new HashMap<String, File>();
			for (int i = 0; i < fileList1.length; i++) {
				map1.put(fileList1[i].getName(), fileList1[i]);
			}
			isIndentical = compareNow(fileList2, map1, isIndentical);
			} 
		else {
			map1 = new HashMap<String, File>();
			for (int i = 0; i < fileList2.length; i++) {
				map1.put(fileList2[i].getName(), fileList2[i]);
			}
			isIndentical = compareNow(fileList1, map1, isIndentical);
		}
		return isIndentical;
	}

	/**
	 * compare 2 files
	 * 
	 * @author hanv
	 * @date 21/1/2016
	 * @author ha
	 * @return true if files are same
	 * 
	 */
	public boolean compareNow(File[] fileArr, HashMap<String, File> map, boolean isIndentical){
		for (int i = 0; i < fileArr.length; i++) {
			String fName = fileArr[i].getName();
			File fComp = map.get(fName);
			map.remove(fName);
			if (fComp != null) {
				if (fComp.isDirectory()) {
					isIndentical = getDiff(fileArr[i], fComp, isIndentical);
				} else {
					String cSum1 = Checksum(fileArr[i]);
					String cSum2 = Checksum(fComp);
					if (!cSum1.equals(cSum2)) {
						if (fileArr[i].getName().contains("setup.exe"))
							TestLogger.warn("Know issue, please check file setup.exe");
						else {
							TestLogger.info(fileArr[i].getName() + "\t\t" + " is different");
							isIndentical = false;
						}
					}
				}
			} else {
				if (fileArr[i].isDirectory()) {
					traverseDirectory(fileArr[i], isIndentical);
				} else {
					TestLogger.info(fileArr[i].getName() + "\t\t" + "only in " + fileArr[i].getParent());
					isIndentical = false;
				}
			}
		}
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String n = it.next();
			File fileFrmMap = map.get(n);
			map.remove(n);
			if (fileFrmMap.isDirectory()) {
				traverseDirectory(fileFrmMap, isIndentical);
			} else {
				TestLogger.info(fileFrmMap.getName() + "\t\t" + "only in " + fileFrmMap.getParent());
			}
		}
		return isIndentical;
	}

	/**
	 * @author ha.vu
	 * @date 21/1/2016
	 * @author ha
	 */
	public boolean traverseDirectory(File dir, boolean isIndentical) {
		File[] list = dir.listFiles();
		for (int k = 0; k < list.length; k++) {
			if (list[k].isDirectory()) {
				traverseDirectory(list[k], isIndentical);
			} else {
				TestLogger.info(list[k].getName() + "\t\t" + "only in " + list[k].getParent());
				isIndentical = false;
			}
		}
		return isIndentical;
	}
	
	
	/**
	 * @author hanv
	 * @date 21/1/2016
	 */
	public String Checksum(File file) {
		try {
			InputStream fin = new FileInputStream(file);
			java.security.MessageDigest md5er = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[1024];
			int read;
			do {
				read = fin.read(buffer);
				if (read > 0)
					md5er.update(buffer, 0, read);
			} while (read != -1);
			fin.close();
			byte[] digest = md5er.digest();
			if (digest == null)
				return null;
			String strDigest = "0x";
			for (int i = 0; i < digest.length; i++) {
				strDigest += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
			}
			return strDigest;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * <b>Check folder is empty or not </b>
	 * 
	 * @param file
	 *            : folder
	 * @return <b>True</b>: if folder is empty <b>False</b>: if folder doesn't
	 *         empty
	 * @author hanv
	 */
	public boolean isFolderEmpty(File file) {
		TestLogger.info("Check folder " + file.getAbsolutePath());
		boolean flag = true;
		if (file.isDirectory())
			if (file.list().length > 0) {
				flag = false;
				TestLogger.info("Folder : " + file.getAbsolutePath() + " having contains");
			} else
				TestLogger.info("Folder : " + file.getAbsolutePath() + " is empty");
		return flag;
	}
	
	/**
	 * <b>Check process name exist on task list or not </b>
	 * 
	 * @param processName
	 *            : Name of process
	 * @return <b>True</b>: if process exist on tasklist <b>False</b>: if
	 *         process doesn't exist on tasklist
	 * @author hanv
	 */
	public boolean isProcessExists(String processName) {
		boolean flag = false;
		try {
			TestLogger.info("-- Check process has name " + processName + " exists");
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("TASKLIST");
			process.getOutputStream().close();
			InputStream inputStream = process.getInputStream();
			InputStreamReader inputstreamreader = new InputStreamReader(inputStream);
			BufferedReader bufferedrReader = new BufferedReader(inputstreamreader);

			String strLine = "";
			while ((strLine = bufferedrReader.readLine()) != null) {
				String[] a = strLine.split(",");
				// x[i++]=a[0];
				if (a[0].contains(processName)) {
					flag = true;
					TestLogger.info("--> Process has name " + processName + " exists on tasklist");
					break;
				}
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * Kill process on win
	 * 
	 * @author hanv
	 * @date 21/1/2016
	 */
	public void killprocess(String processName) {
		try {
			String cmdRun = "taskkill /im " + processName + " /f";
			Runtime runtime = Runtime.getRuntime();
			runtime.exec(cmdRun);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read text file from
	 * 
	 * @param textFilePath
	 * @return
	 */
	public String readTextFile(String textFilePath) {
		String textContain = "";
		String line;
		int count = 0;
		try {
			FileReader fr = new FileReader(textFilePath);
			BufferedReader textReader = new BufferedReader(fr);
			while ((line = textReader.readLine()) != null) {
				textContain = textContain + line + "\n";
				count++;
			}
			textReader.close();

		} catch (Exception e) {
			TestLogger.warn(e.toString());
		}
		return "Total: " + count + "\n" + textContain;
	}
	
	
	public void writeContainToTextFile(String filePath, String content, boolean continueWrite) {

		try {
			File file = new File(filePath);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				TestLogger.info("File not exist, create file: " + filePath);
				file.createNewFile();
			}
			TestLogger.info(file.getAbsolutePath());
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), continueWrite);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\t + " + content);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sleep
	 * @author hanv
	 * @param timeInSecond
	 */
	public void sleep(double timeInSecond) {
		try {
			Thread.sleep((long) (timeInSecond * 1000));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Delete folder
	 * 
	 * @author hanv
	 * @date 21/1/2016
	 */
	public void deleteFolder(File folderPath) {
		File[] files = folderPath.listFiles();
		if (files != null) { // some JVMs return null for empty dirs
			for (File f : files) {
				if (f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
		folderPath.delete();
		sleep(0.1);
	}
	
	/**
	 * Check file exist or not
	 * 
	 * @param filePath
	 * @return true if file exist
	 * @author hanv
	 */
	public boolean checkFileExist(String filePath) {
		File f = new File(filePath);
		if (f.exists()) {
			TestLogger.info("The file " + filePath + " exist");
			return true;
		} else {
			TestLogger.info("The file " + filePath + " not exist");
			return false;
		}
	}
	
	/**
	 * setTestcaseStatus: Set testcase status as passed/failed
	 * 
	 * @author hanv
	 * @param testcaseSatatus: PASSED/FAILED/SKIP
	 * @param message:
	 *            Message print when set test case status : PASSED/FAILED/SKIP
	 */
	public void setTestcaseStatus(String testcaseSatatus, String message) {
		if (testcaseSatatus == "PASS") {
			TestLogger.info("--------------------------------------------------------");
			TestLogger.info("Passed: " + message);
			TestLogger.info("--------------------------------------------------------");
		} else if (testcaseSatatus == "FAIL") {
			// Take snapshot and save to Desktop/failed
			String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(homePath, "ScreenShotTestCaseFailed", 2);

			// Set testcase as failed
			TestLogger.warn(("Failed: " + message));
			Assert.fail(message);
		} else {
			TestLogger.info("==============================================================");
			TestLogger.error("Skipping test test case: " + new Throwable().getStackTrace()[1].getMethodName());
			TestLogger.error(message);
			TestLogger.info("==============================================================");
			throw new SkipException("Skipping this Testcase due: " + message);
		}
	}
	



	/*
	 * ________________________ SIKULI SECTION_______________________________
	 */

	/**
	 * clickOn: simulator click on Windows
	 * @author ha
	 * @param image image name on resource
	 */
	public void clickOn(String image) {
		spath = getResource(image);
		try {
			s.click(spath);
			sleep(0.5);
		} catch (FindFailed e) {
			TestLogger.warn("Cannot find control : " + image);
		}
	}
	
	/**
	 * Wait for object appears on special region
	 * @param rootImage  Object to get root coordinate
	 * @param findImage  Object want to find on region
	 * @param widthRegion  width of region want to find object
	 * @param heighRegion height of region want to find object
	 * @param timeOut time out in seconds
	 * @return true if image found in region
	 * 
	 * @author hanv
	 * @update 9 Jun, 2016
	 */
	public boolean waitForObjectAppearOnRegion(String rootImage, String findImage, int widthRegion, int heighRegion, int timeOut) {
		TestLogger.info("");
		String fullRootImagePath = getResource(rootImage);
		String fullFindImagePath = getResource(findImage);
		Region r;
		Match coordinate;
		boolean isControlInRegion = false;

		if (waitForObjectPresent(rootImage, 5)) {
			int waitTimes = (timeOut % 3 + 1);
			for (int count = 1; count <= waitTimes; count++) {
				try {
					coordinate = s.find(fullRootImagePath);
					TestLogger.info("Toa do x,y cua anh goc :" + coordinate.x +" "+ coordinate.y); 
					r = new Region(coordinate.x, coordinate.y, widthRegion, heighRegion);
					r.find(fullFindImagePath);
					TestLogger.info("Control is found on region! break");
					sleep(0.5);
					isControlInRegion = true;
					break;
				} catch (FindFailed e) {
					System.out.print(" . ");
				}
			}
		} else
			TestLogger.warn("cannot find image");
		System.out.println("");
		return isControlInRegion;
	}
	
	/**
	 * click on object on special region
	 * 
	 * @param rootImage
	 * @param clickonImage
	 * @param widthRegion
	 * @param heighRegion
	 * @param timeOut
	 * @return
	 */
	public boolean clickOnRegion(String rootImage, String clickonImage, int widthRegion, int heighRegion) {
		String fullRootImagePath = getResource(rootImage);
		String fullFindImagePath = getResource(clickonImage);
		Region r;
		Match coordinate;
		boolean isControlInRegionClicked = false;

		if (waitForObjectPresent(rootImage, 5)) {
			try {
				coordinate = s.find(fullRootImagePath);
				r = new Region(coordinate.x, coordinate.y, widthRegion, heighRegion);
				r.hover(fullFindImagePath);
				sleep(1);
				r.click();
				TestLogger.info("Clicked!");
				sleep(1);
				isControlInRegionClicked = true;
			} catch (FindFailed e) {
				System.out.print("Error: " + e);
			}
		} else
			TestLogger.warn("cannot find image");
		return isControlInRegionClicked;
	}
	
	/**
	 * Clean files on download folders
	 * 
	 * @author hanv
	 * @param fileName
	 *            name of file want to delete, if want to delete all files on
	 *            download folder input ""
	 */
	public void cleanResouces(String fileName) {
		TestLogger.info("Clean resource on download page");
		String downloadFolderPath = System.getenv("USERPROFILE") + "\\Downloads\\";
		File DownloadFolder = new File(downloadFolderPath);
		for (File f : DownloadFolder.listFiles())
			if ((f.getName().contains(fileName))&(!f.getName().contains("coccoc_vi.exe"))) {
				TestLogger.info(f.getName());
				f.delete();
			}
	}
	
	
	public String layTextTuAnh(int toadoX,int toadoY,int chieudai, int chieurong)
	{
		  String Textresult= "" ;
		  sleep(3);
		  String imagePath = s.capture(toadoX, toadoY, chieudai, chieurong).getFile();
		   
		  File image = new File(imagePath);
		  File image2 = new File("E:\\anhDaDuocChup.png");
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
	
	/**
	 * Move mouse and click on screen, where under the logo 200px
	 * 
	 * @param imageOfLogo  the name of image was captured
	 * @author hanv
	 */
	public void moveMouseDownFromLogo(String imageOfLogo, int distance){
		String image = getResource(imageOfLogo);
		if (waitForObjectPresent(imageOfLogo, 5)) {
			try {
				Match coordinate = s.find(image);
				s.mouseMove(coordinate);
				sleep(1);
				coordinate.y = coordinate.y + distance;

				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				double height = screenSize.getHeight();
				double newY = coordinate.y;

				if (height >= newY)
					s.mouseMove(coordinate);
				else
					TestLogger.warn("Cannot move mouse to new coordinate ");
			} catch (FindFailed e) {
				TestLogger.warn("ERROR: " + e);
			}
		} else {
			TestLogger.info("Cannot find image on " + image);
			String screenShotPath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(screenShotPath, "MoveMouseError", 1);
		}
	}
	
	/**
	 * Move mouse and click on screen, where next to the logo 
	 * 
	 * @param imageOfLogo
	 *            the name of image was captured
	 * @author hanv
	 * @date 13-Jul-2016
	 */
	public void moveMouseHorizontallyFromLogo(String imageOfLogo, int distance) {
		String image = getResource(imageOfLogo);
		if(waitForObjectPresent(imageOfLogo, 5)){
			try {
				Match coordinate = s.find(image);
				s.mouseMove(coordinate);
				sleep(1);
				coordinate.x = coordinate.x + distance;
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				double width = screenSize.getWidth();
				double newY = coordinate.x;
				
				if(width >= newY)
					s.mouseMove(coordinate);
				else
					TestLogger.warn("Cannot move mouse to new coordinate ");
			} catch (FindFailed e) {
				TestLogger.warn("ERROR: " + e);
			}
		}
		else
		{
			TestLogger.info("Cannot find image on " + image);
			String screenShotPath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(screenShotPath, "MoveMouseError", 1);
		}
	}
	
	/**
	 * Move mouse to special poison
	 * 
	 * @param coodX
	 *            Coordinate of X
	 * @param coodY
	 *            Coordinate of Y
	 */
	public void moveMouseToCoordinate(Point cood) {
		try {
			Robot robot = new Robot();
			int coodX, coodY;

			robot.mouseMove(0, 0);
			sleep(1);

			coodX = (int) cood.getX();
			coodY = (int) cood.getY();

			robot.mouseMove(coodX, coodY);

		} catch (AWTException e) {
			TestLogger.warn(e.toString());
		}
	}
	
	/**
	 * 
	 * @return current coordinate of mouse
	 * @author Hanv
	 */
	public Point getCursorPosition() {
		PointerInfo mouseLocation = MouseInfo.getPointerInfo();
		return mouseLocation.getLocation();
	}
	
	/**
	 * Open files 
	 * @param filePath: full path to files
	 */
	public void openFile(String filePath) {
		s.type(Key.WIN);
		sleep(1);
		s.type(filePath);
		s.type(Key.ENTER);
		sleep(1);
		
	}

	/**
	 * waitForObjectPresent: wait time to execute command
	 * 
	 * @author hanv
	 * @param image wait image, unit: second
	 */
public Boolean waitForObjectPresent(String image, int timeout) {
		
		TestLogger.info("Wait for control like " + image + " appears on about " + timeout );
		Boolean isControlExist = false;
		spath = getResource(image);
		File objectImage  = new File(spath);
		if(objectImage.exists()){
			try{
				for (int i = 1; i <= timeout * 2; i++) {
					try {
						s.wait(spath, 1);
						System.out.println(" Control appears! -> break wait for object");
						isControlExist = true;
						break;
					}
					catch (FindFailed e) {
						double time = timeout - (i*0.5);
						System.out.print( " . . "  + time );
						if (!e.toString().contains("can not find"))
							TestLogger.warn(e.toString());
					}
					finally{
						sleep(0.5);
					}
				}
			}
			catch (Exception e) {
				TestLogger.warn(e.toString());
			}
			System.out.println(" Stop waiting control appears");
		}
		else
			TestLogger.warn("\n\nCannot find image at " + spath  + " on local machine, please check\n");
		return isControlExist;
	}
	
	/**
	 * Wait for object disappears on screen
	 * @param image
	 * @param timeout
	 * @return true if object not found on screen
	 */
	public boolean waitforObjectNotexist(String image, int timeout) {
		TestLogger.info("Wait for control like " + image + " disappears");
		Boolean isControlExist = false;
		spath = getResource(image);
		TestLogger.info("Wait for control like " + image + " disappear on about " + timeout + " seconds: ");
		for (int i = 1; i <= timeout * 2; i++) {
			try {
				s.wait(spath, 1);
				double time = timeout - (i*0.5);
				System.out.print( " . . " + time);
				sleep(0.5);
			} catch (FindFailed e) {
				isControlExist = true;
				break;
			}
		}
		return isControlExist;
	}

	/**
	 * Double -click: use mouse to double click
	 * @author hanv
	 * @param image image name
	 */
	public void doubleClick(String image) {
		spath = getResource(image);
		try {
			s.doubleClick(spath);
		} catch (FindFailed e) {
			TestLogger.error("The control " + image
					+ "Not exist, please check image");
		}
	}

	/**
	 * rightlick: use mouse to right click
	 * 
	 * @author hanv
	 * @param image image name
	 */
	public void rightClick(String image) {
		spath = getResource(image);
		try {
			s.rightClick(spath);
		} catch (FindFailed e) {
			TestLogger.warn("Cannot find control : " + image);
		}
	}

	
	
	/**
	 * Scroll to object
	 * 
	 * @param imagePath
	 * @return
	 * @author hanv
	 */
	public boolean scrollPageToObject(String imagePath) {
		boolean scrollSuccess = false;
		for (int count = 1; count <= 5; count++) {
			if (waitForObjectPresent(imagePath, 3)) {
				scrollSuccess = true;
				break;
			} else {
				s.type(Key.DOWN);
			}
		}
		return scrollSuccess;
	}

	/**
	 * hoverImage: hover mouse on media to view button Savior and download
	 * 
	 * @author hanv
	 * @param image
	 *            : image name
	 */
	public void hoverImage(String image) {
		spath = getResource(image);
		try {
			s.hover(spath);
		} catch (FindFailed e) {
			TestLogger.info("Không thể hover lên ảnh, do không thể tìm thấy ảnh tương ứng !");
		}
	}
	
	public boolean findObjectInToaDo (String image, int x, int y,int chieuDai, int chieuRong) 
	{
		    spath = getResource(image);
		    Boolean flag = false;
	       TestLogger.info ("Demo thoi");
			Region r= new Region(x, y, chieuDai, chieuRong);
			Match mat = null;
			try {
				mat = r.find(spath);
				if (mat.x >0)
				{
					
					return flag = true;
				}
				else
				{
					
					return flag = false;
				}
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				TestLogger.info("Không tìm thấy đối tượng trong phân vùng đó ! ");
			}
			 return flag;	
	}
	


}
