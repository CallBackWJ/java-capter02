package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSlookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String line=null;
		while(true)
		{
			line=sc.nextLine();
			if("exit".equals(line))
				break;
			
			try {
				InetAddress[] inetAddress=InetAddress.getAllByName(line);
				
				for(InetAddress i:inetAddress)
				{
					System.out.println(i.getHostAddress());
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
