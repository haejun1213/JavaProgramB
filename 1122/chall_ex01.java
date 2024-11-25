package kr.ac.kopo.ch14;

public class chall_ex01 {
	
	public static void main(String[] args) {
		int alphabet = 'a';
		
		Worker worker = new Worker();
		worker.start();
		for(int i = 0; i < 100; i++) {
			if(worker.isInterrupted()) break;
			try {
				System.out.println("메인 스레드 : " + (char)(alphabet + i));
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Worker extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			try {
				System.out.println("작업 스레드 : " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		interrupt();
	}
	
}
