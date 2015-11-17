package io.cogi.spring.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * 세션 유틸리티
 * 
 * @since 0.0.1
 * @author yongseoklee
 */
public class SessionUtils {

    /**
     * 세션에 저장된 Object 반환
     * 
     * @param session HttpSession
     * @param name Session Key
     * @return null or Object
     */
    public static Object getAttribute(HttpSession session, String name) {
        return session.getAttribute(name);
    }

    /**
     * 세션에 저장된 Object 반환
     *
     * @param session HttpSession
     * @param name Session Key
     * @param clazz 캐스팅 클래스
     * @return null or 캐스팅된 Object
     */
    @SuppressWarnings("unchecked")
    public static <T> T getAttribute(HttpSession session, String name, Class<T> clazz) {
        Object attribute = session.getAttribute(name);
        return (attribute == null) ? null : (T) attribute;
    }

    /**
     * 세션에 Object 저장
     *
     * @param session HttpSession
     * @param name Session Key
     * @param object 저장될 Object
     */
    public static void setAttribute(HttpSession session, String name, Object object) {
        session.setAttribute(name, object);
    }

    /**
     * 세션에 저장된 Object 삭제
     *
     * @param session HttpSession
     * @param name Session Key
     */
    public static void removeAttribute(HttpSession session, String name) {
        session.removeAttribute(name);
    }

    /**
     * 세션 ID
     *
     * @param session HttpSession
     * @return Session ID
     */
    public static String getSessionId(HttpSession session) {
        return session.getId();
    }

}