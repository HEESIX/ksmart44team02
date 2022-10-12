package ks44team02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import ks44team02.interceptor.CommonInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private final CommonInterceptor commonInterceptor;
	
	public WebConfig(CommonInterceptor commonInterceptor) {
		this.commonInterceptor = commonInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/images/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/admin/assets/**")
				.excludePathPatterns("/user/css/**")
				.excludePathPatterns("/user/js/**")
				.excludePathPatterns("/user/img/**")
				.excludePathPatterns("/user/fonts/**")
				.excludePathPatterns("/favicon.ico");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("file:///" + System.getProperty("user.dir") + "/resources/")
				.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}
