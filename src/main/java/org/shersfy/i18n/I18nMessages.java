package org.shersfy.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class I18nMessages {
	
	private Map<String, I18nProperties> i18n;

	public I18nMessages(Map<String, I18nProperties> i18n) {
		super();
		this.i18n = i18n==null?new HashMap<>():i18n;
	}

	public Map<String, I18nProperties> getI18n() {
		return i18n;
	}
	
	public I18nProperties getI18n(String language, String country) {
		Locale locale = new Locale(language, country);
		return i18n.get(locale.toString());
	}

}
