package myprojects.studentcourseregistrationsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationSystem {

    private Map<String,Student> studentMap;
    private List<Course> courses;

    public RegistrationSystem() {
        studentMap = new HashMap<>();
        courses = new ArrayList<>();
        seedCourses();
    }

    public void registerStudent(String name, String  id, String email){
        if (!studentMap.containsKey(id)) {
            studentMap.put(id, new Student(name,id,email));
            System.out.println("Student registered.");
        }
        else {
            System.out.println("Student already exists.");
        }
    }

    public  Student getStudent(String id){
        return studentMap.get(id);
    }

    public void showCourses(){
        for (Course c: courses) {
            System.out.println(c);
        }
    }

    public Course getCourseByCode(String code){
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)){
                return c;
            }
        }
        return null;

    }


    private void seedCourses() {
        courses.add(new Course("CS101", "Intro to CS", 3));
        courses.add(new Course("MATH201", "Calculus I", 2));
        courses.add(new Course("ENG105", "Academic Writing", 2));
    }

}
