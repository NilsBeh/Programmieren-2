import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class pwMain {
	
	public static void main(String[] args) {
		
		try {
			File file = new File("text.txt");
			FileWriter out = new FileWriter(file);
			PrintWriter writer = new PrintWriter(out);
			writer.println("Hallo, wie gehts?");
			writer.close();
			out.close();
			Scanner scanner = new Scanner(file);
			String line = scanner.nextLine();
			System.out.println(line);
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
