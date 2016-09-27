package collections;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
/**
 * TreeSet 保证元素有序   是SortedSet的实现类 默认情况采用自然排序方式
 * @author huchaochao
 *
 */
public class TreeSetTest {
	
	
	
	
	/**.....1.......
	 * treeset 要求集合中元素必须实现comparable接口
	 * public void compareTo(T o){
	 * 
	 * 	} 若返回0 代表两个元素相等  若返回负数 当前元素小 正数 当前元素大
	 * 
	 * public int compareTo(Object o) {
		if(o instanceof Person){
			Person person=(Person) o;
			//return this.name.compareTo(person.name);
			//return this.age-person.age;
			return -this.age+person.age;
		}else{
			throw new RuntimeException("不能转为person");
		}
	}
	 * treeset 会调用compareTo 方法去和集合中已有元素比较 决定当前元素在集合中的位置 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testComparable() {
		TreeSet tset=new TreeSet();
		inputPerson(tset);
		/*tset.add(new Person("AA",15));
		tset.add(new Person("BB",14));
		tset.add(new Person("CC",13));
		tset.add(new Person("DD",12));*/
		Iterator it=tset.iterator();
		while(it.hasNext()){
			Object obj=it.next();
			System.out.println(obj); 
			//如果person类中不实现compareTo接口会报错
			//java.lang.ClassCastException: collections.Person cannot be cast to java.lang.Comparable
			
		}
	}

	public void inputPerson(TreeSet tset) {
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<5;i++){
			System.out.println("name"+(i+1));
			String pname=scanner.next();
			System.out.println("age"+(i+1));
			int page=scanner.nextInt();
			Person perosn=new Person(pname,page);
			tset.add(perosn);
			
		}
	}
	
	
	/**..........2.................
	 * 此时使用外部排序
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testTreeSetWithComparator(){
		
		//创建comparator接口的实现类
		Comparator comparator=new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Person1 && o2 instanceof Person1){
					Person1 p1=(Person1) o1;
					Person1 p2=(Person1) o2;
					return p1.getAge()-p2.getAge();
				}else{
					throw new ClassCastException("不能转为person类型");
				}
			}
			
		};
		//要传人comparetor接口的实现类
		TreeSet tset=new TreeSet(comparator);
		tset.add(new Person1("AA",15));
		tset.add(new Person1("BB",14));
		tset.add(new Person1("CC",13));
		tset.add(new Person1("DD",12));
		Iterator it=tset.iterator();
		while(it.hasNext()){
			Object obj=it.next();
			System.out.println(obj);
		}
	}
	
	
	/**
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testOthers(){
		TreeSet tset=new TreeSet();
		tset.add(new Person("AA",15));
		tset.add(new Person("BB",14));
		tset.add(new Person("CC",13));
		tset.add(new Person("DD",12));
		Object object=tset.first();
		System.out.println(object);
		Set subSet=tset.tailSet(new Person("CC",13));
		System.out.println(subSet);
		
	}
}
