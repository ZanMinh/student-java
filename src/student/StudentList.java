
package student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentList {

    ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent() {
        Student s = new Student();
        s.enterStudentInfo();
        studentList.add(s);
        System.out.println("hoc sinh da them thanh cong!\n");
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
                System.out.println("khong tim thay hoc sinh nao.\n");
            return;
        }
        System.out.println("Danh sach sinh vien");
        for (Student s : studentList) {
            s.displayStudentInfo();
            System.out.println("-------------------------");
        }
    }

    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> r = new ArrayList<>();
        for (Student s : studentList) {
            if (contains(s.fullName, name)) {
                r.add(s);
            }
        }
        return r;
    }

    private boolean contains(String str, String sub) {
        if (str == null || sub == null) {
            return false;
        }
        String a = str.toUpperCase();
        String b = sub.toUpperCase();
        for (int i = 0; i <= a.length() - b.length(); i++) {
            boolean match = true;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    public void editStudentById(String id) {
        boolean found = false;
        for (Student s : studentList) {
            if (s.studentId.equalsIgnoreCase(id)) {
                s.editStudentById(id);
                System.out.println("Cap nhat sinh vien thanh cong!\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoc sinh nao.\n");
        }
    }

    public boolean deleteStudentById(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).studentId.equalsIgnoreCase(id)) {
                studentList.remove(i);
                System.out.println("Hoc sinh da xoa thanh cong!\n");
                return true;
            }
        }
        System.out.println("Khong tim thay học sinh.\n");
        return false;
    }

    public void sortByName() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = 0; j < studentList.size() - i - 1; j++) {
                if (compare(studentList.get(j).fullName,
                        studentList.get(j + 1).fullName) > 0) {
                    Student tmp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, tmp);
                }
            }
        }
        System.out.println("Sap xep theo ten.\n");
    }

    public void sortByGpa() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = 0; j < studentList.size() - i - 1; j++) {
                if (studentList.get(j).gpa < studentList.get(j + 1).gpa) {
                    Student tmp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, tmp);
                }
            }
        }
        System.out.println("sap xep theo GPA.\n");
    }

    private int compare(String a, String b) {
        int len;
        if (a.length() < b.length()) {
            len = a.length();
        } else {
            len = b.length();
        }

        for (int i = 0; i < len; i++) {
            char c1 = Character.toUpperCase(a.charAt(i));
            char c2 = Character.toUpperCase(b.charAt(i));
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return a.length() - b.length();
    }

    public void saveToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : studentList) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                bw.write(s.studentId + ";" + s.fullName + ";" + s.dateOfBirth.getTime() + ";"
                        + s.major + ";" + s.gpa);
                bw.newLine();
            }
            System.out.println("Lưu file thanh cong.\n");
        } catch (IOException e) {
            System.out.println("Loi khi luu tep: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) {
        studentList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    Student s = new Student();
                    s.studentId = parts[0];
                    s.fullName = parts[1];
                    try{
                         s.dateOfBirth = sdf.parse(parts[2]);
                    } catch(ParseException e) {
                        System.out.println("Ngay khong hop le " + s.studentId);
                        s.dateOfBirth = new Date();
                    }
                    s.major = parts[3];
                    s.gpa = Float.parseFloat(parts[4]);
                    studentList.add(s);
                }
            }
            System.out.println("Da tai tep thanh cong.\n");
        } catch (IOException e) {
                System.out.println("Loi tep: " + e.getMessage());
        }
    }
}
