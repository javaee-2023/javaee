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
    boolean disable=false;
    @Autowired
    AthleteService athleteService;
    @Autowired
    AthleteMapper athleteMapper;
    //添加运动员
    @PostMapping("insert")
    public Map insertAthlete(@RequestBody Athlete athlete){
        System.out.println("insertAthlete"+athlete.toString());
        Map map=new HashMap();
        if(athlete.getName()==""){
            map.put("code", 0);
            map.put("message", "姓名不能为空");
            return map;
        }
        if(athlete.getGroup()==""){
            map.put("code", 0);
            map.put("message", "班级不能为空");
            return map;
        }
        if(athlete.getSport()==""){
            map.put("code", 0);
            map.put("message", "报名项目不能为空");
            return map;
        }
        if(athlete.getSportsTeam()==""){
            map.put("code", 0);
            map.put("message", "是否运动队队员不能为空");
            return map;
        }

        String message=athleteService.insertAthlete(athlete);
        map.put("message", message);
        if(message=="该同学报名成功") map.put("code", 1);
        else map.put("code", 0);
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
        List<Athlete> athleteList=athleteService.findAthletes(athlete);
        map.put("athleteList",athleteList);
        return map;
    }

    //删除
    @GetMapping("delete")
    public Map deleteAthlete(int id){
        System.out.println("删除");
        Map map=new HashMap<>();
        System.out.println(id);
        String message=athleteService.deleteAthletes(id);
        map.put("message", message);
        map.put("code", 1);
        return map;
    }

    //编辑
    @PostMapping("edit")
    public Map editAthlete(@RequestBody List<Athlete> athletes){
        System.out.println(athletes.toString());
        Map map=new HashMap();
        String message=athleteService.editAthlete(athletes.get(0), athletes.get(1));
        map.put("message", message);
        if(message=="编辑成功") map.put("code", 1);
        else map.put("code", 0);
        return map;
    }

    //比赛开始
    @GetMapping("start")
    public Map startCompetition(){
        System.out.println("比赛开始");
        Map map=new HashMap();
        if(disable)
        {
            map.put("message", "比赛已开始");
            map.put("code",1);
        }
        else
        {
            String message=athleteService.check();
            map.put("message", message);
            if(message.equals("比赛开始")){
                map.put("code", 1);
                disable=true;
            }
            else map.put("code", 0);

        }
        return map;
    }
    //比赛初始化
    @GetMapping("init")
    public Map initCompetition(){
        System.out.println("比赛初始化");
        Map map=new HashMap();
        athleteService.initCompetition();
        map.put("message", "初始化成功");
        map.put("code", 1);
        disable=false;
        return map;
    }
    @GetMapping("dis")
    public boolean isDisable(){
        System.out.println("11111111111111");
        return disable;
    }
}
