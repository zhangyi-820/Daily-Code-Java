package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author :zhangyi
 * @description:
 * @date :2021/5/24 9:22
 */
@RestController
@RequestMapping("/demo01")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/insert")
    public String insert(@RequestBody Student student){
        studentService.insertStudent(student);
        return "SUCCESS";
    }

    @RequestMapping(value = "get/{id}")
    public Student getStudent(@PathVariable("id") Integer id){
        return studentService.getStudentBysId(id);
    }

    @RequestMapping(value = "/get")
    public List<Student> getAll(){
        return studentService.getStudent();
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        studentService.deleteStudent(id);
        return "Success";
    }

    @RequestMapping(value = "/update")
    public String update(@RequestBody Student student){
        studentService.updateStudent(student);
        return "Success";
    }
}
