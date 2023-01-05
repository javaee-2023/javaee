package com.example.javaee3.Controller;

import com.example.javaee3.Enity.Athlete;
import com.example.javaee3.Enity.Competition;
import com.example.javaee3.Enity.Group;
import com.example.javaee3.Enity.Player;
import com.example.javaee3.Service.CompetitionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("competition")
public class CompetitionController {
    //查找比赛总表
    @PostMapping("search")
    public List<Player> searchPlayer(@RequestBody Competition competition){
        List<Player> list=new ArrayList<>();
        list=searchPlayer(competition);



        return list;
    }

    Player player = new Player();//
    //比赛成绩初始化
    @GetMapping("init")
    public Map initializeCompetition(String sport){
        Map map=new HashMap();
        if(player.getSport().equals(sport))
        player.setResult(0);
        if(player.getResult() == 0)
        {
            map.put("message", "初始化成功");
            return map;
        }
        else
        {
            map.put("message", "初始化失败");
            return map;
        }
    }

    //小组赛晋级
    @GetMapping("promote")
    public Map promoteCompetition(String round, String sport, String team){
        Map map=new HashMap();
        if()
        {
            map.put("message", "晋级成功");
            return map;
        }
        else if()
        {
            map.put("message", "参赛人数不够");
            return map;
        }
        else if()
        {
            map.put("message", "成绩未全部录入");
            return map;
        }
        else
        {
            map.put("message", "晋级错误");
            return map;
        }
    }

    //比赛模拟
    @GetMapping("simulation")
    public Map simulateCompetition(String round, String sport, String team){
        Map map=new HashMap();
        if()
        {
            map.put("message", "模拟成功");
            return map;
        }
        else if()
        {
            map.put("message", "参赛人数不够");
            return map;
        }
        else if()
        {
            map.put("message", "成绩未全部录入");
            return map;
        }
        else
        {
            map.put("message", "模拟错误");
            return map;
        }
    }


    List<Group> groupList = new ArrayList<>();//
    //查找团队排名
    @GetMapping("groupRank")
    public List<Group> groupRankCompetition(Group group){
        Map map=new HashMap();

        List<Group> list = new ArrayList<>();
        for(int i=0;i<= groupList.size()-1;++i) {
            if (!group.getGroup().equals("")) {
                if (!groupList.get(i).getGroup().equals(group.getGroup())) {
                    continue;
                }
            }
            list.add(groupList.get(i));
        }
                map.put("message", "查找成功");
                return list;

        }

    List<Player> playerList = new ArrayList<>();//
    //查找运动队比赛情况
    @GetMapping("sportsTeam")
    public List<Player> sportsTeamCompetition(Player player){
        Map map=new HashMap();
        List<Player> list = new ArrayList<>();
        for(int i=0;i<= groupList.size()-1;++i) {
            if (!player.getId().equals("")) {
                if (!playerList.get(i).getId().equals(player.getId())) {
                    continue;
                }
            }
            list.add(playerList.get(i));
        }
        map.put("message", "查找成功");
        return list;
    }

}


