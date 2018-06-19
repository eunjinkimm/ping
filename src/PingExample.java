import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;

public class PingExample extends JFrame {
	public PingExample() {
		super("Ping");
		Panel p = new Panel();
		TextArea ta = new TextArea();
		p.add(ta);
		add(p);
		setSize(500, 400);
		setLayout(new FlowLayout());
		setVisible(true);
			
		try {
			long finish = 0;
			long start = 0;
			
				for(int i=1 ; i<=255 ; i++) {
					String ip = "192.168.1." + i;
					start = new GregorianCalendar().getTimeInMillis();
					InetAddress address = InetAddress.getByName(ip);
					boolean reachable = address.isReachable(200);
					finish = new GregorianCalendar().getTimeInMillis();
					if(reachable == true) {
						ta.append(ip + " is ready " + (finish - start + "ms\n"));
					}
					else {
						ta.append(ip + " is not ready\n");
					}
				}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	public static void main(String[] args) {
		new PingExample();
	}
}
