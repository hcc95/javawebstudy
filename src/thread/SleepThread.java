package thread;

public class SleepThread extends Thread {
	
	public static void main(String[] args) {
		Thread t1=new SleepThread("线程-1");
		Thread t2=new SleepThread("线程-2");
		t1.start();
		t2.start();
	}
	public SleepThread(String name){
		super(name);
	}
	@Override
	public void run() {
		
		for(int i=0;i<100;i++){	
			
			try {
				Thread.sleep(1000);//线程停止一秒
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+i);			
			
		}
	}
}
