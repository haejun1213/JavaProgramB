package kr.ac.kopo.day01;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {

		int a = inputNumber("변수 a에 넣을 숫자 입력 : ");
		int b = inputNumber("변수 b에 넣을 숫자 입력 : ");

		int temp = a;
		a = b;
		b = temp;

		showSwap(a, b);
	}

	private static void showSwap(int a, int b) {

		System.out.println("Swapping 결과 >");
		System.out.println("변수 a의 값 = " + a);
		System.out.println("변수 b의 값 = " + b);
	}

	private static int inputNumber(String string) {
		System.out.print(string);
		Scanner sc = new Scanner(System.in);
		int num;
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			return inputNumber(string);
		}
		return num;
	}
}
