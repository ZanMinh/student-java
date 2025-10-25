package student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    String studentId;
    String fullName;
    Date dateOfBirth;
    String major;
    float gpa;

    public void enterStudentInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        studentId = sc.nextLine();

        System.out.print("Enter Full Name: ");
        fullName = sc.nextLine();

        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        String dateOfBirthString = sc.nextLine();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dateOfBirth = sdf.parse(dateOfBirthString);
        } catch (ParseException e) {
            System.out.println("Invalid date. Using current date.");
            dateOfBirth = new Date();
        }

        System.out.print("Enter Major: ");
        major = sc.nextLine();

        System.out.print("Enter GPA: ");
        gpa = sc.nextFloat();
    }

    public void editStudentById(String editId) {
        Scanner sc = new Scanner(System.in);
        if (this.studentId.equals(editId)) {
            System.out.print("Enter Full Name: ");
            fullName = sc.nextLine();

            System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
            String dateOfBirthString = sc.nextLine();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                dateOfBirth = sdf.parse(dateOfBirthString);
            } catch (ParseException e) {
                System.out.println("Invalid date. Not changed.");
            }

            System.out.print("Enter Major: ");
            major = sc.nextLine();

            System.out.print("Enter GPA: ");
            gpa = sc.nextFloat();
        } else {
            System.out.println("N/A");
        }
    }

    public void displayStudentInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Student ID: " + studentId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + sdf.format(dateOfBirth));
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
    }
}