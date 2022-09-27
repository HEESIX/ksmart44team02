package ks44team02.interceptor;

import java.util.Set;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CommonInterceptor implements HandlerInterceptor{
	
	private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		//parameter key SET
		Set<String> paramKeySet = request.getParameterMap().keySet();
		
		//memberId: id001, memberPw: pw001...
		StringJoiner param = new StringJoiner(", ");
		
		for(String key : paramKeySet) {
			param.add(key + " : " + request.getParameter(key));
		}
		
		log.info("ACCESS INFO ==================================================");
		log.info("PORT             :::::::::    {}", request.getLocalPort());
		log.info("ServerName       :::::::::    {}", request.getServerName());
		log.info("Method           :::::::::    {}", request.getMethod());
		log.info("URI              :::::::::    {}", request.getRequestURI());
		log.info("CLIENT IP        :::::::::    {}", request.getRemoteAddr());
		log.info("PRAMETER         :::::::::    {}", param);
		log.info("ACCESS INFO ==================================================");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
