package FirstProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	public static final String clg_name="MIT Academy of Engineering";
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		FileHandler fh = new FileHandler();
		
		System.out.println("Welcome to Student Management System");
		
		while(true){
			System.out.println(" <==== Student Management System ===> ");
	        System.out.println("1.Add Student");
	        System.out.println("2.View All Students");
	        System.out.println("3.Search Student");
	        System.out.println("4.Update Student");
	        System.out.println("5.Delete Student");
	        System.out.println("6.Sort Students");
	        System.out.println("7.Show Topper");
	        System.out.println("8.Count Students");
	        System.out.println("9.Export to Text File");
	        System.out.println("10.Exit");

	        System.out.print("Enter your choice: ");
	        int choice = sc.nextInt();

	        switch (choice) {

	            case 1:
	            	addStudent(fh);
	                break;
	            
	            case 2:
	            	viewStudents(fh);
	                break;
	            
	            case 3:
	                searchStudent(fh);
	                break;
	            
	            case 4:
	                updateStudent(fh);
	                break;
	            	            
	            case 5:
	            	deleteStudent(fh);
	                break;
	           
	            case 6:
	            	sortStudents(fh);
	                break;

	            case 7:
	                showTopper(fh);
	                break;

	            case 8:
	                countStudents(fh);
	                break;           
	                
	            case 9:
	            	exportToTextFile(fh);	
	            	break;
	            case 10:
	            	System.out.println("Closing the Student management System...");
	                return;
	            	                
	            default:
	                System.out.println("Invalid choice. Try again...!");
	        }
	        System.out.println();//empty line 
	    }
		
