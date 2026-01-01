import java.util.*;

// Abstract class
abstract class Person {
	protected String name;
	protected int id;

	public Person() {
		this("Unknown", 0);
	}

	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public abstract void showDetails();
}

// Interface
interface Enrollable {
	void enroll(String course);
}

// Marker interface for University Management System
interface UniversityMember {}

// Final class with constants
final class UniversityConstants {
	public static final String UNIVERSITY_NAME = "ABC University";
	public static final int MAX_COURSES = 5;
	private UniversityConstants() {}
}

// Student class
class Student extends Person implements Enrollable, UniversityMember {
	private ArrayList<String> courses;

	public Student() {
		this("Unknown Student", 0);
	}

	public Student(String name, int id) {
		super(name, id);
		this.courses = new ArrayList<>();
	}

	@Override
	public void enroll(String course) {
		if (courses.size() < UniversityConstants.MAX_COURSES) {
			courses.add(course);
			System.out.println(name + " enrolled in " + course);
		} else {
			System.out.println("Cannot enroll in more than " + UniversityConstants.MAX_COURSES + " courses.");
		}
	}

	@Override
	public void showDetails() {
		System.out.println("Student Name: " + name);
		System.out.println("Student ID: " + id);
		System.out.println("Courses: " + courses);
	}
}

// Professor class
class Professor extends Person implements Enrollable, UniversityMember {
	private String department;
	private ArrayList<String> courses;

	public Professor() {
		this("Unknown Professor", 0, "Unknown");
	}

	public Professor(String name, int id, String department) {
		super(name, id);
		this.department = department;
		this.courses = new ArrayList<>();
	}

	@Override
	public void enroll(String course) {
		courses.add(course);
		System.out.println(name + " assigned to teach " + course);
	}

	@Override
	public void showDetails() {
		System.out.println("Professor Name: " + name);
		System.out.println("Professor ID: " + id);
		System.out.println("Department: " + department);
		System.out.println("Courses Teaching: " + courses);
	}
}

public class UniversityManagement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> people = new ArrayList<>();
		int choice;
		do {
			System.out.println("\n=== " + UniversityConstants.UNIVERSITY_NAME + " Management System ===");
			System.out.println("1. Add Student");
			System.out.println("2. Add Professor");
			System.out.println("3. Enroll Student in Course");
			System.out.println("4. Assign Course to Professor");
			System.out.println("5. Show Person Details");
			System.out.println("6. List All People");
			System.out.println("7. Exit");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1: // Add Student
					System.out.print("Enter Student Name: ");
					String sName = sc.nextLine();
					System.out.print("Enter Student ID: ");
					int sId = sc.nextInt();
					sc.nextLine();
					people.add(new Student(sName, sId));
					System.out.println("Student added.");
					break;
				case 2: // Add Professor
					System.out.print("Enter Professor Name: ");
					String pName = sc.nextLine();
					System.out.print("Enter Professor ID: ");
					int pId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Department: ");
					String dept = sc.nextLine();
					people.add(new Professor(pName, pId, dept));
					System.out.println("Professor added.");
					break;
				case 3: // Enroll Student
					System.out.print("Enter Student ID: ");
					int esId = sc.nextInt();
					sc.nextLine();
					boolean foundStudent = false;
					for (Person p : people) {
						if (p instanceof Student && p.id == esId) {
							System.out.print("Enter Course to Enroll: ");
							String course = sc.nextLine();
							((Enrollable)p).enroll(course);
							foundStudent = true;
							break;
						}
					}
					if (!foundStudent) {
						System.out.println("Student not found.");
					}
					break;
				case 4: // Assign Course to Professor
					System.out.print("Enter Professor ID: ");
					int epId = sc.nextInt();
					sc.nextLine();
					boolean foundProf = false;
					for (Person p : people) {
						if (p instanceof Professor && p.id == epId) {
							System.out.print("Enter Course to Assign: ");
							String course = sc.nextLine();
							((Enrollable)p).enroll(course);
							foundProf = true;
							break;
						}
					}
					if (!foundProf) {
						System.out.println("Professor not found.");
					}
					break;
				case 5: // Show Person Details
					System.out.print("Enter Person ID: ");
					int pid = sc.nextInt();
					sc.nextLine();
					boolean found = false;
					for (Person p : people) {
						if (p.id == pid) {
							p.showDetails();
							found = true;
							break;
						}
					}
					if (!found) {
						System.out.println("Person not found.");
					}
					break;
				case 6: // List All People
					if (people.isEmpty()) {
						System.out.println("No people in the system.");
						break;
					}
					for (Person p : people) {
						p.showDetails();
						System.out.println("-------------------");
					}
					break;
				case 7:
					System.out.println("Exiting... Thank you!");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} while (choice != 7);
		sc.close();
	}
}
