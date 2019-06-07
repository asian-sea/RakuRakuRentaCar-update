package jp.co.rakus.ecommerce.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver{

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException (HttpServletRequest request, HttpServletResponse response, Object object, Exception e) {
		logger.error("！システムエラー発生！", e);
		logger.warn("～警告です～", e);
		return new ModelAndView("redirect:/car/maintenance");
	}
}
