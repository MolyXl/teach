package cn.teach;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * @Date 2019/3/4 9:13
 * @Description 入口类
 * @Version 1.0
 **/
@SpringBootApplication
@EnableScheduling
@MapperScan("cn.teach.mall.mapper")
public class TeachApplication implements WebMvcConfigurer {

    public static void main(String args[]) {
        SpringApplication.run(TeachApplication.class);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
        String root = System.getProperty("user.dir");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + root + "\\upload\\");
        registry.addResourceHandler("/qrcode/**").addResourceLocations("file:" + root + "\\qrcode\\");
        registry.addResourceHandler("/poster/**").addResourceLocations("file:" + root + "\\poster\\");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        long fileSize = 1024 * 1024 * 1024;
        long requestSize = 1024 * 1024 * 1024;
        factory.setMaxFileSize(DataSize.ofBytes(fileSize));
        factory.setMaxRequestSize(DataSize.ofBytes(requestSize));
        return factory.createMultipartConfig();
    }
   /* @Bean
    public TomcatServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(httpConnector());
        return tomcatServletWebServerFactory;
    }*/

    /*@Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        //Connector监听的http的端口号
        connector.setPort(8081);
        connector.setSecure(false);
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(443);
        return connector;
    }*/
}
