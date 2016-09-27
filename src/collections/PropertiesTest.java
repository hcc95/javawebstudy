package collections;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class PropertiesTest {

	
	/*
	 * properties 中存放是键值对  键值都是String类型
	 */
	@Test
	public void testProperties() throws IOException {
		//读取文件
		
		
		//1 创建properties对象
		Properties properties=new Properties();
		//2 调用properties的load方法
		InputStream inStream=PropertiesTest.class
				.getClassLoader()
				.getResourceAsStream("jdbc.properties");
		properties.load(inStream);
		//3 调用getProperties（String key）方法来获取值
		String user=properties.getProperty("user");
		System.out.println(user);
	}

}
