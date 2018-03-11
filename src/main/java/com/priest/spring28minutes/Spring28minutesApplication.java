package com.priest.spring28minutes;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class Spring28minutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring28minutesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSourceResourceBundle() {
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("/messages");
		return bundleMessageSource;
	}
}
