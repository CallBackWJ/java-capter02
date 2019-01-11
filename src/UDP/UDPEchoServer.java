package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	private static final int PORT = 5000;

	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {

		DatagramSocket socket = null;
		DatagramPacket receivePackit = null;
		try {
			// 1.socket create
			socket = new DatagramSocket(PORT);

			// 데이터 수신
			receivePackit = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
			socket.receive(receivePackit);
			
			byte[] data=receivePackit.getData();
			int len=receivePackit.getLength();//데이터 길이
			String messge=new String(data, 0,len,"UTF-8");
			System.out.println("[Server]recevied:"+messge);
			

		} catch (SocketException e) {
			System.out.println("socket excption!!");
		} catch ( IOException e) {
			System.out.println("IO excption!!");
		} finally {
			if (socket != null && socket.isClosed() == false)
				socket.close();
		}
	}
}
