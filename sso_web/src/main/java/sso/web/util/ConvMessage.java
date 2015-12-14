package sso.web.util;
import java.nio.charset.Charset;

import org.springframework.http.converter.StringHttpMessageConverter;


public class ConvMessage extends StringHttpMessageConverter {

	public static final Charset DEFAULT_CHARSET_UTF8 = Charset.forName("UTF-8");

	public ConvMessage() {
		super(DEFAULT_CHARSET_UTF8);
	}
}
