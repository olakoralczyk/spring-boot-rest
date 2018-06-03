package pl.dmcs.rkotas.model.request;

import pl.dmcs.rkotas.model.Course;

import java.util.ArrayList;
import java.util.List;

public class AddStudentRequest {
    private Long id;
    private String studentName;
    private List<Course> studentCourses = new ArrayList<>();

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<Course> courses) {
        this.studentCourses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

