package model;

import exceptions.InvalidStudentDataException;

public class Student {

    private String studentId;
    private String name;
    private String email;
    private int age;
    private double grade;

    // construtor for student
    public Student(String studentId, String name, String email, int age, double grade) {
        // validate id
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new InvalidStudentDataException("Student Id can not be null or empty");
        }

        // validate name
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentDataException("Student name can not be null or empty");
        }

        // validate email
        if (email == null || !email.contains("@")) {
            throw new InvalidStudentDataException("Student email can not be null and must contain @");
        }

        // validate age
        if (age < 18 || age > 33) {
            throw new InvalidStudentDataException("Student must be between 18 and 33 years of age");
        }

        // validate grade
        if (grade < 0.0 || grade > 10.0) {
            throw new InvalidStudentDataException("Student must have grade between 0.0 and 10.0");
        }
        
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.grade = grade;
    }

    // getter methods
    public String getStudentId(){
        return studentId;
    }

    public String getName(){
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString () {
        return String.format("Student: {id = %s, name = %s, email = %s, age = %d, grade = %.1f}", studentId, name, email, age, grade);
    }




}
