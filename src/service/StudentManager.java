package service;

import exceptions.DuplicateStudentException;
import exceptions.InvalidStudentDataException;
import exceptions.StudentNotFoundException;
import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {

    private Map<String, Student> students;

    public StudentManager() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) throws DuplicateStudentException, InvalidStudentDataException {
        // check if student is null
        if (student == null) {
            throw new InvalidStudentDataException("Student can not be null");
        }

        // add student to map if does not exists
        if (!students.containsKey(student.getStudentId())) {
            students.put(student.getStudentId(), student);
        }
        else {
            throw new DuplicateStudentException("Student already exists: " + student);
        }
    }

    public void removeStudent(String studentId) throws StudentNotFoundException, InvalidStudentDataException{
        // check if student id is null or empty
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new InvalidStudentDataException("Student Id can not be null or empty");
        }

        // check if student exists and then remove
        if (!students.containsKey(studentId)) {
            throw new StudentNotFoundException("Student does not exist: " + studentId);
        }
        students.remove(studentId);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student searchStudent(String studentId) throws StudentNotFoundException, InvalidStudentDataException{
        // check if student id is null or empty
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new InvalidStudentDataException("Student Id can not be null or empty");
        }

        // check if student id exists and then return
        if (students.get(studentId) == null) {
            throw new StudentNotFoundException("Student Id does not exist: " + studentId);
        }
        return students.get(studentId);
    }

    public List<Student> searchStudentByName(String searchName) {
        // store matching students in a list
       List<Student> matches = new ArrayList<>();

       // check each student in map
       for (Student student : students.values()) {
           // check if current student's name contains searchName partially or fully
           if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
               matches.add(student);
           }
        }

       return matches;
    }
}
