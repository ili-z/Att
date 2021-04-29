package cn.bdqn.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 璧勬簮鏂囦欢绫伙紒
 * @author Administrator
 *
 */
public class ConfigManager {
	private static Properties properties = null;
	
	//闈欐�佷唬鐮佸潡锛佺被琚姞杞界殑鏃跺�欏姞杞借繖娈典唬鐮侊紒
	static {
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(
                "/database.properties");
		//鍒ゆ柇InputStream鏄惁涓虹┖锛�
		if(is == null) {
			throw new RuntimeException("鎵句笉鍒版暟鎹簱鍙傛暟閰嶇疆鏂囦欢锛�");
		}
		properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			throw new RuntimeException("鏁版嵁搴撻厤缃弬鏁板姞杞介敊璇紒", e);
		}finally {
            try {
            	//鏈�鍚庡叧闂祫婧愶紒锛�
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
	
	/**
	 * 閫氳繃閿壘鍒拌祫婧愭枃浠堕噷闈㈡斁鐨勫�硷紒
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
