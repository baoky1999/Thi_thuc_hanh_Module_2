package Thi_thuc_hanh_Module_2.repositories;

import Thi_thuc_hanh_Module_2.models.Student;
import mvc.models.BenhAn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsRepo {
    static final String URL_CODE = "Module2\\src\\Thi_thuc_hanh_Module_2\\data\\batchs.csv";
    static final String URL_DATA = "Module2\\src\\Thi_thuc_hanh_Module_2\\data\\students.csv";
    static final String URL_DATATERCHER = "Module2\\src\\Thi_thuc_hanh_Module_2\\data\\teacher.csv";
    public static String readCodeClass() {

            File file = new File(URL_CODE);
            try(FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader))
            {
               String line;
               while ((line = bufferedReader.readLine()) != null) {
                   return line;
               }
            } catch (FileNotFoundException e) {
                System.err.println("Không tìm thất File");
            } catch (IOException e) {
                System.err.println("Lỗi đọc dữ liệu File");
            }
            return null;
    }

    private void writeFile(List<Student> student, boolean append) {
        File file = new File(URL_DATA);
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Student students : student) {
                bufferedWriter.write(students.toString());
                bufferedWriter.newLine();
                System.out.println("Thêm mới thành công");
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi File!");
        }
    }

    public void addStudent(Student student) {
        List<Student> students = getAllAdmin();
        students.add(student);
        writeFile(students, false);
    }

    public List<Student> getAllAdmin() {
        List<Student> students = new ArrayList<>();
        File file = new File(URL_DATA);

        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tem = line.split(",");
                students.add(new Student(tem[0],tem[1],tem[2],tem[3],tem[4]));

            }

        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thất File");
        } catch (IOException e) {
            System.err.println("Lỗi đọc dữ liệu File");
        }
        return students;
    }

    public Student findStudent(int id) {
        List<Student> students = getAllAdmin();
        for (Student student : students) {
            if(student.getStudentCode() == id){
                return student;
            }
        }
        return null;
    }

    public void remove(Student student) {
        List<Student> students = getAllAdmin();
        int index = students.size();
        for (int i = 0; i < index; i++) {
            if (students.get(i).getStudentCode() == student.getStudentCode()) {
                students.remove(i);
                break;
            }
        }
        writeFile(students, false);
        for (Student b : students) {
            writeFile((List<Student>) b, true);
        }
    }

    public List<Student> getAllTeacher() {
        List<Student> students = new ArrayList<>();
        File file = new File(URL_DATATERCHER);

        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tem = line.split(",");
                students.add(new Student(tem[0],tem[1],tem[2],tem[3],tem[4]));

            }

        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thất File");
        } catch (IOException e) {
            System.err.println("Lỗi đọc dữ liệu File");
        }
        return students;
    }
}
