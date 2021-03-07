package cn.teach.common.mvc;

import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.util.List;

public interface IRequestDataInitializer {
     List<RequestDataMeta> getDataMeta(Class<?> controllerType,Method method,ApplicationContext context);
     void executed();
     int getOrder();
}