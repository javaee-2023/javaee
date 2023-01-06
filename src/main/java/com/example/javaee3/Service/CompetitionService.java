package com.example.javaee3.Service;

import com.example.javaee3.Entity.*;
import com.example.javaee3.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
        Collections.sort(list);
        return list;
    }
    public String semiFinals(String sport, String team){
        List<Player> list=competitionMapper.findPlayerByCompetition(new Competition("半决赛", sport, team));
        Collections.sort(list);
        for(int i=1;i<=2;++i){
            List<Player> plays=competitionMapper.findPlayerByCompetition(new Competition("决赛", sport, Integer.toString(i)));
            dbScoreMapper.insertScoreWithTeamAndNumber(new DBScore(Integer.toString(i), Integer.toString(plays.size()+1)));
            List<DBScore> dbScores=dbScoreMapper.findByTeamAndNumber(Integer.toString(i), Integer.toString(plays.size()+1));
            Collections.sort(dbScores);
            int sid=dbScores.get(0).getSid();
            int aid=list.get(i-1).getId();
            int cid=dbCompetitionMapper.findByRoundAndSport("决赛", sport).getCid();
            dbAssociationMapper.insertAssociation(new DBAssociation(aid, cid, sid));
        }
        return "半决赛晋级成功";
    }
    public String preliminaryRound(String sport, String team){
        List<Player> list=competitionMapper.findPlayerByCompetition(new Competition("初赛", sport, team));
        Collections.sort(list);
        for(int i=1;i<=4;++i){
            List<Player> plays=competitionMapper.findPlayerByCompetition(new Competition("半决赛", sport, Integer.toString(i)));
            dbScoreMapper.insertScoreWithTeamAndNumber(new DBScore(Integer.toString(i), Integer.toString(plays.size()+1)));
            List<DBScore> dbScores=dbScoreMapper.findByTeamAndNumber(Integer.toString(i), Integer.toString(plays.size()+1));
            Collections.sort(dbScores);
            int sid=dbScores.get(0).getSid();
            int aid=list.get(i-1).getId();
            int cid=dbCompetitionMapper.findByRoundAndSport("半决赛", sport).getCid();
            dbAssociationMapper.insertAssociation(new DBAssociation(aid, cid, sid));
        }
        return "初赛晋级成功";
    }

    public double getRandom(double a, double b){
        return (Math.random() * (b-a) )+a;
    }
    public double getScore(double result, double a, double b, boolean fg){
        if(fg) result=b-(result-a);
        return result*(100/(b-a))+50;
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
        for(int i=0;i<players.size();++i) {
            double result=0;
            double score=0;
            if (sport == "100m赛跑") {
                result = getRandom(11, 15);
                score = getScore(result, 11, 15, true);
            }
            if (sport == "200m赛跑") {
                result = getRandom(24, 30);
                score = getScore(result, 24, 30, true);
            }
            if (sport == "1000m赛跑") {
                result = getRandom(215, 270);
                score = getScore(result, 215, 270, true);
            }
            if (sport == "3000m赛跑") {
                result = getRandom(610, 700);
                score = getScore(result, 610, 700, true);
            }
            if (sport == "立定跳远") {
                result = getRandom(183, 273);
                score = getScore(result, 183, 273, false);
            }
            if (sport == "铅球") {
                 result = getRandom(8.5, 12);
                score = getScore(result, 8.5, 12, false);
            }
            if (sport == "跳高") {
                 result = getRandom(50, 150);
                score = getScore(result, 50, 150, false);
            }
            int cid=dbCompetitionMapper.findByRoundAndSport(round, sport).getCid();
            int aid=players.get(i).getId();
            int sid=dbAssociationMapper.findByAidAndCid(aid, cid).get(0).getSid();
            players.set(i, new Player(sid, aid, result, score));
        }
        Collections.sort(players);
        for(int i=0;i<players.size();++i){
            Player player=players.get(i);
            dbScoreMapper.updateScoreWithGrade(player.getRank(), i+1, player.getResult(), player.getScore());
        }
    }

    public void editCompetition(int aid, String round, String sport, double result){
        int cid=dbCompetitionMapper.findByRoundAndSport(round, sport).getCid();
        int sid=dbAssociationMapper.findByAidAndCid(aid, cid).get(0).getSid();

        double score=0;
        if (sport == "100m赛跑") {
            score = getScore(result, 11, 15, true);
        }
        if (sport == "200m赛跑") {
            score = getScore(result, 24, 30, true);
        }
        if (sport == "1000m赛跑") {
            score = getScore(result, 215, 270, true);
        }
        if (sport == "3000m赛跑") {
            score = getScore(result, 610, 700, true);
        }
        if (sport == "立定跳远") {
            score = getScore(result, 183, 273, false);
        }
        if (sport == "铅球") {
            score = getScore(result, 8.5, 12, false);
        }
        if (sport == "跳高") {
            score = getScore(result, 50, 150, false);
        }
        DBScore dbScore=dbScoreMapper.findBySid(sid);
        List<Player> list=competitionMapper.findPlayerByCompetition(new Competition(round, sport, dbScore.getTeam()));
        Collections.sort(list);
        for(int i=0;i<list.size();++i){
            if(list.get(i).getSid()==sid){
                dbScoreMapper.updateScoreWithGrade(sid, i+1, result, score);
            }
            else{
                dbScoreMapper.updateScoreWithRank(list.get(i).getSid(), i+1);
            }
        }
    }
    public List<Group> groupRankCompetition(){
        List<Group> list=competitionMapper.findGroup();
        Collections.sort(list);
        for(int i=0;i<list.size();++i){
            list.set(i, new Group(i+1 ,list.get(i).getGroup(), list.get(i).getScore()));
        }
        return list;
    }
    public List<SportsTeamPlayer> sportsTeamCompetition(){
        return competitionMapper.findSportsTeam();
    }
}
