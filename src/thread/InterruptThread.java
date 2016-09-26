package thread;

public class InterruptThread extends Thread {

	public static void main(String[] args) {
		InterruptThread thread=new InterruptThread();
		thread.start();
		
		thread.interrupt();//解除线程的阻塞状态

	}
	
	@Override
	public void run(){
		for(int i=0;i<100;i++){	
			try {
				if(i==10){
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+i);			
		}
	}
}
