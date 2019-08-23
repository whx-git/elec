package com.whx.elec8.dao;

import com.whx.elec8.domain.ElecSystemddl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DDlDao {
    @Select("select distinct keyword from elec_systemddl")
    public List<String> queryAllKeywords();

    @Select("select * from elec_systemddl where keyword=#{keyword}")
    public List<ElecSystemddl> queryDatasByKeyword(String keyword);

    @Insert("insert into elec_systemddl values(null,#{param1},#{param2},#{param3})")
    public void insertKeywordDatas(String keyword,Integer code,String data);

    @Delete("delete from elec_systemddl where keyword=#{keyword}")
    public void deleteKeywordDatas(String keyword);

}
