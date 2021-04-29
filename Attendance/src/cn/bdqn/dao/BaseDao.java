package cn.bdqn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.bdqn.util.DataBaseUtil;

/**
 * 鏁版嵁搴撶鐞嗭紒
 * 
 * @author Administrator
 *
 */
public class BaseDao {
	// 澹版槑Connection瀵硅薄灞炴�э紒
	private Connection conn = null;

	/**
	 * 甯﹀弬鏋勯�犳柟娉曪紒
	 * 
	 * @param conn
	 */
	public BaseDao(Connection conn) {
		// 閫氳繃鏋勯�犳柟娉曠殑褰㈠紡缁機onnection璧嬪�硷紒
		this.conn = conn;
	}

	/**
	 * 澧烇紒鍒狅紒鏀癸紒鎿嶄綔锛侊紒
	 * 
	 * @param sql
	 * @param parms
	 * @return
	 */
	protected int excuteUpdate(String sql, Object[] parms) {
		// 澹版槑PreparedStatement瀵硅薄锛�
		conn = DataBaseUtil.getConnection();
		PreparedStatement pstms = null;
		// 澹版槑鍙橀噺鎺ュ彈鍙楀奖鍝嶈鏁帮紒
		int result = -1;
		try {
			// 鎵цSQL璇彞锛�
			pstms = conn.prepareStatement(sql);
			// 鍒ゆ柇杩斿洖鍊肩粨鏋滄槸鍚︿负绌猴紒
			if (parms != null) {
				// 寰幆閬嶅巻Object鏁扮粍锛�
				for (int i = 0; i < parms.length; i++) {
					// 寰幆涓篠QL璇彞璧嬪�硷紒
					pstms.setObject(i + 1, parms[i]);
				}
				// 璋冪敤澧炲垹鏀规柟娉曪紒
				result = pstms.executeUpdate();
 
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			// 鍏抽棴璧勬簮锛�
			DataBaseUtil.closeAll(null, pstms, null);
		}
		return result;
	}

	/**
	 * 鏌ヨ鎿嶄綔锛�
	 * 
	 * @param sql
	 * @param parms
	 * @return
	 */
	protected ResultSet excuteQuery(String sql, Object[] parms) {
		conn = DataBaseUtil.getConnection();
		// 澹版槑PreparedStatement瀵硅薄锛�
		PreparedStatement pstms = null;
		// 澹版槑ResultSet瀵硅薄鐢ㄤ簬杩斿洖鏌ヨ鍒扮殑缁撴灉闆嗭紒
		ResultSet result = null;
		try {
			
			// 鎵цSQL璇彞锛�
			pstms = conn.prepareStatement(sql);
			// 鍒ゆ柇杩斿洖鍊肩粨鏋滄槸鍚︿负绌猴紒
			if (parms != null) {
				// 寰幆閬嶅巻Object鏁扮粍锛�
				for (int i = 0; i < parms.length; i++) {
					// 寰幆涓篠QL璇彞璧嬪�硷紒
					pstms.setObject(i + 1, parms[i]);
				}
			}
			// 璋冪敤鏌ヨ鏂规硶锛�
			result = pstms.executeQuery();
			System.out.println(result);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return result;
	}
}
