package kr.ac.kopo.ch14;

public class chall_ex02 {
	
	public static void main(String[] args) {
		int alphabet = 'a';
		Thread t = new Thread(new MyRunnable());
		t.start();
		for(int i = 0; i < 100; i++) {
			if(!t.isAlive()) break;
			try {
				System.out.println("메인 스레드 : " + (char)(alphabet + i));
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyRunnable implements Runnable {
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
	}
	
}
