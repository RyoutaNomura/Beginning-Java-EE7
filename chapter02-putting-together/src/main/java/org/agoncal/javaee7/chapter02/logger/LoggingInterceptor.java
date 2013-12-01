package org.agoncal.javaee7.chapter02.logger;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.agoncal.javaee7.chapter02.annotation.Loggable;

@Interceptor
@Loggable
public class LoggingInterceptor {

	@Inject
	private Logger logger;

	@AroundInvoke
	public Object logMethod(InvocationContext ic) throws Exception {
		this.logger.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			this.logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
		}
	}
}
