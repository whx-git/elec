package com.whx.elec8.utils.doPage;


import java.util.ArrayList;
import java.util.List;
/*
  描述某一页信息的工具类
 */
public class PageBean<T> {
    public static final String REQUEST_KEY="pageBean";
	//当前页码
	private int pageNo;
	//是否为首页
    private boolean firstPage;
    //是否为末页
    private boolean lastPage;
    //总页数
    private int sumPage;
    //单页容量
    private int pageSize ;
    //总数据数
    private int totalResult ;
    //某一页的数据
    private List<T> beans=new ArrayList<>();
    //分页所请求的URL---controller的url
    private String requestUrl;


    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public List<T> getBeans() {
        return beans;
    }

    public void setBeans(List<T> beans) {
        this.beans = beans;
    }

    public void setSumPage(int sumPage)
    {
    	this.sumPage=sumPage;
    }
    public int getSumPage()
    {
    	return sumPage;
    }
    public void setPageNo(int pageNo)
    {
    	this.pageNo=pageNo;
    
    	
    }
    public int getPageNo()
    {
    	return pageNo;
    }
    public void setFirstPage(boolean firstPage)
    {
    	this.firstPage=firstPage;
    	
    }
    public boolean getFirstPage()
    {
    	return firstPage;
    }
    public void setLastPage(boolean lastPage)
    {
    	this.lastPage=lastPage;
    }
    public boolean getLastPage()
    {
    	return lastPage;
    }
    /**
     * 获得每页的记录数
     * @return int
     */
    public int getPageSize() {
        return pageSize;
    }
    
    /**
     * 设置每页的记录数
     * @param i int 记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNo=" + pageNo +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", sumPage=" + sumPage +
                ", pageSize=" + pageSize +
                ", totalResult=" + totalResult +
                ", beans=" + beans.size() +
                '}';
    }
}
