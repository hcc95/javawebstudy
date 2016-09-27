package collections;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class CollectionsTest {
	/*
	 * 1 获取线程安全的集合对象
	 * ArrayList HashSet HashMap...都不是线程安全的
	 * 
	 * 如何得到一个线程安全的集合对象呢
	 * 调用
	 * Collections.synchronizedxx 方法 获取线程安全的集合对象;
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCollections() {
		List list=new ArrayList();
		//1  得到一个线程安全的集合对象
		List list2=Collections.synchronizedList(list);
		
		List list3=new ArrayList();
		list3.add(new Person1("aa",12));
		list3.add(new Person1("bb",13));
		list3.add(new Person1("ff",16));
		list3.add(new Person1("dd",17));
		list3.add(new Person1("ee",11));
		for(Object obj:list3){
			System.out.println(obj);
		}
		
		System.out.println("...............");
		
		//2  实现排序
		Collections.sort(list3,new Comparator(){

			@Override//按年龄生序排列
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Person1 && o2 instanceof Person1){
					Person1 p1,p2;
					p1=(Person1) o1;
					p2=(Person1) o2;
					
					return p1.getAge()-p2.getAge();
				}
				throw new ClassCastException("error");
			}
			
		});
		
		for(Object obj:list3){
			System.out.println(obj);
		}
		
		System.out.println("...............");
		//3 获取list中 的最小的那个元素
		//这个要求集合中的元素都实现comparable接口
		List list4=new ArrayList();
		list4.add(new Person("aa",12));
		list4.add(new Person("bb",13));
		list4.add(new Person("ff",16));
		list4.add(new Person("dd",17));
		list4.add(new Person("ee",11));
		
		Object min=Collections.min(list4);
		System.out.println(min);
	}

}
