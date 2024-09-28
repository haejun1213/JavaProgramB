package kr.ac.kopo.day05;

public class Bird1 implements Countable1 {

	private String name;
	private int count;
	
	public Bird1(String name, int count) {
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

	@Override
	public void count() {
		System.out.printf("%s가 %d마리 있다.\n",name,count);
	}

	public void fly() {
		System.out.println(count + "마리 " + name + "가 날아간다.");
	}
}
