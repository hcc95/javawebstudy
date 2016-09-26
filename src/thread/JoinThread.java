package thread;

public class JoinThread extends Thread {
	public static void main(String[] args) {
		Thread thread=new JoinThread("线程-1");
		thread.start();
		for(int i=0;i<100;i++){	
			
			System.out.println(Thread.currentThread().getName()+":"+i);			
			try {
				if(i==10){
					thread.join();//让出执行权限 并停止线程
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public JoinThread(String name){
		super(name);
	}
	@Override
	public void run() {		
		for(int i=0;i<100;i++){			
			System.out.println(Thread.currentThread().getName()+":"+i);			
		}
	}
}
