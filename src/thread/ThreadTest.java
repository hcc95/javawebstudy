package thread;


public class ThreadTest {

	public static void main(String[] args) throws InterruptedException{
		
		Thread thread=new FirstThread("FirstThread");
		thread.start();
		String name=Thread.currentThread().getName();		
		for(int i=0;i<10;i++){	
			System.out.println(name+":"+i);
		}
	}

}
class FirstThread extends Thread{
	
	public FirstThread(String name){
		super(name);
	}
	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		for(int i=0;i<10;i++){	
			System.out.println(name+":"+i);
		}
	}
}
