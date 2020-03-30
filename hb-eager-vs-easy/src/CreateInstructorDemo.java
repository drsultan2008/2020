import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor tmpInstructor = new Instructor("Le"," Quang Duyy", "quangduynb00@gmail.com");
			
			InstructorDetail tmpInstructorDetail = new InstructorDetail("youtube.com/lammualamgio","Duy Le");
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			System.out.println("Saving...");
			session.save(tmpInstructor);
			
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
