package myprojects.studentcourseregistrationsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistrationSystem registrationSystem = new RegistrationSystem();
        Scanner scanner = new Scanner(System.in);
        Student currentStudent = null;

        while (true) {
            System.out.println("\n--- Student Course Registration ---");
            System.out.println("1. Register a student");
            System.out.println("2. Show all courses");
            System.out.println("3. Enroll in a course");
            System.out.println("4. Drop a course");
            System.out.println("5. View enrolled courses");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    registrationSystem.registerStudent(name, id, email);
                    currentStudent = registrationSystem.getStudent(id);
                    break;
                case "2":
                    registrationSystem.showCourses();
                    break;
                case "3":
                    if (currentStudent == null) {
                        System.out.println("Please register first.");
                        break;
                    }
                    registrationSystem.showCourses();
                    System.out.print("Enter course code to enroll: ");
                    String courseCode = scanner.nextLine();
                    Course course = registrationSystem.getCourseByCode(courseCode);
                    if (course != null) {
                        currentStudent.enrollCourse(course);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case "4":
                    if (currentStudent == null) {
                        System.out.println("Please register first.");
                        break;
                    }
                    currentStudent.viewCourses();
                    System.out.print("Enter course code to drop: ");
                    String dropCode = scanner.nextLine();
                    Course dropCourse = registrationSystem.getCourseByCode(dropCode);
                    if (dropCourse != null) {
                        currentStudent.dropCourse(dropCourse);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case "5":
                    if (currentStudent != null) {
                        currentStudent.viewCourses();
                    } else {
                        System.out.println("Please register first.");
                    }
                    break;
                case "6":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
