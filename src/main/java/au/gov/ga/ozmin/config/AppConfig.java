package au.gov.ga.ozmin.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(pageable());
		argumentResolvers.add(sort());
	}

	@Bean
	public PageableHandlerMethodArgumentResolver pageable() {
		return new PageableHandlerMethodArgumentResolver();
	}

	@Bean
	public SortHandlerMethodArgumentResolver sort() {
		return new SortHandlerMethodArgumentResolver();
	}

}
