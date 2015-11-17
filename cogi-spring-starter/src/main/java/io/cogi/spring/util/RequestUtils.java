package io.cogi.spring.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author yongseoklee
 * @author zune
 */
public class RequestUtils {

    private RequestUtils() {

    }

    /**
     * 현재 Context에서 HttpServletRequest를 취득함
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    /**
     * Remote IP (Client IP) 취득
     *
     * @param request
     * @return ip or null
     * @see <a href="http://lesstif.com/pages/viewpage.action?pageId=20775886">
     * Proxy(프락시) 환경에서 client IP 를 얻기 위한 X-Forwarded-For(XFF) http header</a>
     */
    public static String getCurrentIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        String[] ipSplit = StringUtils.split(ip, ",");
        if (ipSplit == null)
            return null;

        return ipSplit[0];
    }

    /**
     * RequestURL 및 QueryString 획득
     *
     * @param request
     * @return
     */
    public static String getRequestURLWithQueryString(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();
        if (queryString != null && 0 < queryString.length())
            requestURL.append("?").append(queryString);

        return requestURL.toString();
    }

    /**
     * RequestURI 및 QueryString 획득
     *
     * @param request
     * @return
     */
    public static String getRequestURIWithQueryString(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        if (queryString != null && 0 < queryString.length())
            requestURI = requestURI + "?" + queryString;

        return requestURI;
    }

}
