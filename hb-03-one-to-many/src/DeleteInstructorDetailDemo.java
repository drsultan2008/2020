import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id =3;
			
			System.out.println("Getting...");
			InstructorDetail tmpInstructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("InstructorDetail: "+tmpInstructorDetail);
			
			System.out.println("Instructor get from instructorDetail method: " + tmpInstructorDetail.getInstructor());
			
			// removed associated object 
			// break bi-directional 
			// MY KEY
			tmpInstructorDetail.getInstructor().setInstructorDetail(null);;
			
			System.out.println("Detelting...");
			session.delete(tmpInstructorDetail);
			
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
