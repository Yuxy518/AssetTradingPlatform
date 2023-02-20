package com.atp.backend.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: CommonUtils
 * @Author: Yuxy
 * @Description: 常见工具
 * @DateTime: 2023/2/19 17:13
 **/

public class CommonUtils {
	public static String getNowTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	public static Integer parseInt(String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			num = num * 10 + c - '0';
		}
		return num;
	}

	public static String getRandomNum(int length) {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < length; i ++){
			int x =  (int)(Math.random() * 10);
			s.append(x);
		}
		return s.toString();
	}
}
