package kr.ac.kopo.ch14;

class Echo {

	public void echo(String msg) {
		for (int i = 0; i < 3; i++) {
			System.out.println(msg);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class NonSyncEchoer extends Thread {
	private String msg;
	Echo echo = new Echo();

	public NonSyncEchoer(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		echo.echo(msg);
	}
}

class SyncEchoer extends Thread {
	private String msg;
	static Echo echo = new Echo();

	public SyncEchoer(String msg) {
		this.msg = msg;
	}

	// run() 메서드
	@Override
	public void run() {
		synchronized (echo) {
			echo.echo(msg);
			echo.notify();
			try {
				echo.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ex04 {
	public static void main(String[] args) {
		
		//nonSycnEcho();
		sycnEcho();
	}
	
	public static void nonSycnEcho() {
		NonSyncEchoer p1 = new NonSyncEchoer("환영");
		NonSyncEchoer p2 = new NonSyncEchoer("야호~~~");
		NonSyncEchoer p3 = new NonSyncEchoer("자바");

		p1.start();
		p2.start();
		p3.start();

	}
	
	public static void sycnEcho() {
		SyncEchoer p1 = new SyncEchoer("환영");
		SyncEchoer p2 = new SyncEchoer("자바");
		SyncEchoer p3 = new SyncEchoer("야호~~~");

		p1.start();
		p2.start();
		p3.start();
	}
}