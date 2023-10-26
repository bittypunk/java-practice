package objects9;

import java.util.ArrayList;
import java.util.List;

public class ITECCourse {

    //      fields / dot methods
    String name;
    int code;
    int max;
    List<String> students;
    boolean enrolled;


    // constructor, a method with the same name as the class. No return type
    ITECCourse(String courseName, int courseCode, int courseMaxStudents) {
        this.name = courseName;
        this.code = courseCode;
        this.students = new ArrayList<>(); // sets up student list
        this.max = courseMaxStudents;
    }

    void addStudent(String studentName) {
        // check to see if the course is full before adding a new student
        if (students.size() == max) {
            System.out.println("Course is full - can't add " + studentName);
        } else {
            students.add(studentName);
        }
    }

    void removeStudent(String studentName) {
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
}
