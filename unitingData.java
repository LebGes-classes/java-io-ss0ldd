package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class unitingData {
    private ArrayList<String> data;
    private final String delimeter = ";";
    ArrayList<Student> attendencyLog = new ArrayList<>();
    unitingData(ArrayList<String> data) {
        this.data = data;
    }
    public ArrayList<Student> updateData() {
        return data.stream()
                .map(sub -> sub.split(delimeter))
                .map(ud-> {
                    HashMap<String, String> attendence = new HashMap<>();
                    attendence.put(ud[4], ud[3]);
                    Student student = new Student(new Subject(ud[0]), new Teacher(ud[1]), ud[2],
                            attendence);
                    Student studentInAttendenceLog = isStudentInAttendenceLog(student);
                    if (studentInAttendenceLog != null) {
                        var oldAttendence = studentInAttendenceLog.getAttendance();
                        oldAttendence.put(ud[4], ud[3]);
                        student.setAttendance(oldAttendence);
                    }
                    return student;
                })
                .filter(student -> (isStudentInAttendenceLog(student) == null))
                .peek(student -> attendencyLog.add(student))
                .collect(Collectors.toCollection(ArrayList::new));

//        for (String sub : data) {
//            String[] ud = sub.split(delimeter);
//            HashMap<String, String> attendence = new HashMap<>();
//            attendence.put(ud[4], ud[3]);
//            Student student = new Student(new Subject(ud[0]), new Teacher(ud[1]), ud[2],
//                    attendence);
//            Student studentInAttendenceLog = isStudentInAttendenceLog(student);
//            if (studentInAttendenceLog != null) {
//                var oldAttendence = studentInAttendenceLog.getAttendance();
//                oldAttendence.put(ud[4], ud[3]);
//                student.setAttendance(oldAttendence);
//                continue;
//            }
//            attendencyLog.add(student);
//        }
//        return attendencyLog;
    }
    public Student isStudentInAttendenceLog(Student student) {
        return attendencyLog.stream()
                .filter(checkStudent -> student.equals(checkStudent))
                .findFirst()
                .orElse(null);
//        for(Student checkStudent: attendencyLog) {
//            if (student.equals(checkStudent)) {
//                return checkStudent;
//            }
//        }
//        return null;
    }

}