package objects7;

import java.util.ArrayList;
import java.util.List;

public class ITECCourse {

    //      fields / dot methods
    private String name;
    private int code;
    private int max;
    private List<String> students;
    private boolean enrolled;


    // constructor, a method with the same name as the class. No return type
    public ITECCourse(String courseName, int courseCode, int courseMaxStudents) {
        this.name = courseName;
        this.code = courseCode;
        this.students = new ArrayList<>(); // sets up student list
        this.max = courseMaxStudents;
    }
    // "this" refers to the object that the code is running for
    // can be used to remove ambiguity between instance variables and arguments passed into methods
    // similar to "self" in python
    // isn't required if there's no ambiguity in variable names, liek with class variables and method/constructor arguments

    public void addStudent(String studentName) {
        // check to see if the course is full before adding a new student
        if (students.size() == max) {
            System.out.println("Course is full - can't add " + studentName);
        } else {
            students.add(studentName);
        }
    }

    public void removeStudent(String studentName) {
        if (students.contains(studentName)) {
            students.remove(studentName);
            System.out.println(studentName + " was un-enrolled from " + name);
        } else {
            System.out.println(studentName + " was not found in " + name);
        }
    }

    void writeCourseInfo() {
        System.out.println("Course Name: " + name);
        System.out.println("Course Code: " + code);
        System.out.println("Students enrolled:");
        for (String student : students) {
            System.out.println(student);
        }
        System.out.println("There are " + getNumberOfStudents() + " students enrolled");
        System.out.println("The max number of students for this course is " + max);
    }

    int getNumberOfStudents() {
        return this.students.size();
    }

            // getter/setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // no variable ambiguity could be written as

    // public void setName(String n) {
    //      name = n;   }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
