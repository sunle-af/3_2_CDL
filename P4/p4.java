import java.util.*;
import java.lang.Math;
class p4 {
	public static int[] binary(String[] inputstr)
	{
		int re[] = new int[32];
		int a, b, c, d, i, rem;
		a = b = c = d = 1;
		Stack<Integer> st = new Stack<Integer>();
		if (inputstr != null)
		{
			a = Integer.parseInt(inputstr[0]);
			b = Integer.parseInt(inputstr[1]);
			c = Integer.parseInt(inputstr[2]);
			d = Integer.parseInt(inputstr[3]);
		}
		for (i = 0; i <= 7; i++)
		{
			rem = a % 2;
			st.push(rem);
			a = a / 2;
		}
		for (i = 0; i <= 7; i++) {
			re[i] = st.pop();
		}
		for (i = 8; i <= 15; i++) {
			rem = b % 2;
			st.push(rem);
			b = b / 2;
		}
		for (i = 8; i <= 15; i++) {
			re[i] = st.pop();
		}
		for (i = 16; i <= 23; i++) {
			rem = c % 2;
			st.push(rem);
			c = c / 2;
		}
		for (i = 16; i <= 23; i++) {
			re[i] = st.pop();
		}
		for (i = 24; i <= 31; i++) {
			rem = d % 2;
			st.push(rem);
			d = d / 2;
		}
		for (i = 24; i <= 31; i++) {
			re[i] = st.pop();
		}
		return (re);
	}

	public static int[] decimal(int[] bi)
	{
		int[] arr = new int[4];
		int a, b, c, d, i, j;
		a = b = c = d = 0;
		j = 7;
		for (i = 0; i < 8; i++) {
			
			a = a + (int)(Math.pow(2, j)) * bi[i];
			j--;
		}
		j = 7;
		for (i = 8; i < 16; i++) {
			b = b + bi[i] * (int)(Math.pow(2, j));
			j--;
		}
		
		j = 7;
		for (i = 16; i < 24; i++) {
			
			c = c + bi[i] * (int)(Math.pow(2, j));
			j--;
		}
		
		j = 7;
		for (i = 24; i < 32; i++) {
			
			d = d + bi[i] * (int)(Math.pow(2, j));
			j--;
		}
		
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		arr[3] = d;
		return arr;
	}
	
	public static void main(String args[])
	{
		String inputstr = "192.168.1.1/24";
		System.out.println("CIDR Notation: " + inputstr);
		
		String[] splittedstr = inputstr.split("/");
        System.out.println("IP address : "+splittedstr[0]);
        System.out.println("No.of bits significant for Network Routing: "+splittedstr[1]);
		String[] splittedipaddr = splittedstr[0].split("\\.");
        int n = Integer.parseInt(splittedstr[1]);


        int[] subnet_mask_binary = new int [32];
        for(int i=0;i<32;i++)
        {
            if(i<n)
                subnet_mask_binary[i] = 1;
            else
                subnet_mask_binary[i] = 0;
        }
        System.out.println();

        int[] subnet_mask_IPv4 = decimal(subnet_mask_binary);
        System.out.println("\ta) Subnet mask in dotted decimal notation: "+subnet_mask_IPv4[0]+"."+subnet_mask_IPv4[1]+"."+subnet_mask_IPv4[2]+"."+subnet_mask_IPv4[3]);
		int[] IP_address_binary = binary(splittedipaddr);
        int[] network_address_binary = new int[32];
		for (int i = 0; i < 32; i++) 
        {
			if(i<n)
			    network_address_binary[i] = IP_address_binary[i];
            else
            network_address_binary[i] = 0;
		}
        
        int[] network_address_IPv4 = decimal(network_address_binary);
        System.out.println("\tb) Network address in dotted decimal notation: "+network_address_IPv4[0]+"."+network_address_IPv4[1]+"."+network_address_IPv4[2]+"."+network_address_IPv4[3]);
		
        int[] min_host_binary = new int[32];
        int[] max_host_binary = new int[32];

        for(int i=0;i<32;i++)
        {
            if(i<n)
                min_host_binary[i] = max_host_binary[i] = IP_address_binary[i];
            else
            {
                min_host_binary[i] = 0;
                max_host_binary[i] = 1;
            }
        }
        min_host_binary[31] = (min_host_binary[31]+1)%2;
        max_host_binary[31] = (max_host_binary[31]+1)%2;

        int[] min_host_IPv4 = decimal(min_host_binary);
        int[] max_host_IPv4 = decimal(max_host_binary);
        System.out.println("\tc) Error in  Host IP range: Starting IP "+min_host_IPv4[0]+"."+min_host_IPv4[1]+"."+min_host_IPv4[2]+"."+min_host_IPv4[3]+" --- Ending IP "+max_host_IPv4[0]+"."+max_host_IPv4[1]+"."+max_host_IPv4[2]+"."+max_host_IPv4[3]);
	}
}
