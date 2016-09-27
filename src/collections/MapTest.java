package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;
/**
 * 1 map 用于保存具有映射关系的键值对
 * 2 map 的key 和value 都可以是任何的引用类型的数据
 * 3 map的key 不能重复
 * key通过equals方法返回false
 * 4 key 和value 之间存在单一的一对一关系 即通过指定的key总能找到对应的value值
 * @author huchaochao
 *
 */
public class MapTest {
	/*
	 * 1 添加
	 * 2 查找 遍历
	 * 3 删除
	 * 4 工具
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testMap(){
		
		/**
		 * hashSet是由HashMap定义的
		 * 1） 在hashset中维护了一个HashMap的属性
		 * 2） 在调用HashSet的方法时 实际操作的hashMap对应的方法  set的Add方法就是put方法
		 */
		Map hs=new HashMap();
		// 8 v.put(k,v)
				hs.put("AA", new Person("AA",12));
				hs.put("BB", new Person("BB",12));
				hs.put("CC", new Person("CC",12));
				
		// 1 void clear()
		// 2 boolean containsKey(Object key);
		// 3 boolean containsValue(Object value);
				
		//............遍历Map会用到............		
		// 4 Set<Map.Entry<k,v>> entrySet() :得到键值对应的Entry的set借助泛型
		//.............................
				
		// 5 V get(Object key); 根据key返回对应的value
		// 6 boolean isEmpty(): 检验map是否为空
		
		//...............		
		// 7 Set<k> keySet() set类型
		Set keySet=hs.keySet();
		System.out.println(keySet);
		//.........................
				
		// 9 void putAll(Map<? extends k,? extends v> m)放入一组键值对
		
		// 10 v remove(Object key);
		hs.remove("CC");
		// 11 int Size();
		System.out.println(hs.size());
		// 12 Collection<v> values(); 返回values对应的集合
		Collection values=hs.values();
		System.out.println(values);
		System.out.println(values.getClass());
		
		//对于map的遍历
		//1 遍历键的集合 keySet()
		Iterator it=keySet.iterator();
		while(it.hasNext()){
			Object key=it.next();
			Object val=hs.get(key);
			System.out.println("key:"+key+"----values:"+val);
		}
		//2 遍历值得集合 values()
		
		//..................比较常用..........
		//3 得到键值对的集合
		Set<Map.Entry<String,Object>> set =hs.entrySet();
		Iterator<Entry<String, Object>> iterator=set.iterator();
		while(iterator.hasNext()){
			Map.Entry<String,Object> mapEntity=(Entry<String, Object>) iterator.next();
			System.out.println(mapEntity.getKey()+":"+mapEntity.getValue());
		}
	}
	
	@Test
	public void testLinkedHashMap(){
		Map<String, Person> map=new LinkedHashMap<String, Person>();
		//person 实现了equals方法 所以不能添加重复的元素
		map.put("AA", new Person("AA",12));
		map.put("AA", new Person("AA",12));
		map.put("BB", new Person("BB",12));
		map.put("CC", new Person("CC",12));
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()){
			Object key=it.next();
			Object val=map.get(key);
			System.out.println(key+":"+val);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testTreeMap(){
		Map map=new TreeMap();
		//这里的person1虽然没有实现compare接口 但是String实现了compareTo接口
		map.put("AA", new Person1("AA",12));
		map.put("BB", new Person1("BB",12));
		map.put("CC", new Person1("CC",12));
		/*
		 * map.put(new Person1("AA",12),"AA");
		map.put(new Person1("BB",12),"BB");
		map.put(new Person1("CC",12),"CC");
		这个时候就会报错 如果改成已经实现的person就能成功加入
		*/
		Iterator it=map.keySet().iterator();
		while(it.hasNext()){
			Object key=it.next();
			Object val=map.get(key);
			System.out.println(key+":"+val);
		}
	}
}
