/**
 * 
 */
package com.ningkangkj.wxWebService.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wangping
 *
 */
public class ServerProperty {

	/**
	 * 私有构造方法，不需要创建对象
	 */
	private ServerProperty() {
	}

	public static Properties prop = null;
	
	static {
		prop = new Properties();
		InputStream in = ServerProperty.class.getResourceAsStream("/properties/wechat.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return prop.getProperty(key);
	}

	public static String get(String key, String defaultVal) {
		String val = get(key);
		return val == null ? defaultVal : val;
	}

}
