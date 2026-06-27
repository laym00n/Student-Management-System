import model.Student;
import service.StudentManager;

public class Main {

    public static void main(String[] args) {
        // create a new student object
        Student student1 = new Student("S0001", "John Doe", "keshavgill030@gmail.com", 20, 5.0);
        Student student2 = new Student("54321", "Jane Smith", "jane.smith@example.com", 22, 4.8);
        Student student3 = new Student("98765", "Michael Brown", "m.brown@university.edu", 21, 4.5);


        StudentManager manager = new StudentManager();

        manager.addStudent(student1);

        manager.addStudent(student2);


        System.out.println(manager.searchStudentByName("Jo"));
    }
}