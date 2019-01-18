package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {
	public static final int PORT = 5000; 
	public static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {

		DatagramSocket socket = null;
		DatagramPacket receivePackit = null;
		DatagramPacket sendPackit = null;
		try {
			// 1.socket create
			socket = new DatagramSocket(PORT);

			// 데이터 수신
			while(true){
			receivePackit = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
			socket.receive(receivePackit);
			String messge=new String(receivePackit.getData(), 0,receivePackit.getLength(),"UTF-8");
			System.out.println("[Server]recevied:"+messge);
			
			//데이터 전송
			
			SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss a" );
			String data = format.format( new Date() );

			byte[] sendData=data.getBytes("UTF-8");
			sendPackit=new DatagramPacket(sendData, sendData.length,receivePackit.getAddress(),receivePackit.getPort());
			socket.send(sendPackit);
			
			
			}

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
