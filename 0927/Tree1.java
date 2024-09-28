package kr.ac.kopo.day05;

public class Tree1 implements Countable1 {

	public Tree1(String name, int count) {
		this.name = name;
		this.count = count;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	private String name;
	private int count;
	
	
	@Override
	public void count() {
		System.out.printf("%s가 %d그루 있다.\n",name,count);
	}

	public void ripen() {
		System.out.println(count + "그루 " + name + "에 열매가 잘 익었다.");
	}
}
