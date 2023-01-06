package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.DBAthlete;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DBAthleteMapper {
    @Select("select * from athlete where aid=#{aid}")
    public DBAthlete findByAid(int aid);
    @Select("select * from athlete where name=#{name}")
    public DBAthlete findByName(String name);
    @Select("select * from athlete where `group`=#{group}")
    public List<DBAthlete> findByAId(String group);
    @Select("select * from athlete where aid=#{aid} and name=#{group}")
    public DBAthlete findByAidAndGroup(int aid, String group);
    @Select("select * from athlete where sportsTeam='是'")
    public List<DBAthlete> findByIsSportsTeam();
    @Select("select * from athlete")
    public List<DBAthlete> findAll();

    /**
     * 应当写关联查询的，但是忘了怎么写了，就直接写sql好了
     */
    @Select("select c.sport from athlete as a, association as b, competition as c where a.aid=b.aid and b.cid=c.cid and a.name=#{name}")
    public List<String> searchSports(String name);

    @Insert("insert into athlete(name, `group`, sportsTeam) values(#{name}, #{group}, #{sportsTeam})")
    public int insertAthlete(DBAthlete dbAthlete);

    @Update("update athlete set name=#{name}, `group`=#{group}, sportsTeam=#{sportsTeam} where aid=#{aid}")
    public int updateAthlete(int aid, String name, String group, String sportsTeam);

    @Delete("delete from athlete where aid=#{aid}")
    public int deleteAthlete(int aid);
}
