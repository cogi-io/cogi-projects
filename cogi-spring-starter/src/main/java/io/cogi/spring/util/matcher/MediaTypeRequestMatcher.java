package io.cogi.spring.util.matcher;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

import org.springframework.security.web.util.matcher.RequestMatcher;

import io.cogi.spring.constant.MediaType;

@Data
public abstract class MediaTypeRequestMatcher implements RequestMatcher {

    private static final String DEFAULT_PARAMETER_NAME = "format";

    private boolean favorPathExtension = false;

    private boolean favorParameter = true;

    private boolean ignoreAcceptHeader = true;

    private String parameterName = DEFAULT_PARAMETER_NAME;

    public abstract MediaType getMediaType();

    @Override
    public boolean matches(HttpServletRequest request) {
        if (this.isFavorPathExtension()) {
            String requestURI = request.getRequestURI();
            if (requestURI != null && requestURI.endsWith(this.getMediaType().getExtension()))
                return true;
        }

        if (this.isFavorParameter()) {
            String parameter = request.getParameter(this.getParameterName());
            if (this.getMediaType().getExtension().equals(parameter))
                return true;
        }

        if (!this.isIgnoreAcceptHeader()) {
            String contentType = request.getContentType();
            if (contentType != null && contentType.contains(this.getMediaType().getType()))
                return true;
        }

        return false;
    }

}
