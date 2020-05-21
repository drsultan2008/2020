package Exercies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListStudent {
	private List<Student> list;
	private String nameClass;
	
	public ListStudent(String nameClass) {
		list = new ArrayList<>();
		this.nameClass = nameClass;
		read();
	}
	
	public void read() {
		try(BufferedReader br = new BufferedReader(new FileReader("/home/duy/2020/Algorithm/src/Exercies/data.txt"))){
			String line = br.readLine();
			for (int i=0; i<1000;i++) {
				String arr[] = line.split("-");
				list.add(new Student(arr[0],Double.parseDouble(arr[2]),arr[1]));
				line = br.readLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void show() {
		for (Student i:list) {
			System.out.println(i);
		}
	}
	
	public void sortByName() {
		list.sort(new SortByName());
	}
	
	public void sortByBirthday() {
		list.sort(new SortByBirthday());
	}
	
	public void sortByScore() {
		list.sort(new SortByScore());
	}
	
	public void showTop(int n) {
		sortByScore();
		int index = 0;
		
		System.out.println("===> TOP 5:");
		for (Student i:list) {
			System.out.println(i);
			index++;
			if (index == n) {
				break;
			}
		}
	}
	
	public static void main(String args[]) {
		ListStudent list = new ListStudent("CNTT1");
		list.showTop(5);
	}
}
