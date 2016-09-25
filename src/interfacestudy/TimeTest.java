package interfacestudy;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimeTest {

	public static void main(String[] args) {
		ActionListener listener=new Timerprinter();
		Timer t=new Timer(1000,listener);
		t.start();
		JOptionPane.showMessageDialog(null, "quit program?");
		System.exit(0);

	}

}
class Timerprinter implements ActionListener{
	public void actionPerformed(ActionEvent event){
		Date now=new Date();
		System.out.println("at the tone,the time is "+now);
		Toolkit.getDefaultToolkit().beep();
	}
}
