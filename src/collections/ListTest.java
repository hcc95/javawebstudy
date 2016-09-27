package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * list 代表一个有序的，可重复的元素集合
 * 可以通过索引来访问指定元素的位置
 * @author huchaochao
 *
 */
public class ListTest {
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testArrayList(){
		List list=new ArrayList();	
		//List 和map与set的不同就是 即使person实现了equals方法 任然可以添加重复的元素
		list.add(new Person("AA",12));
		list.add(new Person("AA",12));
		list.add(new Person("AA",12));
		System.out.println(list.size());
		
		//list 独有的遍历方式
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i));
		}
		//Iterator 
		System.out.println(".............");
		Iterator it=list.iterator();
		while(it.hasNext()){
			Object obj=it.next();
			System.out.println(obj);
		}
		
	}
	
	
	
	/**
	 * 对比list
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testHashSet(){
		Set set=new HashSet();
		set.add(new Person("AA",12));
		set.add(new Person("AA",12));
		set.add(new Person("AA",12));
		System.out.println(set.size());
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testListMethod(){
		List<Person> list=new ArrayList<Person>();
		list.add(new Person("AA",12));
		list.add(new Person("CC",12));
		list.add(new Person("BB",13));
		//indexOf 得到一个对象在list的位置 位置是从0开始的
		int index=list.indexOf(new Person("BB",13));
		System.out.println(list.size());
		System.out.println(index);
		//lastIndexOf list可以放重复的元素  获取重复元素的最后一个位置
		int lastindex=list.lastIndexOf(new Person("AA",12));
		//Object remove(int index); 移除指定的索引的元素
		Object obj=list.remove(0);
		System.out.println(obj);
		System.out.println(".............");
		
		//Object set(int index ,Object other); 设置指定索引的元素为other 原来的被替换
		
		Object object=list.set(1,new Person("CC",13));//此时的object是替换之前的对象
		
		System.out.println(lastindex);
		System.out.println("........"+object);
		Iterator<Person> it=list.iterator();
		while(it.hasNext()){
			Object obj1=it.next();			
			System.out.println(obj1);
		}
		//List subList(int fromIndex,int toIndex)
		
	}
	
	
	/**
	 * 
	 */
	public void test(String...strings){
		System.out.println(strings.length);
		for(int i=0;i<strings.length;i++){
			System.out.println(strings[i]);
		}
	}
	
	@Test
	public void testArrayAsList(){
		test("aa","bb","cc");
		
		/**
		 * Arrays.asList(Objcet...args) 返回的是一个list对象
		 * 但不是ArrayList 也不是vector
		 * 
		 * 返回的是一个只读的list 不支持操作
		 */
		List<String> list=Arrays.asList("aa","bb","cc");
		System.out.println(list.getClass());
		System.out.println(list);
	}
}
