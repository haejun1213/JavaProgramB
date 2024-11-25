package kr.ac.kopo.ch14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ex01 {
	public static void main(String[] args) {
		
		//class
		Thread t = new Thread(new MyRunnable2());
		t.start();
		
		//ThreadPool
		Runnable task = () -> {
			for(int i = 0; i < 5; i++) {
				System.out.println("스레드 풀 타이머 : " + i);
				try {
					Thread.sleep(1000);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		};
		
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(task);
		
	}
}

class MyRunnable2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Runnable 구현 타이머 : " + i);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
