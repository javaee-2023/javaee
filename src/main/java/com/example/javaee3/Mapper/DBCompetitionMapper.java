package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.DBCompetition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DBCompetitionMapper {
    @Select("select * from competition where cid=#{cid}")
    public DBCompetition findById(Integer cid);
    @Select("select * from competition where `round`=#{round}")
    public List<DBCompetition> findByRound(String round);
    @Select("select * from competition where sport=#{sport}")
    public List<DBCompetition> findBySport(String sport);
    @Select("select * from competition where `round`=#{round} and sport=#{sport}")
    public DBCompetition findByRoundAndSport(String round, String sport);
}
