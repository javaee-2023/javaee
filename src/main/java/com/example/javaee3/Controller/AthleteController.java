package com.example.javaee3.Controller;

import com.example.javaee3.Enity.Athlete;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("athlete")
@CrossOrigin
public class AthleteController {
    List<Athlete> athletesList=new ArrayList<>();
    boolean flag=false;
    private int cnt=5;
    @GetMapping("init")
    public void initAthlete(){
        if(flag==true) return;
        athletesList.add(new Athlete("1","1","201","立定跳远","第一组","1","是"));
        athletesList.add(new Athlete("2","2","201","立定跳远","第一组","2","否"));
        athletesList.add(new Athlete("3","3","201","铅球","第一组","3","是"));
        athletesList.add(new Athlete("4","4","301","立定跳远","第二组","5","否"));
        athletesList.add(new Athlete("5","5","301","铅球","第二组","5","是"));
        flag=true;
    }

    //添加运动员
    @PostMapping("insert")
    public void insertAthlete(@RequestBody Athlete athlete){
        System.out.println("insertAthlete"+athlete.toString());
        ++cnt;
        athlete.setId(""+cnt);
        athletesList.add(athlete);
    }

    //搜索
    @PostMapping("get")
    public List<Athlete> getAthletes(@RequestBody Athlete athlete){

        List<Athlete> list=new ArrayList<>();
        for(int i=0;i<= athletesList.size()-1;++i){
            //筛选id
            if(!athlete.getId().equals("")){
                if(!athletesList.get(i).getId().equals(athlete.getId())){
                    continue;
                }
            }
            //筛选姓名
            if(!athlete.getName().equals("")){
                if(!athletesList.get(i).getName().equals(athlete.getName())){
                    continue;
                }
            }
            //筛选团体
            if(!athlete.getGroup().equals("")){
                if(!athletesList.get(i).getGroup().equals(athlete.getGroup())){
                    continue;
                }
            }
            //筛选项目
            if(!athlete.getSport().equals("")){
                if(!athletesList.get(i).getSport().equals(athlete.getSport())){
                    continue;
                }
            }
            //筛选小组
            if(!athlete.getTeam().equals("")){
                if(!athletesList.get(i).getTeam().equals(athlete.getTeam())){
                    continue;
                }
            }
            //筛选序号
            if(!athlete.getNumber().equals("")){
                if(!athletesList.get(i).getNumber().equals(athlete.getNumber())){
                    continue;
                }
            }
            //筛选是否运动队员
            if(!athlete.getSportsTeam().equals("")){
                if(!athletesList.get(i).getSportsTeam().equals(athlete.getSportsTeam())){
                    continue;
                }
            }
            //如果满足条件
            list.add(athletesList.get(i));
        }
        return list;
    }

    //删除
    @GetMapping("delete")
    public void deleteAthlete(String id){
        System.out.println(id);
       for(int i=0;i<=athletesList.size()-1;++i){
           if(athletesList.get(i).getId().equals(id)){
               //System.out.println("1");
               athletesList.remove(i);
               return;
           }
       }
    }

    //编辑
    @PostMapping("edit")
    public void editAthlete(@RequestBody Athlete athlete){
        System.out.println(athlete.toString());
        for(int i=0;i<=athletesList.size()-1;++i){
            if(athletesList.get(i).getId().equals(athlete.getId())){
                athletesList.set(i, athlete);
                return;
            }
        }
    }

    //TODO：比赛开始
    @GetMapping("start")
    public Map startCompetition(){

        Map map=new HashMap();
        if(true)//TODO:待修改
        {
            map.put("message", "比赛已开始");
        }
        else
        {
            map.put("message", "项目"+"小组人数不够");
        return map;
        }
        map.put("message", "比赛开始失败");
        return map;
    }
}
