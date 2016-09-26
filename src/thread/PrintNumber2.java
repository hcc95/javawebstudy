package thread;
/**
 * 多线程
 * @author huchaochao
 *
 */
public class PrintNumber2 {
	int i=0;
	public static void main(String[] args) {
		 PrintNumber2 printNumber=new PrintNumber2();
		Thread thread1=new NumberThread2("thread_1 ",printNumber);
		Thread thread2=new NumberThread2("thread_2 ",printNumber);
		thread1.start();
		thread2.start();
	}
}
class NumberThread2 extends Thread{
	
	 PrintNumber2 printNumber;
	public NumberThread2(String name ,PrintNumber2 printNumber){
		super(name);
		this.printNumber=printNumber;
	}
	@Override
	public void run(){
		for(;printNumber.i<100;printNumber.i++){			
			System.out.println(getName()+printNumber.i);			
		}
	}
}
