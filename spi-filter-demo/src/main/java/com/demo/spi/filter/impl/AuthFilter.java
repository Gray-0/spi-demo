package com.demo.spi.filter.impl;

import com.demo.spi.filter.AbstractFilter;
import com.demo.spi.filter.context.FilterContext;

/**
 * 授权过滤器
 * 
 * @author lizp
 * @date 2018年7月26日
 * @version 1.0
 */
public class AuthFilter extends AbstractFilter {

	@Override
	public void doFilter(FilterContext context) throws Exception {
		LOGGER.debug("AuthFilter execute");
		recordExecute(context);
	}

}
