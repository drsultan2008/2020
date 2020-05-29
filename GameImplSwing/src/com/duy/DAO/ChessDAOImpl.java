package com.duy.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.duy.entity.Board;
import com.duy.entity.User;

public class ChessDAOImpl implements ChessDAO {
	private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Board.class)
	.addAnnotatedClass(User.class).buildSessionFactory();
	private Session session;
	
	@Override
	public void addBoard(Board board) {
		session = factory.getCurrentSession();
		
		try {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	@Override
	public void addUserName(User user) {
		session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("===>Saving");
			
			Query<User> query = session.createQuery("from User where name like :userName", User.class);
			query.setParameter("userName",user.getName());
			List<User> theUser = query.getResultList();
			
			if (theUser.isEmpty()) {
				System.out.println("<=== Create new username!");
				session.save(user);
				session.getTransaction().commit();
				System.out.println("===>Saved!");
			}
			else {
				System.out.println("===> Username founded");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

}
