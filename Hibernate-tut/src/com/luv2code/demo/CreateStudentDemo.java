package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// Create the session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// Create the session
		Session session = factory.getCurrentSession();
		
		try {
			Student tmpStudent = new Student("Le","Duy","quangduyn00@gmail.com");
			// start transaction
			session.beginTransaction();
			// save tmpStudent
			session.save(tmpStudent);
			System.out.println("Saving tmpStudent...");
			// commit
			session.getTransaction().commit();
			System.out.println("Save successful!");
		}
		finally{
			factory.close();
		}
	}

}
