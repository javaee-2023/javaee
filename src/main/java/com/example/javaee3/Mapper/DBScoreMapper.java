package com.example.javaee3.Mapper;

import com.example.javaee3.Enity.DBScore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DBScoreMapper {
    @Select("select * from score where sid=#{sid}")
    public DBScore findBySid(int sid);

    @Insert("insert into score(score, result, rank, team, number) values(#{score}, #{result}, #{rank}, #{team}, #{number})")
    public int insertScore(DBScore dbScore);
    @Insert("insert into score(team, number) values(#{team}, #{number})")
    public int insertScoreWithTeamAndNumber(DBScore dbScore);

    @Delete("delete from score where sid=#{sid}")
    public int deleteScore(int sid);
}
