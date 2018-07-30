package com.demo.spi.filter.registry;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.spi.filter.AbstractFilter;

/**
 * 拦截器注册表
 * 
 * @author lizp
 * @date 2018年7月30日
 * @version 1.0
 */
public class FilterRegistryOfAbstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(FilterRegistryOfAbstract.class);

	private static final FilterRegistryOfAbstract INSTANCE = new FilterRegistryOfAbstract();

	public static final FilterRegistryOfAbstract getInstance() {
		return INSTANCE;
	}

	/**
	 * 已注册的拦截器
	 */
	private final CopyOnWriteArrayList<AbstractFilter> filters = new CopyOnWriteArrayList<AbstractFilter>();

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
	 * 加载过滤器 <br>
	 * 1.ServiceLoader的构造函数中调用reload()方法构造了LazyIterator
	 * 2.filterIterator.hasNext()调用了LazyIterator的hasNextService()方法,其中会在META-INF/services/目录下找到对应要加载的类同名的文件进行载入
	 * 3.filterIterator.next()调用了LazyIterator的nextService()方法,其中通过反射对配置的类全名进行实例化
	 */
	private static void loadFilters() {
		ServiceLoader<AbstractFilter> filterLoader = ServiceLoader.load(AbstractFilter.class);
		Iterator<AbstractFilter> filterIterator = filterLoader.iterator();
		while (filterIterator.hasNext()) {
			AbstractFilter filter = filterIterator.next();
			registerFilter(filter);
		}
	}

	/**
	 * 注册过滤器
	 * 
	 * @param filter
	 */
	public static void registerFilter(AbstractFilter filter) {
		synchronized (INSTANCE) {
			INSTANCE.add(filter);
		}
	}

	/**
	 * 获取所有过滤器
	 * 
	 * @return
	 */
	public List<AbstractFilter> getAllFilters() {
		return Collections.unmodifiableList(filters);
	}

	/**
	 * 添加过滤器
	 * 
	 * @param filter
	 * @return
	 */
	private boolean add(AbstractFilter filter) {
		return filters.add(filter);
	}

	private FilterRegistryOfAbstract() {

	}

}
