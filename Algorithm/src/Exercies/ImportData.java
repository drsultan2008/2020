package Exercies;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ImportData {

	public static void main(String[] args) {
		String firstName[] = {"Le","Tran","Pham","Nguyen","Ngo","Ly","Mai"};
		String midName[] = {"Quang","Thi","Van","Quoc","Duy","Tat","Duc"};
		String lastName[] = {"Duy","Hien","Duong","Canh","Tho","Dam","Huy","Truong","Nhung","Loan","Yen","Vy"};
		
		Random ran = new Random();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("/home/duy/2020/Algorithm/src/Exercies/data.txt"))){
			for (int i=0; i<1000; i++) {
				String res = firstName[ran.nextInt(firstName.length)]+" " + midName[ran.nextInt(midName.length)]+" " +lastName[ran.nextInt(lastName.length)];
				res+="-"+Integer.toString(ran.nextInt(28))+"/"+Integer.toString(ran.nextInt(11)+1)+"/"+Integer.toString(ran.nextInt(20)+1990);
				res+="-"+Double.toString(((double)ran.nextInt(10)+ran.nextInt(10))/2);
				bw.write(res);
				bw.newLine();
			}			
			bw.write("Pham Duc Canh|12/4/1998|6.5");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
