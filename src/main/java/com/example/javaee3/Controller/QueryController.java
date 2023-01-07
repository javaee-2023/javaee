package com.example.javaee3.Controller;


import com.example.javaee3.Entity.Player;
import com.example.javaee3.Entity.Student;
import com.example.javaee3.Service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("query")
public class QueryController {
    @Autowired
    QueryService queryService;
    //破纪录列表查询
    @GetMapping("record")
    public Map recordQuery(String sport){
        System.out.println("破记录表"+sport);
        Map map=new HashMap();
        map.put("recordList", queryService.recordsQuery(sport));
        map.put("message", "查询成功");
        map.put("code", 1);
        return map;
    }

    List<Player> playersList=new ArrayList<>();//
    //个人成绩查询
    @PostMapping("student")
    public Map playerRecordQuery(@RequestBody Student student){
        System.out.println("个人查询");
//        System.out.println(Student.to);
        Map map=new HashMap();
        map.put("resultList", queryService.studentQuery(student));
        map.put("message", "查询成功");
        map.put("code", 1);
        return map;
    }

}
