package reflectstudy;

/*public class pingpong extends Thread {
	private String word;
	private int delay;
	
	public pingpong(String whatToSay,int delayTime){
		word=whatToSay;
		delay=delayTime;
	}
	public void run(){
		try {
			for(;;){
				System.out.print(word+" ");
				Thread.sleep(delay);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
		
	}
	public static void main(String[] args){
		new pingpong("ping",33).start();
		new pingpong("pong",100).start();
		
	}
}
*/


public class pingpong implements Runnable {
private String word;
private int delay;

public pingpong(String whatToSay,int delayTime){
	word=whatToSay;
	delay=delayTime;
}
public void run(){
	try {
		for(;;){
			System.out.print(word+" ");
			Thread.sleep(delay);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return;
	}
	
}
public static void main(String[] args){
	Runnable ping=new pingpong("ping",33);
	Runnable pong=new pingpong("pong",100);
	new Thread(ping).start();
	new Thread(pong).start();
}
}
