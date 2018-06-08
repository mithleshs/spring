package dm.spring.mvc.dmspringmvc.configuration;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * This class is responsible for Persistence related configuration.
 *
 * @author mithlesh
 * @version 1.0
 * @since 06 Jun, 2018
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "dm.spring.mvc.dmspringmvc.repository" })
public class RepositoryConfig implements TransactionManagementConfigurer {

	public static final String ENTITY_PACKAGE = "dm.spring.mvc.dmspringmvc.model";

	@Value("${db.driver}")
	private String driver;

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Value("${db.showsql}")
	private boolean showSql;

	@Value("${database.hibernate.dialect}")
	private String dialect;

	@Value("${db.validationQuery}")
	private String validationQuery;

	@Value("${db.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${db.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${db.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${db.maxActiveConnectionInPool}")
	private int maxActiveConnectionInPool;

	@Value("${db.initialPoolSize}")
	private int initialPoolSize;

	@Value("${db.maxPoolWaitMillis}")
	private int maxPoolWaitMillis;

	@Value("${db.connectionAbandonedTimeoutSecs}")
	private int connectionAbandonedTimeoutSecs;

	@Value("${db.minIdleConnectionInPool}")
	private int minIdleConnectionInPool;

	@Autowired
	private DataSource dataSource;

	@Bean
	public DataSource dataSource() {
		final PoolProperties lProps = new PoolProperties();
		lProps.setUrl(url);
		lProps.setDriverClassName(driver);
		lProps.setUsername(username);
		lProps.setPassword(password);
		lProps.setJmxEnabled(true);
		lProps.setTestWhileIdle(testWhileIdle);
		lProps.setTestOnBorrow(testOnBorrow);
		lProps.setValidationQuery(validationQuery);
		lProps.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		lProps.setMaxActive(maxActiveConnectionInPool);
		lProps.setInitialSize(initialPoolSize);
		lProps.setMaxWait(maxPoolWaitMillis);
		lProps.setRemoveAbandonedTimeout(connectionAbandonedTimeoutSecs);
		lProps.setMinIdle(minIdleConnectionInPool);
		lProps.setLogAbandoned(true);
		lProps.setRemoveAbandoned(true);
		lProps.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
				+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
		final DataSource lDatasource = new DataSource();
		lDatasource.setPoolProperties(lProps);
		return lDatasource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean lEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		lEntityManagerFactoryBean.setDataSource(dataSource());
		lEntityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGE);
		final HibernateJpaVendorAdapter lJpaVendorAdapter = new HibernateJpaVendorAdapter();
		lJpaVendorAdapter.setShowSql(showSql);
		lEntityManagerFactoryBean.setJpaVendorAdapter(lJpaVendorAdapter);

		final Properties lJpaProperties = new Properties();
		lJpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
		lEntityManagerFactoryBean.setJpaProperties(lJpaProperties);
		return lEntityManagerFactoryBean;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		final JpaTransactionManager lTransactionManager = new JpaTransactionManager();
		lTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return lTransactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
}
