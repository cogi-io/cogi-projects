package io.cogi.spring.servlet;

import java.io.File;
import java.util.Locale;

import org.springframework.web.servlet.view.JstlView;

/**
 * JstlView 은 View 존재 상관없이 {@link #checkResource(Locale)} 가 항상 true 를 반환
 * Spring Mobile
 * {@link org.springframework.mobile.device.view.AbstractDeviceDelegatingViewResolver​}
 * 의 enableFallback 이 작동하지 않는다.
 * 이를 해결하기 위해 ​checkResource 에서 파일여부를 판단하도록 로직을 추가함
 *
 * @since 0.0.1
 * @author yongseoklee
 */
public class CheckResourceJstlView extends JstlView {

    @Override
    public boolean checkResource(Locale locale) throws Exception {
        String name = getUrl();

        if (getServletContext() != null)
            name = getServletContext().getRealPath(name);

        File resourceFile = new File(name.replace('/', File.separatorChar));

        return resourceFile.isFile();
    }

}
