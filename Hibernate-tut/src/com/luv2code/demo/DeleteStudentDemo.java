package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int idStudent = 1;
			// Get Student with id =1
			Student tmpStudent = session.get(Student.class, idStudent);
			
			// Delete student 
			/*
			session.delete(tmpStudent);
			System.out.println("Deleted tmpStudent");
			session.getTransaction().commit();
			*/
			// Delete student with alternate
			System.out.println("Deleting...");
			session.createQuery("delete Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}
	}

}
