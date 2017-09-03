package com.tencent.latke.demo;

import org.b3log.latke.Latkes;
import org.b3log.latke.logging.Logger;
import org.b3log.latke.servlet.AbstractServletListener;
import org.b3log.latke.util.freemarker.Templates;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpSessionEvent;

/**
 * Created by ansonwen on 2017/8/30.
 */
public class HelloServletListener extends AbstractServletListener{
    private static final Logger LOGGER=Logger.getLogger(HelloServletListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Latkes.setScanPath("com.tencent.latke.demo");
        super.contextInitialized(servletContextEvent);

        final ServletContext servletContext=servletContextEvent.getServletContext();
        try {
            Templates.MAIN_CFG.setServletContextForTemplateLoading(servletContext, "skins/classic");
            Templates.MOBILE_CFG.setServletContextForTemplateLoading(servletContext, "skins/classic");
        }catch (final Exception e){
            throw new IllegalStateException("can not load the default template directory [skins/classic]");
        }
        LOGGER.info("Initialized the context");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        super.contextDestroyed(servletContextEvent);
        LOGGER.info("Destroyed the context");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        super.requestDestroyed(servletRequestEvent);
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        super.sessionDestroyed(httpSessionEvent);
    }




}
