package kr.ac.kopo.day03;

public class exam02 {

	public static void main(String[] args) {
		Cat cat = new Cat("코숏", "노랑", 6);
		
		System.out.println("나의 고양이는 "+ cat.getColor() + " " + cat.getBreed() + "입니다.");
		cat.eat("아침");
		cat.meow();
		System.out.println();
		cat.eat("점심");
		cat.scratch();
		cat.meow();
		
	}

}

class Cat{
	
	private String breed;
	private String color;
	private int age;

	public Cat(String breed, String color, int age) {
		this.breed = breed;
		this.color = color;
		this.age = age;
	}

	public Cat(String breed, String color) {
		this.breed = breed;
		this.color = color;
	}

	public Cat(String breed) {
		this.breed = breed;
	}

	public void eat(String time){
		System.out.println(time + "에 사료를 먹습니다.");
	}
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void meow(){
		System.out.println("야옹~");
	}
	public void scratch(){
		System.out.println("스크래치를 긁습니다.");
	}
	
	
}