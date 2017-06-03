package hsbc.gbm.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class HibernateConfiguration {
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.show_sql}")
	private String showSQL;
	
	@Value("${hibernate.format_sql}")
	private String formatSQL;
	
	@Value("${hibernate.thread}")
	private String thread;
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[] { "hsbc.gbm.domain" });
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
     }
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSQL);
        properties.put("hibernate.format_sql", formatSQL);
        properties.put("hibernate.current_session_context_class", thread);

        return properties;        
    }
	
	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);
       
       return txManager;
    }
}
