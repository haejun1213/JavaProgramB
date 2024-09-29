package test;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class BOJ1966 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int docs = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			Queue<int[]> que = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					return Integer.compare(b, a);
				}
			});

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < docs; j++) {
				int v = Integer.parseInt(st.nextToken());
				que.add(new int[] { j, v });
				pq.add(v);
			}

			int count = 0;
			while (true) {
				int[] current = que.poll();

				if (pq.peek() == current[1]) {
					pq.poll();
					count++;
					if (current[0] == target) {
						System.out.println(count);
						break;
					}
				} else {
					que.add(current);
				}
			}
		}
	}
}
