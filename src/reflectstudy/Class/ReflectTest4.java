package reflectstudy.Class;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * 反射和泛型的结合使用
 * @author hucha
 *
 */
public class ReflectTest4 {
	
	@Test
	public void testGenericAndReflection() {
		PersonDao personDao=new PersonDao();
		Person entity=new Person();
		personDao.save(entity);
		Person result=personDao.get(1);
		/*
		 * reflectstudy.Class.Dao<reflectstudy.Class.Person>
		[class reflectstudy.Class.Person]
		class reflectstudy.Class.Person
		*/
		//Dao dao=new Dao();
	}

}
