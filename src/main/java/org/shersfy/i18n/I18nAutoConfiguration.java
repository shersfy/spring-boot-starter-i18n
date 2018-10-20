package org.shersfy.i18n;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
@EnableConfigurationProperties(I18nProperties.class)
public class I18nAutoConfiguration {
	
	@Autowired
	private I18nProperties config;
	
	@Bean
	@ConditionalOnProperty(prefix=I18nProperties.PREFIX, value="enabled", havingValue="true")
	public I18nMessages i18nMessages() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] arr = resolver.getResources(config.getLocation());
		Map<String, Properties> map = new HashMap<>();
		for (Resource res :arr) {
			String[] names = FilenameUtils.getBaseName(res.getFilename()).split("_");
			if (names.length!=3) {
				continue;
			}
			Properties prop = new Properties();
			prop.load(res.getInputStream());
			res.getInputStream().close();
			map.put(new Locale(names[1], names[2]).toString(), prop);
		}
		return new I18nMessages(map);
	}
}
