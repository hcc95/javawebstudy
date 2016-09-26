package thread;

public class IsLive extends Thread {

	public static void main(String[] args) {
		Thread thread=new IsLive();
		
		System.out.println(thread.isAlive());//false
		thread.start();
		System.out.println(thread.isAlive());//true
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(thread.isAlive());
		thread.start();//结束的线程再次调用会抛异常
	}
	@Override
	public void run(){
		for(int i=0;i<100;i++){	
			System.out.println(Thread.currentThread().getName()+":"+i);			
		}
	}
}
