package PracticeFileIO.Service;
import PracticeFileIO.entity.Student;

import java.util.List;

public class StudentService {
    public void saveStudent(Student student){
        FileService.saveToFile(student.toData());
        System.out.println("Save Successfully");
    }
    public List<Student> getStudent(){
        return null;
    }
}
