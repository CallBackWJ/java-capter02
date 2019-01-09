package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {

	private static final String SERVER_IP = "192.168.0.70";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		// 1.소켓생성
		Socket socket = null;
		try {
			socket = new Socket();

			// 2.서버연결

			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("[client] connected!");
			
			//3. io스트림얻어오기
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			
			//4.쓰기
			String data="hello world\n";
			os.write(data.getBytes("UTF-8"));
			
			//5.읽기
			byte[] buffer=new byte[256];
			int readByteCount=is.read(buffer);
			if(readByteCount==-1)
			{
				System.out.println("[client] closed by server");
				return;
			}
			data=new String(buffer,0,readByteCount,"UTF-8");
			System.out.println("[client] received data:"+data);

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
