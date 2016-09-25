package reflectstudy;

import java.util.concurrent.TimeUnit;

public class StopThread {
	
	private static boolean stopRequest;
	private static synchronized void requestStop(){
		stopRequest=true;
	}
	private static synchronized boolean stopRequest(){
		return stopRequest;
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread backgroudThread=new Thread(new Runnable(){
			public void run(){
				int i=0;
				while(!stopRequest())
					i++;
			}
		});
		backgroudThread.start();
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}

}
