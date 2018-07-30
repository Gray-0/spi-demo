package com.demo.spi.filter.registry;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;

import com.demo.spi.filter.AbstractFilter;

/**
 * 
 * @author lizp
 * @date 2018年7月30日
 * @version 1.0
 */
public class FilterRegistryOfAbstractTest {

	@Test
	public void testLoadFilters() throws Exception {
		final int expectedFiltersSize = getExpectedFiltersSize();

		List<AbstractFilter> filters = FilterRegistryOfAbstract.getInstance().getAllFilters();

		assertThat("预期加载的过滤器数量为[" + expectedFiltersSize + "],与实际加载的过滤器数量不符", filters.size(), is(expectedFiltersSize));
	}

	private int getExpectedFiltersSize() throws FileNotFoundException, IOException {
		int count = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				this.getClass().getResourceAsStream("/META-INF/services/com.demo.spi.filter.AbstractFilter")))) {
			while (reader.ready()) {
				String line = reader.readLine();
				if (!"".equals(line.trim())) {
					count++;
				}
			}
		}
		return count;
	}
}
