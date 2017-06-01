package com.websystique.springsecurity.configuration;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.SessionTrackingMode;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

	@Override
	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
		super.afterSpringSecurityFilterChain(servletContext);
	}

	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		super.beforeSpringSecurityFilterChain(servletContext);
	}

	@Override
	protected boolean enableHttpSessionEventPublisher() {
		return super.enableHttpSessionEventPublisher();
	}

	@Override
	protected String getDispatcherWebApplicationContextSuffix() {
		return super.getDispatcherWebApplicationContextSuffix();
	}

	@Override
	protected EnumSet<DispatcherType> getSecurityDispatcherTypes() {
		return super.getSecurityDispatcherTypes();
	}

	@Override
	protected Set<SessionTrackingMode> getSessionTrackingModes() {
		return super.getSessionTrackingModes();
	}

	@Override
	protected boolean isAsyncSecuritySupported() {
		return super.isAsyncSecuritySupported();
	}
	
}