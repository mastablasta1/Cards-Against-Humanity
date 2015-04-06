package com.idziak.cards;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SessionEventsListener implements HttpSessionListener {
    public static final Logger LOG = LoggerFactory.getLogger(SessionEventsListener.class);

    private static final Map<String, HttpSession> sessions = new HashMap<>();

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOG.info("Session created: " + httpSessionEvent.getSession().getId());
        sessions.put(httpSessionEvent.getSession().getId(), httpSessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOG.info("Session destroyed: " + httpSessionEvent.getSession().getId());
        sessions.remove(httpSessionEvent.getSession().getId());
    }

    public static void removeAllSessions() {
        sessions.values().forEach(HttpSession::invalidate);
    }
}
