package tdd;

import junit.framework.TestCase;
import junit.textui.TestRunner;
public class TestLog extends TestCase {

	private AsynchronousLogger logger;
	private int messagesLogged;
	public static void main(String[] args)
	{
		TestRunner.main(new String[]{"tdd.TestLog"});
	}
	public TestLog(String name)
	{
		super(name); 
	}
	
	protected void setUp() throws Exception
	{
		logger=new AsynchronousLogger(System.out);
		pause();
	}
	protected void tearDown() throws Exception
	{
		logger.stop();
	}
	public void testOneMessage() throws Exception
	{
		logger.logMessage("the message");
		checkMessagesFlowToLog(1);
	}
	
	public void testTweConsecutiveMessages() throws Exception
	{
		logger.logMessage("another");
		logger.logMessage("and another");
		checkMessagesFlowToLog(2);
	}
	
	public void testManyMessages() throws Exception
	{
		for(int i=0; i<10;i++)
		{
			logger.logMessage("message:"+ i);
			checkMessagesFlowToLog(1);
		}
	}
	
	
	private void checkMessagesFlowToLog(int queued) throws Exception{
		checkQueuedAndLogged(queued,messagesLogged);
		pause();
		messagesLogged+=queued;
		checkQueuedAndLogged(0, messagesLogged);
	}
	private void checkQueuedAndLogged(int queued, int logged) {
		assertEquals(queued, logger.messagesInQueue());
		assertEquals(logged, logger.messagesLogged());
	}
	private void pause() throws Exception {
		Thread.sleep(50);
	}
	
	
	
}
