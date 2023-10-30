package student;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private int id;
    private String course;
    private String module;

    public Student(String name, int id, String course, String module) {
        this.name = name;
        this.id = id;
        this.course = course;
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getModule() {
        return module;
    }
}
