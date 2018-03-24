package com.simonton.camel.router.utils;

import java.nio.charset.Charset;

import org.apache.http.entity.ContentType;

public class ContentTypeUtils {
	
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public static String textPlain() {
		return ContentType.TEXT_PLAIN.withCharset(DEFAULT_CHARSET).toString();
	}
	
	public static String jsonPlain() {
		return ContentType.APPLICATION_JSON.withCharset(DEFAULT_CHARSET).toString();
	}
}
