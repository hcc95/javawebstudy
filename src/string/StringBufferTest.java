package string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBufferTest {

	/**
	 * StringBuffer 可以被修改 线程安全 效率低 多线程的情况下使用
	 * StringBuilder 可以被修改 线程不安全 效率高
	 */
	@Test
	public void testStringBuffer() {
		StringBuffer stringBuffer=new StringBuffer("abcde");
		System.out.println(stringBuffer);
		stringBuffer.replace(1, 3, "mvp");
		System.out.println(stringBuffer);
	}
	
	/**
	 * append 把字符串加入已有的字符串序列后面
	 * 注意:append的返回值还是当前的StringBuilder 可以实现方法的连缀
	 * eg  stringBuilder.append().append().append();
	 */
	@Test
	public void testAppend(){
		StringBuilder stringBuilder =new StringBuilder ("abcde");
		//可以预置容量 但是超过容量 仍能继续加入
		stringBuilder.append("efg");//servlet里面常用
		System.out.println(stringBuilder);
	}

}
