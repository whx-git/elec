package com.whx.elec8.dao;

import com.whx.elec8.controller.vo.SiteAddVo;
import com.whx.elec8.controller.vo.SiteInfoVo;
import com.whx.elec8.domain.ElecExportfields;
import com.whx.elec8.domain.ElecStation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SiteInfoDao {
    @Select("select count(*) from elec_station")
    public Long queryCounts();

    @Select("select * from elec_station limit #{param1},#{param2}")
    public List<ElecStation> queryAllDatas(int startPos,int size);

    @Select("select * from elec_station where StationID=#{stationid}")
    public ElecStation getStationByID(String stationid);


    public Long queryCountsCondition(@Param("jct") String jct,
                                     @Param("stationNames") String stationNames,
                                     @Param("stationCode") String stationCode,
                                     @Param("stationType")String stationType,
                                     @Param("contactType") String contactType,
                                     @Param("attributionGround")  String attributionGround);

    public List<ElecStation> queryDatasCondition(@Param("startPos") int startPos,
                                                 @Param("size") int size,
                                                 @Param("jct") String jct,
                                                 @Param("stationNames") String stationNames,
                                                 @Param("stationCode") String stationCode,
                                                 @Param("stationType")String stationType,
                                                 @Param("contactType") String contactType,
                                                 @Param("attributionGround")  String attributionGround);

    @Select("select * from elec_exportfields where belongTo='5-5'")
    public ElecExportfields queryExportInfo();

    public List<ElecStation> querySiteInfoCondition(@Param("jct") String jct,
                                                    @Param("stationNames") String stationNames,
                                                    @Param("stationCode") String stationCode,
                                                    @Param("stationType")String stationType,
                                                    @Param("contactType") String contactType,
                                                    @Param("attributionGround")  String attributionGround);

    @Insert("insert into elec_station(JctID,StationName,JCFrequency,ProduceHome,ContactType,Comment,CreateEmpID,StationType,AttributionGround) values" +
            "(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6},#{param7},#{param8},#{param9})")
    public void insertSiteInfo(String JctID,String StationName,String JCFrequency,String ProduceHome,String ContactType,String Comment,String CreateEmpID,String StationType,String AttributionGround);

    @Insert("insert into elec_station(JctID,StationName,StationCode,UseStartDate,JCFrequency,ProduceHome," +
            "ContactType,StationType,AttributionGround,COMMENT) values(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6},#{param7},#{param8},#{param9},#{param10})")
    public boolean AddSiteInfo(String jctId,
            String stationName,
            String stationCode,
            String useStartDate,
            String jcfrequency,
            String produceHome,
            String contactType,
            String stationType,
            String attributionGround,
            String comment);

    @Delete("delete from elec_station where StationID=#{param1}")
    public boolean deleteSite(Integer stationid);

    @Insert("insert into elec_station(StationID,JctID,StationName,StationCode,UseStartDate,JCFrequency,ProduceHome," +
            "ContactType,StationType,AttributionGround,COMMENT) values(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6},#{param7},#{param8},#{param9},#{param10},#{param11})")
    public boolean modifySite(Integer stationid,
                              String jctId,
                              String stationName,
                              String stationCode,
                              String useStartDate,
                              String jcfrequency,
                              String produceHome,
                              String contactType,
                              String stationType,
                              String attributionGround,
                              String comment);
}

