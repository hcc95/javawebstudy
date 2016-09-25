package reflectstudy.Class;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Test;


/**
 * 反射对当前类method方法的使用
 * @author hucha
 *
 */
public class ReflectTest {
	
	/**
	 * 通用的invoke方法的封装
	 * @param className 某个类的全类名
	 * @param methodName 类的一个方法名
	 * @param args 调用该方法需要传入的参数
	 * @return 返回值
	 */
	public Object invoke(String className,String methodName,Object...args){
		Object obj=null;
		try {
			obj=Class.forName(className).newInstance();
			return invoke(obj,methodName,args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}	
	/**
	 * 通用的invoke方法的封装
	 * @param obj 方法执行的方法的执行对象
	 * @param methodName 类的一个方法名
	 * @param args 调用该方法需要传入的参数
	 * @return 返回值
	 */
	public Object invoke(Object obj,String methodName,Object...args ){
		//1 获取Method对象
		/*Object[] parameterTypes=new Object[args.length];*/
		Class[] parameterTypes=new Class[args.length];
		for(int i=0;i<args.length;i++){
			parameterTypes[i]=args[i].getClass();
			System.out.println(parameterTypes[i]);
		}
		try {
			//2 执行方法
			//3返回方法的返回值
			/*Method method=obj.getClass().getDeclaredMethod(methodName,parameterTypes);*/
			Method method=obj.getClass().getMethod(methodName,parameterTypes);
			return method.invoke(obj, args);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	@Test
	public void testinvoke(){
		Object obj=new Person();
		invoke(obj,"setName","hcc",12);
		invoke("reflectstudy.Class.Person","setName","hcc2",13);
		/**
		 *日期格式化
		 */
		Object  result=invoke("java.text.SimpleDateFormat","format",new Date());
		System.out.println(result);
	}
	/**
	 * Method的相关方法
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	
	@Test
	public void testMothod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class clazz=Class.forName("reflectstudy.Class.Person");
		//1 得到clazz对应的类中用那些方法 不能获取私有方法
		Method[] methods=clazz.getMethods();
		for(Method method:methods){
			System.out.println("方法："+method.getName());
		}
		//2 获取当前类声明的方法 包括私有方法
		Method[] methods1=clazz.getDeclaredMethods();
		System.out.println("................");
		for(Method method:methods1){
			System.out.println("方法："+method.getName());
		}
		//3 获取指定的方法
		Method method=clazz.getDeclaredMethod("setName",String.class);
		System.out.println("```````````");
		System.out.println(method);
		Method method1=clazz.getDeclaredMethod("test");
		System.out.println("```````````");
		System.out.println(method1);
		/**
		 * @name :方法名；
		 * @parameterType：方法的参数 （使用class来描述）的列表
		 */
		Method method2=clazz.getDeclaredMethod("setName",String.class,Integer.class);
		System.out.println("```````````");
		System.out.println(method2);
		//4  执行方法
		/**
		 * @obj:执行那个对应的方法
		 * @args ：执行方法要传入的参数
		 */
		Object obj=clazz.newInstance();
		method2.invoke(obj, "hcc",12);
	}
	@Test
	public void testClass() throws ClassNotFoundException{
		
		Class clazz=null;
		/*得到class对象
		 * 1 直接通过类名.class的方式来获取
		 * 2 通过对象调用getClass()方法来获取
		 * 3 通过全类名的方式来获取
		 */
		// 1  clazz=Person.class;
		
		
		/* 2 Object obj=new Person();
		     clazz=obj.getClass();  
		  */
		
		String className="reflectstudy.Class.Person";
		clazz=Class.forName(className);
		
		Field[] fields=clazz.getDeclaredFields();
		System.out.println(fields);
	}
	@Test
	public void testNewInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		String className="reflectstudy.Class.Person";
		Class clazz=Class.forName(className);
		/*Class<Person> clazz=Class.forName(className);*/
		//clazz.newInstance 实际调用的是无参数的构造器
		// 一般的，一个类既有有参数的构造器，又有一个无参数的构造器
		Object obj=clazz.newInstance();
		System.out.println(obj);
	}
	
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testClassLoad() throws ClassNotFoundException, FileNotFoundException{
		//获取一个系统的类加载器
		ClassLoader classLoader=ClassLoader.getSystemClassLoader();
		System.out.println(classLoader);
		//获取系统类加载器的父类加载器
		classLoader=classLoader.getParent();
		System.out.println(classLoader);
		
		//测试当前类由哪个类进行加载
		classLoader=Class.forName("reflectstudy.Class.Person")
				.getClassLoader();
		System.out.println(classLoader);
		//测试jdk object 是由哪个加载
		classLoader=Class.forName("java.lang.Object")
				.getClassLoader();
		System.out.println(classLoader);
		//关于类加载器的一个主要方法
		
		
		/*	这种方式的properties文件必须在根目录下面
		 * InputStream in=new FileInputStream("test.properties");*/
		/*	或者告诉编译后文件的路径
		 * InputStream in=new FileInputStream("D:/MyEclipse 2015/javawebstudy/WebRoot/WEB-INF/classes/test.properties");*/
		
		
		//调用getResourceAsStream 获取类路径下的文件    放在src同级目录下
		InputStream in=null;
		in=this.getClass()
				.getClassLoader()
				.getResourceAsStream("test.properties");
		System.out.println(in);
		
	}
}
