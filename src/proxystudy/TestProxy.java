package proxystudy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.junit.Test;

public class TestProxy {
	
	
	/**
	 * 
	 * 动态代理
	 * 1 需要一个被代理对象
	 * 2 类加载器通常是和被代理对象使用相同的类加载器
	 * 3 一般的 Proxy.newProxyInstance返回值是被代理对象的接口类型
	 * 当然也可以是其他的接口类型
	 * 第二参数，必须是一个接口类型的数组
	 * 若代理对象不需要额外的实现被代理对象实现的接口以外的接口
	 * 可以使用Proxy.getClass().getInterface()
	 * 4 InvocationHandler通常使用匿名内部类的方式
	 */
	@Test
	public void testProxy(){
		 
		final ArithmeticCalculator arithmeticCalculator=new ArithmeticCalculatorImpl();
		 /**
		  * ClassLoader 有动态代理产生的对象由哪个类加载器来加载
		  * 通常情况下和被代理的对象使用一样的类加载器
		  * Class<?>[]：由动态代理产生的对象必须需要实现的接口的数组
		  * 
		  * InvocationHandler ：具体调用代理对象的方法时，讲产生什么行为
		  */
		 ArithmeticCalculator proxy=(ArithmeticCalculator)Proxy
				 .newProxyInstance(arithmeticCalculator.getClass().getClassLoader(), 
						 new Class[]{ArithmeticCalculator.class}, 
						 new InvocationHandler(){
							@Override
							/**
							 * proxy:
							 * method:正在被调用的方法
							 * args：调用方法时传入的参数
							 */
							public Object invoke(Object proxy, Method method,
									Object[] args) throws Throwable {
								/*System.out.println("method"+method);
								System.out.println(Arrays.asList(args));
								methodpublic abstract void proxystudy.ArithmeticCalculator.mul(int,int)
								[1, 2]
								methodpublic abstract int proxystudy.ArithmeticCalculator.add(int,int)
								[2, 5]*/
								System.out.println("the method: "
								+method.getName()+" begin with:"
								+Arrays.asList(args));
								Object result=method.invoke(arithmeticCalculator, args);
								System.out.println("the method: "
										+method.getName()+" end with:"
										+result);
								return result;
							}	 
				 });
		 proxy.mul(1, 2);
		 int result=proxy.add(2, 5);
		 System.out.println(result);
		 
	}
}
