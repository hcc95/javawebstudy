package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class CollectionTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testToolMethod(){
		Collection collection=new ArrayList();
		//System.out.println(collection.size());
		collection.add("abc");
		collection.add(new Person("hcc",12));
		collection.add(new Person("hcc1",12));
		collection.add(new Person("hcc2",12));
		//1 contains(Object o):利用equals(); 利用equals()方法比较 有没有指定元素
		boolean flag=collection.contains(new Person("hcc1",12));
		//System.out.println(flag);
		//2 containsAll(Collection<?> c) 查看集合中没有指定元素的集合
		Collection collection2=new ArrayList();	
		collection2.add("abc");
		collection2.add(new Person("hcc2",12));
		System.out.println(collection.containsAll(collection2));
		//3 isEmpty(); 检验集合是否为空集合
		System.out.println(collection.isEmpty());
		//4 toArray(); 把集合元素转为Object对象数组
		Object[] objs=collection.toArray();
		System.out.println(objs.length);
		//toArray(T[] a); 泛型
		
	}
	
	/**
	 *	1 clear() 清空
	 *  2 remove() 移除指定  通过equals方法在集合中查找指定的元素 并移除
	 *  3 removeAll(Collection coll) 移除coll中的元素
	 *  4 retainAll(Collection coll) 保存coll中的元素
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRemove(){
		Collection collection=new ArrayList();
		System.out.println(collection.size());
		collection.add("abc");
		
		collection.add(new Person("hcc",12));
		collection.add(new Person("hcc1",12));
		collection.add(new Person("hcc2",12));
		Person p=new Person("hcc3",12);
		collection.add(p);
		System.out.println(collection.size());
		/*collection.clear();
		System.out.println(collection.size());
		*/
		collection.remove(p);
		System.out.println(collection.size());
		
		
		
		System.out.println("........................");
		Collection collection2=new ArrayList();		
		//collection2.addAll(collection);
		System.out.println(collection.size());
		collection.retainAll(collection);
		//collection.removeAll(collection);
		
		System.out.println(collection.size());
		
	}
	
	
	/**
	 * Collection 中无法获取指定单位元素，但是可以遍历所有的元素
	 * 1.使用增强的for循环
	 * 2 使用Iterator 迭代器
	 * （1 先获取迭代器对象调用collection的iterator（）方法 该方法实现了Iterator接口
	 * （2 调用Iterator的接口 里面有 hasNext（）方法
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void testIterator(){
		Collection collection=new ArrayList();
		System.out.println(collection.size());
		collection.add("abc");
		collection.add(new Person("hcc",12));
		collection.add(new Person("hcc1",12));
		collection.add(new Person("hcc2",12));
		collection.add(new Person("hcc3",12));
		System.out.println(collection.size());
		for(Object obj:collection){
			System.out.println(obj);
		}
		System.out.println();//换行
		Iterator  it=collection.iterator();
		while(it.hasNext()){
			Object obj=it.next();//若下一条记录无效 还调用的话 会抛异常 
			System.out.println(obj);
		}
	}
	
	/**
	 * addAll(Collection) 将一组元素到集合中
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAddAll(){
		Collection collection2=new ArrayList();
		Collection collection=new ArrayList();
		//System.out.println(collection.size());
		collection.add("abc");
		collection.add(new Person("hcc",12));
		collection.add(new Person("hcc",12));
		collection.add(new Person("hcc",12));
		collection.add(new Person("hcc",12));
		collection2.addAll(collection);
		System.out.println(collection2.size());
	}
	
	
	/**
	 * add(Object obj)添加一个元素到集合中
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd(){
		Collection collection=new ArrayList();
		System.out.println(collection.size());
		collection.add("abc");
		collection.add(new Person("hcc",12));
		collection.add(new Person("hcc",12));
		collection.add(new Person("hcc",12));
		collection.add(new Person("hcc",12));
		System.out.println(collection.size());
		
	}
}
