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
    HashMap<String, List<String>> studentTeacherMapping = new HashMap<>();

    public void addStudentInDB(Student student){
        studentHashMap.put(student.getName(), student);
    }

    public void addTeacherInDB(Teacher teacher){
        teacherHashMap.put(teacher.getName(), teacher);
    }

    public void mapStudentToTeacher(String s_name, String t_name){
        List<String> studentList;
        if(studentHashMap.containsKey(s_name) && teacherHashMap.containsKey(t_name)){
            if(studentTeacherMapping.containsKey(t_name)){
                studentList = studentTeacherMapping.get(t_name);
            }else{
                studentList = new ArrayList<>();
            }
            studentList.add(s_name);
            studentTeacherMapping.put(t_name, studentList);
        }
    }

    public Student findStudentFromDB(String studentName){
        return studentHashMap.get(studentName);
    }

    public Teacher findTeacherFromDB(String teacherName){
        return teacherHashMap.get(teacherName);
    }

    public List<String> findStudentsByTeacherName(String teacherName){
        return studentTeacherMapping.get(teacherName);
    }

    public List<String> getAllStudents(){
        List<String> studentList = new ArrayList<>();
        for(String s: studentHashMap.keySet()){
            studentList.add(s);
        }
        return studentList;
    }

    public void deleteStudentByTeacherName(String name){
        if(studentTeacherMapping.containsKey(name)){
            List<String> studentList = studentTeacherMapping.get(name);
            for(String s: studentHashMap.keySet()){
                if(studentList.contains(s)){
                    studentHashMap.remove(s);
                }
            }
            studentTeacherMapping.remove(name);
        }

        if(teacherHashMap.containsKey(name)){
            teacherHashMap.remove(name);
        }
    }

    public void deleteAllStudentAndTeachers(){
        studentTeacherMapping.clear();
        studentHashMap.clear();
        teacherHashMap.clear();
    }
}
