//package com.exel.customer.interceptor.config;
//
////import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
////import org.springframework.web.servlet.ModelAndView;
//
////import io.micrometer.common.util.StringUtils;
//
//import org.slf4j.Logger;
//
//import org.slf4j.LoggerFactory;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component("authenticationInterceptor")
//public class AuthenticatorInterceptor implements HandlerInterceptor {
//	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticatorInterceptor.class);
//	private static final String VALID_USERNAME = "ullas@gmail.com";
//	private static final String VALID_PASSWORD = "Ullas@76";
//
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		System.out.println("PreHandler");
//		String authHeader = request.getHeader("Authorization");
//
//		System.out.println(authHeader);  
//		LOGGER.info("");
//                  
//		if (authHeader != null && authHeader.startsWith("Basic")) {
//
//			String encodedCredentials = authHeader.substring(6).trim();
//			System.out.println(encodedCredentials);
//			String decodedCredentials = new String(java.util.Base64.getDecoder().decode(encodedCredentials));
//			System.out.println(decodedCredentials);
//			String[] credentials = decodedCredentials.split(":", 2);
//			System.out.println(credentials[0]);
//			if (credentials.length == 2) {
//				String username = credentials[0];
//				String password = credentials[1];
//
//				return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
//
//			}
//			return false;
//		}
//		return false;
//	}
//}
////	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
////			@Nullable ModelAndView modelAndView) throws Exception {
////		
////	}
////	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
////				@Nullable Exception ex) throws Exception {
////		}
//}
