
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        UniversityRegister register = new UniversityRegister();

        register.addStudent("John Smith",  "Computer Science", "CS101", 66);
        register.addStudent("Alice Johnson",  "Mathematics", "Math101", 45);
        register.addStudent("Bob Brown",  "Computer Science", "CS101",88);
        register.addStudent("Eve Davis",  "Physics", "PHY101",77);

        // Query students by name
        List<Student> johns = register.queryStudentsByName("John Smith");
        System.out.println("Students named John Smith: ");
        UniversityRegister.displayStudents(johns);

        // Query students by course and name
        List<Student> csJohns = register.queryStudentsByCourseAndName("Computer Science", "John");
        System.out.println("Computer Science students with 'John' in their name: ");
        UniversityRegister.displayStudents(csJohns);

        // Remove a student by ID
        register.removeStudent(4);

        // Get students whose names start with 'A'
        List<Student> aStudents = register.queryStudentsByName("Eve Davis");
        System.out.println("Students named Alice: ");
        for (Student student : aStudents) {
            System.out.println("Name: " + student.name());
        }
        register.addStudent("cgfdh",  "comp", "science", 78);

        List<Student> csJohns1 = register.getAllStudentsOnModuleSortedByMarks("CS101");
        UniversityRegister.displayStudents(csJohns1);

    }
}