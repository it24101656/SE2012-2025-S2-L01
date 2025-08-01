import java.util.Scanner;

public class Welcome{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your first name: ");
		String firstName = input.nextLine();

		System.out.print("Enter your last name: ");
		String lastName = input.nextLine();

		System.out.printf("\nWelcome to the Second Year %s %s.", firstName, lastName); 
	}
}