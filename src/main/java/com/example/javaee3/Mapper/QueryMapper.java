package com.example.javaee3.Mapper;

import com.example.javaee3.Entity.Record;
import com.example.javaee3.Entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface QueryMapper {
    @Select("select a.aid as id, a.name as name, b.`rank` as `rank`, " +
            "b.`result` as `result`, b.score as score from athlete as a, score as b," +
            " competition as c, association as d where a.aid =d.aid and b.sid =d" +
            ".sid  and c.cid =d.cid and c.sport=#{sport}")
    public List<Record> queryRecord(String sport);

    public List<Student> queryStudent(Student student);
}
