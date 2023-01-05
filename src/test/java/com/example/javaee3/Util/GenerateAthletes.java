package com.example.javaee3.Util;

import com.example.javaee3.Enity.DBAthlete;
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

@SpringBootTest
public class GenerateAthletes {
    @Autowired
    DBAthleteMapper dbAthleteMapper;
    @Autowired
    DBAssociationMapper dbAssociationMapper;
    @Autowired
    DBCompetitionMapper dbCompetitionMapper;
    @Autowired
    DBScoreMapper dbScoreMapper;
    public int getRandomInt(int a, int b){
        b+=1;
        return (int)(Math.random() * (b-a) )+a;
    }

    @Test
    public void generateAthletes(){
        String sportsTeam="";
        List<String> group=new ArrayList<>(Arrays.asList("101", "102", "103", "104", "105", "106",
                "201", "202", "203", "204", "205", "206",
                "301", "302", "303", "304", "305", "306"));
        for(int i=0;i<=group.size()-1;++i){
            int num=getRandomInt(12, 28);
            //System.out.println(num);
            //System.out.println(GetName.getName());
            for(int j=1;j<=num;++j){
                //十分之一的概率是运动队队员
                if(getRandomInt(1,10)==1) sportsTeam="是";
                else sportsTeam="否";
                DBAthlete dbAthlete=new DBAthlete(0, GetName.getName(), group.get(i), sportsTeam);
                System.out.println(dbAthlete.toString());
                dbAthleteMapper.insertAthlete(dbAthlete);
            }
        }
    }
}