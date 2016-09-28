package string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringMethodTest {

	/**
	 * trim() 去除前后空格
	 */
	@Test
	public void testTrim() {
		String str="  ab  cd ";
		System.out.println("--"+str+"--");
		System.out.println(str.trim());//这一步会赋给一个新的字符串变量
	}
	
	/**
	 * subString 
	 * String的索引是从0开始的
	 */
	@Test
	public void testSub() {
		String str="http://123.com/index.jsp?name=123";
		//str.substring(beginIndex, endIndex)
		String str2=str.substring(1, 3);//从1开始到3结束
		//String str2=str.substring(4);
		System.out.println(str);
		System.out.println(str2);
		
	}
	/**
	 * indexOf 
	 * lastIndexof 
	 * 求指定字符串的索引
	 */
	@Test
	public void testindexOf() {
		String str="http://123.com/index.jsp?name=123";
		System.out.println(str.indexOf("/"));
		System.out.println(str.lastIndexOf("/"));
		System.out.println(str.substring(str.indexOf("//")+2,
				str.lastIndexOf("/")));
	}
	/**
	 * charAt() 得到指定位置的字符
	 */
	@Test
	public void testcharAt(){
		//TODO
		String str="http://123.com/index.jsp?name=123";
		System.out.println(str.charAt(3));
	}
	
	/**
	 * split 用某种索引将字符创拆分成字符串数组
	 */
	@Test
	public void testsplit(){

		String str="aa-b-c-de-e-f";
		String[] values=str.split("-");
		for(String s:values){
			System.out.println(s);
		}
		
	}
	
	/**
	 * equals() 比较字符创内容是否相等必须使用该方法
	 *    不能直接使用==
	 */
	
}
