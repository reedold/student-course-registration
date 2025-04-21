package myprojects.studentcourseregistrationsystem;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private  String courseName;
    private int maxCapacity;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.enrolledStudents = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean addStudent(Student student){
        if (enrolledStudents.size()< maxCapacity && ! enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public void removeStudent(Student student){
        enrolledStudents.remove(student);
    }

    public int getAvailableSeats(){
        return maxCapacity - enrolledStudents.size();
    }



    @Override
    public String toString() {
        return courseCode + " - " + courseName + " | Seats left: " + getAvailableSeats();
    }
}
