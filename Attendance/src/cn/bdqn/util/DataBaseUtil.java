package cn.bdqn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 宸ュ叿绫伙紒
 * 
 * @author Administrator
 *
 */
public class DataBaseUtil {
	// 鏁版嵁搴撻┍鍔ㄥ瓧绗︿覆锛�
	private static String driver = ConfigManager.getProperty("driver");
	// 杩炴帴URL瀛楃涓诧紒
	private static String url = ConfigManager.getProperty("url");
	// 鏁版嵁搴撶敤鎴峰悕锛侊紒
	private static String user = ConfigManager.getProperty("user");
	// 鐢ㄦ埛瀵嗙爜锛�
	private static String password = ConfigManager.getProperty("password");

	// 闈欐�佷唬鐮佸潡鐢ㄤ簬鍔犺浇椹卞姩绫伙紒
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 鑾峰彇鏁版嵁搴撹繛鎺ュ璞★紒
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 杩斿洖杩炴帴瀵硅薄锛�
		return conn;
	}
	
	/**
	 * 鍏抽棴鏁版嵁搴撹繛鎺ワ紒
	 * @param rs ResultSet瀵硅薄锛�
	 * @param pstmt PreparedStatement瀵硅薄锛�
	 * @param conn Connection瀵硅薄锛�
	 */
	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		// 鍏抽棴ResultSet瀵硅薄杩炴帴锛�
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		// 鍏抽棴PreparedStatement瀵硅薄杩炴帴锛�
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		// 鍏抽棴Connection瀵硅薄杩炴帴锛�
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
