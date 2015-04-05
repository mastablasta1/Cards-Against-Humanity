package com.idziak.cards;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionEventsListener implements HttpSessionListener {
    public static final Logger LOG = LoggerFactory.getLogger(SessionEventsListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOG.info("Session created: " + httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOG.info("Session destroyed: " + httpSessionEvent.getSession().getId());
    }
}
