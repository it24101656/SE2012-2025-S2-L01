import java.util.Scanner;

public class Grade{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a mark: ");
		int mark = input.nextInt();
		String grade = getGrade(mark);

		System.out.printf(grade); 
	}

	static String getGrade(int mark){
		if(mark >= 90)
			return "Grade A";
		else if(mark >= 80)
			return "Grade B";
		else if(mark >= 70)
			return "Grade C";
		else if(mark >= 60)
			return "Grade D";
		else 
			return "Fail";
	}
}