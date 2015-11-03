package au.gov.ga.ozmin.config;

import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import au.gov.ga.ozmin.service.CommodityService;
import au.gov.ga.ozmin.service.MineralDepositService;
import au.gov.ga.ozmin.service.MineralResourceService;
import au.gov.ga.ozmin.service.impl.CommodityServiceImpl;
import au.gov.ga.ozmin.service.impl.MineralDepositServiceImpl;
import au.gov.ga.ozmin.service.impl.MineralResourceServiceImpl;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@ComponentScan(basePackages = "au.gov.ga.ozmin")
@EnableJpaRepositories(basePackages = "au.gov.ga.ozmin.repository")
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	Environment env;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(pageable());
		argumentResolvers.add(sort());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(viewResolver());
	}

	@Bean
	public PageableHandlerMethodArgumentResolver pageable() {
		return new PageableHandlerMethodArgumentResolver();
	}

	@Bean
	public SortHandlerMethodArgumentResolver sort() {
		return new SortHandlerMethodArgumentResolver();
	}

	@Bean
	public CommodityService commodityService() {
		return new CommodityServiceImpl();

	}

	@Bean
	public MineralDepositService mineralDepositService() {
		return new MineralDepositServiceImpl();

	}

	@Bean
	public MineralResourceService mineralResourceService() {
		return new MineralResourceServiceImpl();

	}

	@Bean(destroyMethod = "close")
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("jdbc.className"));
		basicDataSource.setUrl(env.getProperty("jdbc.url"));
		basicDataSource.setUsername(env.getProperty("jdbc.username"));
		basicDataSource.setPassword(env.getProperty("jdbc.password"));
		return basicDataSource;

	}

	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
		thymeleafViewResolver.setOrder(1);
		thymeleafViewResolver.setTemplateEngine(templateEngine());
		thymeleafViewResolver.setViewNames(new String[] { "*" });
		return thymeleafViewResolver;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());

		localSessionFactoryBean.setHibernateProperties(hibernateProperties());

		return localSessionFactoryBean;
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.spatial.dialect.oracle.OracleSpatial10gDialect");
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setPackagesToScan("au.gov.ga.ozmin.model");

		return localContainerEntityManagerFactoryBean;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();

		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.addTemplateResolver(templateResolver());
		springTemplateEngine.addDialect(new LayoutDialect());
		return springTemplateEngine;
	}

	@Bean
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver servletContextTemplateResolver = new ServletContextTemplateResolver();
		servletContextTemplateResolver.setPrefix("/WEB-INF/views/");
		servletContextTemplateResolver.setSuffix(".html");
		servletContextTemplateResolver.setTemplateMode("HTML5");
		servletContextTemplateResolver.setCacheable(false);
		return servletContextTemplateResolver;
	}

	private Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;

			{
				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
				setProperty("hibernate.spatial.connection_finder",
						env.getProperty("hibernate.spatial.connection_finder"));
				setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
			}
		};
	}
}
