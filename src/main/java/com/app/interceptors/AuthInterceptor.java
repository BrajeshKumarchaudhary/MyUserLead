package com.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.app.annotation.VerifyClientToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class AuthInterceptor implements HandlerInterceptor  {

	Logger logger =LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler)
			throws Exception {
		if (!(handler instanceof HandlerMethod)) {
            if (httpServletRequest.getRequestURI().contains("swagger")) {
                return HandlerInterceptor.super.preHandle(httpServletRequest, httpServletResponse, handler);
            }

            logger.error("handler is not instance of HandlerMethod : " + httpServletRequest.getRequestURI());
//            throw new HttpClientErrorException(HttpStatus.SC_UNAUTHORIZED, "UNPROCESSABLE or UNAUTHORISED request" + httpServletRequest.getRequestURI());
//           
        }
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		VerifyClientToken verifyClientToken = handlerMethod.getMethod().getAnnotation(VerifyClientToken.class);
		if(verifyClientToken!=null) {
			verfiyToken(httpServletRequest,verifyClientToken);
		}else {
			return HandlerInterceptor.super.preHandle(httpServletRequest, httpServletResponse, handler);
		}
		
		return HandlerInterceptor.super.preHandle(httpServletRequest, httpServletResponse, handler);
	}

	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	private void verfiyToken(HttpServletRequest httpServletRequest, VerifyClientToken verifyClientToken) throws Exception {
		String token = httpServletRequest.getHeader("clientSecret");
        if (token == null || token.isEmpty()) {
            throw new MissingServletRequestParameterException("clientSecret", "string");
        }

        // Check for clientId
        String inputClientId = httpServletRequest.getHeader("clientId");
        if (inputClientId == null || inputClientId.isEmpty()) {
            throw new MissingServletRequestParameterException("clientId", "String");
        }
        if(!token.equals("password")&&(!inputClientId.equals("admin"))) {
        	throw new Exception("Invalid Client Secret and clientId ");
        }
	}
}
