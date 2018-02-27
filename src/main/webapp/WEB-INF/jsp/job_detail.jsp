<%@ page import="java.util.Date" %>
<%@ page import="com.recommend_system.job.entity.Job" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Job djob = (Job)request.getAttribute("job");
    Date time = djob.getCtime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String ctime = sdf.format(time);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>职位介绍</title>
    <link rel="stylesheet" href="../layui-v2.2.5/layui/css/layui.css">
    <script src="../layui-v2.2.5/layui/layui.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <a href="${pageContext.request.contextPath}/index"><div class="layui-logo"> 智能职业推荐系统</div></a>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">消息通知<span class="layui-badge">9</span></a></li>
            <li class="layui-nav-item"><a href="search.html">搜索<i class="layui-icon">&#xe615;</i></a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/my_favorites">我的收藏</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${user.getUserName()}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/User/logOut">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="${pageContext.request.contextPath}/user_info">个人信息</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/job_intension">求职意向</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/search">职位搜索</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/index">统计分析</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/recommended_posts">职位推荐</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="">
            <div class="">
                <div class="inner-left fl" style="margin-left: 20px">
                    <h1>${job.getJobName()}</h1>
                    <h2><a onclick="recordOutboundLink(this, '', '');" href="#" target="_blank">${company.getCompanyName()}</a></h2>
                    <div class="lightspot"></div>
                </div>
                <div class="inner-right fr">
                </div>
            </div>
        </div>
        <div class="layui-elem-quote layui-quote-nm">
            <div class="terminalpage-left">
                <ul class="terminal-ul clearfix">
                    <li><span>职位月薪：</span><strong>${job.getSalaryMin()}-${job.getSalaryMax()}元/月&nbsp;</strong></li>
                    <li><span>工作地点：</span><strong>${job.getWorkplace()}</strong></li>
                    <li><span>工作城市：</span><strong>${job.getWorkcity()}</strong></li>
                    <li><span>发布日期：</span><strong><span id="span4freshdate"><%=ctime%></span></strong></li>
                    <li><span>工作性质：</span><strong><c:if test="${job.getJobNature() == 0}">兼职</c:if><c:if test="${job.getJobNature() == 1}">实习</c:if><c:if test="${job.getJobNature() == 2}">全职</c:if></strong></li>
                    <li><span>工作经验：</span><strong>${job.getWorkexperienceMin()}-${job.getWorkexperienceMax()}年</strong></li>
                    <li><span>最低学历：</span><strong><c:if test="${job.getEducation() == 0}">大专及以下</c:if><c:if test="${job.getEducation() == 1}">本科</c:if><c:if test="${job.getEducation() == 2}">硕士</c:if><c:if test="${job.getEducation() == 3}">博士</c:if><c:if test="${job.getEducation() == 4}">不限</c:if></strong></li>
                    <li><span>招聘人数：</span><strong>${job.getNeedNum()}人</strong></li>
                </ul>
                <div class="layui-tab">
                    <ul class="layui-tab-title">
                        <li class="layui-this">职位详情</li>
                        <li>公司详情</li>
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif; text-indent: 24.1pt;"><strong><span style="font-family: 仿宋; color: rgb(25, 0, 0); font-size: 12pt;">${job.getSpecification()}</strong><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;岗位福利：<span style="font-family: 仿宋; color: rgb(255, 0, 0); font-size: 12pt;">${job.getWelfare()}</span></span></strong></p>
                        </div>
                        <div class="layui-tab-item">
                            <p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif; text-indent: 24.1pt;"><strong><span style="font-family: 仿宋; color: rgb(25, 0, 0); font-size: 12pt;">
                            公司名称：${company.getCompanyName()}<br/><br/>
                            &nbsp;&nbsp;&nbsp;&nbsp;公司主页：${company.getCompanyHomepage()}<br/><br/>
                            &nbsp;&nbsp;&nbsp;&nbsp;公司性质：${company.getCompanyNature()}<br/><br/>
                            &nbsp;&nbsp;&nbsp;&nbsp;公司行业：${company.getCompanyIndustry()}<br/><br/>
                            &nbsp;&nbsp;&nbsp;&nbsp;公司规模：${company.getCompanyScale()}<br/><br/>
                            &nbsp;&nbsp;&nbsp;&nbsp;公司地址：${company.getAddress()}
                            </span>
                            </strong>
                            </p>

                        </div>
                    </div>
                </div>
                <button class="layui-btn" onclick="javascript:history.go(-1)" data-type="reload">返回</button>


                <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 969758570@qq.com
    </div>
</div>
</body>
</html>

