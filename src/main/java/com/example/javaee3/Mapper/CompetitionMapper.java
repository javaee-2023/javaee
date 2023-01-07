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
    public List<Group> findGroup();
    public List<SportsTeamPlayer> findSportsTeam();
}
