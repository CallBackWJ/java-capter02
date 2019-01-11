package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	BufferedReader bufferedReader;
	PrintWriter printWriter;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.listWriters = listWriters;
		this.nickname = null;
		this.bufferedReader = null;
		this.printWriter = null;
	}

	@Override
	public void run() {

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			// 3. 요청 처리
			while (true) {
				String request = bufferedReader.readLine();
				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(printWriter);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");

				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch (IOException e) {
			ChatServer.log("IO에러:" + e);

		} finally {
			try {
				if (socket != null && socket.isClosed() == false)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void doJoin(String nickName, PrintWriter writer) {
		this.nickname = nickName;

		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);

		/* writer pool에 저장 */
		addWriter(writer);

		// ack
		writer.println("채팅방에 오신것을 환영합니다.");
		writer.flush();
	}

	private void broadcast(String data) {

		synchronized (listWriters) {

			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}

		}

	}

	private void doMessage(String message) {

		/* 잘 구현 해 보기 */
		broadcast(nickname+":"+message);

	}

	private void doQuit(Writer writer) {
		
		if(removeWriter(writer))
		{
			String data = nickname + "님이 퇴장 하였습니다.";
			broadcast(data);
		}

		
	}

	private boolean removeWriter(Writer writer) {
		synchronized (listWriters) {
			return listWriters.remove(writer);
		}
		/* 잘 구현 해보기 */
		
	}

}
