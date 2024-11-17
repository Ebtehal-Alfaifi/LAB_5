package com.example.studentsystem.Controller;

import com.example.studentsystem.ApiResponse.Api;
import com.example.studentsystem.Model.StudentModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<StudentModel> students = new ArrayList<>();


@GetMapping("/display")
    //display all student
    public ArrayList<StudentModel> getStudents() {
        return students;
    }
    @PostMapping("/add")
    // add student
    public Api addStudent(@RequestBody StudentModel student) {
    students.add(student);
        return new Api("add success");
    }


    @PutMapping("/update/{index}")
    // update student

    public Api updateStudent(@PathVariable int index,@RequestBody StudentModel student) {
if (index>=0&&index<students.size()) {
    students.set(index, student);
    return new Api("update success");
}
else {
        return new Api("update not  success");}

    }


    @DeleteMapping("/delete/{index}")
    //Delet student
public Api deleteStudent(@PathVariable int index) {
    if (index>=0&&index<students.size()) {
        students.remove(index);
 return new Api("delete success");
    }
    else {
    return new Api("delete not success");
}}



//    Classify based on GPA
@GetMapping("/honors")
    public String Classify(){
    ArrayList<StudentModel> high = new ArrayList<>();
    ArrayList<StudentModel> low = new ArrayList<>();
    for (StudentModel student : students) {
        if (student.getGPA()>=4&&student.getGPA()<=5) {
            high.add(student);
        }
        else {low.add(student);}
    }
        return "High honers"+high +"\nLow honers"+low;
    }



//• Display a group of students whose GPA is greater than the average
  //  GPA


    @GetMapping("/average")
    public ArrayList<StudentModel> getStudentsAverage() {
        double totalGpa = 0.0;
        for (StudentModel student : students) {
            totalGpa += student.getGPA();
        }
        double averageGpa = totalGpa / students.size();

        ArrayList<StudentModel> above = new ArrayList<>();
        for (StudentModel student : students) {
            if (student.getGPA() > averageGpa) {
                above.add(student);
            }
        }

        return above;
    }





}
