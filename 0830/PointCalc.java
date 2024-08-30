package kr.ac.kopo.day02;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PointCalc {

	public static void main(String[] args) {

		int numStudent = getNumberKeyboard("학생 수 : ");
		int[] scores = getScoresLine(numStudent);
		printSumAverage(scores);

	}

	private static void printSumAverage(int[] scores) {

		int sum = 0;

		for (int num : scores) {
			sum += num;
		}

		System.out.println(">> 합계 : " + sum);
		System.out.println(">> 평균 : " + sum / scores.length);
	}

	private static int[] getScoresLine(int numStudent) {
		int[] scores = new int[numStudent];
		System.out.printf("%d명의 성적 : ", numStudent);
		StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine(), " ");

		for (int i = 0; i < scores.length; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		return scores;
	}

	private static int getNumberKeyboard(String string) {
		System.out.print(string);
		Scanner sc = new Scanner(System.in);
		int num;
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			return getNumberKeyboard(string);
		}
		return num;
	}

}
