import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectContactMain {
	
	public static void main(String[] args) {
		
		File file = new File("File_IO_V2\\contact.txt");
		if(file.exists()) {
			System.out.println("die Datei existiert");
		} else {
			System.out.println("Die Datei wird angelegt");
			try {
//				file.mkdir();
				file.createNewFile();
			} catch (IOException e) {			
				e.printStackTrace();
			}
			System.out.println("das programm lebt noch");
		}
		
		
		Contact contacteins = new Contact(2578512, "Nils Behrens");
		
		if (contacteins instanceof Contact) {
		
			try(FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
				oos.writeObject(contacteins);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
