import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
			Instructor tmpInstructor = session.get(Instructor.class, id);			
			
			System.out.println("Duy:Instructor: "+tmpInstructor);
			
			System.out.println("Duy:Course of Instructor: " + tmpInstructor.getCourse());
			session.getTransaction().commit();
			
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
