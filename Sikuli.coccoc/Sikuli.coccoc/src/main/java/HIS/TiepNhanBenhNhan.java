package HIS;

import org.sikuli.script.Key;
import desktop_Framework.HisActions;
import desktop_Framework.TestLogger;

public class TiepNhanBenhNhan extends HisActions {

	// MENU

	// HANH CHINH
	public static String TiepNhanBenhNhan_SoTiepNhan = "TiepNhanBenhNhan_SoTiepNhan.png";

	public static String TiepNhanBenhNhan_HoTen = "TiepNhanBenhNhan_HoTen.png";
	public static String TiepNhanBenhNhan_GioiTinhNam = "TiepNhanBenhNhan_GioiTinhNam.png";
	public static String TiepNhanBenhNhan_GioiTinhNu = "TiepNhanBenhNhan_GioiTinhNu.png";
	public static String TiepNhanBenhNhan_GioiTinhKhongXacDinh = "TiepNhanBenhNhan_GioiTinhKhongXacDinh.png";
	public static String TiepNhanBenhNhan_NgaySinh = "TiepNhanBenhNhan_NgaySinh.png";
	public static String TiepNhanBenhNhan_NamSinh = "TiepNhanBenhNhan_NamSinh.png";
	public static String TiepNhanBenhNhan_SoCMND = "TiepNhanBenhNhan_SoCMND.png";
	public static String TiepNhanBenhNhan_SoDT = "TiepNhanBenhNhan_SoDT.png";
	public static String TiepNhanBenhNhan_NgheNghiep = "TiepNhanBenhNhan_NgheNghiep.png";
	public static String TiepNhanBenhNhan_DanToc = "TiepNhanBenhNhan_DanToc.png";
	public static String TiepNhanBenhNhan_QuocTich = "TiepNhanBenhNhan_QuocTich.png";
	public static String TiepNhanBenhNhan_TinhThanhPho = "TiepNhanBenhNhan_TinhThanhPho.png";
	public static String TiepNhanBenhNhan_QuanHuyen = "TiepNhanBenhNhan_QuanHuyen.png";
	public static String TiepNhanBenhNhan_PhuongXa = "TiepNhanBenhNhan_PhuongXa.png";
	public static String TiepNhanBenhNhan_SoNha = "TiepNhanBenhNhan_SoNha.png";
	public static String TiepNhanBenhNhan_NoiLamViec = "TiepNhanBenhNhan_NoiLamViec.png";
	public static String TiepNhanBenhNhan_NguoiLienHe = "TiepNhanBenhNhan_NguoiLienHe.png";
	public static String TiepNhanBenhNhan_SoDienThoaiNguoiLienHe = "TiepNhanBenhNhan_SoDienThoaiNguoiLienHe.png";
	public static String TiepNhanBenhNhan_NhapNhanhMaThanhPho = "TiepNhanBenhNhan_NhapNhanhMaThanhPho.png";
	public static String TiepNhanBenhNhan_GioiTinhChuaXacDinh = "TiepNhanBenhNhan_GioiTinhChuaXacDinh.png";
	public static String TiepNhanBenhNhan_MaBenhNhan = "TiepNhanBenhNhan_MaBenhNhan.png";

	// TIEP NHAN
	public static String TiepNhanBenhNhan_DoiTuong = "TiepNhanBenhNhan_DoiTuong.png";
	public static String TiepNhanBenhNhan_UuTien = "TiepNhanBenhNhan_UuTien.png";
	public static String TiepNhanBenhNhan_HinhThuc = "TiepNhanBenhNhan_HinhThuc.png";
	public static String TiepNhanBenhNhan_LiDoKhamBenh = "TiepNhanBenhNhan_LiDoKhamBenh.png";

