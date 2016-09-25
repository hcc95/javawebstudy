package proxystudy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

	public static void main(String[] args) {
		Object[] elements=new Object[1000];
		for(int i=0;i<elements.length;i++){
			Integer value=i+1;
			Class[] interfaces=value.getClass().getInterfaces();
			InvocationHandler hander=new TraceHandler(value);
			Object proxy=Proxy.newProxyInstance(null, interfaces, hander);
			elements[i]=proxy;
		}
		//构造一个随机的整数
		Integer key=new Random().nextInt(elements.length)+1;
		//
		int result=Arrays.binarySearch(elements, key);
		
		if(result>=0) System.out.println(elements[result]);
	}

}
class TraceHandler implements InvocationHandler{
	private Object target;
	public TraceHandler(Object t){
		this.target=t;
	}
	@Override
	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		System.out.print(target);
		System.out.print("."+m.getName()+"(");
		if(args!=null){
			for(int i=0;i<args.length;i++){
				System.out.print(args[i]);
				if(i<args.length-1)
					System.out.print(",");
			}	
		}
		System.out.println(")");
		return m.invoke(target, args);
	}
	
	
}