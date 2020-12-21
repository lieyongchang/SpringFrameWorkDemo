package com.config;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionListenerWithMetrics implements HttpSessionListener {
	private final AtomicInteger activeSessions;

	public SessionListenerWithMetrics() {
		super();

		activeSessions = new AtomicInteger();
	}

	public int getTotalActiveSession() {
		return activeSessions.get();
	}

	public void sessionCreated(final HttpSessionEvent event) {
		// System.out.println("session created: " + new Date());
		activeSessions.incrementAndGet();
//		event.getSession().setMaxInactiveInterval(60);
//		session.setMaxInactiveInterval(60);

//		session.setAttribute("timeOutTimeInSeconds", 60);
//		session.setAttribute("showTimerTimeInSeconds", 6);

	}

	public void sessionDestroyed(final HttpSessionEvent event) {
		System.out.println("session Destroy: " + new Date());
		activeSessions.decrementAndGet();

	}
}
