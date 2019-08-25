package com.whx.elec8.service.impls;

import com.whx.elec8.ConstantsKeys;
import com.whx.elec8.controller.vo.SiteAddVo;
import com.whx.elec8.controller.vo.SiteInfoVo;
import com.whx.elec8.dao.DDlDao;
import com.whx.elec8.dao.SiteInfoDao;
import com.whx.elec8.domain.ElecExportfields;
import com.whx.elec8.domain.ElecStation;
import com.whx.elec8.domain.ElecSystemddl;
import com.whx.elec8.service.SiteInfoService;
import com.whx.elec8.service.bo.ExportSettingItem;
import com.whx.elec8.utils.doPage.PageBean;
import com.whx.elec8.utils.doPage.UtilPageBean;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class SiteInfoServiceImpl implements SiteInfoService {

    @Resource
    private SiteInfoDao sIteInfoDao;
    @Resource
    private DDlDao dDlDao;
    private static final String IMPORT_SITE="所属单位#站点名称#安装地点#生产厂家#通讯方式#备注#创建人#站点类别#归属地#";
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
        List<ElecStation> elecStations = sIteInfoDao.queryDatasCondition(startPos, UtilPageBean.PAGE_CAPACITY, siteInfoVo.getJct(), siteInfoVo.getStationName(), siteInfoVo.getStationCode(), siteInfoVo.getStationType(), siteInfoVo.getContactType(), siteInfoVo.getAttributionGround());
        utilPageBean.setBeans(elecStations);
        PageBean pageBean = utilPageBean.getPageBean();
        pageBean.setRequestUrl("/querySiteInfoDatas.html");

        return pageBean;
    }

    @Override
    public List<ExportSettingItem> ExportSiteInfo() {
        ElecExportfields elecExportfields = sIteInfoDao.queryExportInfo();
        //导出数据的数据库列名
        String dbNameStr = elecExportfields.getExpfieldname();
        //导出的excel列名
        String excelNameStr = elecExportfields.getExpnamelist();

        String[] dbNames = dbNameStr.split("#");
        String[] excelNames = excelNameStr.split("#");

        List<ExportSettingItem> exportSettingItems=new ArrayList<>();
        for (int i = 0; i < dbNames.length; i++) {
            String dbName=dbNames[i];
            String excelName=excelNames[i];
            ExportSettingItem exportSettingItem=new ExportSettingItem();
            exportSettingItem.setExcelName(excelName);
            exportSettingItem.setDbName(dbName);
            exportSettingItems.add(exportSettingItem);

        }
        return exportSettingItems;
    }

    @Override
    public List<ExportSettingItem> NoExportSiteInfo() {
        ElecExportfields elecExportfields = sIteInfoDao.queryExportInfo();
        //不用导出的数据库列名
        String noDbNameStr = elecExportfields.getNoexpfieldname();
        //不用导出的excel列名
        String noExcelNameStr = elecExportfields.getNoexpnamelist();
        String[] noDbNames = noDbNameStr.split("#");
        String[] noExcelNames = noExcelNameStr.split("#");
        List<ExportSettingItem> exportSettingItems=new ArrayList<>();
        for (int i = 0; i < noDbNames.length; i++) {
            String noDbName=noDbNames[i];
            String noExcelName=noExcelNames[i];
            ExportSettingItem exportSettingItem=new ExportSettingItem();
            exportSettingItem.setDbName(noDbName);
            exportSettingItem.setExcelName(noExcelName);
            exportSettingItems.add(exportSettingItem);
        }
        return exportSettingItems;
    }

    @Override
    public void saveSiteExportInfo(HttpSession session, String expNameList, String expFieldName, String noExpNameList, String noExpFieldName) {
        String[] dbNames = expFieldName.split("#");
        String[] excelNames = expNameList.split("#");
        String[] noDbNames = noExpFieldName.split("#");
        String[] noExcelNames = noExpNameList.split("#");

        List<ExportSettingItem> exportSettingItems=new ArrayList<>();
        for (int i = 0; i < dbNames.length; i++) {
           String dbName=dbNames[i];
           String excelName=excelNames[i];
            ExportSettingItem exportSettingItem=new ExportSettingItem();
            exportSettingItem.setExcelName(excelName);
            exportSettingItem.setDbName(dbName);
            exportSettingItems.add(exportSettingItem);
        }
        List<ExportSettingItem> noExportSettingItems=new ArrayList<>();
        for (int i = 0; i < noDbNames.length; i++) {
            String noDbName=noDbNames[i];
            String noExcelName=noExcelNames[i];
            ExportSettingItem noexportSettingItem=new ExportSettingItem();
            noexportSettingItem.setDbName(noDbName);
            noexportSettingItem.setExcelName(noExcelName);
            noExportSettingItems.add(noexportSettingItem);
        }
        session.setAttribute(ConstantsKeys.SESSION_SITE_EX_ITEMS,exportSettingItems);
        session.setAttribute(ConstantsKeys.SESSION_SITE_NOEX_ITEMS,noExportSettingItems);
    }

    @Override
    public byte[] ExportSiteFiles(SiteInfoVo siteInfoVo, List<ExportSettingItem> exportSettingItems) throws Exception {
        List<ElecStation> elecStations = sIteInfoDao.querySiteInfoCondition(siteInfoVo.getJct(), siteInfoVo.getStationName(), siteInfoVo.getStationCode(), siteInfoVo.getStationType(), siteInfoVo.getContactType(), siteInfoVo.getAttributionGround());

        //创建工作簿
        XSSFWorkbook workBook = new XSSFWorkbook();
        //创建工作表  工作表的名字叫helloWorld
        XSSFSheet sheet = workBook.createSheet("站点基本信息");

        //向sheet中创建行列
        //标题行

        XSSFRow rowTitle = sheet.createRow(0);
        //设置高度
        rowTitle.setHeightInPoints(40);
        //获取一个样式对象
        CellStyle cellStyle=workBook.createCellStyle();
        XSSFCellStyle styleTemp=((XSSFCellStyle)cellStyle);
        //字体加粗变红
        XSSFFont font = workBook.createFont();
        font.setBold(true);
        font.setFontHeight(10);
        font.setColor(new XSSFColor(new java.awt.Color(255,0,0)));
        styleTemp.setFont(font);
        //设置居中对齐
        styleTemp.setAlignment(HorizontalAlignment.CENTER);
        styleTemp.setVerticalAlignment(VerticalAlignment.CENTER);
        for (int i = 0; i < exportSettingItems.size(); i++) {
            XSSFCell cell = rowTitle.createCell(i);
            cell.setCellValue(exportSettingItems.get(i).getExcelName());
            sheet.setColumnWidth(i,9000);
            //给标题单元格设置样式
            cell.setCellStyle(cellStyle);
        }

        //数据

        //数据行
        for (int i = 0; i < elecStations.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);

            ElecStation elecStation = elecStations.get(i);

            for (int j = 0; j < exportSettingItems.size(); j++) {
                XSSFCell cell = row.createCell(j);
                String dbName = exportSettingItems.get(j).getDbName();
                String fieldName = dbName.toLowerCase();

                Field field = ElecStation.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                cell.setCellValue(field.get(elecStation).toString());
            }

        }
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            workBook.write(byteArrayOutputStream);
            workBook.close();
            return byteArrayOutputStream.toByteArray();
    }

    @Override
    public String SiteImports(MultipartFile file) {
        XSSFWorkbook workBook=null;
        try {
            workBook = new XSSFWorkbook( file.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
            return "你传的不是一个excel文件";
        }
        //读取工作表
        XSSFSheet sheet = workBook.getSheetAt(0);

        //检验:文档内容必须符合规范
        XSSFRow rowTitle = sheet.getRow(0);
        int rowTitleCells = rowTitle.getPhysicalNumberOfCells();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < rowTitleCells; i++) {
            XSSFCell cell = rowTitle.getCell(i);
            if (cell==null) {
                return "导入数据存在空单元格,请修改";
            }
            rowTitle.getCell(i).setCellType(XSSFCell.CELL_TYPE_STRING);
            //获取标题行单元格的内容
            String stringCellValue = rowTitle.getCell(i).getStringCellValue();
            stringBuilder.append(stringCellValue);
            stringBuilder.append("#");
        }
        if(!stringBuilder.toString().trim().equals(IMPORT_SITE)){
            return "文件格式非法,请修改后重试!";
        }

        List<ElecSystemddl> jctids = dDlDao.queryDatasByKeyword("所属单位");
        List<ElecSystemddl> stationNames = dDlDao.queryDatasByKeyword("站点名称");
        List<ElecSystemddl> stationTypes = dDlDao.queryDatasByKeyword("站点类别");
        StringBuilder resultInfo=new StringBuilder();

        int rowNums = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowNums; i++) {
            XSSFRow row = sheet.getRow(i);
            int columuNum = row.getPhysicalNumberOfCells();
            for (int j = 0; j < columuNum; j++) {
                row.getCell(j).setCellType(XSSFCell.CELL_TYPE_STRING);
                String cell = row.getCell(j).getStringCellValue().trim();
//  所属单位#站点名称#安装地点#生产厂家#通讯方式#备注#创建人#站点类别#归属地#
                switch (j){
                    case 0:
                        boolean contains=false;
                        for (ElecSystemddl jctid : jctids) {
                            if(jctid.getDdlname().equals(cell)){
                                contains=true;
                            }
                        }
                        if(!contains){
                            resultInfo.append("第");
                            resultInfo.append(i+1);
                            resultInfo.append("行,第");
                            resultInfo.append(j+1);
                            resultInfo.append("列,所属单位并不存在.,请修正!<br/>");
                        }
                        break;
                    case 1:
                        boolean canTrue=false;
                        for (ElecSystemddl stationName : stationNames) {
                            if(stationName.getDdlname().equals(cell)){
                                canTrue=true;
                            }
                        }
                        if(!canTrue){
                            resultInfo.append("第");
                            resultInfo.append(i+1);
                            resultInfo.append("行,第");
                            resultInfo.append(j+1);
                            resultInfo.append("列,站点名称并不存在.,请修正!<br/>");
                        }
                        break;
                    case 7:
                        boolean canT=false;
                        for (ElecSystemddl stationType : stationTypes) {
                            if(stationType.getDdlname().equals(cell)){
                                canT=true;
                            }
                        }
                        if(!canT){
                            resultInfo.append("第");
                            resultInfo.append(i+1);
                            resultInfo.append("行,第");
                            resultInfo.append(j+1);
                            resultInfo.append("列,站点类别并不存在.,请修正!<br/>");
                        }
                        break;
                }
            }
        }
        if(resultInfo.length()==0){
            for (int i = 1; i < rowNums; i++) {
                XSSFRow row = sheet.getRow(i);
                int columnNum= row.getPhysicalNumberOfCells();
                List<String> param=new ArrayList<>();
                for (int j = 0; j < columnNum; j++) {
                    row.getCell(j).setCellType(XSSFCell.CELL_TYPE_STRING);
                    String cell = row.getCell(j).getStringCellValue().trim();
                    param.add(cell);
                }
                sIteInfoDao.insertSiteInfo(param.get(0),param.get(1),param.get(2),param.get(3),param.get(4),
                        param.get(5),param.get(6),param.get(7),param.get(8));
            }
            resultInfo.append("导入成功");
        }
        try {
            workBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultInfo.toString();

    }

    @Override
    public boolean AddSiteInfo(SiteAddVo siteAddVo) {
        return  sIteInfoDao.AddSiteInfo(siteAddVo.getJctId(),siteAddVo.getStationName(),siteAddVo.getStationCode(),siteAddVo.getUseStartDate(),siteAddVo.getJcfrequency(),siteAddVo.getProduceHome(),siteAddVo.getContactType(),
                siteAddVo.getStationType(),siteAddVo.getAttributionGround(),siteAddVo.getComment());

    }

    @Override
    public String modifiSiteInfo(SiteAddVo siteAddVo,ElecStation station) {
        boolean b = sIteInfoDao.deleteSite(station.getStationid());
        if (!b) {
            return "修改失败!";
        }
        boolean b1 = sIteInfoDao.modifySite(station.getStationid(),siteAddVo.getJctId(),siteAddVo.getStationName(),siteAddVo.getStationCode(),siteAddVo.getUseStartDate(),siteAddVo.getJcfrequency(),siteAddVo.getProduceHome(),siteAddVo.getContactType(),
                siteAddVo.getStationType(),siteAddVo.getAttributionGround(),siteAddVo.getComment());
        if (!b1) {
            return "修改失败!";
        }
        return "修改成功!";
    }

    @Override
    public String deleteSite(Integer stationid) {
        boolean b = sIteInfoDao.deleteSite(stationid);
        if (!b) {
            return "删除失败,请重试!";
        }
        return "删除成功!";
    }


}
