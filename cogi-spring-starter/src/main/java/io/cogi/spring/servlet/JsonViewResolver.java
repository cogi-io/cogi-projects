package io.cogi.spring.servlet;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import io.cogi.spring.servlet.view.json.MappingJackson2JsonView;

/**
 * @since 0.0.1
 * @author yongseoklee
 */
public class JsonViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return new MappingJackson2JsonView();
    }

}
