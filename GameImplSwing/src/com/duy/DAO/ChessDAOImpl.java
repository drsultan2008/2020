package com.duy.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.duy.entity.Board;
import com.duy.entity.User;

public class ChessDAOImpl implements ChessDAO {
	private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Board.class)
	.addAnnotatedClass(User.class).buildSessionFactory();
	private Session session;
	
	@Override
	public void addBoard(Board board) {
		
	}

	@Override
	public void addUserName(User user) {
		session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("===>Saving");
			session.save(user);
			session.getTransaction().commit();
			System.out.println("===>Saved!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

}
