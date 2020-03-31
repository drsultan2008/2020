
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class CreateCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			int instructorId = 1;
			session.beginTransaction();
			// Get contructor
			Instructor tmpConstructor = session.get(Instructor.class, instructorId);
			
			// Add 2 course to Database
			Course course1 = new Course("Learning C");
			Course course2 = new Course("Learn C Advance");
			
			System.out.println("Adding course");
			tmpConstructor.add(course1);
			tmpConstructor.add(course2);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
