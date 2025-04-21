package myprojects.studentcourseregistrationsystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private String email;
    private List<Course> enrolledCourses;

    public Student(String id, String name, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course) && course.addStudent(this)) {
            enrolledCourses.add(course);
            System.out.println("Enrolled in course: " + course.getCourseName());
        } else {
            System.out.println("Enrollment failed.");
        }
    }

    public void dropCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
            course.removeStudent(this);
            System.out.println("Dropped course: " + course.getCourseName());
        } else {
            System.out.println("You are not enrolled in this course.");
        }
    }

    public void viewCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("No enrolled courses.");
        } else {
            System.out.println("Enrolled Courses:");
            for (Course c : enrolledCourses) {
                System.out.println("- " + c.getCourseName() + " (" + c.getCourseCode() + ")");
            }
        }
    }
}
