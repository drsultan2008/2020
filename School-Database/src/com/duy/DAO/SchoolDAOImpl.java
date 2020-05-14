package com.duy.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.duy.entity.Classes;
import com.duy.entity.Student;

public class SchoolDAOImpl implements SchoolDAO {

	private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Classes.class)
			.addAnnotatedClass(Student.class).buildSessionFactory();
	private Session session;

	@Override
	public List<Classes> getClassRoom() {
		session = factory.getCurrentSession();
		List<Classes> list = null;

		try {
			session.beginTransaction();

			Query<Classes> query = session.createQuery("from Classes", Classes.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("==> All classes:");
		for (Classes i : list) {
			System.out.println("==>" + i);
		}

		return list;
	}

	@Override
	public void addStudent(Student student, String classRoom) {
		session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			System.out.println("===>Saving..." + student);
			session.save(student);

			Query<Classes> query = session.createQuery("from Classes where name = :nameClass", Classes.class);
			query.setParameter("nameClass", classRoom);
			List<Classes> theClass = query.getResultList();

			if (theClass.isEmpty()) {
				System.out.println("===>Not found class, computer is creating new class !");
				Classes newClass = new Classes(classRoom);
				session.save(newClass);
				theClass.add(newClass);
			}

			theClass.get(0).addStudent(student);

			session.getTransaction().commit();
			System.out.println("===>Saved!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void addClass(Classes classRoom) {
		session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			System.out.println("===>Saving..." + classRoom);
			session.save(classRoom);
			session.getTransaction().commit();
			System.out.println("===>Saved!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void main(String args[]) {
		SchoolDAO schoolDAO = new SchoolDAOImpl();
		Classes classRoom = new Classes("Java Core");
		Student studentOne = new Student("Pham T.T Hien", 9, 9, 9);
		Student studentTwo = new Student("Le Quang Duy", 9, 9, 9);

//		schoolDAO.addClass(classRoom);
//		schoolDAO.addStudent(studentTwo, "JavaCore");;
//		System.out.println(schoolDAO.getClassRoom().toString());
		schoolDAO.getClassRoom();
//		schoolDAO.getClassRoom("Java Core");
//		schoolDAO.addStudent(3, "JavaEz");
//		schoolDAO.addStudent(1, "JavaEz");

		for (Student i:schoolDAO.getStudents()) {
			System.out.println("===>"+i);
		};
		
		schoolDAO.bestStudent();
//		schoolDAO.deleteStudent(9);
//		schoolDAO.deleteClass(5);

//		schoolDAO.getClassRoom("Java Core");

//		schoolDAO.addStudent(new Student("LE QUANG DUY",10,10,10), "Java Core");
//		schoolDAO.bestStudent();
//		System.out.println(schoolDAO.getStudent(9));
//		schoolDAO.getStudent(1);
//		schoolDAO.getStudent(3);
		
//		schoolDAO.deleteClass(6);
		
//		schoolDAO.getStudent(1);
//		schoolDAO.getStudent(3);
//		schoolDAO.updateStudent(9, new Student("Le Quang Duy",9,9,9));
//		schoolDAO.getStudent(9);
	}

	@Override
	public void getClassRoom(String nameClass) {
		session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Query<Classes> query = session.createQuery("from Classes where name = :nameClass", Classes.class);
			query.setParameter("nameClass", nameClass);
			List<Classes> theClass = query.getResultList();

			if (theClass.isEmpty()) {
				System.out.println("===>Not found class");
			} else {
				System.out.println("===>Class name: " + theClass.get(0).getName());

				System.out.println("===>List student: ");
				List<Student> listStudent = theClass.get(0).getStudent();
				for (Student i : listStudent) {
					System.out.println("===>" + i);
				}
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void addStudent(int id, String classRoom) {
		session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Query<Student> queryStudent = session.createQuery("from Student where id = :idStudent", Student.class);
			queryStudent.setParameter("idStudent", id);
			List<Student> listStudent = queryStudent.getResultList();

			if (listStudent.isEmpty()) {
				System.out.println("===>Not found student !");
				return;
			}

			Query<Classes> queryClass = session.createQuery("from Classes where name = :nameClass", Classes.class);
			queryClass.setParameter("nameClass", classRoom);
			List<Classes> theClass = queryClass.getResultList();

			if (theClass.isEmpty()) {
				System.out.println("===>Not found class, computer is creating new class !");
				Classes newClass = new Classes(classRoom);
				session.save(newClass);
				theClass.add(newClass);
			}

			theClass.get(0).addStudent(listStudent.get(0));

			session.getTransaction().commit();
			System.out.println("===>Saved!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Student> getStudents() {
		session = factory.getCurrentSession();
		List<Student> list = null;

		try {
			session.beginTransaction();

			Query<Student> query = session.createQuery("from Student", Student.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Student getStudent(int id) {
		session = factory.getCurrentSession();
		List<Student> listStudent = null;
		try {
			session.beginTransaction();

			Query<Student> queryStudent = session.createQuery("from Student where id = :idStudent", Student.class);
			queryStudent.setParameter("idStudent", id);
			listStudent = queryStudent.getResultList();

			if (listStudent.isEmpty()) {
				System.out.println("===>Not found student !");
				return null;
			}

			System.out.println("===>" + listStudent.get(0));

			if (listStudent.get(0).getClasses().isEmpty()) {
				System.out.println("===>Not join any class");
			} else {
				System.out.println("===> Class join:");
				for (Classes i : listStudent.get(0).getClasses()) {
					System.out.println("===> " + i);
				}
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listStudent.get(0);
	}

	@Override
	public void updateStudent(int id, Student newStudent) {
		Student student = getStudent(id);
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			student.setFullName(newStudent.getFullName());
			student.setChemistry(newStudent.getChemistry());
			student.setMath(newStudent.getMath());
			student.setPhysical(newStudent.getPhysical());
			session.saveOrUpdate(student);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("===>Updated!");
	}

	@Override
	public void deleteStudent(int id) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Student student = session.get(Student.class, id);
			
			if (student == null) {
				System.out.println("==> Not found the Student");
				return;
			}
			
			System.out.println("===>Deleting");
			session.delete(student);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("===>Deleted!");
	}

	@Override
	public void deleteClass(int id) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Classes classes = session.get(Classes.class, id);
			
			if (classes == null) {
				System.out.println("===> Not found class");
				return;
			}
			
			System.out.println("===>Deleting");
			session.delete(classes);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("===>Deleted!");
	}

	@Override
	public Student bestStudent() {
		session = factory.getCurrentSession();
		List<Student> listStudent = null;
		try {
			session.beginTransaction();
			String sql = "from Student ORDER BY math DESC, physical DESC, chemistry DESC";
			Query<Student> query = session.createQuery(sql).setMaxResults(5);
			listStudent = query.getResultList();
			
			System.out.println("===> Top 5 best of best student all class:");
			for (Student i:listStudent) {
				System.out.println("===>"+i);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listStudent.get(0);
	}
}
