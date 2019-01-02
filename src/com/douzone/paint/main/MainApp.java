package paint;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point p1 = new Point();
		p1.setX(100);
		p1.setY(200);

		drawPoint(p1);

		Point p2 = new Point(50, 50);
		drawPoint(p2);

		Point p3 = new ColorPoint();
		p3.setX(100);
		p3.setY(50);
		((ColorPoint) p3).setColor("Red");
		drawPoint(p3);

		Shape triangle = new Triangle();
		draw(triangle);
		Shape rect=new Rect();
		draw(rect);
		Shape circle=new Circle();
		draw(circle);
	}

	public static void draw(Shape s)
	{
		s.draw();
	}
	public static void drawPoint(Point point) {
		point.show();
	}

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
