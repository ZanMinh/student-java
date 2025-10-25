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
            System.out.println("1. Nhap thong tin hoc sinh");
            System.out.println("2. Hien thi tat ca hoc sinh");
                System.out.println("Xoa id hoc sinh");
            System.out.println("4.Sua ID hoc sinh ");
            System.out.println("5. Tim hoc sinh theo ten");
            System.out.println("6. Sap xep diem sinh vien giam dan");
            System.out.println("7. Sap xep diem sinh vien tang dan");
            System.out.println("8. Luu danh sach sinh vie");
            System.out.println("9. Tai danh sach sinh vien");
            System.out.println("0. Exit");
            System.out.print("Chon tuy chon khac: ");

            while (!sc.hasNextInt()) {
                System.out.print("KKhong hop le.Vui long nhap lai: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap so luong sinh vien: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Khong hop le. Vui long nhap lai: ");
                        sc.next();
                    }
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n Sinh vien " + (i + 1) + " ---");
                        Student student = new Student();
                        student.enterStudentInfo();
                        studentList.studentList.add(student);
                    }
                    break;

                case 2:
                    studentList.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Nhap ID sinh vien de xoa: ");
                    String deleteId = sc.nextLine();
                    if (studentList.deleteStudentById(deleteId)) {
                        System.out.println("Hoc sinh da xoa thanh cong.");
                    } else {
                        System.out.println("Khong tim thay hoc sinh nao.");
                    }
                    break;

                case 4:
                    System.out.print("Nhap ID sinh vien de chinh sua: ");
                    String editId = sc.nextLine();
                    studentList.editStudentById(editId);
                    break;

                case 5:
                    System.out.print("Tim kiem ten sinh vien: ");
                    String name = sc.nextLine();
                    ArrayList<Student> r = studentList.findStudentByName(name);
                    if (r.isEmpty()) {
                        System.out.println("Khong tim thay hoc sinh nao.");
                    } else {
                        for (Student s : r) {
                            s.displayStudentInfo();
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 6:
                    studentList.sortByGpa();
                    System.out.println("Sap xep diem trung binh giam dan.");
                    break;

                case 7:
                    studentList.sortByName();
                    System.out.println("Sap xep diem trung binh tang dan.");
                    break;

                case 8:
                    System.out.print("Nhap ten tep de luu: ");
                    String saveFile = sc.nextLine();
                    studentList.saveToFile(saveFile);
                    break;

                case 9:
                    System.out.print("Nhap ten tep de tai: ");
                    String loadFile = sc.nextLine();
                    studentList.loadFromFile(loadFile);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Tuy chon khong hop le. Vui long nhap lai.");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}