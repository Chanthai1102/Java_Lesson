package OOP.ArraysList_School;

public class SchoolApp {
    public static void main(String[] args){
        School school = new School();
        school.setName("thai school");
        Student student1 = new Student(1,"thai",Gender.MALE);
        Student student2 = new Student(2,"chanthai",Gender.MALE);
        school.registerStudent(student1);
        school.registerStudent(student2);
        school.displayStudent();
        school.sortByName();
        System.out.println("After Sort");
        school.displayStudent();
        Student student = school.findByName("chanthai");
        System.out.println(student.toString());
        Student newStudent = new Student("chan",Gender.FEMALE);
        school.updateStudent(2,newStudent);
        school.displayStudent();
    }
}
