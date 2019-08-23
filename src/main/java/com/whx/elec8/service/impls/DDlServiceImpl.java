package com.whx.elec8.service.impls;

import com.whx.elec8.ConstantsKeys;
import com.whx.elec8.dao.DDlDao;
import com.whx.elec8.domain.ElecSystemddl;
import com.whx.elec8.service.DDlService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DDlServiceImpl implements DDlService {
    @Resource
    private DDlDao dDlDao;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public List<String> queryAllKeyword() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(ConstantsKeys.REDIES_KEY_DDL_KEYWORDS);
        List<String> keywords =null;
        if (o==null) {
            keywords = dDlDao.queryAllKeywords();
            if (keywords!=null) {
                valueOperations.set(ConstantsKeys.REDIES_KEY_DDL_KEYWORDS,keywords);
            }
        }else{
            keywords= (List<String>) o;
        }
        return keywords;
    }

    @Override
    public List<ElecSystemddl> queryDatasByKeyword(String keyword) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(ConstantsKeys.REDIES_KEY_DDL_KEYWORD_DATAS + keyword);
        List<ElecSystemddl> list=null;
        if (o==null) {
            list = dDlDao.queryDatasByKeyword(keyword);
            if (list!=null) {
                valueOperations.set(ConstantsKeys.REDIES_KEY_DDL_KEYWORD_DATAS+keyword,list);
            }
        }else{
            list= (List<ElecSystemddl>) o;
        }

        return list;
    }

    @Override
    @Transactional
    public void addKeyword(String keyword, String[] datas) {
        for (int i = 0; i <datas.length ; i++) {
            dDlDao.insertKeywordDatas(keyword,i+1,datas[i]);

        }
        redisTemplate.delete(ConstantsKeys.REDIES_KEY_DDL_KEYWORDS);
    }

    @Override
    @Transactional
//    @CacheEvict
    public void modifyKeyword(String keyword, String[] datas) {
        dDlDao.deleteKeywordDatas(keyword);
        for (int i = 0; i <datas.length ; i++) {
            dDlDao.insertKeywordDatas(keyword,i+1,datas[i]);

        }
        redisTemplate.delete(ConstantsKeys.REDIES_KEY_DDL_KEYWORD_DATAS+keyword);


    }


}
