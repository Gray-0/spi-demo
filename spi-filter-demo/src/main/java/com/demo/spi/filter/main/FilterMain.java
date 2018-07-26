package com.demo.spi.filter.main;

import com.demo.spi.filter.FilterRunner;
import com.demo.spi.filter.context.FilterContext;

/**
 * 
 * @author lizp
 * @date 2018年7月26日
 * @version 1.0
 */
public class FilterMain {

	public static void main(String[] args) throws Exception {
		FilterRunner runner = new FilterRunner();
		FilterContext context = FilterContext.getInstance();
		runner.doFilters(context);
	}
}
