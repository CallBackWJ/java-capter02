package chat.client.win;

import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "192.168.0.70";
	private static final int SERVER_PORT = 5000;

	public String join() {

		String name = null;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = sc.nextLine();
			if (name.isEmpty() == false) {
				break;
			}
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		return name;
	}

	public void chat() {
		new ChatWindow(join(), SERVER_IP, SERVER_PORT).show();
	}

	public static void main(String[] args) {

		new ChatClientApp().chat();
	}

}
