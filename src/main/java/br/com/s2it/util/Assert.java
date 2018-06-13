package br.com.s2it.util;

public class Assert {

	public static boolean isNotNull(final Object param){
		return param != null;
	}

	public static boolean isNull(final Object param){
		return param == null;
	}
}
