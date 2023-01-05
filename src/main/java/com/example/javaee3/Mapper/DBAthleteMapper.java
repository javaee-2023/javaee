package com.example.javaee3.Mapper;

import com.example.javaee3.Enity.DBAthlete;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface DBAthleteMapper {
    @Select("select * from athlete where aid=#{aid}")
    public DBAthlete findByAid(int aid);
    @Select("select * from athlete where name=#{name}")
    public DBAthlete findByAName(String name);
    @Select("select * from athlete where group=#{group}")
    public DBAthlete findByAId(String group);
    @Select("select * from athlete where aid=#{aid} and name=#{name}")
    public DBAthlete findByAidAndName(int aid, String name);
    @Select("select * from athlete where aid=#{aid} and name=#{group}")
    public DBAthlete findByAidAndGroup(int aid, String group);
    @Select("select * from athlete where name=#{name} and group=#{group}")
    public DBAthlete findByNameAndGroup(String name, String group);
    @Select("select * from athlete where aid=#{aid} and name=#{name} and group=#{group}")
    public DBAthlete findByAidAndNameAndGroup(int aid, String name, String group);
    @Select("select * from athlete where sportsTeam='是'")
    public DBAthlete findByIsSportsTeam();

    @Insert("insert into athlete(aid, name, group, sportsTeam) values(#{aid}, #{name}, #{group}, #{sportsTeam})")
    public int insertAthlete(DBAthlete dbAthlete);

    @Delete("delete from athlete where aid=#{aid}, name=#{name}, group=#{group}, sportsTeam=#{sportsTeam}")
    public int deleteAthlete(int aid, String name, String group, String SportsTeam);
}
