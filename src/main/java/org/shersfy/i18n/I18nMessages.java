package org.shersfy.i18n;

import java.util.Map;
import java.util.Properties;

public class I18nMessages {
	
	private Map<String, Properties> i18n;

	public I18nMessages(Map<String, Properties> i18n) {
		super();
		this.i18n = i18n;
	}

	public Map<String, Properties> getI18n() {
		return i18n;
	}

}
