package kr.ac.kopo.day01;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {

		float rkfh = inputNumber("직사각형의 가로 길이 : ");
		float tpfh = inputNumber("직사각형의 세로 길이 : ");
		showRec(calcRec(rkfh, tpfh));

	}

	private static void showRec(float res) {
		System.out.printf("직사각형의 넓이는 %.1fcm입니다.", res);

	}

	private static float calcRec(float rkfh, float tpfh) {

		return rkfh * tpfh;
	}

	private static float inputNumber(String string) {
		System.out.print(string);
		Scanner sc = new Scanner(System.in);
		float num;
		try {
			num = sc.nextFloat();
		} catch (Exception e) {
			return inputNumber(string);
		}
		return num;
	}

}
