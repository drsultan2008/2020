import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor tmpInstructor = new Instructor("Le"," Quang Duy", "quangduynb00@gmail.com");
			
			InstructorDetail tmpInstructorDetail = new InstructorDetail("youtube.com/lammualamgio","Duy Le");
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			System.out.println("Saving...");
			session.save(tmpInstructor);
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}
