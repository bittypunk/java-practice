package objects9;

public class ITECCourseManager {
    public static void main(String[] args) {
        ITECCourse maintenanceCourse = new ITECCourse("Microcomputer Systems Maintenance",
                1310, 20);

        // Add some students
        // check that we haven't exceeded the max

        maintenanceCourse.addStudent("Anna");
        maintenanceCourse.addStudent("Bill");
        maintenanceCourse.addStudent("Carl");

        maintenanceCourse.writeCourseInfo();

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
