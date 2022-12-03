package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudentToDB(Student student){
        studentRepository.addStudentInDB(student);
    }

    public void addTeacherToDB(Teacher teacher){
        studentRepository.addTeacherInDB(teacher);
    }

    public Student getStudentFromDB(String studentName){
        return studentRepository.findStudentFromDB(studentName);
    }

    public Teacher getTeacherFromDB(String teacherName){
        return studentRepository.findTeacherFromDB(teacherName);
    }

    public List<String> getAllStudentFromDB(){
        return studentRepository.getAllStudents();
    }

    public void deleteAllTeachersFromDB(){
        studentRepository.deleteAllTeachers();
    }


}
