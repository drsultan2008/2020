
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Reviewer;
import com.luv2code.demo.entity.Student;

public class CreateCourseStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviewer.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// Create new course and new student

			Course tmpCourse = new Course("Learning Java C++");
			
			// Add reviewer
			tmpCourse.add(new Reviewer("This course is coool"));
			
			System.out.println("Saving course");
			session.save(tmpCourse);
			
			Student tmpStudent1 = new Student("Le", "Duy", "quangduynb00@gmail.com");
			Student tmpStudent2 = new Student("Pham", "Hien", "rongkonchemgio@gmail.com");
			
			tmpCourse.addStudent(tmpStudent1);
			tmpCourse.addStudent(tmpStudent2);
			
			System.out.println("Saving student");
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			

			
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
