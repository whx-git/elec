package com.whx.elec8.service.impls;

import com.whx.elec8.dao.DataChartDao;
import com.whx.elec8.domain.ElecFileupload;
import com.whx.elec8.service.DataChartService;
import com.whx.elec8.utils.DateTimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataChartServiceImpl implements DataChartService {

    @Resource
    private DataChartDao dataChartDao;

    @Resource
    private HttpSolrServer solrServer;
    //  G:\elecWork
    private static final String UPLOAD_DIR_ROOT="G:/elecWork";
//    elecData
    public static final String FILE_BASE="/elecData";
    @Override
    @Transactional
    public String uploadFiles(MultipartFile[] uploads, String[] comments, String projId, String belongTo) {
        String dirs = genDirs(projId, belongTo);

        //文件转储
        List<MultipartFile> fileOk=new ArrayList<>();
        String resltInfo=null;
        for (MultipartFile upload : uploads) {
          String filePath= dirs+upload.getOriginalFilename();
            try {
                upload.transferTo(new File(filePath));
                fileOk.add(upload);
            } catch (IOException e) {
                resltInfo+=upload.getOriginalFilename()+"传输失败!!<br/>";
                e.printStackTrace();
            }
        }


        //存储数据库
        for (int i = 0; i < fileOk.size(); i++) {
            MultipartFile file = fileOk.get(i);
            String comment=comments[i];
            String filename = file.getOriginalFilename();

            String fileUrl=FILE_BASE+"/"+projId+"/"+belongTo+"/"+filename;

            String uploadDate= DateTimeUtil.getNow_YYYY_MM_DD();
            ElecFileupload elecFileupload=new ElecFileupload();

            elecFileupload.setProjid(projId);
            elecFileupload.setBelongto(belongTo);
            elecFileupload.setFilename(filename);
            elecFileupload.setFileurl(fileUrl);
            elecFileupload.setProgresstime(uploadDate);
            elecFileupload.setIsdelete("0");
            elecFileupload.setCreateempid("admin");
            elecFileupload.setCreatedate(new Date());
            elecFileupload.setComment(comment);

            try {
                dataChartDao.insertFileUpload(elecFileupload);

                SolrInputDocument solrInputDocument=new SolrInputDocument();
                solrInputDocument.addField("id", elecFileupload.getSeqid());
                solrInputDocument.addField("ProjID", projId);
                solrInputDocument.addField("BelongTo",belongTo );
                solrInputDocument.addField("FileName",filename );
                solrInputDocument.addField("FileURL", fileUrl);
                solrInputDocument.addField("ProgressTime",uploadDate );
                solrInputDocument.addField("IsDelete","0" );
                solrInputDocument.addField("CreateEmpID", "admin");
                solrInputDocument.addField("CreateDate", uploadDate);
                solrInputDocument.addField("comment",comment );

                solrServer.add(solrInputDocument);
                solrServer.commit();

            } catch (Exception e) {
                e.printStackTrace();
                resltInfo+=file.getOriginalFilename()+"传输失败!!<br/>";
            }

        }


        if (resltInfo==null || resltInfo.length()==0) {
            resltInfo="上传成功!";

        }
        return resltInfo;


    }

    @Override
    public List<ElecFileupload> queryAddData(String projId, String belongTo) {

        return dataChartDao.queryAddData(projId,belongTo);
    }

    @Override
    public List<ElecFileupload> queryData(String projId, String belongTo, String queryString) {
        SolrQuery solrQuery=new SolrQuery();

        if (StringUtils.isEmpty(queryString)) {
            solrQuery.setQuery("*:*");
        }else {
            solrQuery.setQuery("datachartsearch:\""+queryString+"\"");
        }

        if (!StringUtils.isEmpty(projId)) {
            solrQuery.addFilterQuery("ProjID:\""+projId+"\"");
        }
        if (!StringUtils.isEmpty(belongTo)) {
            solrQuery.addFilterQuery("BelongTo:\""+belongTo+"\"");
        }

        List<ElecFileupload> elecFileuploads=new ArrayList<>();
        try {
            QueryResponse queryResponse = solrServer.query(solrQuery);

            SolrDocumentList results = queryResponse.getResults();
            for (SolrDocument document : results) {
                ElecFileupload elecFileupload=new ElecFileupload();
                elecFileupload.setProjid(document.getFieldValue("ProjID").toString());
                elecFileupload.setBelongto(document.getFieldValue("BelongTo").toString());
                elecFileupload.setFilename(document.getFieldValue("FileName").toString());
                elecFileupload.setFileurl(document.getFieldValue("FileURL").toString());
                elecFileupload.setComment(document.getFieldValue("comment").toString());
                elecFileuploads.add(elecFileupload);

            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return elecFileuploads;
    }

    private String genDirs(String projId, String belongTo){
        String dir1=UPLOAD_DIR_ROOT+"/"+projId;
        String dir2=dir1+"/"+belongTo+"/";

        File dir=new File(dir2);
        if(!dir.exists()){
            dir.mkdirs();

        }

        return dir2;
    }


}
