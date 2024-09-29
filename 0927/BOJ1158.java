package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Queue<Integer> que = new LinkedList<>();
		int size = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < size; i++) {
			que.offer(i + 1);
		}
		bw.write("<");
		for (int i = 0; i < size - 1; i++) {

			for (int j = 1; j < K; j++) {
				que.offer(que.poll());
			}
			bw.write(que.poll() + ", ");
		}

		bw.write(que.poll() + ">");
		bw.flush();
		bw.close();
		br.close();
	}

}