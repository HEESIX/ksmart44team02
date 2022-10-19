package ks44team02.common.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ks44team02.dto.GoodsCategory;
import ks44team02.service.GoodsService;

@Aspect
@Component
public class CommonAop {

	
	private static final Logger log = LoggerFactory.getLogger(CommonAop.class);

	private final GoodsService goodsService;
	
	public CommonAop(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@After("execution(public * ks44team02.*.controller.*Controller.*(..))")
	public void menuAop(JoinPoint joinPoint) throws RuntimeException{
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		List<GoodsCategory> goodsCategoryListUser = goodsService.getGoodsCategoryListUser();
		
		log.info("goodsCategoryListUser ::: {}", goodsCategoryListUser);
		
		if(goodsCategoryListUser != null) request.setAttribute("goodsCategoryListUser", goodsCategoryListUser);
		
	}
	
}
