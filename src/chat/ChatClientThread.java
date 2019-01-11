package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;

	public ChatClientThread(BufferedReader bufferedReader)
	{
		this.bufferedReader=bufferedReader;
	}
	public void run()
	{
		
			try {
				while(bufferedReader!=null)
				System.out.println(bufferedReader.readLine());
			} catch (IOException e) {
				System.out.println(e);
			}
		
	}
}
