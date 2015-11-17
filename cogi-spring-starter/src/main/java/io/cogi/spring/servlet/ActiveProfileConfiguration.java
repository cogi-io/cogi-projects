package io.cogi.spring.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lombok.extern.slf4j.Slf4j;

import org.springframework.core.env.AbstractEnvironment;

import io.cogi.spring.config.Profiles;

@Slf4j
public class ActiveProfileConfiguration implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String defaultProfile = this.getValue(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME);
        String activeProfile = this.getValue(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME);

        if (defaultProfile == null) {
            defaultProfile = Profiles.DEFAULT;
            System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, defaultProfile);
        }

        if (activeProfile == null) {
            activeProfile = Profiles.DEFAULT;
            System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, activeProfile);
        }

        log.info("String Profile - Default: {}, Active: {}", defaultProfile, activeProfile);
    }

    protected String getValue(String name) {
        if (System.getenv(name) != null)
            return System.getenv(name);

        if (System.getProperty(name) != null)
            return System.getProperty(name);

        return null;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
