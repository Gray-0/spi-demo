demo2主要为验证ServiceLoader的加载情况，主要包含以下两方面：  
1.当项目中包含多个META-INF/services/com.demo.spi.filter.IFilter文件  
2.当META-INF/services/com.demo.spi.filter.IFilter文件中包含同名配置  

/spi-filter-demo2/src/test/java/com/demo/spi/filter/FilterRunnerTest.java  
验证发现当包含多个META-INF/services/com.demo.spi.filter.IFilter文件时，ServiceLoader会将多个文件内的配置全部进行加载  

/spi-filter-demo2/src/test/java/com/demo/spi/filter/registry/FilterRegistryTest.java  
验证发现当包含同名配置时，ServiceLoader会将只会实例化一次  