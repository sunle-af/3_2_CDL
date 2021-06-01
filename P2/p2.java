import java.io.*;
import java.net.*;
class p2
{
  public static void ping_request(String ipAddress)
              throws UnknownHostException, IOException
  {
    InetAddress object = InetAddress.getByName(ipAddress);
    System.out.println("Sending Ping Request to " + ipAddress);
    if (object.isReachable(5000))
      System.out.println("Host is reachable");
    else
      System.out.println("Sorry ! We can't reach to this host");
  }
  public static void main(String[] args)
          throws UnknownHostException, IOException
  {
    String ip_address = "127.0.0.1";
    ping_request(ip_address);
  
    ip_address = "133.192.31.42";
    ping_request(ip_address);
  
    ip_address = "145.154.42.58";
    ping_request(ip_address);
  }
}