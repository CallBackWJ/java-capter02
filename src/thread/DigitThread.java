package thread;

public class DigitThread extends Thread{
	@Override
	public void run()
	{
		for(int i=0; i<=9;i++)
		{
			System.out.println("["+getId()+"] "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
		Thread diThread=new DigitThread();

		diThread.start();
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
