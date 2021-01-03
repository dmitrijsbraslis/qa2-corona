package model;

import java.util.List;

public class Course {
    private String name;
    private int startDate;
    private List<Student> students;

    public Course(String name, int startDate, List<Student> students) {
        this.name = name;
        this.startDate = startDate;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public int getStartDate() {
        return startDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printInfo() {
        System.out.println("Course: " + name + " starting from " + startDate);
        System.out.println("Students of this course:");
        for (Student student : students) {
            System.out.println(student.getFullName());
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
