package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Init add
		Session session = factory.getCurrentSession();
		try {
			// Add tmpStudent to Database
			session.beginTransaction();
			Student tmpStudent = new Student("Nguyen", "An", "nguyenvananymb@gmail.com");
			
			System.out.println("Saving to the Database");
			session.save(tmpStudent);
			
			session.getTransaction().commit();
			System.out.println("Saved!");
			
			// Get new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with id: "+ tmpStudent.getId());
			
			Student myStudent = session.get(Student.class, tmpStudent.getId());
	
			System.out.println("Get complete: "+ myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
			
		
	}
}
