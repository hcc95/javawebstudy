package dateandrandom;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import static java.lang.Math.*;
public class RandomTest {

	/**
	 * Random 中封装随机的方法
	 * 
	 * nextInt() 在一个范围内随机产生int整数
	 */
	@Test
	public void test() {
		Random random=new Random();
		System.out.println(random.nextInt(90));
	}
	
	
	/**
	 * Math 静态导入
	 * 
	 * import static java.lang.Math.*
	 * 
	 * 导入指定的指定属性和方法
	 * 这样会容易造成混淆
	 * 
	 */
	@Test
	public void testMath(){
		//import static java.lang.Math.* 就可以直接使用
		System.out.println(Math.sin(Math.PI/6));
		System.out.println(sin(PI/6));
	}
}
