package org.shersfy.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 注入后即可使用
 *
 */
public class I18nMessages {
	
	private Map<String, I18nProperties> i18n;

	public I18nMessages(Map<String, I18nProperties> i18n) {
		super();
		this.i18n = i18n==null?new HashMap<>():i18n;
	}

	public Map<String, I18nProperties> getI18n() {
		return i18n;
	}
	
	public I18nProperties getI18n(String language) {
		Locale locale = Locale.CHINA;
		if("en".equalsIgnoreCase(language)
				|| "en_US".equalsIgnoreCase(language)) {
			locale = Locale.US;
		}
		return getI18n(locale.getLanguage(), locale.getCountry());
	}
	
	public I18nProperties getI18n(String language, String country) {
		Locale locale = new Locale(language, country);
		return i18n.get(locale.toString());
	}

}
