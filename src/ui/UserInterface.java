package ui;

import exceptions.DuplicateStudentException;
import exceptions.InvalidStudentDataException;
import exceptions.StudentNotFoundException;
import model.Student;
import service.StudentManager;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private StudentManager manager;

    public UserInterface(Scanner scanner, StudentManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }

    // display menu to user
    public void displayMenu() {
        System.out.println();
        System.out.println("=====CHOOSE AN OPTION=====");

        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Search Student by Name");
        System.out.println("5. Display All Students");
        System.out.println("6. Exit");
    }

    // main loop running method
    public void run() {
        // flag variable
        boolean running = true;

        while (running) {

            // display the menu options to user
            displayMenu();
            System.out.print("Enter your choice: ");

            // get the user input in string as it is safer (no buffer issue) and no NumberFormatException
            String userInput = scanner.nextLine().trim();

            // handle user input using switch
            switch (userInput) {
                case "1" -> addNewStudentFlow();
                case "2" -> removeStudentFlow();
                case "3" -> searchStudentByIdFlow();
                case "4" -> searchStudentByNameFlow();
                case "5" -> displayAllStudentsFlow();
                case "6" -> {
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option! Please enter a number between 1 and 6");
            }
        }
    }

    // handle addNewStudentFlow()
    private void addNewStudentFlow() {
        System.out.println("-----Add New Student-----");

        System.out.println("Enter Student's ID: ");
        String id = scanner.nextLine().trim();

        System.out.println("Enter Student's Name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Enter Student's Email: ");
        String email = scanner.nextLine().trim();

        System.out.println("Enter Student's Age: ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter Student's Grade: ");
        double grade = Double.parseDouble(scanner.nextLine().trim());

        // create a new student
        try {
            Student student = new Student(id, name, email, age, grade);
            manager.addStudent(student);
        }
        catch (DuplicateStudentException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidStudentDataException e){
            System.out.println("Create a Valid Student: " + e.getMessage());
        }
    }

    // handle removeStudentFlow()
    private void removeStudentFlow() {
        System.out.println("Enter Student's ID to Remove: ");
        String id = scanner.nextLine().trim();

        try {
            manager.removeStudent(id);
            System.out.println("Success: Student with ID " + id + " has been removed.");
        }
        catch (InvalidStudentDataException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
        catch (StudentNotFoundException e) {
            System.out.println("Remove Error: " + e.getMessage());
        }

    }

    // handle searchStudentByIdFlow()
    private void searchStudentByIdFlow() {
        System.out.println("Enter Student's ID to Search: ");
        String id = scanner.nextLine().trim();

        try {
            Student student = manager.searchStudent(id);
            System.out.printf("%-12s %-20s %-30s %-5s %-6s%n", "ID", "Name", "Email", "Age", "Grade");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("%-12s %-20s %-30s %-5d %-6.1f%n",
                    student.getStudentId(),
                    student.getName(),
                    student.getEmail(),
                    student.getAge(),
                    student.getGrade());
        } catch (InvalidStudentDataException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // handle searchStudentByNameFlow()
    private void searchStudentByNameFlow() {
        System.out.println("Enter Student's Name to Search: ");
        String name = scanner.nextLine().trim();

        List<Student> matchedStudents = manager.searchStudentByName(name);
        if (matchedStudents == null || matchedStudents.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        // print header
        System.out.printf("%-12s %-20s %-30s %-5s %-6s %n", "ID", "Name", "Email", "Age", "Grade");
        System.out.println("--------------------------------------------------------------------------------");
        for (Student s : matchedStudents) {
            System.out.printf("%-12s %-20s %-30s %-5d %-6.1f %n", s.getStudentId(), s.getName(), s.getEmail(), s.getAge(), s.getGrade());
        }
    }

    // handle displayAllStudentsFlow()
    private void displayAllStudentsFlow() {
        System.out.println("-----Display All Students-----");

        List<Student> students = manager.getAllStudents();
        if (students == null || students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        // Print header
        System.out.printf("%-12s %-20s %-30s %-5s %-6s%n", "ID", "Name", "Email", "Age", "Grade");
        System.out.println("--------------------------------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-12s %-20s %-30s %-5d %-6.1f%n",
                    s.getStudentId(),
                    s.getName(),
                    s.getEmail(),
                    s.getAge(),
                    s.getGrade());
        }
    }
}




