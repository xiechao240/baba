package com.baba.common.utils;

import java.util.UUID;

/**
 * UUID生成工具
 * 
 * @author Administrator
 * 
 */
public class UUIDGeneratorUtils {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		return str.replaceAll("-", "");
	}

	

	

	 public static void main(String[] args) {
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 System.out.println(getUUID());
		 //System.out.println(getKey(211));
	 }
}
