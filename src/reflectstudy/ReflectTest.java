package reflectstudy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;


public class ReflectTest {
	public static void main(String[] args){
		String name;
		if(args.length>0){
			name=args[0];
		}else{
			Scanner in=new Scanner(System.in);
			System.out.println("enter class name(e.g. java.util.Date)");
			name=in.next();
		}
		try {
			Class c1=Class.forName(name);
			Class superc1=c1.getSuperclass();
			System.out.print("class "+name);
			if(superc1!=null&&superc1!=Object.class){
				System.out.print("extends "+superc1.getName());
				System.out.print("\n{\n");
				printConstructors(c1);
				System.out.println();
				printMethod(c1);
				System.out.println();
				printFileds(c1);
				System.out.print("}");	
			}
		} catch (Exception e) {
			System.exit(0);
		}
	}
/**
 * 打印构造器器信息
 * @param c1
 */
	public static void printConstructors(Class c1) {
		Constructor[] constructors=c1.getConstructors(); 
		for(Constructor c:constructors){
			String name=c1.getName();
			System.out.print(" "+Modifier.toString(c.getModifiers()));
			System.out.print(" "+name+"(");
			Class[] paramTypes=c.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++){
				if(j<0);
				System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
		
	}
	/**
	 * 打印方法信息
	 * @param c1
	 */
	public static void printMethod(Class c1) {
		Method[] methods=c1.getMethods();
		for(Method m:methods){
			Class retType=m.getReturnType();
			String name=m.getName();
			System.out.print(" "+Modifier.toString(c1.getModifiers()));
			System.out.print(" "+retType.getName()+" "+name+"(");
			Class[] paraTypes=m.getParameterTypes();
			for(int j=0;j<paraTypes.length;j++){
				if(j<0) System.out.print(", ");
				System.out.print(paraTypes[j].getName());
			}
			System.out.println(");");
		}
		
	}
	/**
	 * 打印作用域信息
	 * @param c1
	 */
	public static void printFileds(Class c1) { 
		Field[] fields=c1.getFields();
		for(Field f:fields){
			Class type=f.getType();
			String name=f.getName();
			System.out.print(" "+Modifier.toString(c1.getModifiers()));
			System.out.print(" "+type.getName()+" "+name+";");
		}
	}

	
}
