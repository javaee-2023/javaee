package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.DBAssociation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DBAssociationMapper {
    @Select("select * from association")
    public List<DBAssociation> findAll();
    @Select("select * from association where aid=#{aid}")
    public List<DBAssociation> findByAid(int aid);
    @Select("select * from association where cid=#{cid}")
    public List<DBAssociation> findByCid(int cid);
    @Select("select * from association where sid=#{sid}")
    public List<DBAssociation> findBySid(int sid);
    @Select("select * from association where aid=#{aid} and cid=#{cid}")
    public List<DBAssociation> findByAidAndCid(int aid, int cid);
    @Select("select * from association where aid=#{aid} and sid=#{sid}")
    public List<DBAssociation> findByAidAndSid(int aid, int sid);
    @Select("select * from association where cid=#{cid} and sid=#{sid}")
    public List<DBAssociation> findByCidAndSid(int cid, int sid);
    @Select("select * from association where aid=#{aid} and cid=#{cid} and sid=#{sid}")
    public DBAssociation findByAidAndAndCidAndSid(int aid, int cid, int sid);

    @Insert("insert into association(aid, cid, sid) values(#{aid}, #{cid}, #{sid})")
    public int insertAssociation(DBAssociation dbAssociation);

    @Update("update association set cid=#{c_cid} where aid=#{aid} and cid=#{cid} and sid=#{sid}")
    public int updateAssociationWithCid(int aid, int cid, int sid, int c_cid);

    @Delete("delete from association where aid=#{aid} and cid=#{cid} and sid=#{sid}")
    public int deleteAssociation(DBAssociation dbAssociation);
    @Delete("delete from association where aid=#{aid}")
    public int deleteAssociationByAid(int aid);

}
