package com.example.javaee3.Mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DBAssociationMapperTest {
    @Autowired
    DBAssociationMapper dbAssociationMapper;
    @Test
    public void insert(){
        //dbAssociationMapper.insertAssociation(1,2,3);
    }
    @Test
    public void delete(){
        //dbAssociationMapper.insertAssociation(1,2,3);
    }
}