package com.whx.elec8.dao;

import com.whx.elec8.domain.ElecFileupload;
import com.whx.elec8.domain.ElecUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface DataChartDao {
    @Insert("insert into elec_fileupload values(null,#{projid},#{belongto},#{filename},#{fileurl},#{progresstime},#{isdelete},#{createempid},#{createdate},#{comment})")
    @SelectKey(statement = "select last_insert_id()",before = false,keyColumn = "SeqID",keyProperty = "seqid",resultType = Integer.class)
    public void insertFileUpload(ElecFileupload elecFileupload)throws Exception;

    public List<ElecFileupload> queryAddData(@Param("projId") String projId, @Param("belongTo") String belongTo);


}

