package com.whx.elec8.domain;

import java.util.Date;

public class ElecUser {
    private String userid;

    private String jctid;

    private String username;

    private String logonname;

    private String logonpwd;

    private String sexid;

    private Date birthday;

    private String address;

    private String contacttel;

    private String email;

    private String mobile;

    private String isduty;

    private String postid;

    private Date ondutydate;

    private Date offdutydate;

    private String remark;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    private boolean isChecked;

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getJctid() {
        return jctid;
    }

    public void setJctid(String jctid) {
        this.jctid = jctid == null ? null : jctid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLogonname() {
        return logonname;
    }

    public void setLogonname(String logonname) {
        this.logonname = logonname == null ? null : logonname.trim();
    }

    public String getLogonpwd() {
        return logonpwd;
    }

    public void setLogonpwd(String logonpwd) {
        this.logonpwd = logonpwd == null ? null : logonpwd.trim();
    }

    public String getSexid() {
        return sexid;
    }

    public void setSexid(String sexid) {
        this.sexid = sexid == null ? null : sexid.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContacttel() {
        return contacttel;
    }

    public void setContacttel(String contacttel) {
        this.contacttel = contacttel == null ? null : contacttel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIsduty() {
        return isduty;
    }

    public void setIsduty(String isduty) {
        this.isduty = isduty == null ? null : isduty.trim();
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid == null ? null : postid.trim();
    }

    public Date getOndutydate() {
        return ondutydate;
    }

    public void setOndutydate(Date ondutydate) {
        this.ondutydate = ondutydate;
    }

    public Date getOffdutydate() {
        return offdutydate;
    }

    public void setOffdutydate(Date offdutydate) {
        this.offdutydate = offdutydate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

    public String getCreateempid() {
        return createempid;
    }

    public void setCreateempid(String createempid) {
        this.createempid = createempid == null ? null : createempid.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getLastempid() {
        return lastempid;
    }

    public void setLastempid(String lastempid) {
        this.lastempid = lastempid == null ? null : lastempid.trim();
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    @Override
    public boolean equals(Object obj) {
        ElecUser elecUser= (ElecUser) obj;
        return this.getUserid().equals(elecUser.getUserid());
    }
}