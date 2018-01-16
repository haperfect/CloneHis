package desktop_Framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KiemSoatDatabase {

	public static Connection con;
	public static String URL = "jdbc:oracle:thin:@11.0.5.3:1521:mbdb01";
	public static String USERNAME = "HIS_TEST_PERFORMANCE";
	public static String PASSWORD = "PCoQl2r9ua";
	Statement smt;
	public Connection taoKetNoi(String URL, String user, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver Loaded");
		try {
			con = DriverManager.getConnection(URL, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection created");

		return con;
	}
	
	
	public String getMaKhuVuc(Connection con, String makhuvuc) throws SQLException
	{
		String giatri = "" ;
		Statement smt = con.createStatement();
		System.out.println("Statement created");
		ResultSet rs = smt.executeQuery(
				"Select * from Local WHERE LOCAL_CODE = '" + makhuvuc +"'");
		System.out.println("Query Executed");
		if ( rs.next())
		{
			giatri = rs.getString("LOCAL_CODE");
		}
		else
		{
			TestLogger.info("Khong co du lieu nao !");
		}
		return giatri ;
	}
	
	public void closeKetNoi (Connection con)
	{   
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
