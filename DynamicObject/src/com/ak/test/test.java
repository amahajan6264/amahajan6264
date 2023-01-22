package com.ak.test;

import java.lang.reflect.Constructor;

public class test {

	public static void main(String[] args) {
//		try {
//			// get load into the jvm java.lang.class
//			Class c = Class.forName(args[0]);
//			// create the object this class
//			Object obj = c.newInstance();
//			// Demo d=(Demo)obj;
//			System.out.println("demo " + obj);
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//			e.printStackTrace();
//		}
		try {
			// load the class into java.lang.Class
			Class c = Class.forName(args[0]);
			// get the constructor available class
			Constructor con[] = c.getConstructors();
			Object obj = con[0].newInstance();
			System.out.println(obj);
			Object obj1 = con[1].newInstance(45, 34);
			System.out.println(obj1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
