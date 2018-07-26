package com.demo.spi.filter;

import java.util.List;
import com.demo.spi.filter.context.FilterContext;
import com.demo.spi.filter.registry.FilterRegistry;

/**
 * 
 * 包装过滤器调用过程
 * 
 * @author lizp
 * @date 2018年7月26日
 * @version 1.0
 */
public class FilterRunner {

	/**
	 * 调用过滤器
	 * 
	 * @param context
	 * @throws Exception
	 */
	public void doFilters(FilterContext context) throws Exception {
		List<IFilter> filters = FilterRegistry.getInstance().getAllFilters();
		for (IFilter filter : filters) {
			filter.doFilter(context);
		}
	}
}
