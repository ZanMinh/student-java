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

        System.out.print("nhap id: ");
        studentId = sc.nextLine();

        System.out.print("nhap ten: ");
        fullName = sc.nextLine();

        System.out.print("nga sinh: ");
        String dateOfBirthString = sc.nextLine();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dateOfBirth = sdf.parse(dateOfBirthString);
        } catch (ParseException e) {
            System.out.println("Ngay sinh khong hop le.");
            dateOfBirth = new Date();
        }

        System.out.print("Ma mon: ");
        major = sc.nextLine();

        System.out.print("GPA: ");
        gpa = sc.nextFloat();
    }

    public void editStudentById(String editId) {
        Scanner sc = new Scanner(System.in);
        if (this.studentId.equals(editId)) {
            System.out.print("nhap ho ten: ");
            fullName = sc.nextLine();

            System.out.print("nhap ngay sinh: ");
            String dateOfBirthString = sc.nextLine();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                dateOfBirth = sdf.parse(dateOfBirthString);
            } catch (ParseException e) {
                System.out.println("Ngay khong hop le.");
            }

            System.out.print("Ma mon: ");
            major = sc.nextLine();

            System.out.print("nhap GPA: ");
            gpa = sc.nextFloat();
        } else {
            System.out.println("N/A");
        }
    }

    public void displayStudentInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ID: " + studentId);
        System.out.println("Ho va ten: " + fullName);
        System.out.println("Ngay sinh: " + sdf.format(dateOfBirth));
        System.out.println("Mon hoc: " + major);
        System.out.println("GPA: " + gpa);
    }
}