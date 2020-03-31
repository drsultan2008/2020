import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id =1;
			
			System.out.println("Getting...");
			
			// Option 2: Hibernate query with HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.course where i.id=:theInstructorId");
			// Set parameter query
			query.setParameter("theInstructorId", id);
			// Executed query & get Instructor
			Instructor tmpInstructor = query.getSingleResult();
			
			session.getTransaction().commit();
			session.close();
			System.out.println("Session closed!");
			
			// Option 1: get before session close
			System.out.println("Duy:Instructor: "+tmpInstructor);
			
			System.out.println("Duy:Course of Instructor: " + tmpInstructor.getCourse());
			
			System.out.println("Done!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}	}

}
