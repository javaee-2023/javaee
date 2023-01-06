package com.example.javaee3.Controller;

import com.example.javaee3.Entity.Athlete;
import com.example.javaee3.Mapper.AthleteMapper;
import com.example.javaee3.Service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("athlete")
@CrossOrigin
public class AthleteController {
    boolean flag=false;
    boolean fg=false;
    @Autowired
    AthleteService athleteService;
    @Autowired
    AthleteMapper athleteMapper;
    //添加运动员
    @PostMapping("insert")
    public Map insertAthlete(@RequestBody Athlete athlete){
        System.out.println("insertAthlete"+athlete.toString());
        Map map=new HashMap();
        String message=athleteService.insertAthlete(athlete);
        map.put("message", message);
        return map;
    }

    //搜索
    @PostMapping("get")
    public Map getAthletes(@RequestBody Athlete athlete){
        System.out.println(athlete.toString());
        Map map=new HashMap<>();
        List<Athlete> athleteList=athleteService.findAthletes(athlete);
        map.put("athleteList",athleteList);
        map.put("message", "搜索成功");
        map.put("code", 1);
        return map;
    }

    //搜索2，不弹出信息
    @PostMapping("search")
    public Map searchAthletes(@RequestBody Athlete athlete){
        Map map=new HashMap<>();
        System.out.println(athlete.toString());
        List<Athlete> athleteList=athleteService.findAthletes(athlete);
        map.put("athleteList",athleteList);
        return map;
    }

    //删除
    @GetMapping("delete")
    public Map deleteAthlete(int id){
        Map map=new HashMap<>();
        System.out.println(id);
        String message=athleteService.deleteAthletes(id);
        map.put("message", message);
        return map;
    }

    //编辑
    @PostMapping("edit")
    public Map editAthlete(@RequestBody List<Athlete> athletes){
        System.out.println(athletes.toString());
        Map map=new HashMap();
        String message=athleteService.editAthlete(athletes.get(0), athletes.get(1));
        map.put("message", message);
        return map;
    }

    //TODO：比赛开始
    @GetMapping("start")
    public Map startCompetition(){
        System.out.println("比赛开始");
        Map map=new HashMap();
        if(fg)
        {
            map.put("message", "比赛已开始");
        }
        else
        {
            map.put("message", athleteService.check());
        }
        return map;
    }
    //比赛初始化
    @GetMapping("init")
    public Map initCompetition(){
        System.out.println("比赛初始化");
        Map map=new HashMap();
        athleteService.initCompetition();
        map.put("Message", "初始化成功");
        return map;
    }
}
