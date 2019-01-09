package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {

	private static final int PORT = 5000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1.서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. binding(Socket에 SocketAddress(IPAddress+port))
			InetAddress inetAddress = InetAddress.getLocalHost();
			String localhostAddress = inetAddress.getHostAddress();
			serverSocket.bind(new InetSocketAddress(localhostAddress, PORT));
			// 3. accept(클라이언트로부터 연결요청을 기다리다.)
			System.out.println("[server] binding " + localhostAddress + ":" + PORT);
			Socket socket = serverSocket.accept();
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			// 4.io스트림 받아오기
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);

				String data=null;
				// 5. 데이터 읽기
				while (true) {
					data=br.readLine();
					if (data == null) {
						System.out.println("[server] close by client");
						break;
					}
					System.out.println("[server]received data:" + data);
					
					pw.println(data);
				}
			} catch (SocketException e) {
				// TODO: handle exception
				System.out.println("비정상 종료");
			} finally {
				try {
					if (serverSocket != null && serverSocket.isClosed() == false)
					{
						serverSocket.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 데이터 쓰기

		} catch (IOException e) {
			System.out.println("소켓연결 실패");
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
