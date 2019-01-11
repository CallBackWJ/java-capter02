package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPTimeClient {

	private static final String SERVER_IP = "192.168.0.70";
	private static final int SERVER_PORT = 5000;
	public static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {

		Scanner sc = null;
		DatagramSocket socket = null;
		try {
			// 1.키보드 연결
			sc = new Scanner(System.in);
			// 2. 소켓 생성
			socket = new DatagramSocket();

			while (true) {
				// 3. 사용자입력 받음
				System.out.print("[enter]");
				String message = sc.nextLine();
				if ("quit".equals(message)) {break;}
				// 메세지 전송
				byte[] data;

				data = message.getBytes("UTF-8");

				DatagramPacket sendPacket = new DatagramPacket(data, data.length,new InetSocketAddress(SERVER_IP, SERVER_PORT));
				socket.send(sendPacket);
				
				DatagramPacket receivePacket=new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket);
				message=new String(receivePacket.getData(), 0, receivePacket.getLength(),"UTF-8");
				System.out.println("<<"+message);
				
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//자원정리
			if(sc!=null)
			{
				sc.close();
			}
			if(socket!=null&&socket.isClosed()==false)
				socket.close();
		}
	}
}
