package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// Add 3 Student to Database
			Student tmpStudent1 = new Student("Le","Duy","quangduynb00@gmail.com");
			Student tmpStudent2 = new Student("Le","Le","quangduynb00@gmail.com");
			Student tmpStudent3 = new Student("Le","Quang","quangduynb00@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Creating 3 student");
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			session.save(tmpStudent3);
			
			session.getTransaction().commit();;
			System.out.println("Complete commit 3 student!");
			
		}
		finally {
			factory.close();
		}
	}

}
