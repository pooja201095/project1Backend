package com.DaoImpl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.Categorydao;
import com.Model.Cart;
import com.Model.Product;
import com.Model.User;
import com.Model.Category;
@SuppressWarnings("deprecation")
@Repository("cartDaoImpl")

public class CartDaoImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public void insertcart(Cart cart)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cart> findCartById(String userEmail)
	{
		Session session= sessionFactory.openSession();
		List<Cart> p=null;
		
		
		try{
			session.beginTransaction();
			
			p=(List<Cart>)session.createQuery("FROM Cart where userMailId=:email").setString("email", userEmail).list();
			session.getTransaction().commit();
			
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
	}
	public Cart getCartbyId(int cartId,String userEmail)
	{
		Session session= sessionFactory.openSession();
		Cart cart=null;
		session.beginTransaction();
		cart=(Cart)session.createQuery("FROM Cart where userMailId=:email and cartProductId=:id").setString("email", userEmail).setInteger("id", cartId).uniqueResult();
		session.getTransaction().commit();
		return cart;
	}
	
	
	public void deleteCart(int cartId)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Cart cart=(Cart)session.get(Cart.class,cartId);
		session.delete(cart);
		session.getTransaction().commit();
	}
	
	public void updateCart(Cart c)
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
