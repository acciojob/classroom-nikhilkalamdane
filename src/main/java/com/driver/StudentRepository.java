package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Component
public class StudentRepository {
    HashMap<String, Student> studentHashMap = new HashMap<>();
    HashMap<String, Teacher> teacherHashMap = new HashMap<>();

    public void addStudentInDB(Student student){
        studentHashMap.put(student.getName(), student);
    }

    public void addTeacherInDB(Teacher teacher){
        teacherHashMap.put(teacher.getName(), teacher);
    }

    public Student findStudentFromDB(String studentName){
        return studentHashMap.get(studentName);
    }

    public Teacher findTeacherFromDB(String teacherName){
        return teacherHashMap.get(teacherName);
    }

    public List<String> getAllStudents(){
        List<String> studentList = new ArrayList<>();
        for(String s: studentHashMap.keySet()){
            studentList.add(s);
        }
        return studentList;
    }

    public void deleteAllTeachers(){
        teacherHashMap.clear();
    }
}
