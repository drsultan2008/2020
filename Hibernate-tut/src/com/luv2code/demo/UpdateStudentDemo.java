package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int idStudent = 1;
			Student tmpStudent = session.get(Student.class, idStudent);
			
			// set First Name
			tmpStudent.setFirstName("Le Quang");
			System.out.println("Updating...");
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			// NEW
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='quangduynb00@gmail.com'");
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}
