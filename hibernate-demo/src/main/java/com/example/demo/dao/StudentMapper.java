package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2021/5/24 9:16
 */
public interface StudentMapper extends CrudRepository<Student,String> {
    Student save(Student student);

    void deleteById(int id);

    List<Student> findAll();

    Student findById(int id);


}
