package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;


/**
 * @author :zhangyi
 * @description:
 * @date :2021/5/24 9:11
 */
@Entity
@Table(name="student",schema = "person")
@Data
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "classId")
    public String classId;
}
