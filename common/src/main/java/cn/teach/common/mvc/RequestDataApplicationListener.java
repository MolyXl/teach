package cn.teach.common.mvc;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class RequestDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();

        Map<String, IRequestDataInitializer> intializersMap = context.getBeansOfType(IRequestDataInitializer.class);
        if (intializersMap == null || intializersMap.size() == 0) {
            return;
        }
        Collection<IRequestDataInitializer> intializers = intializersMap.values();
        List<IRequestDataInitializer> sorted = intializers.stream().sorted(new Comparator<IRequestDataInitializer>() {
            @Override
            public int compare(IRequestDataInitializer o1, IRequestDataInitializer o2) {
                return o1.getOrder() - o2.getOrder();
            }

        }).collect(Collectors.toList());
        Map<String, Object> controllers = context.getBeansWithAnnotation(Controller.class);
        Map<String, Object> restControllers = context.getBeansWithAnnotation(RestController.class);
        if (controllers == null) {
            controllers = new HashMap<String, Object>();
        }
        if (restControllers != null) {
            controllers.putAll(restControllers);
        }

        Class<? extends Object> controllerType = null;
        for (Map.Entry<String, Object> entry : controllers.entrySet()) {
            controllerType = entry.getValue().getClass();
            if (Advised.class.isAssignableFrom(controllerType)) {
                Advised advised = (Advised) context.getBean(controllerType);
                SingletonTargetSource singTarget = (SingletonTargetSource) advised.getTargetSource();
                controllerType = singTarget.getTarget().getClass();
            }

            Method[] methods = controllerType.getDeclaredMethods();
            for (Method m : methods) {
                List<String> requestUrls = getRequetMappingForMethod(controllerType, m);

                for (String requestUrl : requestUrls) {
                    List<RequestDataMeta> metas=new ArrayList<RequestDataMeta>();
                    initRequestData(requestUrl, controllerType, m, sorted,context,metas);
                    if(metas.size()>0){
                        RequestData.getInstance().addData(requestUrl, metas);
                    }
                }
            }
        }

        for(IRequestDataInitializer item:sorted){
            item.executed();
        }
    }

    private void initRequestData(String requestUrl, Class<? extends Object> controllerType, Method method,
            Collection<IRequestDataInitializer> initializers, ApplicationContext context,List<RequestDataMeta> metas) {
        for (IRequestDataInitializer initializer : initializers) {
            List<RequestDataMeta> metasForInitializer = initializer.getDataMeta(controllerType, method,context);
            if (metasForInitializer != null) {
                metas.addAll(metasForInitializer);
            }
        }
    }

    private List<String> getRequetMappingForMethod(Class<? extends Object> controllerType, Method method) {
        RequestMapping controllerMapping = controllerType.getAnnotation(RequestMapping.class);
        RequestMapping methodMapping = method.getAnnotation(RequestMapping.class);
        List<String> urls = new ArrayList<String>();
        if (methodMapping == null) {
            return urls;
        }
        String[] methodPaths = methodMapping.value();
        if (controllerMapping == null) {
            for (String methodPath : methodPaths) {
                if (!methodPath.startsWith("/")) {
                    methodPath = "/" + methodPath;
                }
                urls.add(methodPath);
            }

            return urls;
        }
        String[] controllerPaths = controllerMapping.value();
        for (String controllerPath : controllerPaths) {
            if (!controllerPath.startsWith("/")) {
                controllerPath = "/" + controllerPath;
            }
            for (String methodPath : methodPaths) {
                if (!methodPath.startsWith("/")) {
                    methodPath = "/" + methodPath;
                }
                urls.add(controllerPath + methodPath);
            }
        }

        return urls;
    }

}