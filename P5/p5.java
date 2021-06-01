import java.util.*;
public class p5{
	public static void main(String args[]){
		System.out.print("Enter IP version, header length and TOS in hexadecimal format : ");
		Scanner scan = new Scanner(System.in);
		String num = scan.next();
		System.out.println("IP version : "+num.charAt(0) + ", Header Length : "+num.charAt(1)+ ", TOS : "+num.charAt(2)+num.charAt(3));
		System.out.println();

		System.out.print("Enter Total length Field of IP header : ");
		String input2 = scan.next();
		int ans = sum(num, input2);
		System.out.println("Adding above two 16 bit words gives result : "+Integer.toHexString(ans));
		System.out.println();

		System.out.print("Enter Identification field : ");
		String input3 = scan.next();
		int second_result = sum(Integer.toHexString(ans), input3);
		System.out.println("Adding last result and next input gives result : "+Integer.toHexString(second_result));
		System.out.println();

		System.out.print("Enter flags and fragment offset : ");
		String input4 = scan.next();
		int third_result = sum(Integer.toHexString(second_result), input4);
		System.out.println("Adding last result and next input gives result : "+Integer.toHexString(third_result));
		System.out.println();

		System.out.print("Enter TTL field and protocol field : ");
		String input5 = scan.next();
		int fourth_result = sum(Integer.toHexString(third_result), input5);
		System.out.println("Adding last result and next input gives result : "+Integer.toHexString(fourth_result));
		System.out.println();

		System.out.print("Enter Header Checksum field (which is 0000 at destination end) : ");
		String input6 = scan.next();
		int fifth_result = sum(Integer.toHexString(fourth_result), input6);
		System.out.println("Adding last result and next input gives result : "+Integer.toHexString(fifth_result));
		System.out.println();

		System.out.print("Enter Source IP Address : ");
		String input7 = scan.next();
		int sixth_result = sum(Integer.toHexString(fifth_result), input7);
		System.out.println("Adding last result and next input gives result : "+Integer.toHexString(sixth_result));
		System.out.println();

		System.out.print("Enter Destination IP Address : ");
		String input8 = scan.next();
		int seventh_result = sum(Integer.toHexString(sixth_result), input8);
		System.out.println("Adding last result and next input gives result : "+Integer.toHexString(seventh_result));
		System.out.println();

		System.out.println("Enter Options and Padding Fields : ");
		System.out.print("First 16 bits : ");
		String input9 = scan.next();
		int eight_result = sum(Integer.toHexString(seventh_result), input9);
		System.out.println("Adding last result and next input gives result : "+Integer.toHexString(eight_result));
		System.out.println();

		System.out.print("Next 16 bits : ");
		String input10 = scan.next();
		int output = sum(Integer.toHexString(eight_result), input10);
		System.out.println("Final result is : "+Integer.toHexString(output));
		System.out.println();

		System.out.println("Complement the final result to get the Checksum");
		System.out.println();

		int my_checksum = compgenerator(output);
		System.out.println("Checksum generated is "+ Integer.toHexString(my_checksum));
	}
	static int sum(String s1, String s2){
		int x = Integer.parseInt(s1, 16);
		int y = Integer.parseInt(s2,16);
		int my_checksum = x+y;
		String my_hex_val = Integer.toHexString(my_checksum);

		if(my_hex_val.length() > 4){
			int carry = Integer.parseInt(("" + my_hex_val.charAt(0)), 16);
			my_hex_val = my_hex_val.substring(1,5);
			my_checksum = Integer.parseInt(my_hex_val, 16);
			my_checksum += carry;
		}
		return my_checksum;
	}
	static int compgenerator(int my_checksum){
		my_checksum = Integer.parseInt("FFFF", 16) - my_checksum;
      	return my_checksum;
	}
}