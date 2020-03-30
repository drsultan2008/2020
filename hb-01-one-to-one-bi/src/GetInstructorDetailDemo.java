import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id =2;
			
			System.out.println("Getting...");
			InstructorDetail tmpInstructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("InstructorDetail: "+tmpInstructorDetail);
			
			System.out.println("Instructor get from instructorDetail method: " + tmpInstructorDetail.getInstructor());
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}