	// BAO HIEM Y TE
	public static String TiepNhanBenhNhan_SoThe = "TiepNhanBenhNhan_SoThe.png";
	public static String TiepNhanBenhNhan_Tuyen = "TiepNhanBenhNhan_Tuyen.png";
	public static String TiepNhanBenhNhan_NoiGioiThieu = "TiepNhanBenhNhan_NoiGioiThieu.png";
	public static String TiepNhanBenhNhan_MaDangKiKhamChuaBenhBanDau = "TiepNhanBenhNhan_MaDangKiKhamChuaBenhBanDau.png";
	public static String TiepNhanBenhNhan_KhuVuc = "TiepNhanBenhNhan_KhuVuc.png";
	public static String TiepNhanBenhNhan_SoTuyenChuyen = "TiepNhanBenhNhan_SoTuyenChuyen.png";
	public static String TiepNhanBenhNhan_NgayChuyen = "TiepNhanBenhNhan_NgayChuyen.png";
	public static String TiepNhanBenhNhan_TuNgay = "TiepNhanBenhNhan_TuNgay.png";
	public static String TiepNhanBenhNhan_DenNgay = "TiepNhanBenhNhan_DenNgay.png";
	public static String TiepNhanBenhNhan_TuyenChuyen = "TiepNhanBenhNhan_TuyenChuyen.png";
	public static String TiepNhanBenhNhan_NgayDu5Nam = "TiepNhanBenhNhan_NgayDu5Nam.png";
	public static String TiepNhanBenhNhan_MienDongYTra = "TiepNhanBenhNhan_MienDongYTra.png";
	public static String TiepNhanBenhNhan_LiDoChuyen = "TiepNhanBenhNhan_LiDoChuyen.png";

	// DANG KI KHAM
	public static String TiepNhanBenhNhan_TenDichVu = "TiepNhanBenhNhan_TenDichVu.png";
	public static String TiepNhanBenhNhan_NoiThucHien = "TiepNhanBenhNhan_NoiThucHien.png";
	public static String TiepNhanBenhNhan_ThuTienSau = "TiepNhanBenhNhan_ThuTienSau.png";
	public static String TiepNhanBenhNhan_DonGiaDoanhThu = "TiepNhanBenhNhan_DonGiaDoanhThu.png";
	public static String TiepNhanBenhNhan_ThanhTienDoanhThu = "TiepNhanBenhNhan_ThanhTienDoanhThu.png";
	public static String TiepNhanBenhNhan_DonGiaBaoHiemYTe = "TiepNhanBenhNhan_DonGiaBaoHiemYTe.png";
	public static String TiepNhanBenhNhan_ThanhTienBaoHiemYTe = "TiepNhanBenhNhan_ThanhTienBaoHiemYTe.png";
	public static String TiepNhanBenhNhan_ThucTeBaoHiemChiTra = "TiepNhanBenhNhan_ThucTeBaoHiemChiTra.png";
	public static String TiepNhanBenhNhan_BenhNhanThanhToan = "TiepNhanBenhNhan_BenhNhanThanhToan.png";
	public static String TiepNhanBenhNhan_DanhSachBenhNhan = "TiepNhanBenhNhan_DanhSachBenhNhan.png";
	public static String TiepNhanBenhNhan_DanhSachBenhNhanDKKOnline = "TiepNhanBenhNhan_DanhSachBenhNhanDKKOnline.png";
	public static String TiepNhanBenhNhan_Luu = "TiepNhanBenhNhan_Luu.png";
	public static String TiepNhanBenhNhan_BoQua = "TiepNhanBenhNhan_BoQua.png";
	public static String TiepNhanBenhNhan_Them = "TiepNhanBenhNhan_Them.png";
	public static String TiepNhanBenhNhan_Sua = "TiepNhanBenhNhan_Sua.png";
	public static String TiepNhanBenhNhan_NghiepVu = "TiepNhanBenhNhan_NghiepVu.png";
	public static String TiepNhanBenhNhan_Nap = "TiepNhanBenhNhan_Nap.png";
	public static String checkbox_uncheck = "checkbox_uncheck.png";
	public static String checkbox_checked = "checkbox_checked.png";
	public static String Checkbox_default_ThuTienSau = "Checkbox_default_ThuTienSau.png";
	public static String Checkbox_Checked_ThuTienSau = "Checkbox_Checked_ThuTienSau.png";
	public static String Checkbox_Uncheck_ThuTienSau = "Checkbox_Uncheck_ThuTienSau.png";
	public static String Phieukham = "Phieukham.png";
	public static String HIS_VuiLongChoDoi = "HIS_VuiLongChoDoi.png";
	public static String CanhBaoHoTen = "CanhBaoHoTen.png";
	public static String AfterLoading = "AfterLoading.png";
	public static String TiepNhanBenhNhan_Sua_Enable = "TiepNhanBenhNhan_Sua_Enable.png";
	// Loi pop-up
	public static String Hochieu_cmnd = "Hochieu_cmnd.png";
	public static String TiepNhanBenhNhan_UuTien_Unchecked = "TiepNhanBenhNhan_UuTien_Unchecked.png";
	public static String TiepNhanBenhNhan_GioiTinhNamNuKhongXacDinh = "TiepNhanBenhNhan_GioiTinhNamNuKhongXacDinh.png";
	public static String TiepNhanBenhNhan_GioiTinh_Radio_Checked = "TiepNhanBenhNhan_GioiTinh_Radio_Checked.png";
	public static String TiepNhanBenhNhan_MessageLoi = "TiepNhanBenhNhan_MessageLoi.png";
    public static String TiepNhanBenhNhan_BHYTChiTra = "TiepNhanBenhNhan_BHYTChiTra.png";
	public static String TiepNhanBenhNhan_ThuTienSau_Uncheck = "TiepNhanBenhNhan_ThuTienSau_Uncheck.png";
	public static String TiepNhanBenhNhan_ChuyenPhongKham = "TiepNhanBenhNhan_ChuyenPhongKham.png";

    
	
