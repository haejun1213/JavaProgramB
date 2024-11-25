package kr.ac.kopo.ch14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class chall_ex03 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Runnable task = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			exec.shutdown();
		};

		exec.execute(task);
		int alphabet = 'a';
		int i = 0;
		while (!exec.isShutdown()) {
			System.out.println((char) (alphabet + i));
			i += 1;
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
