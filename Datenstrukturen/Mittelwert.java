import java.util.LinkedList;
import java.util.Scanner;

public class Mittelwert {
	
	private double number;
	
	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}
		
	public static void main(String[] args) {
		
		public Mittelwert(double number) {
			super();
			this.number = number;
		}
		
		LinkedList<Mittelwert> mittelwerte = new LinkedList<>();
	
		System.out.println("Geben Sie mehrere Doublewerte ein!");
		Scanner scannerVariable = new Scanner(System.in);
		String userInput = scannerVariable.nextLine();
		
		if(userInput.contentEquals("quit")) {
			
		} else {
			mittelwerte.add(new Mittelwert(userInput));
		}

	}
}
