package Thi_thuc_hanh_Module_2.controllers;

import Thi_thuc_hanh_Module_2.models.Student;
import Thi_thuc_hanh_Module_2.repositories.StudentsRepo;
import Thi_thuc_hanh_Module_2.views.ViewStudents;

import java.util.List;

public class ControllerStudents {

    public void controllerMenu() {

        ViewStudents viewStudents = new ViewStudents();
        StudentsRepo studentsRepo = new StudentsRepo();
        int choice;
        while(true) {
            choice = viewStudents.viewMenu();
            switch(choice) {
                case 1:
                    Student student = viewStudents.inputStudent();
                    studentsRepo.addStudent(student);
                    break;
                case 2:
                    int removeStudent = viewStudents.remove();
                    Student student1 =  studentsRepo.findStudent(removeStudent);
                    if (student1 == null) {
                        viewStudents.messageDelete(false);
                    } else {
                        boolean isConfirm = viewStudents.confirmDelete(student1);
                        if (isConfirm) {
                            studentsRepo.remove(student1);
                            viewStudents.messageDelete(true);
                            return;
                        } else {
                            viewStudents.messageDelete(false);
                        }
                    }
                    break;
                case 3:
                    List<Student> studentAll = studentsRepo.getAllAdmin();
                    viewStudents.displayAllStudent(studentAll);
                    break;
                case 4:
                    List<Student> studentAllTeacher = studentsRepo.getAllTeacher();
                    viewStudents.displayAllStudent(studentAllTeacher);
                    break;
                case 5:
                    break;
                case 6:
                    return;
            }
        }
    }

}
