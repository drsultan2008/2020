package JavaCoreThayPhuc.Week06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShapeAppIOFile {

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		
		read(shapes);
		
		displayShapes(shapes);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/duy/2020/Chaos/src/JavaCoreThayPhuc/Week06/output.txt"))){
			for (Shape shape: shapes) {
				bw.write(shape.toString());
				bw.newLine();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	private static void displayShapes(List<Shape> shapes) {
		for (Shape shape: shapes) {
			System.out.println(shape);
		}
	}

	private static void read(List<Shape> shapes) {
		try(BufferedReader br = new BufferedReader(new FileReader("/home/duy/2020/Chaos/src/JavaCoreThayPhuc/Week06/data_shape.txt"))){
			String line = null;
			
			while ((line = br.readLine())!= null) {
				String [] lineSplit = line.split(" ");
				
				if (lineSplit.length < 2 || lineSplit.length >3 ) {
					System.out.println("One line num element >=2 & <=3");
					return;
				}
				
				if (lineSplit.length == 2) {
					shapes.add(new Vector(Double.parseDouble(lineSplit[0]), Double.parseDouble(lineSplit[1])));
				}else {
					shapes.add(new Cycle(Double.parseDouble(lineSplit[0]), Double.parseDouble(lineSplit[1]),Double.parseDouble(lineSplit[1])));
				}
			}
			
			
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}

}
