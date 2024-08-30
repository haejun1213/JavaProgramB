package kr.ac.kopo.day02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MethodPrac {

	static String[] menu = { "1.getSum", "2.getMax", "3.getContain", "4.getReverseSort", "0.종료" };

	public static void main(String[] args) {

		boolean quit = false;
		int[] arr = getArray(inputNumber("입력할 정수의 개수 : "));
		while (!quit) {

			int select = inputNumber("메뉴 번호를 입력해 주세요 : ", menu);

			switch (select) {

			case 1 -> getSum(arr);
			case 2 -> getMax(arr);
			case 3 -> getContain(arr);
			case 4 -> getReverseSort(arr);
			case 0 -> quit = true;
			}
		}

	}

	private static void getReverseSort(int[] arr) {
	
		int temp;
		for(int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
		System.out.println(Arrays.toString(arr));
		
	}
	
	

	private static void getContain(int[] arr) {
		int n = inputNumber("기준 정수 : ");
		int count = 0;
		for (int num : arr) {
			if (num > n) {
				count++;
			}
		}
		System.out.printf(">> %d 보다 큰 수의 개수 : %d\n", n, count);

	}

	private static void getMax(int[] arr) {

		int max = arr[0];
		for (int num : arr) {
			if (max < num) {
				max = num;
			}
		}
		System.out.printf(">> 최댓값 : %d\n", max);
	}

	private static void getSum(int[] arr) {

		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		System.out.printf(">> 합계 : %d\n", sum);
	}

	private static int[] getArray(int size) {
		int[] scores = new int[size];
		StringTokenizer st;
		do {
			System.out.printf("정수 %d개를 입력하시요 : ", size);
			st = new StringTokenizer(new Scanner(System.in).nextLine(), " ");
		} while (st.countTokens() != size);
		for (int i = 0; i < scores.length; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		return scores;
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

	private static int inputNumber(String string, String[] menu) {
		Scanner sc = new Scanner(System.in);
		int num;
		try {
			do {
				showMenu(menu);
				System.out.print(string);
				num = sc.nextInt();
			} while (num >= menu.length);
		} catch (Exception e) {
			return inputNumber(string, menu);
		}
		return num;
	}

	private static void showMenu(String[] menu) {
		System.out.println("------------------------------------");
		for (String s : menu) {
			System.out.println(s);
		}
	}

}
