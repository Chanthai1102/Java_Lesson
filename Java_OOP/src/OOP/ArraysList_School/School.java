package OOP.ArraysList_School;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SimpleTimeZone;

public class School {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();

    public void registerStudent(Student student){
        students.add(student);
    }
    public void displayStudent(){
        for (Student student: students){
            System.out.println("Name : " + student.getName() + " Gender : " + student.getGender());
        }
    }
    public void removeStudent(int studentID){
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if (student.getId() == studentID){
                iterator.remove();
            }
        }
    }
    public void sortByName(){
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        students.sort(comparator);
    }
    public Student findByName(String name){
        for (Student student : students){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }
    public void updateStudent(int studentID, Student newStudent){
        for (Student student : students){
            if (student.getId() == studentID){
                student.setGender(newStudent.getGender());
                student.setName(newStudent.getName());
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
