package threadpriority;
/**
 * synchronized 保证同一时间只有一个线程访问资源
 * @author hucha
 *
 */
public class PrintLetter implements Runnable {

	public static void main(String[] args) {
		PrintLetter printLetter=new PrintLetter();
		Thread t1=new Thread(printLetter);
		Thread t2=new Thread(printLetter);
		
		t1.setName("线程-1  ");
		t2.setName("线程-2  ");
		t1.start();
		t2.start();

	}
	private char c = 'a';//char 是单引号   String 是双引号
	public boolean print(){
		synchronized(this){
			if(c <= 'z'){
				System.out.println(Thread.currentThread()
						.getName()+":"+c);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				c++;
				return true;
			}
		}
		
		return false;
	}
	@Override
	public void run() {
		boolean flag=print();
		while (flag){
			flag=print();
		}
	}
}
