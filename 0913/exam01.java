package kr.ac.kopo.day03;

import java.util.Scanner;

public class exam01 {
	public static void main(String[] args) {
		System.out.print("원의 반지름 : ");
		Circle circle = new Circle(new Scanner(System.in).nextDouble());
		System.out.printf("반지름이 %.1f인 원의 넓이는 %.2f입니다.",circle.getRadius() ,circle.calc());
		 
	}
}

class Circle{
	
	static final double PI = 3.14;
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double calc() {
		return radius * radius * PI;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
}