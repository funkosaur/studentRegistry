import java.util.*;
import java.util.stream.Collectors;

public class UniversityRegister {
    private ArrayList<Student> students;

    public UniversityRegister() {
<<<<<<< Updated upstream
        students = new ArrayList<>();
=======
        students = new ArrayList<Student>();
>>>>>>> Stashed changes
    }


    public void addStudent(String name, int id, String course, String module) {
        Student student = new Student(name, id, course, module);
        System.out.println(student.getName());
        students.add(student);
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
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
