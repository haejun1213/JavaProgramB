package kr.ac.kopo.day04;

public class OverridingTest {

	public static void main(String[] args) {

		Circle circle = new Circle(5.0);
		System.out.println(">>> 원 : ");
		System.out.println("반지름 : " + circle.getRadius());
		System.out.println("면적 : " + circle.getArea());

		Ball ball = new Ball(5.0);
		System.out.println("\n>>> 공 : ");
		System.out.println("반지름 : " + ball.getRadius());
		System.out.println("면적 : " + ball.getArea());

		Cylinder cylinder = new Cylinder(5.0, 7.0);
		System.out.println("\n>>> 원기둥 : ");
		System.out.println("반지름 : " + cylinder.getRadius());
		System.out.println("높이 : " + cylinder.getHeight());
		System.out.println("면적 : " + cylinder.getArea());
	}

}
