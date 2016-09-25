package reflectstudy.Class;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;
/**
 * 反射对field的操作
 * @author hucha
 *
 */
public class ReflectTest2 {
	/**
	 * Field里面封装了字段的信息
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * 
	 */
	@Test
	public void testField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String className="reflectstudy.Class.Person";
		Class clazz=Class.forName(className);
		/*Field[] fields=clazz.getFields();//不能获取私有的字段*/		
		
		// 1 获取所有声明字段 包括私有的字段
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields){
			System.out.println(field.getName());
		}
		//2 获取指定的字段的值
		Field field1=clazz.getDeclaredField("age");
		System.out.println(field1.getName());
		
		Person person =new Person("zhangsan",15);
		//34获取指定对象的filed值
		Object obj=field1.get(person);	
		System.out.println(obj);
		//4 设置指定对象的值
		field1.set(person, 51);
		System.out.println(person.getAge());
		
		//5 该字段是私有的  setAccessible
		Field field2=clazz.getDeclaredField("name");
		field2.setAccessible(true);
		System.out.println(field2.getName());
		System.out.println(field2.get(person));
	}
	
	@Test
	public void testClassField() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		String className="reflectstudy.Class.Student";
		String fieldName="name";//父类的私有字段
		Object val="hello";
		//创建className 对应的对象 并为其赋值
		Object obj=null;
		Class clazz=Class.forName(className);
		Field field = getField(clazz,fieldName);
		obj=clazz.newInstance();//clazz.newInstance 实际调用的是无参数的构造器
		setValue(obj, field,val);
		Student stu=(Student) obj;
		Object p=getFieldValue(obj,field);
		System.out.println(stu.getName());//hello
		System.out.println(p);//hello
		
	}
	public Object getFieldValue(Object obj,Field field) throws IllegalArgumentException, IllegalAccessException{
		field.setAccessible(true);
		return field.get(obj);
	}
	public void setValue(Object obj, Field field,Object val)
			throws InstantiationException, IllegalAccessException {
		field.setAccessible(true);
		field.set(obj, val);
	}

	public Field getField( Class clazz,String fieldName) {
		Field field=null;
		for (Class clazz2=clazz;clazz2!=Object.class;clazz2=clazz2.getSuperclass()) {
			try {
				field=clazz2.getDeclaredField(fieldName);
			} catch (NoSuchFieldException | SecurityException e) {
			//e.printStackTrace();
			}
		}
		return field;
	}
}
