package com.douzone.paint.point;

public class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	public ColorPoint()
	{
		
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println("점 [ X=" + getX() + ", Y=" + getY() + ",Color=" + color + " ]을 그렸습니다.");
	}

	@Override
	public void show(boolean visible) {
		if (visible)
			show();
		else
			System.out.println("점 [  X=" + getX() + ", Y=" + getY() + ",Color=" + color + "  ]을 지웠습니다.");
	}

}
