package Exercies;

public class Student {
	private String name;
	private double score;
	private String birthDay;
	
	public Student(String name, double score, String birthDay) {
		super();
		this.name = name;
		this.score = score;
		this.birthDay = birthDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", birthDay=" + birthDay + "]";
	}
	
}
