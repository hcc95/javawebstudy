package thread;

public class YieldThread extends Thread{
	
	public static void main(String[] args) {
		Thread t1=new YieldThread("线程-1");
		Thread t2=new YieldThread("线程-2");
		t1.start();
		t2.start();
	}
	public YieldThread(String name){
		super(name);
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){			
			System.out.println(Thread.currentThread().getName()+":"+i);			
			if(i%10==0){
				yield();//i为10的倍数时让出执行权限，等待CPU下一次调用
			}
		}
	}
}
