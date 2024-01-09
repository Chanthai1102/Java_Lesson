package PracticeFileIO.School;

import PracticeFileIO.Service.StudentService;
import PracticeFileIO.entity.Gender;
import PracticeFileIO.entity.Student;

public class StudentApplication {
    public static void main(String[] args){
        Student student = new Student(1,"Thai", Gender.MALE, 12);
        //Student student = new Student(2,"Chan Thai", Gender.MALE, 11);
        StudentService studentService = new StudentService();
        studentService.saveStudent(student);
    }
}
