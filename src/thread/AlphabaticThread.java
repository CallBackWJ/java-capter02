package thread;

public class AlphabaticThread extends Thread {

	public void run()
	{
		for(char c='a';c<='z';c++)
		{
			System.out.println("["+Thread.currentThread().getId()+"]"+c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
