package io.cogi.spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import io.cogi.spring.constant.MediaType;
import io.cogi.spring.servlet.ExcelViewResolver;
import io.cogi.spring.servlet.JsonViewResolver;

public abstract class DefaultWebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .favorPathExtension(false)
                .ignoreAcceptHeader(true)
                .favorParameter(true)
                .parameterName("format")
                .defaultContentType(MediaType.asSpringMediaType(MediaType.TEXT_HTML))
                .mediaType(MediaType.TEXT_HTML.getExtension(), MediaType.asSpringMediaType(MediaType.TEXT_HTML))
                .mediaType(MediaType.APPLICATION_JSON.getExtension(), MediaType.asSpringMediaType(MediaType.APPLICATION_JSON))
                .mediaType(MediaType.APPLICATION_XLS.getExtension(), MediaType.asSpringMediaType(MediaType.APPLICATION_XLS))
                .useJaf(false);
    }

    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        resolver.setUseNotAcceptableStatusCode(true);

        List<ViewResolver> resolvers = new ArrayList<>();
        resolvers.add(jspViewResolver());
        resolvers.add(jsonViewResolver());
        resolvers.add(excelViewResolver());

        resolver.setViewResolvers(resolvers);
        return resolver;
    }

    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }

    @Bean
    public ViewResolver excelViewResolver() {
        ExcelViewResolver viewResolver = new ExcelViewResolver();
        viewResolver.setPrefix("/WEB-INF/excel/");
        return viewResolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxInMemorySize(102400);
        multipartResolver.setMaxUploadSize(20971520);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

}
