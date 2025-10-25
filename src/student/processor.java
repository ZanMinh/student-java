package student;

import java.util.ArrayList;
import java.util.Scanner;

public class processor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList studentList = new StudentList();
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Enter student information");
            System.out.println("2. Display all students");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Edit student by ID");
            System.out.println("5. Find student by name");
            System.out.println("6. Sort students by GPA (descending)");
            System.out.println("7. Sort students by name (ascending)");
            System.out.println("8. Save student list to file");
            System.out.println("9. Load student list from file");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of students: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Invalid input. Enter a number: ");
                        sc.next();
                    }
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Student " + (i + 1) + " ---");
                        Student student = new Student();
                        student.enterStudentInfo();
                        studentList.studentList.add(student);
                    }
                    break;

                case 2:
                    studentList.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = sc.nextLine();
                    if (studentList.deleteStudentById(deleteId)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to edit: ");
                    String editId = sc.nextLine();
                    studentList.editStudentById(editId);
                    break;

                case 5:
                    System.out.print("Enter name to search: ");
                    String name = sc.nextLine();
                    ArrayList<Student> r = studentList.findStudentByName(name);
                    if (r.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : r) {
                            s.displayStudentInfo();
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 6:
                    studentList.sortByGpa();
                    System.out.println("Sorted by GPA (descending).");
                    break;

                case 7:
                    studentList.sortByName();
                    System.out.println("Sorted by name (ascending).");
                    break;

                case 8:
                    System.out.print("Enter filename to save: ");
                    String saveFile = sc.nextLine();
                    studentList.saveToFile(saveFile);
                    break;

                case 9:
                    System.out.print("Enter filename to load: ");
                    String loadFile = sc.nextLine();
                    studentList.loadFromFile(loadFile);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option, try again.");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}