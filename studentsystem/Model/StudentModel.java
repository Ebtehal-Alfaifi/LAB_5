package com.example.studentsystem.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentModel {
    private String id;
    private String name;
    private int age;
    private String degree;
    private double GPA;

}


