package com.recommend_system.uservisit.entity;

import java.io.Serializable;
import java.util.Date;

public class VisitJob implements Serializable {
    private Integer visistedJobId;

    private String webId;

    private Date serverTime;

    private Date clientTime;

    private Integer userType;

    private String cookieId;

    private Date cookieCtime;

    private String ip;

    private Integer userId;

    private Integer tJobId;

    private String useragent;

    private static final long serialVersionUID = 1L;

    public Integer getVisistedJobId() {
        return visistedJobId;
    }

    public void setVisistedJobId(Integer visistedJobId) {
        this.visistedJobId = visistedJobId;
    }

    public String getWebId() {
        return webId;
    }

    public void setWebId(String webId) {
        this.webId = webId == null ? null : webId.trim();
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public Date getClientTime() {
        return clientTime;
    }

    public void setClientTime(Date clientTime) {
        this.clientTime = clientTime;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getCookieId() {
        return cookieId;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId == null ? null : cookieId.trim();
    }

    public Date getCookieCtime() {
        return cookieCtime;
    }

    public void setCookieCtime(Date cookieCtime) {
        this.cookieCtime = cookieCtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer gettJobId() {
        return tJobId;
    }

    public void settJobId(Integer tJobId) {
        this.tJobId = tJobId;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent == null ? null : useragent.trim();
    }
}