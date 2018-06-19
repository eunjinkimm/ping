import java.net.InetAddress;
import java.util.GregorianCalendar;
 
public class PingRRT {
 
  public static void main(String[] args) {
 
    try {
      String ipAddress = "192.168.1.166";
      InetAddress inet = InetAddress.getByName(ipAddress);
 
      System.out.println("Sending Ping Request to " + ipAddress);
 
      long finish = 0;
      long start = new GregorianCalendar().getTimeInMillis();
 
      if (inet.isReachable(5000)){
        finish = new GregorianCalendar().getTimeInMillis();
        System.out.println("Ping RTT: " + (finish - start + "ms"));
      } else {
        System.out.println(ipAddress + " NOT reachable.");
      }
    } catch ( Exception e ) {
      System.out.println("Exception:" + e.getMessage());
    }
  }
}