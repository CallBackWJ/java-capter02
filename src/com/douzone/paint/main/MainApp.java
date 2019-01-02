package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.i.Shape;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicString;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point p1 = new Point();
		p1.setX(100);
		p1.setY(200);

		draw(p1);

		Point p2 = new Point(50, 50);
		draw(p2);

		Point p3 = new ColorPoint();
		p3.setX(100);
		p3.setY(50);
		((ColorPoint) p3).setColor("Red");
		draw(p3);
		
		Point p4=new ColorPoint(200,100,"Yellow");
		draw(p4);

		Shape triangle = new Triangle();
		draw(triangle);
		Shape rect=new Rect();
		draw(rect);
		Shape circle=new Circle();
		draw(circle);
		draw(new GraphicString("Hello"));
		
		Shape s=new Circle();
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);
	
		Circle c=(Circle)s;
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Object);

		
	}

	public static void draw(Drawable s)
	{
		s.draw();
	}
//	public static void drawPoint(Point point) {
//		point.show();
//	}

//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	public static void drawCircle(Circle circle)
//	{
//		circle.draw();
//	}
}
