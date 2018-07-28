package com.demo.spi.filter.impl;

import com.demo.spi.filter.context.FilterContext;
import com.demo.spi.filter.impl.AbstractFilter;

/**
 * 后处理过滤器
 * 
 * @author lizp
 * @date 2018年7月28日
 * @version 1.0
 */
public class PostFilter extends AbstractFilter {

	@Override
	public void doFilter(FilterContext context) throws Exception {
		LOGGER.debug("PostFilter execute");
		recordExecute(context);
	}

}