//		addStudent(fh);
//		viewStudents(fh);
//		searchStudent(fh);
//		updateStudent(fh);
	}
	
	
	public static void addStudent(FileHandler fh)  {
		ArrayList<Student> students = fh.readStudents();
//		System.out.print("Enter Id: ");
		
		int id = inputValidId(students);
		
		sc.nextLine();
		
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter no of Subjects : ");
		int n = sc.nextInt();
		
		ArrayList<Integer> marks = new ArrayList<Integer>();
		
		for(int i = 0;i<n;i++) {
			int temp;
			
			while(true) {
				System.out.print("Enter mark for subject_"+(i+1)+" = ");
				temp = sc.nextInt();
				
				if(temp >=0 && temp<=100) {
					break;
				}else {
					System.out.println("Invalid Marks, enter valid mark from 0-100");
				}
			}
			marks.add(temp);
		}
		
		Student newStudent = new Student(id, name, marks);
		students.add(newStudent);
		
		fh.writeStudents(students);//students data saved here
		
		System.out.println("Student added to jail successfully");
	}
	
	public static int inputValidId(ArrayList<Student> students) {

	    int id;

	    while (true) {
	        System.out.print("Enter Student ID: ");

	        try {
	            id = sc.nextInt();  // try to read integer

	            if (id <= 0) {
	                System.out.println("ID must be positive.");
	                continue;
	            }

	            boolean duplicate = false;

	            for (Student s : students) {
	                if (s.getId() == id) {
	                    duplicate = true;
	                    break;
	                }
	            }

	            if (duplicate) {
	                System.out.println("ID already exists. Try another.");
	            } else {
	                break;
	            }

	        } catch (Exception e) {
	            System.out.println("Invalid input. Please enter a number.");
	            sc.next(); // clear wrong input
	        }
	    }

	    return id;
	}
	
	public static void viewStudents(FileHandler fh) {
		ArrayList<Student> students = fh.readStudents();
		
		if(students.isEmpty()) {
			System.out.println("No Data found");
			return;
		}
		
		System.out.println("All students Info");
		System.out.println("ID\tName\tNoOfSub\t\t%age");		
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public static void searchStudent(FileHandler fh) {
		ArrayList<Student> students = fh.readStudents();
		
		if(students.isEmpty()) {
			System.out.println("No student is Available");
			return;
		}
		
//		System.out.println("Enter Student id to search : ");
		
		int id = inputExistingId(students);

	    boolean found = false;

	    for (Student s : students) {
	        if (s.getId() == id) {
	            System.out.println("Student found:");
	            System.out.println(s);
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("Student not found.");
	    }
	}
	
	public static void updateStudent(FileHandler fh)  {
		ArrayList<Student> students = fh.readStudents();
		
		if(students.isEmpty()) {
			System.out.println("NO students available");
			return;
		}
		
//		System.out.print("Enter Student ID to update: ");
	    int id = inputExistingId(students);
	    boolean found = false;

	    for (Student s : students)  {
	        if (s.getId() == id) {

	            System.out.println("Student Found:");
	            System.out.println(s);

	            System.out.println("What do you want to update?");
	            System.out.println("1.Name");
	            System.out.println("2.Marks");

	            int choice = sc.nextInt();
	            sc.nextLine();

	            if (choice == 1) {
	                System.out.print("Enter new name: ");
	                String newName = sc.nextLine();
	                s.setName(newName);

	            } else if (choice == 2) {

	                System.out.print("Enter number of subjects: ");
	                int n = sc.nextInt();

	                ArrayList<Integer> newMarks = new ArrayList<>();

	                for (int i = 0; i < n; i++) {
	                    int mark;

	                    while (true) {
	                        System.out.print("Enter marks for subject " + (i + 1) + ": ");
	                        mark = sc.nextInt();

	                        if (mark >= 0 && mark <= 100) {
	                            break;
	                        } else {
	                            System.out.println("Invalid marks. Try again.");
	                        }
	                    }

	                    newMarks.add(mark);
	                }

	                s.setMarks(newMarks);
	                
	            }

	            fh.writeStudents(students);

	            System.out.println("Student updated successfully.");
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("Student not found.");
	    }
		
	}
	
	public static void deleteStudent(FileHandler fh) {

	    ArrayList<Student> students = fh.readStudents();

	    if (students.isEmpty()) {
	        System.out.println("No students available.");
	        return;
	    }

//	    System.out.print("Enter Student ID to delete: ");
	    int id = inputExistingId(students);

	    ArrayList<Student> updatedList = new ArrayList<>();

	    boolean found = false;

	    for (Student s : students) {
	        if (s.getId() == id) {
	            found = true;
	            continue; // skip this student
	        }
	        updatedList.add(s);
	    }

	    if (found) {
	        fh.writeStudents(updatedList);
	        System.out.println("Student deleted successfully.");
	    } else {
	        System.out.println("Student not found.");
	    }
	}
	
	public static void sortStudents(FileHandler fh) {

	    ArrayList<Student> students = fh.readStudents();

	    if (students.isEmpty()) {
	        System.out.println("No students available.");
	        return;
	    }

	    System.out.println("Choose sorting option:");
	    System.out.println("1. Sort by Percentage");
	    System.out.println("2. Sort by Name");
	    System.out.println("3. Sort by ID");

	    int choice = sc.nextInt();

	    switch (choice) {

	        case 1:
	            students.sort(new SortByPercentage());
	            System.out.println("Sorted by Percentage");
	            break;

	        case 2:
	            students.sort(new SortByName());
	            System.out.println("Sorted by Name");
	            break;
	        case 3:
	            students.sort(new SortById());
	            System.out.println("Sorted by ID");
	            break;

	        default:
	            System.out.println("Invalid choice.");
	            return;
	    }

	    for (Student s : students) {
	        System.out.println(s);
	    }
	}
	
	public static void showTopper(FileHandler fh) {

	    ArrayList<Student> students = fh.readStudents();

	    if (students.isEmpty()) {
	        System.out.println("No students available");
	        return;
	    }

	    Student topper = students.get(0);

	    for (Student s : students) {
	        if (s.getPercentage() > topper.getPercentage()) {
	            topper = s;
	        }
	    }

	    System.out.println("Topper:");
	    System.out.println("ID\tName\tNoOfSub\t\t%age");
	    System.out.println(topper);
	    System.out.println("lets Celebrate for : " + topper.getName());
	}
	
	public static void countStudents(FileHandler fh) {

	    ArrayList<Student> students = fh.readStudents();

	    System.out.println("Total Students: " + students.size());
	}
	
	public static int inputExistingId(ArrayList<Student> students) {

	    int id;

	    while (true) {
	        System.out.print("Enter Student ID: ");

	        try {
	            id = sc.nextInt();

	            if (id <= 0) {
	                System.out.println("ID must be positive.");
	                continue;
	            }

	            boolean found = false;

	            for (Student s : students) {
	                if (s.getId() == id) {
	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                System.out.println("ID not found. Try again.");
	            } else {
	                break;
	            }

	        } catch (Exception e) {
	            System.out.println("Invalid input. Enter numeric ID.");
	            sc.next(); // clear invalid input
	        }
	    }

	    return id;
	}
	
	public static void exportToTextFile(FileHandler fh) {

	    ArrayList<Student> students = fh.readStudents();

	    if (students.isEmpty()) {
	        System.out.println("No students available to export.");
	        return;
	    }

	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("studentReport.txt"))) {

	        // Header
	        bw.write("ID\tName\tSubjects\tPercentage");
	        bw.newLine();

	        // Data
	        for (Student s : students) {
	            bw.write(
	                s.getId() + "\t" +
	                s.getName() + "\t" +
	                s.getNumOfSubjects() + "\t\t" +
	                String.format("%.2f", s.getPercentage())
	            );
	            bw.newLine();
	        }

	        System.out.println("Data exported successfully to studentReport.txt");

	    } catch (IOException e) {
	        System.out.println("Error writing file: " + e.getMessage());
	    }
	}
}
	
