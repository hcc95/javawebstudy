package thread;
/**
 * 多线程
 * @author huchaochao
 *
 */
public class PrintNumber {
	public static void main(String[] args) {
		int i=0;
		Thread thread1=new NumberThread("thread_1 ");
		Thread thread2=new NumberThread("thread_2 ");
		NumberThread.setI(i);
		thread1.start();
		thread2.start();
	}
}
class NumberThread extends Thread{
	
	public NumberThread(String name){
		super(name);
	}
	private static int i;
	
	public static void setI(int i){
		NumberThread.i=i;
	}
	@Override
	public void run(){
		for(;i<100;i++){			
			System.out.println(getName()+i);			
		}
	}
}
