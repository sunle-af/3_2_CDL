import java.net.*; 
import java.io.*;
import java.util.*;
public class p1 {
    public static void main(String[] args) throws Exception
    {  
        
         p1 object = new p1();
        object.getMA();
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("System IP Address : " +
                      (localhost.getHostAddress()).trim());
        try{
            InetAddress currentIP = InetAddress.getLocalHost();
            System.out.println("The IP address is : " + currentIP.getHostAddress());
            System.out.println("The host name is : " + currentIP.getHostName());
         }
         catch (UnknownHostException e){
            System.out.println( "Couldn't find the local address.");
         }
    }
    void getMA()
    {
        try {
            Enumeration<NetworkInterface> networks
                = NetworkInterface.getNetworkInterfaces();
   
            while (networks.hasMoreElements()) {
                NetworkInterface network
                    = networks.nextElement();
                
                byte[] mac = network.getHardwareAddress();
  
                if (mac != null) {
                    System.out.print(
                        "Current MAC address : ");
                    
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format(
                            "%02X%s", mac[i],
                            (i < mac.length - 1) ? "-"
                                                 : ""));
                    }
                    
                    System.out.println(sb.toString());
                }
            }
        }
        catch (SocketException e) {
            e.printStackTrace();
        }
    }
}