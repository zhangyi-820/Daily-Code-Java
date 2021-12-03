package com.example.easypoidemo.service;

import com.example.easypoidemo.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/10/28 10:30
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class StudentService {

    public Boolean saveAll(List<Student> students){
        System.out.println("save all students");
        return true;
    }
}
