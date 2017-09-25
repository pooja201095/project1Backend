package com.DaoImpl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.Categorydao;
import com.Model.Cart;
import com.Model.Order;
import com.Model.Product;
import com.Model.User;
import com.Model.Category;
@SuppressWarnings("Unused")
@Repository("orderDaoImpl")

public class OrderDaoImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	public OrderDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public void insertOrder(Order order)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(order);
		session.getTransaction().commit();
	}

}
