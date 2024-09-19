package kr.ac.kopo.day03;

public class Account {
	String accNum;
	String name;
	int money;

	public Account(String accNum, String name, int baseMoney) {
		this.accNum = accNum;
		this.name = name;
		this.money = baseMoney;
	}

	@Override
	public String toString() {
		return accNum + "\t" + name + "\t" + money;
	}

	public void add(int money) {
		this.money += money;

	}

	public void sub(int money) {
		this.money -= money;

	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}


}
