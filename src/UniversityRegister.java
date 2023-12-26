import java.util.*;
import java.util.stream.Collectors;

public class UniversityRegister {
    private final ArrayList<Student> students;

    public UniversityRegister() {
        students = new ArrayList<>();
    }
    
    static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Module: " + student.getModule());
            System.out.println();
        }
    }

    public void addStudent(String name, int id, String course, String module) {
        Student studentWithSameId = findStudentWithSameId(id);
        if (studentWithSameId != null) {
            String errorMessage = "A student with ID " + id + " already exists.";
            throw new IllegalArgumentException(errorMessage);
        }

        Student newStudent = new Student(name, id, course, module);
        System.out.println(newStudent.getName());
        students.add(newStudent);
    }

    private Student findStudentWithSameId(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void removeStudent(int id) {
        boolean wasRemoved = students.removeIf(student -> student.getId() == id);
        if(!wasRemoved){
            System.out.println("No student found with ID: " + id);
        } else {
            students.removeIf(student -> student.getId() == id);
            System.out.println(students);
            displayStudents(students);
        }
    }

    public List<Student> queryStudentsByName(String name) {

        return students.stream()
                .filter(student -> student.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Student> queryStudentsByCourse(String course, String searchText) {
        return students.stream()
                .filter(student -> student.getCourse().equals(course) && student.getName().contains(searchText))
                .collect(Collectors.toList());
    }

    public List<Student> queryStudentsByModule(String module) {
        return students.stream()
                .filter(student -> student.getModule().equals(module))
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudentsOnModuleSortedByMarks(String module) {
        // Implement this function to sort students by marks, if you have a marks attribute in the Student class.
        // You can use functional programming constructs to achieve this.
        return null;
    }

    public List<Student> getStudentsByCourseAndName(String course, String searchText) {
        // Implement this function to filter students by course and name using functional programming.
        return null;
    }

    public List<Student> getStudentsWhoseNamesStartWith(char letter) {
        // Implement this function to filter students whose names start with a given letter using functional programming.
        return null;
    }



}
