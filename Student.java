package org.example;
;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Student implements Serializable {
    private String studentName;
    private HashMap<String, String> attendance;
    private Teacher teacher;
    private Subject subject;
    public Student(Subject subject, Teacher teacher, String nameOfStudent, HashMap<String,String> attendance) {
        this.studentName = nameOfStudent;
        this.attendance = attendance;
        this.subject = subject;
        this.teacher = teacher;
    }
    public String getNameOfStudent() {
        return studentName;
    }

    public HashMap<String, String> getAttendance() {
        return attendance;
    }

    public void setAttendance(HashMap<String, String> attendance) {
        this.attendance = attendance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;

        return Objects.equals(studentName, student.studentName)
                && Objects.equals(teacher, student.teacher) && Objects.equals(subject, student.subject);

    }

    @Override
    public String toString() {
        return "Student{" +
                "nameOfStudent='" + studentName + '\'' +
                ", attendance=" + attendance +
                ", teacher=" + teacher +
                ", subject=" + subject +
                '}';
    }
}