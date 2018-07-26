package com.demo.spi.filter;

import com.demo.spi.filter.context.FilterContext;

/**
 * 过滤器接口服务
 * 
 * @author lizp
 * @date 2018年7月26日
 * @version 1.0
 */
public interface IFilter {

	/**
	 * 执行过滤
	 * 
	 * @param context
	 * @throws Exception
	 */
	void doFilter(FilterContext context) throws Exception;
}
