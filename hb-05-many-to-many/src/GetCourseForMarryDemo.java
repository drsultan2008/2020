
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Reviewer;
import com.luv2code.demo.entity.Student;

public class GetCourseForMarryDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviewer.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id = 2;
			System.out.println("Getting...");
			Student tmpStudent = session.get(Student.class, id);
			
			System.out.println("Course of Hien: " + tmpStudent.getCourses());
			
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
