package com.demo.spi.filter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.spi.filter.IFilter;
import com.demo.spi.filter.context.FilterContext;

/**
 * 抽象过滤器实现
 * 
 * @author lizp
 * @date 2018年7月26日
 * @version 1.0
 */
public abstract class AbstractFilter implements IFilter {

	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractFilter.class);

	/**
	 * 记录过滤器执行
	 * 
	 * @param context
	 * @param key
	 */
	protected void recordExecute(FilterContext context) {
		context.add(this.getClass().getName());
	}
}
