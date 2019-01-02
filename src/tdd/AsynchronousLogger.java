package tdd;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsynchronousLogger {

	private List messages = Collections.synchronizedList(new ArrayList());
	private Thread t;
	private boolean running = false;
	private int logged = 0;
	private PrintStream logStream;

	public AsynchronousLogger(PrintStream stream) {
		// TODO Auto-generated constructor stub
		logStream = stream;
		running = true;
		t = new Thread(new LoggerThread());
		t.setPriority(Thread.NORM_PRIORITY - 3);
		t.start();
	}

	private void mainLoggerLoop() {
		// TODO Auto-generated method stub
		while (running) {
			logQueuedMassages();
			sleepTillMoreMessagesQueued();
		}
	}

	private void logQueuedMassages() {
		// TODO Auto-generated method stub
		while (messagesInQuese() > 0)
			logOneMessage();
	}

	private void logOneMessage() {
		// TODO Auto-generated method stub
		String msg;
		msg = (String) messages.remove(0);
		logStream.println(msg);
		logged++;
	}

	private void sleepTillMoreMessagesQueued() {
		// TODO Auto-generated method stub

		try {
			synchronized (messages) {
				messages.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	private int messagesInQuese() {
		// TODO Auto-generated method stub
		return 0;
	}

	private class LoggerThread implements Runnable {
		public void run() {
			mainLoggerLoop();
		}
	}

	public void stop() throws InterruptedException {
		// TODO Auto-generated method stub
		running=false;
		wakeLoggerThread();
		t.join();
	}

	public void logMessage(String msg) {
		// TODO Auto-generated method stub

		messages.add(msg);
		wakeLoggerThread();
	}

	private void wakeLoggerThread() {
		// TODO Auto-generated method stub
		synchronized (messages) {
		messages.notifyAll();	
		}
	}

	public Object messagesInQueue() {
		// TODO Auto-generated method stub
		return messages.size();
	}

	public Object messagesLogged() {
		// TODO Auto-generated method stub
		return logged;
	}

}
