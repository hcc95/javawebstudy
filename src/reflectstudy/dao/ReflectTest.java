package reflectstudy.dao;

import static org.junit.Assert.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class ReflectTest {
	/**
	 * 通过反射 ，获得定义Class时声明的父类的泛型参数的类型
	 * 如  public EmployeeDao extends BaseDao<Employee,String>
	 * @param clazz 子类对应的class对象
	 * @param index 子类继承父类时传入的泛型的索引
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenericType(Class clazz,int index){
		Type genType=clazz.getGenericSuperclass();
		if(!(genType instanceof ParameterizedType)){
			return Object.class;
		}
		Type[] params=((ParameterizedType)genType).getActualTypeArguments();
		if(index>params.length ||index<0){
			return Object.class;
		}
		if(!(params[index] instanceof Class)){
			return Object.class;
		}
		return (Class) params[index];
	}
	
	
	/**
	 * 通过反射，获取Class的父类的第一个泛型参数类型
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unhecked")
	public static<T> Class<T> getSuperGenericType(Class clazz){
		
		return getSuperClassGenericType(clazz,0);	
	}
	
	@Test
	public void testgetSuperClassGenericType(){
		Class clazz=EmployeeDao.class;
		//Employee.class
		Class argClazz=getSuperClassGenericType(clazz,0);
		System.out.println(argClazz);
		//String.class
		argClazz=getSuperClassGenericType(clazz,1);
		System.out.println(argClazz);
	}

	
}
