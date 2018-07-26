package com.demo.spi.filter.impl;

import com.demo.spi.filter.context.FilterContext;

/**
 * 预处理过滤器
 * 
 * @author lizp
 * @date 2018年7月26日
 * @version 1.0
 */
public class PreFilter extends AbstractFilter {

	@Override
	public void doFilter(FilterContext context) throws Exception {
		LOGGER.debug("PreFilter execute");
		recordExecute(context);
	}

}
