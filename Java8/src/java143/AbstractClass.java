package java143;

public abstract class AbstractClass {

	public AbstractClass() {
		super();
		System.out.println("You can create constructor abstract class");
	}

	abstract int add(int a, int b);

	int sub(int a, int b) {
		return a + b;
	}

	static int multiply(int a, int b) {
		return a * b;
	}
}
