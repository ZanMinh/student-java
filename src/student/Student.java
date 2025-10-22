package student;

import java.util.Scanner;

public class Student {

    long id;
    int age;
    String name, gender, rank;
    double average, math, literature, english;

    public void calculateAverage() {
        average = (math + literature + english) / 3;
    }

    public void calculateRank() {
        if (average >= 8) {
            rank = "Gioi";
        } else if (average >= 6.5 && average < 8) {
            rank = "kha";
        } else if (average >= 5 && average < 6.5) {
            rank = "trung binh";
        } else {
            rank = "yeu";
        }
    }

    public Student(long id, String name, String gender, int age,
            double math, double literature, double english) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.math = math;
        this.literature = literature;
        this.english = english;
        calculateAverage();
        calculateRank();
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Ten: " + name
                + ", Gioi tinh: " + gender
                + ", tuoi: " + age
                + ", toan: " + math
                + ", Van: " + literature
                + ", Anh: " + english
                + ", TB: " + String.format("%.2f", average)
                + ", Hoc luc: " + rank;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long id;
        System.out.print("Nhap ID: ");
        id = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();

        System.out.print("Nhap gioi tinh: ");
        String gender = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        int age = sc.nextInt();

        System.out.print("Nhap diem toan: ");
        double math = sc.nextDouble();

        System.out.print("Nhap diem Van: ");
        double physics = sc.nextDouble();

        System.out.print("Nhap diem Anh: ");
        double chemistry = sc.nextDouble();

        Student s = new Student(id, name, gender, age, math, physics, chemistry);
        System.out.println("\nThong tin sinh vien:");
        System.out.println(s);
    }
}
