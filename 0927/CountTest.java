package kr.ac.kopo.day05;

public class CountTest {

	public static void main(String[] args) {

		Countable1[] objs = { new Bird1("뻐꾸기", 5), new Bird1("독수리", 2), new Tree1("사과나무", 10), new Tree1("밤나무", 7) };


		for (Countable1 obj : objs) {
			obj.count();
		}

		
		for (Countable1 obj : objs) {
			if (obj instanceof Bird1) {
				((Bird1)obj).fly();
			} else {
				((Tree1)obj).ripen();
			}
		}

	}
}
