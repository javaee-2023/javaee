package com.example.javaee3.Service;

import com.example.javaee3.Entity.*;
import com.example.javaee3.Mapper.*;
import com.sun.nio.sctp.Association;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AthleteService {
    @Autowired
    DBAthleteMapper dbAthleteMapper;
    @Autowired
    DBAssociationMapper dbAssociationMapper;
    @Autowired
    DBCompetitionMapper dbCompetitionMapper;
    @Autowired
    DBScoreMapper dbScoreMapper;
    @Autowired
    AthleteMapper athleteMapper;
    //插入运动员
    public String insertAthlete(Athlete athlete){
        Map map=new HashMap<>();
        int aid=0, cid=0, sid=0;
        boolean flag=false;

        //看项目人数是否已满
        if(dbScoreMapper.searchFreeNumberAndTeam(athlete.getSport()).size()==72) return "项目人已满，无法报名";

        DBAthlete check=dbAthleteMapper.findByName(athlete.getName());

        //已经存在看是否已经报了这个项目
        if(check!=null) {
            List<String> stringList = dbAthleteMapper.searchSports(check.getName());
            for (int i = 0; i <stringList.size();++i){
                if(stringList.get(i).equals(athlete.getSport())) return "这名同学已报名了该项目";
            }
            flag=true;//标志了该同学已经加入了，无须再插入，只要增加比赛项目即可。
        }

        //处理数据库分数信息
        if(athlete.getNumber()==""&&athlete.getTeam()!=""){
            List<String> strings=dbScoreMapper.searchFreeNumber(athlete.getTeam(), athlete.getSport());
            for(int i=0;i<strings.size();++i){
                map.put(strings.get(i), 1);
            }
            for(int i=1;i<=9;++i){
                if(map.get(Integer.toString(i))==null){
                    athlete.setNumber(Integer.toString(i));
                    break;
                }
            }
            if(athlete.getNumber()=="") return athlete.getSport()+"项目第"+athlete.getTeam()+"分组没有序号了，无法自动分配";
            map.clear();
        }
        else if(athlete.getTeam()==""&&athlete.getNumber()!=""){
            List<String> strings=dbScoreMapper.searchFreeTeam(athlete.getNumber(), athlete.getSport());
            for(int i=0;i<strings.size();++i){
                map.put(strings.get(i), 1);
            }
            for(int i=1;i<=8;++i){
                if(map.get(Integer.toString(i))==null){
                    athlete.setTeam(Integer.toString(i));
                    break;
                }
            }
            if(athlete.getNumber()=="") return athlete.getSport()+"项目第"+athlete.getNumber()+"序号没有小组了，无法自动分配";
            map.clear();
        }
        else if(athlete.getNumber()==""&&athlete.getTeam()==""){
            List<DBScore> dbScores=dbScoreMapper.searchFreeNumberAndTeam(athlete.getSport());
            for(int i=0;i<dbScores.size();++i){
                DBScore dbScore=dbScores.get(i);
                map.put(dbScore.getNumber()+dbScore.getScore(), 1);
            }
            boolean fg=false;
            for(int i=1;i<=8;++i){
                for(int j=1;j<=9;++j){
                    String string=Integer.toString(j)+Integer.toString(i);
                    if(map.get(string)==null){
                        athlete.setTeam(Integer.toString(i));
                        athlete.setNumber(Integer.toString(j));
                        fg=true;
                        break;
                    }
                    if(fg) break;
                }
            }
            if(athlete.getNumber()==""&&athlete.getTeam()=="") return athlete.getSport()+"项目人已满，无法报名";
            map.clear();
        }

        if(!flag){
            DBAthlete dbAthlete=new DBAthlete(athlete.getName(), athlete.getGroup(), athlete.getSportsTeam());
            dbAthleteMapper.insertAthlete(dbAthlete);
        }
        aid=dbAthleteMapper.findByName(athlete.getName()).getAid();
        dbScoreMapper.insertScoreWithTeamAndNumber(new DBScore(athlete.getTeam(), athlete.getNumber()));
        List<DBScore> scores=dbScoreMapper.findByTeamAndNumber(athlete.getTeam(), athlete.getNumber());
        Collections.sort(scores);
        sid=scores.get(0).getSid();
        cid=dbCompetitionMapper.findByRoundAndSport("初赛", athlete.getSport()).getCid();
        dbAssociationMapper.insertAssociation(new DBAssociation(aid, cid, sid));
        return "该同学报名成功";
    }

    public List<Athlete> findAthletes(Athlete athlete) {
        return athleteMapper.findAthletes(athlete);
    }

    public String deleteAthletes(int id) {
        dbAthleteMapper.deleteAthlete(id);
        List<DBAssociation> associations=dbAssociationMapper.findByAid(id);
        dbAssociationMapper.deleteAssociationByAid(id);
        for(int i=0;i<associations.size();++i){
            dbScoreMapper.deleteScore(associations.get(i).getSid());
        }
        return "删除成功";
    }
    public String editAthlete(Athlete pre, Athlete nex){
        System.out.println("pre: "+pre.toString());
        System.out.println("nex: "+nex.toString());
        DBAssociation dbAssociation=athleteMapper.findAssociationByAthlete(pre);
        if(nex.getName()!="")       pre.setName(nex.getName());
        if(nex.getGroup()!="")      pre.setGroup(nex.getGroup());
        if(nex.getSport()!="")      pre.setSport(nex.getSport());
        if(nex.getTeam()!="")       pre.setTeam(nex.getTeam());
        if(nex.getNumber()!="")     pre.setNumber(nex.getNumber());
        if(nex.getSportsTeam()!="") pre.setSportsTeam(nex.getSportsTeam());
        int cid=dbCompetitionMapper.findByRoundAndSport("初赛", nex.getSport()).getCid();
        dbScoreMapper.updateScoreWithTeamAndNumber(dbAssociation.getSid(), pre.getTeam(), pre.getNumber());
        dbAthleteMapper.updateAthlete(dbAssociation.getAid(),pre.getName(), pre.getGroup(),pre.getSportsTeam());
        dbAssociationMapper.updateAssociationWithCid(dbAssociation.getAid(), dbAssociation.getCid(), dbAssociation.getSid(), cid);
        return "编辑成功";
    }
    public String check(){
        if(dbScoreMapper.searchFreeNumberAndTeam("100m赛跑").size()<72) return "100m赛跑比赛人数不够";
        if(dbScoreMapper.searchFreeNumberAndTeam("200m赛跑").size()<72) return "200m赛跑比赛人数不够";
        if(dbScoreMapper.searchFreeNumberAndTeam("1000m赛跑").size()<72) return "1000m赛跑比赛人数不够";
        if(dbScoreMapper.searchFreeNumberAndTeam("3000m赛跑").size()<72) return "3000m赛跑比赛人数不够";
        if(dbScoreMapper.searchFreeNumberAndTeam("立定跳远m赛跑").size()<72) return "立定跳远比赛人数不够";
        if(dbScoreMapper.searchFreeNumberAndTeam("铅球赛跑").size()<72) return "铅球比赛人数不够";
        if(dbScoreMapper.searchFreeNumberAndTeam("跳高").size()<72) return "跳高比赛人数不够";
        return "比赛开始";
    }
    public String initCompetition(){
        List<DBCompetition> comp1=dbCompetitionMapper.findByRound("决赛");
        List<DBCompetition> comp2=dbCompetitionMapper.findByRound("半决赛");
        List<DBCompetition> comp3=dbCompetitionMapper.findByRound("初赛");
        for(int i=0;i<comp1.size();++i){
            int cid=comp1.get(i).getCid();
            List<DBAssociation> dbAssociations=dbAssociationMapper.findByCid(cid);
            for(int j=0;j<dbAssociations.size();++j){
                dbScoreMapper.deleteScore(dbAssociations.get(j).getSid());
                dbAssociationMapper.deleteAssociation(dbAssociations.get(i));
            }
        }
        for(int i=0;i<comp2.size();++i){
            int cid=comp2.get(i).getCid();
            List<DBAssociation> dbAssociations=dbAssociationMapper.findByCid(cid);
            for(int j=0;j<dbAssociations.size();++j){
                dbScoreMapper.deleteScore(dbAssociations.get(j).getSid());
                dbAssociationMapper.deleteAssociation(dbAssociations.get(i));
            }
        }
        for(int i=0;i<comp3.size();++i){
            int cid=comp3.get(i).getCid();
            List<DBAssociation> dbAssociations=dbAssociationMapper.findByCid(cid);
            for(int j=0;j<dbAssociations.size();++j){
                dbScoreMapper.initScore(dbAssociations.get(j).getSid());
            }
        }
        return "初始化成功";
    }
}
