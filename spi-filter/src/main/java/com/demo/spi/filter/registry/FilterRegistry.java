package com.demo.spi.filter.registry;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.spi.filter.IFilter;

/**
 * 拦截器注册仓库
 * 
 * @author lizp
 * @date 2018年7月26日
 * @version 1.0
 */
public class FilterRegistry {

	private static final Logger LOGGER = LoggerFactory.getLogger(FilterRegistry.class);

	private static final FilterRegistry INSTANCE = new FilterRegistry();

	public static final FilterRegistry getInstance() {
		return INSTANCE;
	}

	/**
	 * 已注册的拦截器
	 */
	private final CopyOnWriteArrayList<IFilter> filters = new CopyOnWriteArrayList<IFilter>();

	static {
		try {
			LOGGER.debug("loadFilters begin");
			loadFilters();
		} catch (Exception e) {
			LOGGER.error("loadFilters error", e);
		} finally {
			LOGGER.debug("loadFilters end");
		}
	}

	/**
	 * 加载过滤器
	 */
	private static void loadFilters() {
		ServiceLoader<IFilter> filterLoader = ServiceLoader.load(IFilter.class);
		Iterator<IFilter> filterIterator = filterLoader.iterator();
		while (filterIterator.hasNext()) {
			// next方法中对META-INF/services/com.demo.spi.filter.IFilter中配置的类名通过反射进行实例化
			IFilter filter = filterIterator.next();
			registerFilter(filter);
		}
	}

	/**
	 * 注册过滤器
	 * 
	 * @param filter
	 */
	public static void registerFilter(IFilter filter) {
		synchronized (INSTANCE) {
			INSTANCE.add(filter);
		}
	}

	/**
	 * 获取所有过滤器
	 * 
	 * @return
	 */
	public List<IFilter> getAllFilters() {
		return Collections.unmodifiableList(filters);
	}

	/**
	 * 添加过滤器
	 * 
	 * @param filter
	 * @return
	 */
	private boolean add(IFilter filter) {
		return filters.add(filter);
	}

	private FilterRegistry() {

	}

}
