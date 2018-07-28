package com.demo.spi.filter;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import com.demo.spi.filter.context.FilterContext;
import com.demo.spi.filter.impl.AuthFilter;
import com.demo.spi.filter.impl.LogFilter;
import com.demo.spi.filter.impl.PostFilter;
import com.demo.spi.filter.impl.PreFilter;

/**
 * 
 * @author lizp
 * @date 2018年7月28日
 * @version 1.0
 */
public class FilterRunnerTest {

	@Test
	public void testDoFilters() throws Exception {
		FilterRunner runner = new FilterRunner();
		FilterContext context = FilterContext.getInstance();
		runner.doFilters(context);
		Set<String> filterExecuteSet = context.getFilterExecuteSet();
		assertTrue(filterExecuteSet.contains(AuthFilter.class.getName()));
		assertTrue(filterExecuteSet.contains(PreFilter.class.getName()));
		assertTrue(filterExecuteSet.contains(LogFilter.class.getName()));
		assertTrue(filterExecuteSet.contains(PostFilter.class.getName()));
	}

}
