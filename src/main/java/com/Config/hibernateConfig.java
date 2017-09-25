package com.Config;

import java.util.Properties;







import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrderDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.Model.Cart;
import com.Model.Order;
import com.Model.Supplier;
import com.Model.User;
import com.Model.Category;
import com.Model.Product;


@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class hibernateConfig{

@Autowired
@Bean(name="dataSource")
public DataSource getH2DataSource()
{
System.out.println("Data Source Method");
DriverManagerDataSource dataSource = new DriverManagerDataSource();
dataSource.setDriverClassName("org.h2.Driver");
dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
dataSource.setUsername("sa");
dataSource.setPassword("");

System.out.println("Data Source Created");
return dataSource;
}

private Properties getHibernateProperties() {
Properties properties = new Properties();
properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
properties.put("hibernate.hbm2ddl.auto", "update");
properties.put("hibernate.show_sql", "true");
System.out.println("Table source created..........");
return properties;
}

@Autowired
@Bean(name = "sessionFactory")

public SessionFactory getSessionFactory(DataSource dataSource) {
	System.out.println("Session Factory....................");
LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
sessionBuilder.addProperties(getHibernateProperties());
sessionBuilder.addAnnotatedClass(User.class);
sessionBuilder.addAnnotatedClass(Category.class);
sessionBuilder.addAnnotatedClass(Product.class);
sessionBuilder.addAnnotatedClass(Supplier.class);
sessionBuilder.addAnnotatedClass(Cart.class);
sessionBuilder.addAnnotatedClass(Order.class);
//sessionBuilder.scanPackages("com.model");
return sessionBuilder.buildSessionFactory();
}




@Autowired
@Bean(name="userDaoImpl")
public UserDaoImpl getUserDAO(SessionFactory sessionFactory)
{
	System.out.println(" user Bean created");
return new UserDaoImpl(sessionFactory);
}

@Autowired
@Bean(name="categoryDaoImpl")
public CategoryDaoImpl getCategoryDao(SessionFactory sessionFactory)
{
	System.out.println(" Category Bean created");
return new CategoryDaoImpl(sessionFactory);
}

@Autowired
@Bean(name="productDaoImpl")
public ProductDaoImpl getProductDao(SessionFactory sessionFactory)
{
	System.out.println(" Product Bean created");
return new ProductDaoImpl(sessionFactory);
}


@Autowired
@Bean(name="supplierDaoImpl")
public SupplierDaoImpl getSupplierDao(SessionFactory sessionFactory)
{
	System.out.println(" Supplier Bean created");
return new SupplierDaoImpl(sessionFactory);
}


@Autowired
@Bean(name="orderDaoImpl")
public OrderDaoImpl getOrderDao(SessionFactory sessionFactory)
{
	System.out.println(" Order Bean created");
return new OrderDaoImpl(sessionFactory);
}


@Autowired
@Bean(name="cartDaoImpl")
public CartDaoImpl getCartDao(SessionFactory sessionFactory)
{
	System.out.println(" Cart Bean created");
return new CartDaoImpl(sessionFactory);
}




@Autowired
@Bean(name = "transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
return transactionManager;
}

}