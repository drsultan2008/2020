package com.luv2code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			// Query Students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			// Display Students
			System.out.println();
			for (Student iter: theStudents) {
				System.out.println(iter);
			}
			
			// Query where firtName  = 'Le'
			theStudents = session.createQuery("from Student s where s.lastName='Le'").getResultList();
			// Display Students
			for (Student iter:theStudents) {
				System.out.println(iter);
			}
				
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
