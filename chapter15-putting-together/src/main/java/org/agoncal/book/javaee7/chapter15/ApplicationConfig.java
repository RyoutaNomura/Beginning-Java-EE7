package org.agoncal.book.javaee7.chapter15;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;


@ApplicationPath("rs")
public class ApplicationConfig extends Application {
	private final Set<Class<?>> classes;

	public ApplicationConfig() {
		HashSet<Class<?>> c = new HashSet<>();
		c.add(BookRestService.class);
		c.add(MOXyJsonProvider.class);

		this.classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return this.classes;
	}
}
