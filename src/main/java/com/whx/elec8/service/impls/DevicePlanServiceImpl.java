package com.whx.elec8.service.impls;

import com.whx.elec8.ConstantsKeys;
import com.whx.elec8.controller.vo.DevPlanSearchVo;
import com.whx.elec8.dao.DDlDao;
import com.whx.elec8.dao.DevicePlanDao;
import com.whx.elec8.domain.ElecDevicePlan;
import com.whx.elec8.domain.ElecExportfields;
import com.whx.elec8.domain.ElecSystemddl;
import com.whx.elec8.service.DevicePlanService;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DevicePlanServiceImpl implements DevicePlanService {

    @Resource
    private DevicePlanDao devicePlanDao;

    @Resource
    private DDlDao dDlDao;
    private static final String IMPORT_MODEL="所属单位#设备名称#计划时间#设备类型#品牌#型号#用途#数量#单位#金额#";

    @Override
    public List<ElecDevicePlan> getAllPlans() {

        return devicePlanDao.queryAllPlans();
    }

    @Override
    public PageBean<ElecDevicePlan> getPageDatasIndex(HttpServletRequest request) {
        UtilPageBean utilPageBean=new UtilPageBean(request);
        Long counts = devicePlanDao.queryCounts();

        //设置分页信息记录
        utilPageBean.setTotalResult((int)(long)counts);
        //设置结果
        int startpos = utilPageBean.getBeginResult();

        List<ElecDevicePlan> elecDevicePlans = devicePlanDao.queryPagePlans(startpos, UtilPageBean.PAGE_CAPACITY);
        //获取limit
        utilPageBean.setBeans(elecDevicePlans);
        PageBean pageBean = utilPageBean.getPageBean();

        //分页时访问该页面
        pageBean.setRequestUrl("/planPage.html");

        return pageBean;
    }

    @Override
    public PageBean<ElecDevicePlan> getPageDatasCondition(HttpServletRequest request, DevPlanSearchVo devPlanSearchVo) {
        if (devPlanSearchVo ==null) {
            return getPageDatasIndex(request);
        }
        UtilPageBean utilPageBean=new UtilPageBean(request);
        Long counts = devicePlanDao.queryCountsByCondition(devPlanSearchVo.getJctId(), devPlanSearchVo.getDevName(), devPlanSearchVo.getPlanDatef(), devPlanSearchVo.getPlanDatet(), devPlanSearchVo.getDevType());

        //设置分页信息记录
        utilPageBean.setTotalResult((int)(long)counts);
        //设置结果
        int startpos = utilPageBean.getBeginResult();

        List<ElecDevicePlan> elecDevicePlans = devicePlanDao.queryPagePlansByCondition(startpos, UtilPageBean.PAGE_CAPACITY,
                devPlanSearchVo.getJctId(), devPlanSearchVo.getDevName(), devPlanSearchVo.getPlanDatef(), devPlanSearchVo.getPlanDatet(), devPlanSearchVo.getDevType());
        //获取limit
        utilPageBean.setBeans(elecDevicePlans);
        PageBean pageBean = utilPageBean.getPageBean();

        //分页时访问该页面
        pageBean.setRequestUrl("/queryDatas.html");
        return pageBean;
    }

    @Override
    public ElecDevicePlan getPlanByID(String devPlanId) {

        return  devicePlanDao.queryPlanByID(devPlanId);

    }

    @Override
    public List<ExportSettingItem> getDefaltExportItems() {
        ElecExportfields defaltPlanEXSetting = devicePlanDao.queryDefaltPlanEXSetting();
        //要导出的数据库列名
        String dbNamesStr = defaltPlanEXSetting.getExpfieldname();
        //要导出的excel列名
        String excelNameStr = defaltPlanEXSetting.getExpnamelist();

        String[] dbNames = dbNamesStr.split("#");
        String[] excelNames = excelNameStr.split("#");

        List<ExportSettingItem> exportSettingItems=new ArrayList<>();
        for (int i = 0; i < dbNames.length; i++) {
            String dbName=dbNames[i];
            String excelName=excelNames[i];
            ExportSettingItem exportSettingItem=new ExportSettingItem();
            exportSettingItem.setDbName(dbName);
            exportSettingItem.setExcelName(excelName);
            exportSettingItems.add(exportSettingItem);
        }

        return exportSettingItems;
    }

    @Override
    public List<ExportSettingItem> getDefaltNoExportItems() {
        ElecExportfields defaltPlanEXSetting = devicePlanDao.queryDefaltPlanEXSetting();

        //不用导出的数据库列名
        String dbNamesStr = defaltPlanEXSetting.getNoexpfieldname();
        //不用导出的excel列名
        String excelNameStr = defaltPlanEXSetting.getNoexpnamelist();

        String[] dbNames = dbNamesStr.split("#");
        String[] excelNames = excelNameStr.split("#");

        List<ExportSettingItem> exportSettingItems=new ArrayList<>();
        for (int i = 0; i < dbNames.length; i++) {
            String dbName=dbNames[i];
            String excelName=excelNames[i];
            ExportSettingItem exportSettingItem=new ExportSettingItem();
            exportSettingItem.setDbName(dbName);
            exportSettingItem.setExcelName(excelName);
            exportSettingItems.add(exportSettingItem);
        }

        return exportSettingItems;

    }

    @Override
    public void saveExportSetting(String names, String fields, String nonames, String nofields, HttpSession session) {
        String[] excelNames = names.split("#");
        String[] dbNames = fields.split("#");
        String[] noExcelNames = nonames.split("#");
        String[] noDbNames = nofields.split("#");

        List<ExportSettingItem> exportSettingItems=new ArrayList<>();
        for (int i = 0; i < dbNames.length; i++) {
            String dbName=dbNames[i];
            String excelName=excelNames[i];
            ExportSettingItem exportSettingItem=new ExportSettingItem();
            exportSettingItem.setDbName(dbName);
            exportSettingItem.setExcelName(excelName);
            exportSettingItems.add(exportSettingItem);
        }

        List<ExportSettingItem> noExportSettingItems=new ArrayList<>();
        for (int i = 0; i < noDbNames.length; i++) {
            String noDbName=noDbNames[i];
            String noExcelName=noExcelNames[i];
            ExportSettingItem exportSettingItem=new ExportSettingItem();
            exportSettingItem.setDbName(noDbName);
            exportSettingItem.setExcelName(noExcelName);
            noExportSettingItems.add(exportSettingItem);
        }

        session.setAttribute(ConstantsKeys.SESSION_PLAN_EX_ITEMS,exportSettingItems);

        session.setAttribute(ConstantsKeys.SESSION_PLAN_NOEX_ITEMS,noExportSettingItems);

    }

    @Override
    public byte[] genExportFile(DevPlanSearchVo devPlanSearchVo, List<ExportSettingItem> exportSettingItems) throws Exception{
        List<ElecDevicePlan> elecDevicePlans = devicePlanDao.queryPlansByCondition( devPlanSearchVo.getJctId(), devPlanSearchVo.getDevName(), devPlanSearchVo.getPlanDatef(), devPlanSearchVo.getPlanDatet(), devPlanSearchVo.getDevType());


        //创建工作簿
        XSSFWorkbook workBook = new XSSFWorkbook();
        //创建工作表  工作表的名字叫helloWorld
        XSSFSheet sheet = workBook.createSheet("设备购置计划");

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


        //数据行
        for (int i = 0; i < elecDevicePlans.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);

            ElecDevicePlan elecDevicePlan = elecDevicePlans.get(i);

            for (int j = 0; j < exportSettingItems.size(); j++) {
                XSSFCell cell = row.createCell(j);
                String dbName = exportSettingItems.get(j).getDbName();
                String fieldName = dbName.toLowerCase();

                Field field = ElecDevicePlan.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                cell.setCellValue(field.get(elecDevicePlan).toString());
            }

        }

        //内存流
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        workBook.write(byteArrayOutputStream);

        workBook.close();//最后记得关闭工作簿

        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public String importPlans(MultipartFile files) {

        //读取工作簿
        XSSFWorkbook workBook = null;
        try {
            //校验1:非法文件
            workBook = new XSSFWorkbook( files.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return "你传的不是一个excel文件";
        }
        //读取工作表
        XSSFSheet sheet = workBook.getSheetAt(0);



//        int rowNums = sheet.getPhysicalNumberOfRows();
//        System.out.println("rowNums = " + rowNums);

        //校验2:文档内容必须符合模板规范
        XSSFRow rowTitle = sheet.getRow(0);
        //标题行的单元格数
        int rowTitleCells = rowTitle.getPhysicalNumberOfCells();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < rowTitleCells; i++) {
            XSSFCell cell = rowTitle.getCell(i);
            if (cell==null) {
                return "导入数据存在空单元格,请修改!!";
            }

            rowTitle.getCell(i).setCellType(XSSFCell.CELL_TYPE_STRING);
            //获取标题行单元格的内容
            String stringCellValue = rowTitle.getCell(i).getStringCellValue();
            stringBuilder.append(stringCellValue);
            stringBuilder.append("#");
        }
        if (!stringBuilder.toString().trim().equals(IMPORT_MODEL)) {
            return "文件格式非法!!请修改后重新上传!";
        }



        List<ElecSystemddl> jctids = dDlDao.queryDatasByKeyword("所属单位");
        StringBuilder resultInfo=new StringBuilder();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        //总行数
        int rowNums = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowNums; i++) {
            XSSFRow row = sheet.getRow(i);
            int columnNum = row.getPhysicalNumberOfCells();
            for (int j = 0; j < columnNum; j++) {
                row.getCell(j).setCellType(XSSFCell.CELL_TYPE_STRING);
                String stringCellValue = row.getCell(j).getStringCellValue().trim();
//                所属单位#设备名称#计划时间#设备类型#品牌#型号#用途#数量#单位#金额#
                switch (j){
                    case 0:
                        //判断所属单位
                        boolean contains=false;
                        for (ElecSystemddl jctid : jctids) {
                            if(jctid.getDdlname().equals(stringCellValue)){
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
                    case 2:
                        //判断计划时间格式,时间区间是否正确
                        Date date=null;
                        try {
                            //excel中的日期
                             date = simpleDateFormat.parse(stringCellValue);
                             Calendar calendar1=Calendar.getInstance();
                             calendar1.setTime(date);
                             //判断是否在当前时间之后
                            boolean b = calendar.before(calendar1);
                            if (!b) {
                                resultInfo.append("第");
                                resultInfo.append(i+1);
                                resultInfo.append("行,第");
                                resultInfo.append(j+1);
                                resultInfo.append("列,计划时间需要在当前时间之后,请修正!<br/>");
                            }

                        } catch (ParseException e) {
                            e.printStackTrace();
                            resultInfo.append("第");
                            resultInfo.append(i+1);
                            resultInfo.append("行,第");
                            resultInfo.append(j+1);
                            resultInfo.append("列,时间日期格式错误,请修正!<br/>");
                        }
                        break;
                }


            }
            System.out.println();


        }
        if(resultInfo.length()==0){
            //数据可入库

            for (int i = 1; i < rowNums; i++) {
                XSSFRow row = sheet.getRow(i);
                int columnNum = row.getPhysicalNumberOfCells();
                List<String> params=new ArrayList<>();
                for (int j = 0; j < columnNum; j++) {
                    row.getCell(j).setCellType(XSSFCell.CELL_TYPE_STRING);
                    String stringCellValue = row.getCell(j).getStringCellValue().trim();
                    params.add(stringCellValue);

                }
                devicePlanDao.insertPlans(params.get(0),params.get(1) , params.get(2), params.get(3),params.get(4) , params.get(5), params.get(6), params.get(7), params.get(8),params.get(9) );
            }
            resultInfo.append("导入成功!");
        }

        try {
            workBook.close();//最后记得关闭工作簿
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultInfo.toString();
    }
}
