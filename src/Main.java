
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        UniversityRegister register = new UniversityRegister();

        register.addStudent("John Smith", 1, "Computer Science", "CS101");
        register.addStudent("Alice Johnson", 2, "Mathematics", "Math101");
        register.addStudent("Bob Brown", 3, "Computer Science", "CS102");
        register.addStudent("Eve Davis", 4, "Physics", "PHY101");

        // Query students by name
        List<Student> johns = register.queryStudentsByName("John Smith");
        System.out.println("Students named John Smith: ");
        UniversityRegister.displayStudents(johns);

        // Query students by course and name
        List<Student> csJohns = register.queryStudentsByCourse("Computer Science", "John");
        System.out.println("Computer Science students with 'John' in their name: ");
        for (Student student : csJohns) {
            System.out.println("Course: " + student.getCourse());
        }

        // Remove a student by ID
        register.removeStudent(4);

        // Get students whose names start with 'A'
        List<Student> aStudents = register.queryStudentsByName("Alice Johnson");
        System.out.println("Students named Alice: ");
        for (Student student : aStudents) {
            System.out.println("Name: " + student.getName());
        }
        register.addStudent("cock", 6, "comp", "science");

    }
}