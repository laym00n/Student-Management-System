package model;

public class Student {

    private String studentId;
    private String name;
    private String email;
    private int age;
    private double grade;

    // construtor for student
    public Student(String studentId, String name, String email, int age, double grade) {
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
