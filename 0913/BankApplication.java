package kr.ac.kopo.day03;

import java.util.Scanner;

public class BankApplication {

	static String[] menu = { "1.계좌생성", "2.계좌목록", "3.예금", "4.출금", "0.종료" };
	static int accountNo = 0;
	static Account[] accountList = new Account[100];

	public static void main(String[] args) {

		boolean quit = false;
		while (!quit) {

			int select = inputNumber("선택>> ", menu);

			switch (select) {

			case 1 -> createAccount();
			case 2 -> accountList();
			case 3 -> deposit();
			case 4 -> withdraw();
			case 0 -> quit = true;
			}
		}

	}

	private static void withdraw() {
		System.out.println("-----------");
		System.out.println("출금");
		System.out.println("-----------");

		Scanner sc = new Scanner(System.in);

		System.out.print("계좌번호 : ");
		String accNum = sc.nextLine();
		for (int i = 0; i < accountNo; i++) {
			if(accountList[i].getAccNum().equals(accNum)) {
				
				System.out.print("출금액 : ");
				int money = sc.nextInt();
				accountList[i].sub(money);
				break;
			}
		}
		
	}

	private static void deposit() {
		System.out.println("-----------");
		System.out.println("예금");
		System.out.println("-----------");

		Scanner sc = new Scanner(System.in);

		System.out.print("계좌번호 : ");
		String accNum = sc.nextLine();
		for (int i = 0; i < accountNo; i++) {
			if(accountList[i].getAccNum().equals(accNum)) {
				
				System.out.print("예금액 : ");
				int money = sc.nextInt();
				accountList[i].add(money);
				break;
			}
		}
		
	}

	private static void accountList() {
		System.out.println("-----------");
		System.out.println("계좌목록");
		System.out.println("-----------");
		for (int i = 0; i < accountNo; i++) {
			System.out.println(accountList[i].toString());
		}
	}

	private static void createAccount() {
		System.out.println("-----------");
		System.out.println("계좌생성");
		System.out.println("-----------");
		Scanner sc = new Scanner(System.in);

		System.out.print("계좌번호 : ");
		String accNum = sc.nextLine();
		System.out.print("계좌주 : ");
		String name = sc.nextLine();
		System.out.print("초기입금액 : ");
		int baseMoney = sc.nextInt();

		accountList[accountNo++] = new Account(accNum, name, baseMoney);

		System.out.println("결과: 계좌가 생성되었습니다.");
	}

	private static void showMenu(String[] menu) {
		System.out.println("------------------------------------");
		for (String s : menu) {
			System.out.print(s + "|");

		}
		System.out.println();
		System.out.println("------------------------------------");

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

}
