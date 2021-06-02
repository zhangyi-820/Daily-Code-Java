package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2021/5/24 9:17
 */
public interface StudentService {
    void insertStudent(Student student);
    void deleteStudent(int sId);
    void updateStudent(Student student);
    List<Student> getStudent();
    Student getStudentBysId(int sId);
}
