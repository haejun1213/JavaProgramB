package kr.ac.kopo.day02;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = 1;

		while (num != 0) {
			num = evenodd(inputNumber("숫자를 입력하세요 : "));
		}
	}

	private static int evenodd(int num) {
		System.out.println(num % 2 == 0 ? ">>짝수입니다" : "홀수입니다.");
		return inputNumber("계속 하시겠습니까? (0-멈춤/1-계속) : ");
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
