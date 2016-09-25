package reflectstudy.Class;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;


/**
 * 反射和注解的结合使用
 * @author hucha
 *
 */
public class ReflectTest3 {
	/**
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@Test
	public void testAnnotation() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/*Person person=new Person();
		person.setAge(-4);*/
		String className="reflectstudy.Class.Person";
		Integer val=-20;
		Class clazz=Class.forName(className);
		Object obj=clazz.newInstance();
		Method method=clazz.getDeclaredMethod("setAge", Integer.class);
		Annotation annotation=method.getAnnotation(AgeValidator.class);
		
		if(annotation!=null){
			if(annotation instanceof AgeValidator){
				AgeValidator ageValidator=(AgeValidator) annotation;
				
				if(val < ageValidator.min()||val>ageValidator.max()){
					throw new RuntimeException("年龄非法");
				}
			}
			
		}
		
		method.invoke(obj, val);
		System.out.println(obj);//person{name= ;age=}
	}

}
