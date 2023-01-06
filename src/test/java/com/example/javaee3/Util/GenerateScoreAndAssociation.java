package com.example.javaee3.Util;

import com.example.javaee3.Entity.DBAssociation;
import com.example.javaee3.Entity.DBAthlete;
import com.example.javaee3.Entity.DBScore;
import com.example.javaee3.Mapper.DBAssociationMapper;
import com.example.javaee3.Mapper.DBAthleteMapper;
import com.example.javaee3.Mapper.DBCompetitionMapper;
import com.example.javaee3.Mapper.DBScoreMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class GenerateScoreAndAssociation {
    @Autowired
    DBAthleteMapper dbAthleteMapper;
    @Autowired
    DBAssociationMapper dbAssociationMapper;
    @Autowired
    DBCompetitionMapper dbCompetitionMapper;
    @Autowired
    DBScoreMapper dbScoreMapper;

    public ArrayList<DBAthlete> randomList(ArrayList<DBAthlete> sourceList){
        ArrayList<DBAthlete> randomList = new ArrayList<>( sourceList.size( ) );
        do{
            int randomIndex = Math.abs( new Random( ).nextInt( sourceList.size() ) );
            randomList.add( sourceList.remove( randomIndex ) );
        }while( sourceList.size( ) > 0 );
        return randomList;
    }

    @Test
    public void generateScoreAndAssociation(){
        ArrayList<DBAthlete> list=(ArrayList<DBAthlete>)dbAthleteMapper.findAll();
        list=randomList(list);
//        for(int i=0;i< list.size();++i){
//            System.out.println(list.get(i).toString());
//        }
        List<String> sport=new ArrayList<>(Arrays.asList("100m赛跑", "200m赛跑", "1000m赛跑", "3000m赛跑", "立定跳远", "铅球", "跳高"));

        String round="初赛";
        int cnt=0, cid=0, sid=0, aid=0;
        for(int i=0;i<=6;++i){//7个项目
            for(int j=0;j<=7;++j){//8个小组
                for(int k=0;k<=8;++k){//9个序号
                    ++cnt;
                    DBAthlete dbAthlete=list.get(cnt%list.size());
                    aid=dbAthlete.getAid();
                    DBScore dbScore=new DBScore(Integer.toString (j+1), Integer.toString(k+1));
                    //生成比赛数据
                    dbScoreMapper.insertScoreWithTeamAndNumber(dbScore);
                    sid=cnt;
                    //生成关系
                    cid=dbCompetitionMapper.findByRoundAndSport(round, sport.get(i)).getCid();
                    dbAssociationMapper.insertAssociation(new DBAssociation(aid, cid, sid));
                }
            }
        }
    }
}
