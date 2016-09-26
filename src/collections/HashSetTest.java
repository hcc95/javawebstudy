package collections;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * set 都不能放重复的引用
 * hashset 中不能有重复的元素 判定两个元素相同的标准 equals() 返回true
 * 
 * hashset 根据hashCode（）值来存储元素 所以不能保证元素的顺序
 * @author huchaochao
 *
 */

public class HashSetTest {
	
	
	
	@Test
	public void testAdd(){
		Set set=new HashSet();
		Person p1=new Person("hcc",12);
		Person p2=new Person("hcc",12);
		//Person p3=new Person("hcc3",12);
		//TODO flase问题 Person 要重写equals方法吗？
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p1));
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());
	}
	
	
}