	public String getSoTiepNhan() {
		setClipboardValue("");
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoTiepNhan, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String soTiepNhan = getClipboardValue();
		return soTiepNhan;
	}
	
	public void dienSoTiepNhan(String soTiepNhan)
	{
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoTiepNhan, 100);
		s.click();
		s.type(soTiepNhan);
		s.type(Key.ENTER);
		
	}
	

	public void dienMaBenhNhan(String maBenhNhan)
	{
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_MaBenhNhan, 100);
		s.type(maBenhNhan);
		s.type(Key.ENTER);
		
	}
	
	
	public String getMaBenhNhan()
	{
		setClipboardValue("");
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_MaBenhNhan, 100);
		s.click();
		s.type("a",Key.CTRL);
		s.type("c",Key.CTRL);
		return getClipboardValue();
		
	}
	
	

	public void dienHoTen(String Hoten) {
		
		waitForObjectPresent(TiepNhanBenhNhan_HoTen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_HoTen, 100);
		s.click();
		setClipboardValue("");
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_HoTen, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		setClipboardValue(Hoten);
		s.type("v", Key.CTRL);
	}

	public String getHoten() {
		setClipboardValue("");
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_HoTen, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String hoten = getClipboardValue();
		return hoten;
	}

	public void dienNgaySinh(String ngaysinh) {
		
		waitForObjectPresent(TiepNhanBenhNhan_NgaySinh, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgaySinh, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(ngaysinh);
	}

	public String getNgaySinh() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NgaySinh, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgaySinh, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String ngaysinh = getClipboardValue();
		TestLogger.info("Ngay sinh ==> " + ngaysinh);
		return ngaysinh;
	}

	public void dienNamSinh(String namsinh) {

		waitForObjectPresent(TiepNhanBenhNhan_NamSinh, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgaySinh, 322);
		s.click();

		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(namsinh);
		s.type(Key.ENTER);
		
	}

	public String getNamSinh() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NamSinh, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgaySinh, 322);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String namsinh = getClipboardValue();
		return namsinh;
	}
	

	public void dienSoCMTND(String soCMTND) {
		/*
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoCMND, 100);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(soCMTND);
	}

	public String getSoCMTND() {
		setClipboardValue("");
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoCMND, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String soCMTND = getClipboardValue();
		return soCMTND;
	}

	public void dienSoDT(String soDT) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_SoDT, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoDT,100); s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(soDT);
	}

	public String getSoDT() {
		setClipboardValue("");
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoDT, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String soDT = getClipboardValue();
		return soDT;
	}

	public void dienNgheNghiep(String nghenghiep) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_NgheNghiep, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgheNghiep, 100);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(nghenghiep);
		s.type("v", Key.CTRL);

	}

	public String getNgheNghiep() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NgheNghiep, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgheNghiep, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String nghenghiep = getClipboardValue();
		return nghenghiep;

	}

	public void dienDanToc(String dantoc) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_DanToc, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_DanToc, 100);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(dantoc);
		s.type("v", Key.CTRL);

	}

	public String getDanToc() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_DanToc, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_DanToc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienNhapNhanh(String MaCacTinhThanh) {

		waitForObjectPresent(TiepNhanBenhNhan_NhapNhanhMaThanhPho, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NhapNhanhMaThanhPho, 100);
		s.click();

		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(MaCacTinhThanh);
	}

	public String getNhapNhanh() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NhapNhanhMaThanhPho, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NhapNhanhMaThanhPho, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienQuocTich(String QuocTich) {
		waitForObjectPresent(TiepNhanBenhNhan_QuocTich, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_QuocTich, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(QuocTich);
		s.type("v", Key.CTRL);

	}

	public String getQuocTich() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_QuocTich, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_QuocTich, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienThanhPho(String Thanhpho) {
		waitForObjectPresent(TiepNhanBenhNhan_TinhThanhPho, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_TinhThanhPho, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(Thanhpho);
		s.type("v", Key.CTRL);

	}

	public String getThanhPho() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_TinhThanhPho, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_TinhThanhPho, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienQuanHuyen(String QuanHuyen) {
		waitForObjectPresent(TiepNhanBenhNhan_QuanHuyen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_QuanHuyen, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(QuanHuyen);
		s.type("v", Key.CTRL);

	}

	public String getQuanHuyen() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_QuanHuyen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_QuanHuyen, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienPhuongXa(String PhuongXa) {
		waitForObjectPresent(TiepNhanBenhNhan_PhuongXa, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_PhuongXa, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(PhuongXa);
		s.type("v", Key.CTRL);

	}

	public String getPhuongXa() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_PhuongXa, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_PhuongXa, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienSoNha(String SoNha) {

		waitForObjectPresent(TiepNhanBenhNhan_SoNha, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoNha, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(SoNha);
		s.type("v", Key.CTRL);

	}

	public void chonGioiTinhNam() {
		waitForObjectPresent(TiepNhanBenhNhan_GioiTinhNam, 5);
		clickOn(TiepNhanBenhNhan_GioiTinhNam);
	}

	public void chonGioiTinhNu() {
		waitForObjectPresent(TiepNhanBenhNhan_GioiTinhNu, 5);
		clickOn(TiepNhanBenhNhan_GioiTinhNu);
	}

	public void chonGioiTinhChuaXacDinh() {
		waitForObjectPresent(TiepNhanBenhNhan_GioiTinhChuaXacDinh, 5);
		clickOn(TiepNhanBenhNhan_GioiTinhChuaXacDinh);
	}

	public String getSoNha() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_SoNha, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoNha, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienSoCMND(String SoCMND) {

		waitForObjectPresent(TiepNhanBenhNhan_SoCMND, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoCMND, 100);
		s.click();

		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(SoCMND);
	}

	public String getSoCMND() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_SoCMND, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoCMND, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienSoDienThoai(String SoDienThoai) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_SoDT, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoDT, 100); s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(SoDienThoai);
	}

	public String getSoDienThoai() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_SoDT, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoDT, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienNoiLamViec(String NoiLamViec) {

		waitForObjectPresent(TiepNhanBenhNhan_NoiLamViec, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NoiLamViec, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(NoiLamViec);
		s.type("v", Key.CTRL);
	}

	public String getNoiLamViec() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NoiLamViec, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NoiLamViec, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienNguoiLienHe(String NguoiLienHe) {

		waitForObjectPresent(TiepNhanBenhNhan_NguoiLienHe, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NguoiLienHe, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(NguoiLienHe);
		s.type("v", Key.CTRL);
	}

	public String getNguoiLienHe() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NguoiLienHe, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NguoiLienHe, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienSoDienThoaiNguoiLienHe(String SoDTnguoiLienHe) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_SoDienThoaiNguoiLienHe, 5);
		 * moveMouseHorizontallyFromLogo(
		 * TiepNhanBenhNhan_SoDienThoaiNguoiLienHe, 100); s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(SoDTnguoiLienHe);
	}

	public String getSoDienThoaiNguoiLienHe() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_SoDienThoaiNguoiLienHe, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoDienThoaiNguoiLienHe, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienDoiTuong(String DoiTuongdichVu) {

		waitForObjectPresent(TiepNhanBenhNhan_DoiTuong, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_DoiTuong, 100);
		s.click();
		s.type("a", Key.CTRL);
		sleep(1);
		s.type(Key.DELETE);
		setClipboardValue(DoiTuongdichVu);
		s.type("v", Key.CTRL);
		/*s.type(DoiTuongdichVu);
		sleep(2);*/
		s.type(Key.ENTER);
	}

	public String getDoiTuong() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_DoiTuong, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_DoiTuong, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void chonUuTien(String YesOrNo) {

		waitForObjectPresent(TiepNhanBenhNhan_UuTien, 5);
		if (YesOrNo.equals("Yes")) {
			s.type(Key.SPACE);
		}

	}

	public String getUuTien() {

		if (waitForObjectAppearOnRegion(TiepNhanBenhNhan_DoiTuong, checkbox_uncheck, 305, 23, 5)) {
			return "No";
		} else {
			return "Yes";
		}

	}

	public void chonHinhThuc(String HinhThucKham) {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_HinhThuc, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_HinhThuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		setClipboardValue(HinhThucKham);
		s.type("v", Key.CTRL);
		s.type(Key.ENTER);

	}

	public String getHinhThuc() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_HinhThuc, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_HinhThuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();

	}

	public void dienLiDo(String lido) {

		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_LiDoKhamBenh, 100);
		setClipboardValue("");
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		setClipboardValue(lido);
		s.type("v", Key.CTRL);
		s.type(Key.ENTER);
	}

	public String getLiDo() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_LiDoKhamBenh, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_LiDoKhamBenh, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienSoTheBHYT(String sotheBHYT) {
		
		waitForObjectPresent(TiepNhanBenhNhan_SoThe, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoThe, 100);
		s.click();
		
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(sotheBHYT);

	}

	public String getSoTheBHYT() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_SoThe, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoThe, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienTuyen(String tuyen) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_Tuyen, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_Tuyen, 100);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(tuyen);
		s.type("v", Key.CTRL);
		// s.type(Key.ENTER);
	}

	public String getTuyen() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_Tuyen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_Tuyen, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienNoiGioiThieu(String noiGioiThieu) {

		waitForObjectPresent(TiepNhanBenhNhan_NoiGioiThieu, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NoiGioiThieu, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(noiGioiThieu);
		s.type("v", Key.CTRL);
		s.type(Key.ENTER);
	}

	public String getNoiGioiThieu() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NoiGioiThieu, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NoiGioiThieu, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienMaDKKCB(String MaDKKCB) {
		
		waitForObjectPresent(TiepNhanBenhNhan_MaDangKiKhamChuaBenhBanDau, 5);
		moveMouseHorizontallyFromLogo(
		TiepNhanBenhNhan_MaDangKiKhamChuaBenhBanDau, 100); 
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(MaDKKCB);
		s.type(Key.ENTER);
	}

	public String getMaDKKCB() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_MaDangKiKhamChuaBenhBanDau, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_MaDangKiKhamChuaBenhBanDau, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienKhuVuc(String Khuvuc) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_KhuVuc, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_KhuVuc, 42);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(Khuvuc);
		// s.type(Key.ENTER);
	}

	public String getKhuVuc() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_KhuVuc, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_KhuVuc, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienSoTuyenChuyen(String SoTuyenChuyen) {

		waitForObjectPresent(TiepNhanBenhNhan_SoTuyenChuyen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoTuyenChuyen, 100);
		s.click();

		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(SoTuyenChuyen);
		s.type(Key.ENTER);
	}

	public String getSoTuyenChuyen() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_SoTuyenChuyen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_SoTuyenChuyen, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienNgayChuyen(String ngaychuyen) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_NgayChuyen, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgayChuyen, 100);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(ngaychuyen);
		// s.type(Key.ENTER);
	}

	public String getNgayChuyen() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NgayChuyen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgayChuyen, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienTuNgay(String tungay) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_TuNgay, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_TuNgay, 100);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(tungay);
		// s.type(Key.ENTER);
	}

	public String getTuNgay() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_TuNgay, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_TuNgay, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienDenNgay(String denngay) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_DenNgay, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_DenNgay, 100);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(denngay);
		// s.type(Key.ENTER);
	}

	public String getDenNgay() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_DenNgay, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_DenNgay, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienTuyenChuyen(String tuyenchuyen) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_TuyenChuyen, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_TuyenChuyen, 100);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(tuyenchuyen);
		s.type("v", Key.CTRL);
		// s.type(Key.ENTER);
	}

	public String getTuyenChuyen() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_TuyenChuyen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_TuyenChuyen, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienNgayDu5Nam(String ngaydu5nam) {
		/*
		 * waitForObjectPresent(TiepNhanBenhNhan_NgayDu5Nam, 5);
		 * moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgayDu5Nam, 100);
		 * s.click();
		 */
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type(ngaydu5nam);
		// s.type(Key.ENTER);
	}

	public String getNgayDu5Nam() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NgayDu5Nam, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_NgayDu5Nam, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienLiDoChuyen(String lidochuyen) {

		waitForObjectPresent(TiepNhanBenhNhan_LiDoChuyen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_LiDoChuyen, 100);
		s.click();
		s.type("a", Key.CTRL);
		sleep(1);
		s.type(Key.DELETE);
		setClipboardValue(lidochuyen);
		s.type("v", Key.CTRL);
		// s.type(Key.ENTER);
	}

	public String getLiDoChuyen() {

		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_LiDoChuyen, 5);
		moveMouseHorizontallyFromLogo(TiepNhanBenhNhan_LiDoChuyen, 100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void dienTenDichVu(String tenDichVu) {
		moveMouseDownFromLogo(TiepNhanBenhNhan_TenDichVu, 37);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		setClipboardValue(tenDichVu);
		s.type("v", Key.CTRL);
		sleep(2);
		s.type(Key.ENTER);
	}
	
	public void dienTenDichVu2(String tenDichVu) {
		moveMouseDownFromLogo(TiepNhanBenhNhan_TenDichVu, 58);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		setClipboardValue(tenDichVu);
		s.type("v", Key.CTRL);
		sleep(2);
		s.type(Key.ENTER);
	}
	
	public void dienTenDichVu3(String tenDichVu) {
		moveMouseDownFromLogo(TiepNhanBenhNhan_TenDichVu, 84);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		setClipboardValue(tenDichVu);
		s.type("v", Key.CTRL);
		sleep(2);
		s.type(Key.ENTER);
	}

	public void dienNoiThucHien(String noiThucHien) {
		moveMouseDownFromLogo(TiepNhanBenhNhan_NoiThucHien, 36);
		s.click();
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		setClipboardValue(noiThucHien);
		s.type("v", Key.CTRL);
		s.type(Key.ENTER);
	}

	public String getNoiThucHien() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_NoiThucHien, 5);
		moveMouseDownFromLogo(TiepNhanBenhNhan_NoiThucHien, 36);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public String getTenDichVu() {
		setClipboardValue("");
		waitForObjectPresent(TiepNhanBenhNhan_TenDichVu, 5);
		moveMouseDownFromLogo(TiepNhanBenhNhan_TenDichVu, 36);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		return getClipboardValue();
	}

	public void chonThuTienSau(String YesorNo) {

		// click thu tien sau
		if (YesorNo.equals("Yes"))
			clickToaDo(680, 540);
		else {
			s.type(Key.SPACE);
		}

		/*
		 * if (YesorNo.equals("Yes")) { s.type(Key.SPACE); } else {
		 * clickOnRegion(TiepNhanBenhNhan_ThuTienSau,
		 * Checkbox_Checked_ThuTienSau, 200, 200);
		 * 
		 * }
		 */
	}
	
	public void moRongKhungPhongKham ()
	{
		clickToaDo(1200, 289);
	}
	
	public void thuHepKhungPhongKham () 
	{
		clickToaDo(1201, 71);
	}

}
