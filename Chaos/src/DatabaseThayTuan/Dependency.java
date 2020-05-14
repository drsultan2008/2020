package DatabaseThayTuan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Dependency {
	private List<Piece> list;
	private String x;
	TreeSet<Character> res;

	public Dependency() {
		list = new LinkedList<>();
		res = new TreeSet<>();
	}

	public void init() {
		try (BufferedReader br = new BufferedReader(
				new FileReader("/home/duy/2020/Chaos/src/DatabaseThayTuan/Data/data.txt"))) {
			String line1 = br.readLine();
			String line2 = br.readLine();

			line1 = line1.substring(3, line1.length() - 1);
			line2 = line2.substring(2);

			x = line2;

			String arr[] = line1.split(",");

			for (String i : arr) {
				String[] part = i.split("->");
				list.add(new Piece(part[0], part[1]));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void process() {
		for (char i : x.toCharArray()) {
			res.add(i);
		}

		boolean hasChange = false;
		int index = 0;
		for (index = 0; index < list.size() || hasChange == true; index++) {
			hasChange = false;

			if (check(list.get(index).getFrom())) {
				int tmp = index;
				for (char c : list.get(index).getTo().toCharArray()) {
					if (res.add(c)) {
						hasChange = true;
						index = 0;
					}
				}
			}
		}

		System.out.println(res.toString());
	}

	public boolean check(String c) {
		for (char i : c.toCharArray()) {
			if (!res.contains(i)) {
				return false;
			}
		}

		return true;
	}

	public void displayList() {
		for (Piece i : list) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		Dependency app = new Dependency();
		app.init();
//		app.displayList();
		app.process();
	}
}
