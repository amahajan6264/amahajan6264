package com.ak.dyna;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.ak.servlet.MarrigeApplication;

public class MyWebAppInitializer implements ServletContainerInitializer {
	static {
		System.out.println("static block of MyWebAppInitializer class");
	}

	public MyWebAppInitializer() {
		System.out.println("0 param constructor");
	}

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		// create User-defined Servlet class object
		MarrigeApplication mp = new MarrigeApplication();
		System.out.println("MyWebAppInitializer.onstartup(-,-)");
		// register with container
		ServletRegistration.Dynamic dynamic = ctx.addServlet("marrige", mp);
		// enable load on startup
		dynamic.setLoadOnStartup(1);
		// add url pattern
		dynamic.addMapping("/marrigeurl");
	}

}
