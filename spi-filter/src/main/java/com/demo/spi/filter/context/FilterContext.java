package com.demo.spi.filter.context;

import java.util.HashSet;
import java.util.Set;

/**
 * 过滤器上下文容器
 * 
 * @author lizp
 * @date 2018年7月26日
 * @version 1.0
 */
public class FilterContext {
	/**
	 * 记录过滤器执行
	 */
	private Set<String> filterExecuteSet;

	public static FilterContext getInstance() {
		FilterContext context = new FilterContext();
		context.setFilterExecuteSet(new HashSet<String>(8));
		return context;
	}

	public boolean add(String str) {
		return filterExecuteSet.add(str);
	}

	public Set<String> getFilterExecuteSet() {
		return filterExecuteSet;
	}

	public void setFilterExecuteSet(Set<String> filterExecuteSet) {
		this.filterExecuteSet = filterExecuteSet;
	}

}
