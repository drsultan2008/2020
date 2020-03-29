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
			displayStudents(theStudents);
			
			// Query where firtName  = 'Le'
			theStudents = session.createQuery("from Student s where s.lastName='Le'").getResultList();
			System.out.println();
			displayStudents(theStudents);
			
			// Query firstName= 'Le' OR lastName='Duy'
			theStudents = session.createQuery("from Student s where s.firstName='Le' AND s.lastName='Duy'").getResultList();
			System.out.println();
			displayStudents(theStudents);
			
			// Query email end "gmail.com"
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			System.out.println();
			displayStudents(theStudents);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student iter: theStudents) {
			System.out.println(iter);
		}
	}

}
