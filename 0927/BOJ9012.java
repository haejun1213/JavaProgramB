package test;

import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < time; i++) {
			Stack<Character> stk = new Stack<>();
			boolean isVPS = true;
			char[] chars = sc.nextLine().toCharArray();
			x: for (char c : chars) {
				if (c == '(') {
					stk.push(c);
				} else {
					if (stk.size() != 0) {
						stk.pop();
					} else {
						isVPS = false;
						break x;
					}
				}
			}

			if (stk.size() != 0)
				isVPS = false;

			System.out.println(isVPS ? "YES" : "NO");
		}
	}
}
