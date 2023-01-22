package com.ak.dyanamic;

public class Demo {
	private int a = 10;
	private int b = 20;

	public Demo() {
		System.out.println("Demo :: 0 param constructor");
	}

	public Demo(int a, int b) {

		super();
		System.out.println("Demo ::2 param constructor");
		this.a = a;
		this.b = b;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method");
		super.finalize();
	}

	@Override
	public String toString() {
		return "Demo [a=" + a + ", b=" + b + "]";
	}

}
