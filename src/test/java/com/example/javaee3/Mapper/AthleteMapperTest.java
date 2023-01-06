package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.Athlete;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class AthleteMapperTest {
    @Autowired
    AthleteMapper athleteMapper;
    @Test
    void findAthletes() {
        Athlete athlete=new Athlete(5, "","","","","","");
        List<Athlete> athletes=athleteMapper.findAthletes(athlete);
        System.out.println(athletes.size());
        for(int i=0;i<athletes.size();++i){
            System.out.println(athletes.get(i).toString());
        }
    }



}