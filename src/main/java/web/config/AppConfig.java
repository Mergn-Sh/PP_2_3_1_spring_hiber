package web.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "web")
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_hibernate?useSSL=false&serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("web.entity");

        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties propsHiber=new Properties();
        propsHiber.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        propsHiber.setProperty("hibernate.show_sql", "true");

        entityManager.setJpaProperties(propsHiber);

        return entityManager;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }

//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        return internalResourceViewResolver;
//    }

//      @Bean
//      public LocalSessionFactoryBean sessionFactoryBean(){
//          LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//          sessionFactoryBean.setDataSource(dataSource());
//          sessionFactoryBean.setPackagesToScan("web.entity");
//
//          Properties hibernateProperties = new Properties();
//          hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//          hibernateProperties.setProperty("hibernate.show_sql", "true");
//
//          sessionFactoryBean.setHibernateProperties(hibernateProperties);
//
//          return sessionFactoryBean;
//      }

//      @Bean
//      public HibernateTransactionManager transactionManager(){
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
//
//        return transactionManager;
//      }
}
