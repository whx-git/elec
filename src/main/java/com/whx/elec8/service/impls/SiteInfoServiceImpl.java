package com.whx.elec8.service.impls;

import com.whx.elec8.controller.vo.SiteInfoVo;
import com.whx.elec8.dao.SIteInfoDao;
import com.whx.elec8.domain.ElecStation;
import com.whx.elec8.service.SiteInfoService;
import com.whx.elec8.utils.doPage.PageBean;
import com.whx.elec8.utils.doPage.UtilPageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SiteInfoServiceImpl implements SiteInfoService {

    @Resource
    private SIteInfoDao sIteInfoDao;
    @Override
    public PageBean<ElecStation> getAllPageDatas(HttpServletRequest request) {
        UtilPageBean utilPageBean=new UtilPageBean(request);
        Long counts = sIteInfoDao.queryCounts();
        utilPageBean.setTotalResult((int)(long)counts);
        int startPos = utilPageBean.getBeginResult();
        List<ElecStation> elecStations = sIteInfoDao.queryAllDatas(startPos, UtilPageBean.PAGE_CAPACITY);
        utilPageBean.setBeans(elecStations);
        PageBean pageBean = utilPageBean.getPageBean();

        pageBean.setRequestUrl("/siteInfoPage.html");

        return pageBean;
    }

    @Override
    public ElecStation getStation(String stationid) {
        ElecStation station = sIteInfoDao.getStationByID(stationid);
        return station;
    }

    @Override
    public PageBean<ElecStation> getPageDatasCondition(HttpServletRequest request, SiteInfoVo siteInfoVo) {
        if (siteInfoVo==null) {
            return getAllPageDatas(request);
        }
        UtilPageBean utilPageBean=new UtilPageBean(request);
        Long counts = sIteInfoDao.queryCountsCondition(siteInfoVo.getJct(), siteInfoVo.getStationName(), siteInfoVo.getStationCode(), siteInfoVo.getStationType(), siteInfoVo.getContactType(), siteInfoVo.getAttributionGround());

        utilPageBean.setTotalResult((int)(long)counts);
        int startPos = utilPageBean.getBeginResult();
        List<ElecStation> elecStations = sIteInfoDao.queryDatasCondition(Math.toIntExact(counts), UtilPageBean.PAGE_CAPACITY, siteInfoVo.getJct(), siteInfoVo.getStationName(), siteInfoVo.getStationCode(), siteInfoVo.getStationType(), siteInfoVo.getContactType(), siteInfoVo.getAttributionGround());
        utilPageBean.setBeans(elecStations);
        PageBean pageBean = utilPageBean.getPageBean();
        pageBean.setRequestUrl("/querySiteInfoDatas.html");

        return pageBean;
    }
}
