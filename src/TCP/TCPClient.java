package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPClient {

	private static final String SERVER_IP = "192.168.0.70";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		// 1.소켓생성
		Socket socket = null;
		try {
			socket = new Socket();

			//1.1 소켓 버퍼 사이즈 확인
			int receiveBufferSize=socket.getReceiveBufferSize();
			int sendBufferSize=socket.getSendBufferSize();
			System.out.println(receiveBufferSize+":"+sendBufferSize);
			
			//1.2 버퍼사이즈 변경
			socket.setReceiveBufferSize(1024*10);
			socket.setSendBufferSize(1024*10);
			
			
			//1.3 소켓 버퍼 사이즈 재확인
			receiveBufferSize=socket.getReceiveBufferSize();
			sendBufferSize=socket.getSendBufferSize();
			System.out.println(receiveBufferSize+":"+sendBufferSize);
			
			//1.4  SO_NODELAY  ==> nagle algorithm off
			socket.setTcpNoDelay(true);
			
			//1.5 SO_TIMEOUT
			socket.setSoTimeout(2000);// read 에서의 타임 아웃 설정
			
			
			
			
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

		}catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("socket time out exception!!!");
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
