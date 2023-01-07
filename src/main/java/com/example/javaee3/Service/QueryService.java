package com.example.javaee3.Service;

import com.example.javaee3.Entity.Record;
import com.example.javaee3.Entity.Student;
import com.example.javaee3.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class QueryService {
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
    @Autowired
    QueryMapper queryMapper;
    public List<Record> recordsQuery(String sport){
        System.out.println("插眼");
        List<Record> records=queryMapper.queryRecord(sport);
        System.out.println(records.size());
        for(int i=0;i<records.size();++i){
            System.out.println(records.get(i));
        }
        records.sort(Comparator.comparing(Record::getScore).reversed());
        for(int i=0;i<records.size();++i){
            records.set(i, new Record(i+1, records.get(i)));
        }
        return records;
    }
    public List<Student> studentQuery(Student student){
        return queryMapper.queryStudent(student);
    }
}
