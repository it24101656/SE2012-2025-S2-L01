import java.util.Scanner;

public class Marks {
	static int[][] marks;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of students: ");
		int sCount = sc.nextInt();
		sc.nextLine();

		marks = new int[sCount][3];

		while (true) {
			System.out.println("\n-----MENU-----");
			System.out.println("1. Add student marks: (add [studentID])");
			System.out.println("2. Update student mark: (update [studentID] [subjectID])");
			System.out.println("3. Get the average for a subject: (average_s [subjectID])");
			System.out.println("4. Get the average for a student: (average [studentID])");
			System.out.println("5. Get the total mark of a student: (total [studentID])");
			System.out.println("6. Display the marks: (display)");
			System.out.println("7. Exit");

			System.out.printf("\n* studentID should be a number between 1 and %d\n", sCount);
			System.out.println("** subjectID should be 1 = Mathematics, 2 = Chemistry, 3 = Physics");
			System.out.print("\nGive your input according to the formats given: ");

			String input = sc.nextLine().toLowerCase().trim();
			String[] parts = input.split(" ");

			if (parts.length == 0 || parts[0].isEmpty()) 
				continue;

			if (parts[0].equals("exit")) {
				System.out.println("\nExiting...");
				break;
			}

			else if (parts[0].equals("add") && parts.length == 2) {
				int student = Integer.parseInt(parts[1]) - 1;
				if (student >= 0 && student < sCount) {
					System.out.print("\nEnter Mathematics marks: ");
					marks[student][0] = sc.nextInt();
					System.out.print("Enter Chemistry marks: ");
					marks[student][1] = sc.nextInt();
					System.out.print("Enter Physics marks: ");
					marks[student][2] = sc.nextInt();
					sc.nextLine();
					System.out.println("\nMarks added");
				}
			}

			else if (parts[0].equals("update") && parts.length == 3) {
				int student = Integer.parseInt(parts[1]) - 1;
				int subject = Integer.parseInt(parts[2]) - 1;
				if (student >= 0 && student < sCount && subject >= 0 && subject < 3) {
					System.out.print("\nEnter new mark: ");
					marks[student][subject] = sc.nextInt();
					sc.nextLine();
					System.out.println("Mark updated");
				}
			}

			else if (parts[0].equals("average_s") && parts.length == 2) {
				int subject = Integer.parseInt(parts[1]) - 1;
				if (subject >= 0 && subject < 3) {
					int i, total = 0;
					for (i = 0; i < sCount; i++) {
						total += marks[i][subject];
					}
					double average = (double) total / sCount;
					System.out.printf("\nAverage mark for subject %d: %.2f\n", subject + 1, average);
				}
			}

			else if ((parts[0].equals("average") || parts[0].equals("total")) && parts.length == 2) {
				int student = Integer.parseInt(parts[1]) - 1;
				if (student >= 0 && student < sCount) {
					int i, total = 0;
					for (i = 0; i < 3; i++) {
						total += marks[student][i];
					}
					if (parts[0].equals("average")) {
						double average = (double) total / 3;
						System.out.printf("\nAverage mark for student %d: %.2f\n", student + 1, average);
					} else {
						System.out.printf("\nTotal mark for student %d: %d\n", student + 1, total);
					}
				}
			}

			else if (parts[0].equals("display")) {
				System.out.printf("\nStudent\t\tM    C    P\n");
				for (int i = 0; i < sCount; i++) {
					System.out.printf("%d\t\t%d   %d   %d\n", i + 1, marks[i][0], marks[i][1], marks[i][2]);
				}
			}

		}
	}
}
