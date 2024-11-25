package kr.ac.kopo.ch14;

import java.util.Scanner;

public class ex02 {
	public static void main(String[] args) {
		
		Worker2 worker = new Worker2();
		worker.start();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			if(sc.nextLine().equals("1")) {
				worker.interrupt();
				break;
			}
		}
	}

}

class Worker2 extends Thread {
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("작업 실행 중...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("작업이 종료되었습니다.");
				break;
			}
			
		}
	}
	
}
