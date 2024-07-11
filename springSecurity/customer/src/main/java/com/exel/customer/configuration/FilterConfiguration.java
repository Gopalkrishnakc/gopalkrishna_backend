//package com.exel.customer.configuration;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//////
//import com.exel.customer.filters.AdminFilter;
////import com.exel.customer.filters.CustomerFilters;
//
//@Configuration
//public class FilterConfiguration {
//
////	@Bean
////	 FilterRegistrationBean<CustomerFilters> registerBean(){
////		FilterRegistrationBean<CustomerFilters> registerBean= new FilterRegistrationBean<CustomerFilters>();
////		registerBean.setFilter(new CustomerFilters());
////		registerBean.addUrlPatterns("/api/customer");
////		return registerBean;
////	}
//	@Bean
//	public FilterRegistrationBean<AdminFilter> registerBean(){
//		FilterRegistrationBean<AdminFilter> registerBean= new FilterRegistrationBean<AdminFilter>();
//		registerBean.setFilter(new AdminFilter());
//		registerBean.addUrlPatterns("/admin/");
//		return registerBean;
//	}
//}
