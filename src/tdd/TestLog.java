package tdd;

import junit.framework.TestCase;
import junit.textui.TestRunner;

public class TestLog extends TestCase {

	private AsynchronousLogger logger;
	private int messagesLogged;
	public static void main(String[] args)
	{
		TestRunner.main(new String[]{"TestLog"});
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
	
	
	private void checkMessagesFlowToLog(int i) throws Exception{
		// TODO Auto-generated method stub
		
	}
	private void pause() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
