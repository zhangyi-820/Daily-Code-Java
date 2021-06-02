package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2021/5/24 9:19
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void insertStudent(Student student) {
        studentMapper.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.save(student);
    }

    @Override
    public List<Student> getStudent() {
        return studentMapper.findAll();
    }

    @Override
    public Student getStudentBysId(int id) {
        return studentMapper.findById(id);
    }
}
