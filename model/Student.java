package pl.dmcs.rkotas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
    @Id
    @GeneratedValue
    private long id;

    private String studentName;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
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

    public void setStudentCourses(List<Course> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
