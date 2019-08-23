package com.whx.elec8.dao;

import com.whx.elec8.domain.ElecStation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SIteInfoDao {
    @Select("select count(*) from elec_station")
    public Long queryCounts();

    @Select("select * from elec_station limit #{param1},#{param2}")
    public List<ElecStation> queryAllDatas(int startPos,int size);

    @Select("select * from elec_station where StationID=#{stationid}")
    public ElecStation getStationByID(String stationid);

    @Select("")
    public Long queryCountsCondition(@Param("jct") String jct,
                                     @Param("stationName") String stationName,
                                     @Param("stationCode") String stationCode,
                                     @Param("stationType")String stationType,
                                     @Param("contactType") String contactType,
                                     @Param("attributionGround")  String attributionGround);

    public List<ElecStation> queryDatasCondition(@Param("startPos") int startPos,
                                                 @Param("size") int size,
                                                 @Param("jct") String jct,
                                                 @Param("stationName") String stationName,
                                                 @Param("stationCode") String stationCode,
                                                 @Param("stationType")String stationType,
                                                 @Param("contactType") String contactType,
                                                 @Param("attributionGround")  String attributionGround);

}

