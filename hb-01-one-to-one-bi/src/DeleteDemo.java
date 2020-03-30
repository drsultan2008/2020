import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int instructorId =1;
			session.beginTransaction();
			
			Instructor tmpInstructor = session.get(Instructor.class, instructorId);
			
			if (tmpInstructor != null) {
				System.out.println("Deleting " + tmpInstructor);
				session.delete(tmpInstructor);
			}
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
