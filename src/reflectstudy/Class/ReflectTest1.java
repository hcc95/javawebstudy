package reflectstudy.Class;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.junit.Test;


/**
 * 反射对父类method的操作
 * @author hucha
 *
 */
public class ReflectTest1 {

	
	/**
	 * 通用的invoke方法的封装
	 * @param className 某个类的全类名
	 * @param methodName 类的一个方法名  方法可能是私有方法，也有可能是父类的方法
	 * @param args 调用该方法需要传入的参数
	 * @return 返回值
	 */
	public Object invoke2(String className,String methodName,Object...args){
		Object obj=null;
		try {
			obj=Class.forName(className).newInstance();
			return invoke2(obj,methodName,args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}	
	/**
	 * 通用的invoke方法的封装
	 * @param obj 方法执行的方法的执行对象
	 * @param methodName 类的一个方法名  方法可能是私有方法，也有可能是父类的方法
	 * @param args 调用该方法需要传入的参数
	 * @return 返回值
	 */
	public Object invoke2(Object obj,String methodName,Object...args ){
		//1 获取Method对象
		/*Object[] parameterTypes=new Object[args.length];*/
		Class clazz=obj.getClass();
		Class[] parameterTypes=new Class[args.length];
		for(int i=0;i<args.length;i++){
			parameterTypes[i]=args[i].getClass();
			System.out.println(parameterTypes[i]);
		}
		try {
			//2 执行方法
			//3返回方法的返回值
			/*Method method=obj.getClass().getDeclaredMethod(methodName,parameterTypes);*/
			Method method=getMethod(clazz,methodName,parameterTypes);
			//
			method.setAccessible(true);
			return method.invoke(obj, args);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	
	/**
	 * 获取clazz的methodName方法，该方法可能是私有的，有可能是父类中
	 * @param clazz
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 */
	public Method getMethod(Class clazz,String methodName,
			Class...parameterTypes){
		for(;clazz!=Object.class;clazz=clazz.getSuperclass()){
			try {
				Method method=clazz.getDeclaredMethod(methodName, parameterTypes);
				return method;
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}		
		return null;		
	}
	
	
	/**
	 * 测试getmethod 这个方法
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testGetMethod() throws ClassNotFoundException{
		Class clazz=Class.forName("reflectstudy.Class.Student");
		Method method=getMethod(clazz,"method1",Integer.class);
		System.out.println(method);
		Method method1;
		try {
			method1 = getMethod(clazz, "method2");
			System.out.println(method1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	@Test
	public void testinvoke2(){
		
		Object obj=new Student();
		//student 的私有方法
		invoke2(obj,"method1",10);
		//student的父类person的方法
		Object result=invoke2(obj,"method2");
		System.out.println(result);
		/*
		 * //student 的私有方法
		invoke2("reflectstudy.Class.Student","method1",10);
		//student的父类person的方法
		Object result=invoke2("reflectstudy.Class.Student","method2");
		System.out.println(result);
		*/
	}
	@Test
	public void testPrviateinvoke() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class clazz=Class.forName("reflectstudy.Class.Student");
		Method method=clazz.getDeclaredMethod("method1", Integer.class);
		method.setAccessible(true);
		Object obj=clazz.newInstance();//clazz.newInstance 实际调用的是无参数的构造器
		method.invoke(obj, 10);
	}
	
	@Test
	public void testGetSuperClass() throws ClassNotFoundException {
		String className="reflectstudy.Class.Person";
		Class clazz=Class.forName(className);
		Class superClazz=clazz.getSuperclass();
		System.out.println(superClazz);
		
	}

}
