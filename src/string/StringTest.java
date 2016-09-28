package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 1 String 是不可变的字符序列
 * 
 * 2 字符串缓冲池： 
 * 1）直接通过= 为字符串赋值， 会在缓冲池中查找有没有一样的字符串，
 *  如果有 就把那个引用赋值给字符串变量 
 *  否则，会创建一个新的字符创，并把它放在缓冲池中
 * 2）如果是new 则就是直接创建新的
 * 
 * @author huchaochao
 *
 */
public class StringTest {

	@Test
	public void test() {
		String str="www";
		String result=str.replace("w", "a");
		System.out.println(str);
		System.out.println(result);
		
	}

	@Test
	public void testNewString() {
		String str1="www";
		String str2="www";
		
		System.out.println(str1==str2);//true 表示两个引用指向同一个地方
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		String str3=new String("www");
		String str4=new String("www");
		
		System.out.println(str3==str4);//false 两个对象都是新创建的
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
	}
	
	@Test
	public void testPassRef(){
		Person person=new Person("abc",12);
		System.out.println(person);
		changePerson(person);//将person的引用传递了 指向同一引用空间 所以值会改变
		System.out.println(person);
		
		String str="hcc";
		changeString(str);
		System.out.println(str);//结果还是不变
	}
	public void changePerson(Person person){
		person.setName("hcc");
		
	}
	public void changeString(String str){
		String result=str.replace("h", "g");//会产生一个新的字符串  但必须给一个引用
		
		System.out.println(result);
	}
	
}
