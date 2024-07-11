//package com.exel.customer.filters;
//
//import java.io.IOException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//@Component
//public class AdminFilter implements Filter {
////
////	@Override
////	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
////			throws IOException, ServletException {
////		// TODO Auto-generated method stub
////		
////	}
//	
//
//	
//		 Logger LOGGER = LoggerFactory.getLogger(AdminFilter.class);
//
//		@Override
//		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//				throws IOException, ServletException {
//
//			LOGGER.info("(AdminFilter)-->Inside doFilter Method");
//			 HttpServletRequest req = (HttpServletRequest) request;
//				LOGGER.info("Port: "+ req.getLocalPort());
//				LOGGER.info("Method Name: "+ req.getMethod());
//				LOGGER.info("Request URI: "+ req.getRequestURI());
//				LOGGER.info("Servelt Path: "+ req.getServletPath());
//
//			chain.doFilter(request, response);
//			
//		}
//
//	}
//
