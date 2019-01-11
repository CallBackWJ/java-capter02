package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "192.168.0.70";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		Encoder encoder = Base64.getEncoder();
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("[client] connected!");
			String data = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			new ChatClientThread(br).start();
			System.out.print("이름:");
			data = scanner.nextLine();
			pw.println("join:"+data);
			
			while (true) {
				
				System.out.print("ME:");
				data = scanner.nextLine();

				if ("quit".equals(data)) {
					pw.println(data);
					System.out.println("ME:종료합니다.");
					return;
				}
				
				pw.println("message:"+data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && socket.isClosed() == false)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
}
