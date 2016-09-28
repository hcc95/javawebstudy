package dateandrandom;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateFormatTest {

	/**
	 * Date() 封装了日期和时间
	 * 
	 * DateFormat() 把日期格式化成一个字符串
	 * &把一个字符串格式化成一个date对象
	 * 1 DateFormat 是一个抽象类
	 * 抽象类获取对象的方式
	 * 1）创建其子类对象
	 * 2）有的抽象类提供了工厂方法获取抽象类实例
	 */
	@Test
	public void testDate() {
		Date date=new Date();
		System.out.println(date);
	}
	
	
	/**
	 *  1 DateFormat 是一个抽象类
	 * 抽象类获取对象的方式
	 * 1）创建其子类对象
	 * 2）有的抽象类提供了工厂方法获取抽象类实例
	 * eg DateFormat dateFormat=DateFormat
				.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG)
	 */
	@Test
	public void testDateFormat() {
		
		DateFormat dateFormat=DateFormat
				.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		Date date=new Date();
		String dateStr=dateFormat.format(date);
		System.out.println(dateStr);
	}
	
	/**
	 * SimpleDateFormat
	 * @throws ParseException 
	 */
	@Test
	public void testSimpleDateFormat() throws ParseException{
		DateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date date=new Date();
		String dateStr=dateFormat.format(date);
		System.out.println(dateStr);
		
		String str="2016-24-28 05:24:14";
		Date date2=dateFormat.parse(str);//将字符串格式化成时间格式
		
		System.out.println(date2);//Thu Jan 28 05:24:14 CST 2016
		
	}
}
