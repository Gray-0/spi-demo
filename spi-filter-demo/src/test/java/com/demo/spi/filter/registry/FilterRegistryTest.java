package com.demo.spi.filter.registry;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;

import com.demo.spi.filter.IFilter;

/**
 * 
 * @author lizp
 * @date 2018年7月26日
 * @version 1.0
 */
public class FilterRegistryTest {

	@Test
	public void testLoadFilters() throws Exception {
		final int expectedFiltersSize = getExpectedFiltersSize();

		List<IFilter> filters = FilterRegistry.getInstance().getAllFilters();

		assertThat(filters, new BaseMatcher<List<IFilter>>() {
			@SuppressWarnings("unchecked")
			@Override
			public boolean matches(Object object) {
				List<IFilter> actualFilters = (List<IFilter>) object;
				return expectedFiltersSize == actualFilters.size();
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("预期加载的过滤器数量为[" + expectedFiltersSize + "],与实际加载的过滤器数量不符");
			}
		});
	}

	private int getExpectedFiltersSize() throws FileNotFoundException, IOException {
		int count = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				this.getClass().getResourceAsStream("/META-INF/services/com.demo.spi.filter.IFilter")))) {
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
