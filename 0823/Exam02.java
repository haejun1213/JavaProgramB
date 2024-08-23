package kr.ac.kopo.day01;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		int num = inputNumber("정수를 입력하세요 : ");
		evenOddShow(num);
	}

	private static void evenOddShow(int num) {
		System.out.println(num % 2 == 0 ? "짝수" : "홀수");
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
