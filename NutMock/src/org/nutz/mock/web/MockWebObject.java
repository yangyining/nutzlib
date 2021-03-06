package org.nutz.mock.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import org.nutz.mock.MockObject;

public class MockWebObject extends MockObject{
	
	private Map<String, String> initParameterMap = new HashMap<String, String>();
	
	private ServletContext servletContext;
	
	public String getInitParameter(String key) {
		return initParameterMap.get(key);
	}

	public Enumeration<String> getInitParameterNames() {
		return new Vector<String>(initParameterMap.keySet()).elements();
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void addInitParameter(String key,String value){
		initParameterMap.put(key, value);
	}
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
