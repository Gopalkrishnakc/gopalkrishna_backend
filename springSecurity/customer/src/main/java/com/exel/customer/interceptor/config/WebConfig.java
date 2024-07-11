//package com.exel.customer.interceptor.config;
//
////import java.util.Locale;
//
////import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
////import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//
//@Configuration
//@ComponentScan
//public class WebConfig implements WebMvcConfigurer{
//	@Autowired
//	AuthenticatorInterceptor authenticatorInterceptor;
// @Override
//public void addInterceptors(InterceptorRegistry registry) {
//
//	registry.addInterceptor( authenticatorInterceptor ).addPathPatterns("/api/customer/**");
//}
//}
//// @Bean
////  LocaleResolver localeResolver() {
////	SessionLocaleResolver slr = new SessionLocaleResolver();
////	slr.setDefaultLocale(Locale.ENGLISH);
////	return (LocaleResolver) slr;
//// }
//}
