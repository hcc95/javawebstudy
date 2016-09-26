package threadpriority;

public class TicketHouse implements Runnable {

	private int fiveCount=1,tenCount=0,twentyCount=0;
	
	public synchronized void buy(){
		String name=Thread.currentThread().getName();
		//zf:20元
		if("zf".equals(name)){
			if(fiveCount < 3){
				try {
					wait();
					System.out.println("5元面值"+fiveCount+"张飞必须等待");
					System.out.println("卖一张票给张飞,找零15");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if("gy".equals(name)){
			fiveCount++;
			System.out.println("卖一张票给关羽，钱正好  5元面值"+fiveCount);
			
		}else if("lb".equals(name)){
			fiveCount++;
			System.out.println("卖一张票给刘备，钱正好  5元面值"+fiveCount);
			
		}
		notifyAll();
	}
	@Override
	public void run() {
		buy();

	}

	public static void main(String[] args) {
		Runnable r=new TicketHouse();
		Thread t1=new Thread(r);
		t1.setName("zf");
		Thread t2=new Thread(r);
		t2.setName("gy");
		Thread t3=new Thread(r);
		t3.setName("lb");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
