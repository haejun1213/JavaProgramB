package kr.ac.kopo.ch14;

import java.util.Random;

class NumAndSum {
	static private int sum = 0;
	static private int i = 0;

	public static int getSum() {
		return sum;
	}

	public static void setSum(int sum) {
		NumAndSum.sum = sum;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		NumAndSum.i = i;
	}
}

class Accumulator extends Thread {
	private int cnt;
	private Random r = new Random();
	private static NumAndSum ns = new NumAndSum();

	public Accumulator(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public void run() {
		synchronized (ns) {
			while (NumAndSum.getI() < cnt) {
				int num = r.nextInt(10);
				int sum = num + NumAndSum.getSum();
				NumAndSum.setSum(sum);
				NumAndSum.setI(NumAndSum.getI() + 1);

				System.out.println(Thread.currentThread().getName() + " : " + num);

				ns.notify();
				try {
					if (NumAndSum.getI() < cnt) {
						ns.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			ns.notifyAll();
		}
	}
}

public class ex03 {

	public static void main(String[] args) {
		Accumulator ac1 = new Accumulator(5);
		Accumulator ac2 = new Accumulator(5);
		ac1.setName("Thread-01");
		ac2.setName("Thread-02");
		ac1.start();
		ac2.start();

		try {
			ac1.join();
			ac2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("누적 값 : " + NumAndSum.getSum());
	}
}
