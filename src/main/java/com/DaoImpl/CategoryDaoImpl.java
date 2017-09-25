package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.Categorydao;
import com.Model.Product;
import com.Model.User;
import com.Model.Category;
@SuppressWarnings("Unused")
@Repository("categoryDaoImpl")
public class CategoryDaoImpl implements Categorydao
{

	
		@Autowired
		SessionFactory sessionFactory;
		
		 public CategoryDaoImpl(SessionFactory sessionFactory)
		{
					this.sessionFactory= sessionFactory;
		}
		
		
		public void insertcategory(Category category)
		{
			Session session= sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(category);
			session.getTransaction().commit();
		}
		
		public List<Category> retrive()
		{
			Session session= sessionFactory.openSession();
			session.beginTransaction();
			List<Category> list= session.createQuery("FROM Category").list();
			session.getTransaction().commit();
			return list;
		}
		
		public Category findById(int cid)
		{
			Session session= sessionFactory.openSession();
			session.beginTransaction();
			Category p=null;
			try{
				session.getTransaction();
				p=session.get(Category.class,cid);
				session.getTransaction().commit();
				
			}
			catch(HibernateException ex)
			{
				ex.printStackTrace();
				session.getTransaction().rollback();
			}
			return p;
		}
		
		
		public void deleteCategory(int cid)
		{
			Session session= sessionFactory.openSession();
			session.beginTransaction();
			Category category=(Category)session.get(Category.class,cid);
			session.delete(category);
			session.getTransaction().commit();
		}
		
		public void updateCategory(Category c)
		{
			Session session= sessionFactory.openSession();
			try{
			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
			}
			catch(HibernateException ex){
				ex.printStackTrace();
				session.getTransaction().rollback();
			}
		}
}

