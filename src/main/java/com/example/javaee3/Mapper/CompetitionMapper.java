package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.Competition;
import com.example.javaee3.Entity.Group;
import com.example.javaee3.Entity.Player;
import com.example.javaee3.Entity.SportsTeamPlayer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompetitionMapper {
    public List<Player> findPlayerByCompetition(Competition competition);
    @Select("select `group`, sum(c.score) as score from athlete as a, association as b, score as c where a.aid=b.aid and b.sid=c.sid group by `group`")
    public List<Group> findGroup();
    public List<SportsTeamPlayer> findSportsTeam();
}
