
/*Author- Alark Patel 
Project 1 - Maintaining homeworklist assignment. 
*/
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class homeworklist {
	public static ArrayList<assignment> hw = new ArrayList<assignment>();
	public static Scanner scan = new Scanner(System.in);
	public static String date;

	public static void main(String args[]) {
		for (int i = 0; i <= 1; i++) {
			switch (menu()) {
			case 1:
				add();
				i = 0;
				break;
			case 2:
				remove();
				i = 0;
				break;
			case 3:
				orderedlist();
				i = 0;
				break;
			case 4:
				findbyDate();
				i = 0;
				break;
			}
		}

	}

	static int menu() {
		System.out.println("1> Add a new Assignment and Date." + "\n2> Remove an Assignment."
				+ "\n3> List in Order it was assign." + "\n4> Find Assigment(s) wiht early due date.");
		String select = scan.nextLine();
		int choice = Integer.parseInt(select);
		return choice;
	}

	public static void add() {
		System.out.print("Input Assignement:");
		String inputassign = scan.nextLine();
		System.out.print("Input Date in ONLY (mm/dd/yy) format:");
		date = scan.nextLine();

		if (date.isEmpty() || inputassign.isEmpty()) {
			System.out.println("You need an Input");
		} else {
			System.out.println("Your Assignment is added.");
		}
		assignment task1 = new assignment(inputassign, date);
		hw.add(task1);
		// System.out.println(hi.toString());
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void remove() {
		System.out.print("Input assignment which needs to remove:");
		String rem = scan.nextLine();
		if (hw.isEmpty()) {
			System.out.println("Your List is empty.");
		}
		if (hw.size() == 0) {
			System.out.println("You need to add assignment first and try again.");
		} else {
			if (rem.isEmpty()) {
				System.out.println("You need an Input");
			} else {
				System.out.println("Assignment is Removed");
				hw.remove(rem);
			}

		}

		// assignment task2 = new assignment("", rem);
		// System.out.println("Size of the new list" + hw.size());

	}

	public static void orderedlist() {
		if (hw.isEmpty()) {
			System.out.println("You need Input first. ");
		} else {
			for (int i = 0; i < hw.size(); i++) {
				System.out.println(hw.get(i).toString());
			}
		}
	}

	public static void findbyDate() {
		// SimpleDateFormat df = new SimpleDateFormat(date);
		DateTimeFormatter df = DateTimeFormatter.ofPattern(date);
		Collections.sort(hw, (s1, s2) -> LocalDateTime.parse((CharSequence) s1, df)
				.compareTo(LocalDateTime.parse((CharSequence) s2, df)));
		for (assignment ds : hw) {
			System.out.println(ds);
		}
		/*
		 * if (hw.size() == 0) { System.out.println("Input Assignment and Date "); }
		 * else { for (int i = 0; i < hw.size(); i++) { System.out.println(hw.get(i)); }
		 * }
		 */
	}

}
