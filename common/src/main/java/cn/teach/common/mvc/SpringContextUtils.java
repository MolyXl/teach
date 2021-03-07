package cn.teach.common.mvc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName Jwt
 * @Author MaZhuli
 * @Date 2018/8/25 15:55
 * @Description springboot上下文
 * @Version 1.0
 **/
@Component
public class SpringContextUtils implements ApplicationContextAware{
	private static ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringContextUtils.context==null) {
			SpringContextUtils.context = applicationContext;
		}
	}
	public static ApplicationContext getContext(){
        return context;
	}
	
	public static <T> T getBean(Class<T> requiredType){
		return  getContext().getBean(requiredType);
	}
}
