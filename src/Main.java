import model.Student;
import model.StudentManagementSystem;

public class Main {

    public static void main(String[] args) {
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
        studentManagementSystem.addStudent(new Student("12345", "John Doe", "keshavgill030@gmail.com", 20, 5.0));
        studentManagementSystem.addStudent(new Student("67890", "Jane Smith", "jane.smith@gmail.com", 22, 4.7));

        Student foundStudent = studentManagementSystem.searchStudent("12345");
        System.out.println(foundStudent);
    }
}