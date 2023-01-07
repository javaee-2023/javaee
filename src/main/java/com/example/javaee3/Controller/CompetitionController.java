package com.example.javaee3.Controller;

import com.example.javaee3.Entity.Competition;
import com.example.javaee3.Entity.Group;
import com.example.javaee3.Entity.Player;
import com.example.javaee3.Service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("competition")
public class CompetitionController {
    @Autowired
    CompetitionService competitionService;
    //查找比赛总表
    @PostMapping("search")
    public Map searchPlayer(@RequestBody Competition competition){
        System.out.println("寻找比赛中运动员"+competition.toString());
        Map map=new HashMap<>();
        map.put("athleteList", competitionService.searchPlayer(competition));
        map.put("message", "查询成功");
        map.put("code", 1);
        return map;
    }

    //无消息
    @PostMapping("find")
    public Map findPlayer(@RequestBody Competition competition){
        System.out.println("寻找比赛中运动员"+competition.toString());
        Map map=new HashMap<>();
        map.put("athleteList", competitionService.searchPlayer(competition));
        map.put("message", "查询成功");
        return map;
    }

    //比赛赛晋级
    @GetMapping("promote")
    public Map promoteCompetition(String round, String sport, String team){
        System.out.println("晋级");
        System.out.println(round+" "+sport+" "+team);
        Map map=new HashMap();
        if(Objects.equals(round, "决赛")){
            map.put("message", "决赛不能晋级");
            map.put("code", 0);
            return map;
        }
        if(Objects.equals(round, "半决赛")){
            String message=competitionService.semiFinals(sport, team);
            map.put("message", message);
            if(message.equals("半决赛晋级成功")) map.put("code", 1);
            else map.put("code", 0);
        }
        if(Objects.equals(round, "初赛")){
            String message=competitionService.preliminaryRound(sport, team);
            map.put("message", message);
            if(message.equals("初赛晋级成功")) map.put("code", 1);
            else map.put("code", 0);
        }
        return map;
    }


    //比赛模拟
    @GetMapping("simulation")
    public Map simulateCompetition(String round, String sport, String team){
        System.out.println("模拟比赛");
        competitionService.simulateCompetition(round, sport, team);
        Map map=new HashMap();
        map.put("message", "模拟比赛成功");
        map.put("code", 1);
        return map;
    }

    //修改成绩
    @GetMapping("edit")
    public Map editCompetition(int id, String round, String sport, double result){
        System.out.println("修改比赛");
        System.out.println(id+" "+round+" "+sport+" "+result);
        String message=competitionService.editCompetition(id, round, sport, result);
        Map map=new HashMap();
        map.put("message", message);
        if(message=="编辑成功") map.put("code", 1);
        else map.put("code", 0);
        return map;
    }

    List<Group> groupList = new ArrayList<>();//
    //查找团队排名
    @GetMapping("groupRank")
    public Map groupRankCompetition(){
        System.out.println("团队排名");
        Map map=new HashMap();
        map.put("groupList", competitionService.groupRankCompetition());
        map.put("message", "查找成功");
        map.put("code", 1);
        return map;
    }

    //查找运动队队员信息
    @GetMapping("sportsTeam")
    public Map sportsTeamCompetition(){
        System.out.println("运动队统计");
        Map map=new HashMap();
        List<Player> list = new ArrayList<>();
        map.put("sportsTeamList", competitionService.sportsTeamCompetition());
        map.put("message", "查找成功");
        map.put("code", 1);
        return map;
    }
    //获取map


}


