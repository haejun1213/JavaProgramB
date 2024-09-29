package test;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int size = sc.nextInt();
		sc.nextLine();
		Stack<Integer> stk = new Stack<>();

		int cnt = 0;
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}
		stk.push(1);
		sb.append("+\n");
		for (int i = 0, num = 1; i < size; i++) {
			if (stk.size() == 0) {
				if (size > num) {
					stk.push(++num);
					sb.append("+\n");
				}
			}
			while (nums[i] > stk.peek()) {
				stk.push(++num);
				sb.append("+\n");
			}
			if (nums[i] == stk.peek()) {
				stk.pop();
				cnt++;
				sb.append("-\n");
			}

		}
		if (cnt == size) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}