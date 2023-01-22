package java143;

public class TestJava8FeatureAbstractClass extends AbstractClass {
	public int add(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		TestJava8FeatureAbstractClass test = new TestJava8FeatureAbstractClass();
		System.out.println("Addition      : " + test.add(45, 23));
		System.out.println("Subtraction   : " + test.sub(45, 23));
		System.out.println("multplication : " + test.multiply(45, 23));

	}

}
