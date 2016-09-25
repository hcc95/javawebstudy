package reflectstudy.Class;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
/**
 * 
 * 反射获取获取Dao子类的带泛型的父类
 * @author huchaochao
 *
 * @param <T>
 */
public class Dao<T>{
	
	private Class<T> clazz;
	
	public Dao(){
		/*System.out.println("Dao's contructor.....");
		System.out.println(this);
		System.out.println(this.getClass());
		//获取Dao子类的父类
		Class clazz2=this.getClass().getSuperclass();
		System.out.println(clazz2);*/
		
		//获取Dao子类的带泛型的父类，Dao<Person>
		Type type=this.getClass().getGenericSuperclass();
		System.out.println(type);//reflectstudy.Class.Dao<reflectstudy.Class.Person>
		
		//获取具体的泛型的参数
		if(type instanceof ParameterizedType){
			ParameterizedType parameterizedType=(ParameterizedType) type;
			Type[] args=parameterizedType.getActualTypeArguments();
			System.out.println(Arrays.asList(args));//[class reflectstudy.Class.Person]
			if( args!=null && args.length>0){
				Type arg=args[0];
				if(arg instanceof Class){
					clazz=(Class<T>) arg;//class reflectstudy.Class.Person
				}
			}
		}
	}
	
	T get(Integer id){
		
		System.out.println(clazz);//class reflectstudy.Class.Person
		return null;
	}
	
	void save (T entity){
		
	}
}
