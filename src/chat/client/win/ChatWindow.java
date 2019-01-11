package chat.client.win;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatWindow  {
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private final String IP;
	private final int PORT;
	private final String name;

	public ChatWindow(String name,String ip,int port) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.IP=ip;
		this.PORT=port;
		this.name=name;
		
	}
	public void initStream() throws IOException {
		socket = new Socket();
		socket.connect(new InetSocketAddress(IP, PORT));
		System.out.println("[client] connected!");
		String data = null;

		br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
		pw.println("join:"+name);
	}
	
	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				char keycode = e.getKeyChar();
				if (keycode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});
		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		
		
		
		try {
			initStream();
			new Thread(new Runnable() {
				
				public void run() {
					try {
						while (br != null)
						{
							textArea.append(br.readLine()+"\n");
							textField.requestFocus();
						}
							
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}).start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private void sendMessage() {
		String message = textField.getText();
		textField.setText("");
		if(!"quit".equals(message))
		{
			message="message:"+message;
		}
			
		pw.println(message);	
		

	}
}
