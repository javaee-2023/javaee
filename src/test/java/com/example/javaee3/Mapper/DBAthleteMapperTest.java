package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.DBAthlete;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DBAthleteMapperTest {
    @Autowired
    DBAthleteMapper dbAthleteMapper;
    @Test
    public void tmp(){
        DBAthlete dbAthlete=dbAthleteMapper.findByName("于永立");
        System.out.println(dbAthlete.toString());
        if(dbAthlete==null) System.out.println(1);
    }
}