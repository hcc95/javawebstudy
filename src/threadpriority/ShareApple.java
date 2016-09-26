package threadpriority;

/**
 * 线程不安全  多个线程访问一个共享的资源
 * 使用synchronize 代码块解决安全问题
 * @author hucha
 *
 */
public class ShareApple implements Runnable {

	public static void main(String[] args) {
		ShareApple sharApple=new ShareApple();
		Thread t1=new Thread(sharApple);
		t1.setName("小明");
		t1.start();
		Thread t2= new Thread(sharApple);
		t2.setName("小强");
		t2.start();

	}
	private int appleCount=5;
	
	/**
	 * 拿苹果实体
	 * @return
	 */
	boolean getApple(){
		
		synchronized(this){
			if(appleCount>0){
				 appleCount--;
				 try {
					// TODO Auto-generated catch block
					Thread.sleep(1000);  //造成线程安全问题
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println(Thread.currentThread()
						 .getName()+"拿了一个苹果"+"还剩下"+appleCount+"个苹果");
				 return true;
			 }
		}//线程同步 共享同一个参数
		 
		
		
		return false;
	 }
	 
	/**
	 * 线程体
	 */
	@Override
	public void run() {
		boolean flag=getApple();
		while(flag){
			 flag=getApple();
		 }
		 System.out.println(Thread.currentThread()
				 .getName()+"线程已经结束");
	}
}
