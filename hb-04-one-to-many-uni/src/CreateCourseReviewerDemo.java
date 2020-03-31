
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Reviewer;

public class CreateCourseReviewerDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviewer.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// Create new course and new comments
			Course tmpCourse = new Course("Learning Java");
			tmpCourse.add(new Reviewer("This course is amazing"));
			tmpCourse.add(new Reviewer("Perfect to learning"));
			tmpCourse.add(new Reviewer("This course is dump, are you stupid ?"));
			
			System.out.println("Saving this course & comments");
			session.save(tmpCourse);
			
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
