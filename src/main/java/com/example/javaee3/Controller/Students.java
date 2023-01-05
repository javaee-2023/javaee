package com.example.javaee3.Controller;

import com.example.javaee3.Enity.Student;
import com.example.javaee3.Util.GetStudents;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("student")
public class Students {
    @CrossOrigin
    @RequestMapping("test")
    public void test(){
        System.out.println("Hello world!");
    }
    @CrossOrigin
    @GetMapping("getAllStudent")
    public List<Student> getAll(){
        List<Student> student= GetStudents.getStudent();
        return student;
    }
    @CrossOrigin
    @PostMapping("pGet")
    public List<Student> pGet(){
        List<Student> student=GetStudents.getStudent();
        return student;
    }
    @CrossOrigin
    @GetMapping("findStudentById")
    public Map findById(int id){
        Map map=new HashMap<>();
        List<Student> student=GetStudents.getStudent();
        for(int i=0;i<student.size();i++){
            if(student.get(i).getId()==id){
                map.put("code", 200);
                map.put("data", student.get(i));
                return map;
            }
        }
        map.put("code", 200);
        map.put("message", "not found");
        return map;
    }
    @CrossOrigin
    @PostMapping("findStudentByName")
    public Map findStudentByName(@RequestBody Student stu){
        System.out.println(stu);
        String name=stu.getName();
        Map map=new HashMap<>();
        List<Student> student=GetStudents.getStudent();
        for(int i=0;i<student.size();i++){
            if(student.get(i).getName().equals(name)){
                map.put("code", 200);
                map.put("data", student.get(i));
                return map;
            }
        }
        map.put("code", 200);
        map.put("message", "not found");
        return map;
    }
}
