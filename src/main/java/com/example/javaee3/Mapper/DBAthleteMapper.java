package com.example.javaee3.Mapper;

import com.example.javaee3.Enity.DBAthlete;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DBAthleteMapper {
    @Select("select * from athlete where aid=#{aid}")
    public DBAthlete findByAid(int aid);
    @Select("select * from athlete where name=#{name}")
    public List<DBAthlete> findByAName(String name);
    @Select("select * from athlete where group=#{group}")
    public List<DBAthlete> findByAId(String group);
    @Select("select * from athlete where aid=#{aid} and name=#{name}")
    public DBAthlete findByAidAndName(int aid, String name);
    @Select("select * from athlete where aid=#{aid} and name=#{group}")
    public DBAthlete findByAidAndGroup(int aid, String group);
    @Select("select * from athlete where name=#{name} and group=#{group}")
    public List<DBAthlete> findByNameAndGroup(String name, String group);
    @Select("select * from athlete where aid=#{aid} and name=#{name} and group=#{group}")
    public DBAthlete findByAidAndNameAndGroup(int aid, String name, String group);
    @Select("select * from athlete where sportsTeam='是'")
    public List<DBAthlete> findByIsSportsTeam();
    @Select("select * from athlete")
    public List<DBAthlete> findAll();

    @Insert("insert into athlete(name, `group`, sportsTeam) values(#{name}, #{group}, #{sportsTeam})")
    public int insertAthlete(DBAthlete dbAthlete);

    @Delete("delete from athlete where aid=#{aid}, name=#{name}, group=#{group}, sportsTeam=#{sportsTeam}")
    public int deleteAthlete(int aid, String name, String group, String SportsTeam);
}
