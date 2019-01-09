package network;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class LocalhostTest {


	public static void main(String[] args) {
		try {
			InetAddress inetAddress=InetAddress.getLocalHost();
			
			String hostName=inetAddress.getHostName();
			String hostAddress=inetAddress.getHostAddress();
			
		
			System.out.println(hostName+":"+hostAddress);
			byte[] address=inetAddress.getAddress();
		
			for(byte a:address)
			{
				System.out.print(a&0x000000ff);
				System.out.println(".");
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
