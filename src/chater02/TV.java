package chater02;

public class TV {

	private boolean power;
	private int channel;
	private int volume;
	private final int MAX_CHANNEL = 50;
	private final int MAX_VOLUME = 50;

	public TV() {

	}

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;

	}

	public void power(boolean power) {
		this.power = power;
	}

	public void channel(int channel) {
		if (power)
		{
			if (channel > MAX_CHANNEL)
			{
				channel = 0;
			}else if(channel< 0)
			{
				channel =50;
			}
			this.channel=channel;
		}
	}

	public void channel(boolean up) {
		if (up)
			channel(channel + 1);
		else
			channel(channel - 1);
	}

	public void volume(int volume) {
		if (power)
		{
			if (volume > MAX_VOLUME)
			{
				volume = 0;
			}else if(volume< 0)
			{
				volume =50;
			}
			this.volume=volume;
		}
	}

	public void volume(boolean up) {
		if (up)
			volume(volume + 1);
		else
			volume(volume - 1);
	}

	public void status() {
		System.out.println("TV[power = " + power + ", channel =" + channel + ", volume" + volume + " ]");
	}

}
