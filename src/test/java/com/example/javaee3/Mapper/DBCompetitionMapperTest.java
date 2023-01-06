package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.DBCompetition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DBCompetitionMapperTest {
    @Autowired
    private DBCompetitionMapper dbCompetitionMapper;
    @Test
    public void find(){
        DBCompetition dbCompetition;
        List<DBCompetition> list;
        dbCompetition=dbCompetitionMapper.findById(1);
        System.out.println(dbCompetition.toString());
        list=dbCompetitionMapper.findByRound("初赛");
        System.out.println(list.toString());
        list=dbCompetitionMapper.findBySport("100m赛跑");
        System.out.println(list.toString());
        dbCompetition=dbCompetitionMapper.findByRoundAndSport("初赛","立定跳远");
        System.out.println(dbCompetition.toString());
    }

}