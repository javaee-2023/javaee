package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.Athlete;
import com.example.javaee3.Entity.DBAssociation;
import com.example.javaee3.Entity.DBCompetition;
import com.example.javaee3.Service.AssociationService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AthleteMapper {

    public List<Athlete> findAthletes(Athlete athlete);
    public DBAssociation findAssociationByAthlete(Athlete athlete);
}
