package controller;

import java.util.Date;

import net.sf.json.JSONObject;

public class Test {
	
	
	
	public static void main(String[] args) {
		
		Date date = new Date();
		
		System.out.println(JSONObject.fromObject(date));
		
	}
}
