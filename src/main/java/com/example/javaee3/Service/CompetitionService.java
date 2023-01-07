package com.example.javaee3.Service;

import com.example.javaee3.Entity.*;
import com.example.javaee3.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class CompetitionService {
    @Autowired
    CompetitionMapper competitionMapper;
    @Autowired
    DBAssociationMapper dbAssociationMapper;
    @Autowired
    DBCompetitionMapper dbCompetitionMapper;
    @Autowired
    DBAthleteMapper dbAthleteMapper;
    @Autowired
    DBScoreMapper dbScoreMapper;
    public List<Player> searchPlayer(Competition competition) {
        List<Player> list=competitionMapper.findPlayerByCompetition(competition);
        list.sort(Comparator.comparing(Player::getScore).thenComparing(Player::getId).reversed());
        for(int i=0;i<list.size();++i){
            list.set(i, new Player(i+1, list.get(i) ) );
            dbScoreMapper.updateScoreWithRank(list.get(i).getSid(), i+1);
        }
        return list;
    }
    public String semiFinals(String sport, String team){
        List<Player> list=competitionMapper.findPlayerByCompetition(new Competition("半决赛", sport, team));
        for(int i=0;i<list.size();++i){
            int cid=dbCompetitionMapper.findByRoundAndSport("决赛", sport).getCid();
            if(dbAssociationMapper.findByAidAndCid(list.get(i).getId(), cid).size()!=0){
                return "操作失败，该组已晋级";
            }
        }
        list.sort(Comparator.comparing(Player::getScore).reversed());
        for(int i=1;i<=2;++i){
            List<Player> plays=competitionMapper.findPlayerByCompetition(new Competition("决赛", sport, Integer.toString(1)));
            dbScoreMapper.insertScoreWithTeamAndNumber(new DBScore(Integer.toString(1), Integer.toString(plays.size()+1)));
            List<DBScore> dbScores=dbScoreMapper.findByTeamAndNumber(Integer.toString(1), Integer.toString(plays.size()+1));
            dbScores.sort(Comparator.comparing(DBScore::getSid).reversed());
            int sid=dbScores.get(0).getSid();
            int aid=list.get(i-1).getId();
            int cid=dbCompetitionMapper.findByRoundAndSport("决赛", sport).getCid();
            dbAssociationMapper.insertAssociation(new DBAssociation(aid, cid, sid));
        }
        return "半决赛晋级成功";
    }
    public String preliminaryRound(String sport, String team){
        List<Player> list=competitionMapper.findPlayerByCompetition(new Competition("初赛", sport, team));
        for(int i=0;i<list.size();++i){
            int cid=dbCompetitionMapper.findByRoundAndSport("半决赛", sport).getCid();
            if(dbAssociationMapper.findByAidAndCid(list.get(i).getId(), cid).size()!=0){
                return "操作失败，该组已晋级";
            }
        }
        list.sort(Comparator.comparing(Player::getScore).reversed());
        for(int i=1;i<=4;++i){
            List<Player> plays=competitionMapper.findPlayerByCompetition(new Competition("半决赛", sport, Integer.toString(i)));
            dbScoreMapper.insertScoreWithTeamAndNumber(new DBScore(Integer.toString(i), Integer.toString(plays.size()+1)));
            List<DBScore> dbScores=dbScoreMapper.findByTeamAndNumber(Integer.toString(i), Integer.toString(plays.size()+1));
            dbScores.sort(Comparator.comparing(DBScore::getSid).reversed());
            int sid=dbScores.get(0).getSid();
            int aid=list.get(i-1).getId();
            int cid=dbCompetitionMapper.findByRoundAndSport("半决赛", sport).getCid();
            dbAssociationMapper.insertAssociation(new DBAssociation(aid, cid, sid));
        }
        return "初赛晋级成功";
    }

    public double fixed(double x){
        double d = x;
        BigDecimal bd=new BigDecimal(d);
        double d1=bd.setScale(2, RoundingMode.HALF_UP).doubleValue();
        return d1;
    }
    public double getRandom(double a, double b){

        return fixed((Math.random() * (b-a) )+a);
    }
    public double getScore(double result, double a, double b, boolean fg){
        if(fg) result=b-(result-a);
        return fixed((result-a)*(100/(b-a)));
    }

    /**
     * 100m 11s~15s
     * 200m 24~30s
     * 1000 215s~270s
     * 3000 610~700s
     * 立定跳远 183~273cm
     * 铅球 8.5-12
     * 跳高 50com~150cm
     */
    public void simulateCompetition(String round, String sport, String team){
        List<Player> players=competitionMapper.findPlayerByCompetition(new Competition(round, sport, team));
//        System.out.println("模拟A");
        for(int i=0;i<players.size();++i) {
            double result=0;
            double score=0;
            if (Objects.equals(sport, "100m赛跑")) {
//                System.out.println("模拟B");
                result = getRandom(11, 15);
                score = getScore(result, 11, 15, true);
            }
            if (Objects.equals(sport, "200m赛跑")) {
                result = getRandom(24, 30);
                score = getScore(result, 24, 30, true);
            }
            if (Objects.equals(sport, "1000m赛跑")) {
                result = getRandom(215, 270);
                score = getScore(result, 215, 270, true);
            }
            if (Objects.equals(sport, "3000m赛跑")) {
                result = getRandom(610, 700);
                score = getScore(result, 610, 700, true);
            }
            if (Objects.equals(sport, "立定跳远")) {
                result = getRandom(183, 273);
                score = getScore(result, 183, 273, false);
            }
            if (Objects.equals(sport, "铅球")) {
                 result = getRandom(8.5, 12);
                score = getScore(result, 8.5, 12, false);
            }
            if (Objects.equals(sport, "跳高")) {
                 result = getRandom(50, 150);
                score = getScore(result, 50, 150, false);
            }
            int cid=dbCompetitionMapper.findByRoundAndSport(round, sport).getCid();
            int aid=players.get(i).getId();
            int sid=dbAssociationMapper.findByAidAndCid(aid, cid).get(0).getSid();
            dbScoreMapper.updateScoreWithGrade(sid, result, score);
        }
    }

    public String editCompetition(int aid, String round, String sport, double result){
        int cid=dbCompetitionMapper.findByRoundAndSport(round, sport).getCid();
        int sid=dbAssociationMapper.findByAidAndCid(aid, cid).get(0).getSid();
        //System.out.println("*"+sport);
        double score=0;
        if (Objects.equals(sport, "100m赛跑")) {
            if(result>15) score=0;
            else if(result<11) score=100;
            else score = getScore(result, 11, 15, true);
            //System.out.println("*"+score);
        }
        if (Objects.equals(sport, "200m赛跑")) {
            if(result>30) score=0;
            else if(result<24) score=100;
            else score = getScore(result, 24, 30, true);
        }
        if (Objects.equals(sport, "1000m赛跑")) {
            if(result>270) score=0;
            else if(result<215) score=100;
            else score = getScore(result, 215, 270, true);
        }
        if (Objects.equals(sport, "3000m赛跑")) {
            if(result>700) score=0;
            else if(result<610) score=100;
            else score = getScore(result, 610, 700, true);
        }
        if (Objects.equals(sport, "立定跳远")) {
            if(result>273) score=0;
            else if(result<183) score=100;
            else score = getScore(result, 183, 273, false);
        }
        if (Objects.equals(sport, "铅球")) {
            if(result>12) score=100;
            else if(result<8.5) score=0;
            else score = getScore(result, 8.5, 12, false);
        }
        if (Objects.equals(sport, "跳高")) {
            if(result>150) score=100;
            else if(result<50) score=0;
            else score = getScore(result, 50, 150, false);
        }

        DBScore dbScore=dbScoreMapper.findBySid(sid);
        List<Player> list=competitionMapper.findPlayerByCompetition(new Competition(round, sport, dbScore.getTeam()));
        dbScoreMapper.updateScoreWithGrade(sid, result, score);
        return "编辑成功";
    }
    public List<Group> groupRankCompetition(){
        List<Group> list=competitionMapper.findGroup();
        list.sort(Comparator.comparing(Group::getScore).reversed());
        for(int i=0;i<list.size();++i){
            list.set(i, new Group(i+1 ,list.get(i).getGroup(), list.get(i).getScore()));
        }
        return list;
    }
    public List<SportsTeamPlayer> sportsTeamCompetition(){
        return competitionMapper.findSportsTeam();
    }
}
