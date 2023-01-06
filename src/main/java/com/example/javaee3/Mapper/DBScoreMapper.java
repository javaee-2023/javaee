package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.DBScore;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DBScoreMapper {
    @Select("select * from score where sid=#{sid}")
    public DBScore findBySid(int sid);
    @Select("Select * from score where team=#{team}")
    public List<DBScore> findByTeam(String team);
    @Select("Select * from score where `number`=#{number}")
    public List<DBScore> findByNumber(String number);
    @Select("Select * from score where team=#{team},`number`=#{number}")
    public List<DBScore> findByTeamAndNumber(String team, String number);

    /**
     * 应当写关联查询的，但是忘了怎么写了，就直接写sql好了
     */
    @Select("select a.`number` from score as a, association as b, competition as c where a.sid=b.sid and b.cid=c.cid and a.team=#{team} and sport=#{sport}")
    public List<String> searchFreeNumber(String team, String sport);
    @Select("select a.team from score as a, association as b, competition as c where a.sid=b.sid and b.cid=c.cid and a.`number`=#{number} and sport=#{sport}")
    public List<String> searchFreeTeam(String number, String sport);
    @Select("select a.`number` as `number` ,a.team as team from score as a, association as b, competition as c where a.sid=b.sid and b.cid=c.cid and sport=#{sport}")
    public List<DBScore> searchFreeNumberAndTeam(String sport);

    @Insert("insert into score(score, `result`, `rank`, team, `number`) values(#{score}, #{result}, #{rank}, #{team}, #{number})")
    public int insertScore(DBScore dbScore);
    @Insert("insert into score(team, `number`) values(#{team}, #{number})")
    public int insertScoreWithTeamAndNumber(DBScore dbScore);

    @Update("update score set team=#{team}, `number`=#{number} where sid=#{sid}")
    public int updateScoreWithTeamAndNumber(int sid, String team, String number);
    @Update("update score set `rank`=null, `result`=null, score=null where sid=#{sid}")
    public int initScore(int sid);
    @Delete("delete from score where sid=#{sid}")
    public int deleteScore(int sid);

}
