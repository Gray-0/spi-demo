package com.demo.spi.filter.registry;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.demo.spi.filter.IFilter;

/**
 * 
 * @author lizp
 * @date 2018年7月28日
 * @version 1.0
 */
public class FilterRegistryTest {

	@Test
	public void testLoadFilters() throws Exception {
		final int expectedFiltersSize = 4;

		List<IFilter> filters = FilterRegistry.getInstance().getAllFilters();

		assertThat("预期加载的过滤器数量为[" + expectedFiltersSize + "],与实际加载的过滤器数量不符", filters.size(), is(expectedFiltersSize));
	}

}
