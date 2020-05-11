package com.duy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="math")
	private double math;
	
	@Column(name="physical")
	private double physical;
	
	@Column(name="chemistry")
	private double chemistry;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST})
	@JoinTable(
		name = "class_student",
		joinColumns = @JoinColumn(name="student_id"),
		inverseJoinColumns = @JoinColumn(name="class_id")
	)
	private List<Classes> classes;
	
	public Student() {}
	
	public Student(String fullName, double math, double physical, double chemistry) {
		super();
		this.fullName = fullName;
		this.math = math;
		this.physical = physical;
		this.chemistry = chemistry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getPhysical() {
		return physical;
	}

	public void setPhysical(double physical) {
		this.physical = physical;
	}

	public double getChemistry() {
		return chemistry;
	}

	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}
	
	public void addClasses(Classes theClasses) {
		if (classes == null) {
			classes = new ArrayList<>();
		}
		
		classes.add(theClasses);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", math=" + math + ", physical=" + physical
				+ ", chemistry=" + chemistry + "]";
	}
	
}
