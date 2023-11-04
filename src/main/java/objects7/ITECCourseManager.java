package objects7;

public class ITECCourseManager {
    public static void main(String[] args) {
        ITECCourse maintenanceCourse = new ITECCourse("Microcomputer Systems Maintenance",
                1310, 20);

        // Add some students
        // check that we haven't exceeded the max

        maintenanceCourse.addStudent("Anna");
        maintenanceCourse.addStudent("Bill");
        maintenanceCourse.addStudent("Carl");

        // carl decided to drop the course
        maintenanceCourse.removeStudent("Carl");

        maintenanceCourse.writeCourseInfo();
         // can get individual variable values with getter methods
        System.out.println("Course name is: " + maintenanceCourse.getName());
        System.out.println("Course code is: " + maintenanceCourse.getCode());

        System.out.println("Max students in the course is " + maintenanceCourse.getMax());

        // and can set variables, if set methods are provided
        // can increase number of max students
        maintenanceCourse.setMax(24);
        System.out.println("The maximum number of students is now " + maintenanceCourse.getMax());


        ITECCourse datacomCourse = new ITECCourse("Data Communications",
                1425, 30);

        datacomCourse.addStudent("Dave");
        datacomCourse.addStudent("Ed");
        datacomCourse.addStudent("Flora");

        datacomCourse.writeCourseInfo();


        ITECCourse softdevelopCourse = new ITECCourse("Software Development Projects",
                2903, 24);

        softdevelopCourse.addStudent("Gus");
        softdevelopCourse.addStudent("Harry");
        softdevelopCourse.addStudent("Izzy");

        softdevelopCourse.writeCourseInfo();


    }

}
