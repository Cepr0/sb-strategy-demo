package io.github.cepr0.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericFactoryBean<T, D> implements FactoryBean<Map<Class<? extends D>, ? extends T>>, ApplicationContextAware {

	private final Class<T> beanClass;
	private final Class<D> genericClass;

	private ApplicationContext ctx;

	public GenericFactoryBean(@NonNull final Class<T> beanClass, @NonNull final Class<D> genericClass) {

		if (!beanClass.isInterface()) {
			throw new IllegalArgumentException("Parameter 'beanClass' must be an interface");
		}

		if (!genericClass.isInterface()) {
			throw new IllegalArgumentException("Parameter 'genericClass' must be an interface");
		}

		this.beanClass = beanClass;
		this.genericClass = genericClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Class<? extends D>, ? extends T> getObject() {
		return ctx.getBeansOfType(beanClass)
				.values()
				.stream()
				.filter(bean -> genericClass.isAssignableFrom((Class<?>) getFirstGenericType(bean)))
				.collect(Collectors.toUnmodifiableMap(bean -> (Class<? extends D>) getFirstGenericType(bean), bean -> bean));
	}

	private Type getFirstGenericType(T bean) {
		return ((ParameterizedType) bean.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
	}

	@Override
	public Class<?> getObjectType() {
		return Map.class;
	}

	@Override
	public void setApplicationContext(@NonNull final ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
}
