package kr.ac.kopo.day01;

import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) {

		double radius = inputNumber("원의 반지름을 입력하세요(cm) : ");
		showCir(calcCir(radius));
	}

	private static void showCir(double res) {
		System.out.printf("원의 넓이는 %.2fcm입니다.", res);
	}

	private static double calcCir(double radius) {

		final double PI = 3.14;
		return radius * radius * PI;
	}

	private static double inputNumber(String string) {
		System.out.print(string);
		Scanner sc = new Scanner(System.in);
		double num;
		try {
			num = sc.nextDouble();
		} catch (Exception e) {
			return inputNumber(string);
		}
		return num;
	}
}
