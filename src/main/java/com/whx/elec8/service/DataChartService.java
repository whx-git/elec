package com.whx.elec8.service;

import com.whx.elec8.domain.ElecFileupload;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DataChartService {
    public String uploadFiles(MultipartFile[] uploads , String[] comments, String projId, String belongTo);

    public List<ElecFileupload> queryAddData(String projId,String belongTo);

    public List<ElecFileupload> queryData(String projId,String belongTo,String queryString);

}
