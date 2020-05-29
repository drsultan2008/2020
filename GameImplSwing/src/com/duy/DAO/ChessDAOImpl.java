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
	public void addBoard(Board board,User user) {
		session = factory.getCurrentSession();
			
		try {
			session.beginTransaction();
			Query<User> query = session.createQuery("from User where name like :userName",User.class);
			query.setParameter("userName", user.getName());
			List<User> userName = query.getResultList();
			
			if (userName.isEmpty()) {
				System.out.println("?");
			}
			else {
				userName.get(0).add(board);
			}
			
			session.getTransaction().commit();
			System.out.println("===>Saved");
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
	

	@Override
	public List<Board> getBoards(User user) {
		session = factory.getCurrentSession();
		List<Board> boards = null;
		
		try {
			session.beginTransaction();
			
			Query<Board> query = session.createQuery("from Board where id_user =: id",Board.class);
			query.setParameter("id", user.getId());
			boards = query.getResultList();
			
			if (boards.isEmpty()) {
				System.out.println("===> Board is Empty");
				return null;
			}
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return boards;
	}

	@Override
	public User getUser(String userName) {
		session = factory.getCurrentSession();
		List<User> user = null;
		
		try {
			session.beginTransaction();
			Query<User> query = session.createQuery("from User where name like :userName",User.class);
			query.setParameter("userName", userName);
			user = query.getResultList();
			
			if (user.isEmpty()) {
				System.out.println("===>Not found userName");
				return null;
			}
			
			session.getTransaction().commit();
			return user.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return null;
	}

}
