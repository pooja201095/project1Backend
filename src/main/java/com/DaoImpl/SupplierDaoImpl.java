package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.SupplierDao;
import com.Model.Category;
import com.Model.Product;
import com.Model.Supplier;
@SuppressWarnings("Unused")
@Repository("SupplierDaoImpl")
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;
	
	 public SupplierDaoImpl(SessionFactory sessionFactory)
	{
				this.sessionFactory= sessionFactory;
	}


	public void insertSupplier(Supplier supplier) {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.persist(supplier);
		session.getTransaction().commit();
		
	}
	
	public List<Supplier> retrive()
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> list= session.createQuery("FROM Supplier").list();
		session.getTransaction().commit();
		return list;
	}
	
	public Supplier findById(int sid)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Supplier p=null;
		try{
			session.getTransaction();
			p=session.get(Supplier.class,sid);
			session.getTransaction().commit();
			
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
	}
	
	
	public void deleteSupplier(int sid)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Supplier supplier=(Supplier)session.get(Supplier.class,sid);
		session.delete(supplier);
		session.getTransaction().commit();
	}
	
	public void updateSupplier(Supplier s)
	{
		Session session= sessionFactory.openSession();
		try{
		session.beginTransaction();
		session.update(s);
		session.getTransaction().commit();
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
		}

	}
}
