package threadpriority;
/**
 * 线程的优先级 但是效果不可控制
 * @author huchaochao
 *
 */
public class PriorityTest extends Thread {

	public static void main(String[] args) {
		PriorityTest t1=new PriorityTest("线程-1");
		PriorityTest t2=new PriorityTest("线程-2");
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(Thread.currentThread().getPriority());
		t1.setPriority(MIN_PRIORITY);
		t2.setPriority(MAX_PRIORITY);
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(Thread.currentThread().getPriority());
		t1.start();
		t2.start();
		for (int i = 0; i <100; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	public PriorityTest(String name){
		super(name);
	}
	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
