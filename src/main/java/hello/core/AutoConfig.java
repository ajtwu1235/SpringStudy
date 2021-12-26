package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


    @Configuration
    @ComponentScan(
            basePackages = "hello.core",
            includeFilters =@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = MyFilter.class),
            excludeFilters=@ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Configuration.class)
    )
    public class AutoConfig {
    }

