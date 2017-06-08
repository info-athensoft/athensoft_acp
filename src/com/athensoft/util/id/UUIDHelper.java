package com.athensoft.util.id;

import java.util.UUID;

/**
 * UUID utilities
 * @author Athens
 *
 */
public class UUIDHelper {
	
	/**
	 * generate a UUID without '-' symbol
	 * @return
	 */
	public static String getUUID(){
		final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	/**
	 * generate a UUID of generation 4
	 * @return
	 */
	public static String getUUID4(){
		//TODO
		return null;
	}
	
	public static void main(String[] args){
		System.out.println(getUUID());
		System.out.println(getUUID());
		System.out.println(getUUID());
	}
}
