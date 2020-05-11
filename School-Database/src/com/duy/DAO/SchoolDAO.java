package com.duy.DAO;

import java.util.List;

import com.duy.entity.Classes;
import com.duy.entity.Student;

public interface SchoolDAO {
	public List<Classes> getClassRoom();
	public void getClassRoom(String nameClass);
	public void addStudent(Student student, String classRoom);
	public void addStudent(int id, String classRoom);
	public void addClass(Classes classRoom);
	public List<Student> getStudents();
	public Student getStudent(int id);
	public void updateStudent(int id, Student newStudent);
	public void deleteStudent(int id);
	public void deleteClass(int id);
}
