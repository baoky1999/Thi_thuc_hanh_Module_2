package Thi_thuc_hanh_Module_2.views;

import Thi_thuc_hanh_Module_2.models.Student;
import Thi_thuc_hanh_Module_2.repositories.StudentsRepo;
import Thi_thuc_hanh_Module_2.services.CommonCheck;
import mvc.models.BenhAn;

import java.util.List;
import java.util.Scanner;

public class ViewStudents {

    public int viewMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hệ thống quản lý dánh sách sinh viên:");
        System.out.println("1,Thêm mới sinh viên");
        System.out.println("2,Xóa sinh viên");
        System.out.println("3,Xem danh sách sinh viên");
        System.out.println("4,Xem danh sách giáo viên");
        System.out.println("5,Tìm kiếm sinh viên");
        System.out.println("6,Thoát");
        int choice = CommonCheck.checkParseInteger();
        return choice;
    }

    public Student inputStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên:");
        String name = CommonCheck.checkRegexPoint();
        String gender;
        boolean check;
        do {
            System.out.println("Nhập ngày sinh:");
            gender = sc.nextLine();
            check = CommonCheck.isDay(gender);
        }while(!check);

        System.out.println("Nhập số điện thoại");
        String phone = CommonCheck.checkRegexPhone();
        System.out.println("Nhập giới tính học sinh:");
        String email = sc.nextLine();
        String codeClass = StudentsRepo.readCodeClass();
        Student student = new Student(name,gender,phone,email,codeClass);
        return student;
    }

    public int remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id sinh viên cần xóa:");
        int id = CommonCheck.checkParseInteger();
        return id;
    }

    public boolean confirmDelete(Student student) {
        System.out.println("Bạn có chắc chắn muốn xóa sinh viên có mã: " + student.getStudentCode() + " này không ? Bấm YES để xác nhận xóa, Bấm NO để hủy thao tác.");
        Scanner input = new Scanner(System.in);
        String confirm = input.nextLine();
        if (confirm.equals("YES")) {
            return true;
        } else {
            return false;
        }
    }

    public void messageDelete(boolean result) {
        if (result) {
            System.out.println("Xóa sinh viên thành công");
        } else {
            System.out.println("Xóa sinh viên thất bại");
        }
    }

    public void displayAllStudent(List<Student> students) {
        System.out.println("----Danh sách bệnh án----");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
