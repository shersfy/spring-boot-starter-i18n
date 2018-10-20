package org.shersfy.i18n;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(I18nConfigProperties.PREFIX)
public class I18nConfigProperties {
	
	public static final String PREFIX ="i18n.config";
	
	/**
	 * Default false.
	 * Flag i18n is enabled
	 */
	private boolean enabled = false;
	
	/**
	 * Default classpath:i18n/*.properties. 
	 * messages_*.properties files location. 
	 */
	private String location = "classpath:i18n/*.properties";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}