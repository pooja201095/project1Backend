package com.DaoImpl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.ProductDao;
import com.Dao.Categorydao;
import com.Model.User;
import com.Model.Category;
import com.Model.Product;
@SuppressWarnings("Unused")
@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	
	 public ProductDaoImpl(SessionFactory sessionFactory)
	{
				this.sessionFactory= sessionFactory;
	}
	
	
	public void insertproduct(Product pro)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(pro);
		session.getTransaction().commit();
	}
	
	public List<Product> retrive()
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<Product> list= session.createQuery("from product").list();
		session.getTransaction().commit();
		return list;
	}
	
	public Product findById(int pid)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Product p=null;
		try{
			session.getTransaction();
			p=session.get(Product.class,pid);
			session.getTransaction().commit();
			
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
	}

}
