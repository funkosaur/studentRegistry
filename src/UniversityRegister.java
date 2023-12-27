import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UniversityRegister {
    private final ArrayList<Student> students;


    public UniversityRegister() {
        students = new ArrayList<>();
    }

    static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("Name: " + student.name());
            System.out.println("ID: " + student.id());
            System.out.println("Course: " + student.course());
            System.out.println("Module: " + student.module());
            System.out.println("Mark: " + student.mark());
            System.out.println();
        }
    }

    private static int idCounter = 0;
    public void addStudent(String name, String course, String module, int mark) {
        if (name == null || course == null || module == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        int id = ++idCounter;
        Student newStudent = new Student(name, id, course, module, mark);
        students.add(newStudent);
    }

    private Student findStudentWithSameId(int id) {
        return students.stream()
                .filter(student -> student.id() == id)
                .findFirst()
                .orElse(null);
    }

    public void removeStudent(int id) {
        boolean wasRemoved = students.removeIf(student -> student.id() == id);
        if(!wasRemoved){
            System.out.println("No student found with ID: " + id);
        }
    }

    private List<Student> _queryStudents(Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Student> queryStudentsByName(String name) {
        return _queryStudents(student -> student.name().equals(name));
    }



    /*

    public List<Student> queryStudentsByName(String name) {

        return students.stream()
                .filter(student -> student.getName().equals(name))
                .collect(Collectors.toList());
    }*/

    public List<Student> queryStudentsByCourse(String course) {
        return _queryStudents(student -> student.course().equals(course));
    }

    public List<Student> queryStudentsByCourseAndName(String course, String searchText) {
        return _queryStudents(student -> student.course().equals(course) && student.name().contains(searchText));
    }

    public List<Student> queryStudentsByModule(String module) {
        return _queryStudents(student -> student.module().equals(module));
    }

    /* public List<Student> queryStudentsByModule(String module) {
        return students.stream()
                .filter(student -> student.getModule().equals(module))
                .collect(Collectors.toList());
    }*/



    public List<Student> getAllStudentsOnModuleSortedByMarks(String module) {
        return students.stream()
                .filter(student -> student.module().equals(module))
                .sorted(Comparator.comparing(Student::mark).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsWhoseNamesStartWith(char letter) {
        return _queryStudents(student -> student.name().startsWith(String.valueOf(letter)));
    }

    public OptionalDouble calculateAverageMarksForCourse(String course) {
        return students.stream()
                .filter(student -> student.course().equals(course))
                .mapToInt(Student::mark)
                .average();
    }

}
