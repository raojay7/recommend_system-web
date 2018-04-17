<%@ page import="java.util.Date" %>
<%@ page import="com.recommend_system.job.entity.Job" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.recommend_system.userlike.entity.UserLikeKey" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.recommend_system.user.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Job djob = (Job)request.getAttribute("job");
    Date time = djob.getCtime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String ctime = sdf.format(time);
    User user = (User)session.getAttribute("user");
    int uid = user.getUserId();
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
    <a href="${pageContext.request.contextPath}/index"><div class="layui-logo"> 智能职业分析系统</div></a>
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
    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/job_search">职位搜索</a></li>
    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/index">统计分析</a></li>
    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/recommended_posts">职位推荐</a></li>
    </ul>
    </div>
    </div>

    <div class="layui-body">
    <!-- 内容主体区域 -->

    <div class="layui-row">
    <div class="layui-col-xs5">
    <div class="inner-left fl" style="margin-left: 20px">
    <h1 style="margin-top: 20px">${job.getJobName()}</h1>
    <h2><a onclick="recordOutboundLink(this, '', '');" href="#" target="_blank">${company.getCompanyName()}</a></h2>
    <div class="lightspot"></div>
    </div>
    <div class="inner-right fr">
    </div>
    </div>
    <div class="layui-col-xs5">
    <blockquote class="layui-elem-quote layui-quote-nm">
    <p style="font-size: 18px"><i class="layui-icon" style="font-size: 20px;">&#xe658;</i>&nbsp;<b>评分反馈:</b>
    &nbsp;&nbsp;<button class="layui-btn layui-btn-sm" id="setScore"><i class="layui-icon"></i></button>
    </p>
    <br>
    <div class="dropdown" style="">
    <input list="place" placeholder="用户评分(0.0~5.0)" class="form-control" id="grade" value="${score}" <%--onkeyup="value=value.replace(/[^0-9]/g,'')" onpaste="value=value.replace(/[^0-9]/g,'')" oncontextmenu = "value=value.replace(/[^0-9]/g,'')"--%>>
<script src="../js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#setScore").click(function () {
                window.location.href = "../recommend/feedback?jid=${job.getJobId()}&cid=${company.getCompanyId()}&score=" + $("#grade").val();
            })
        })
    </script>

    <datalist id="place">

        <option value="0.0" ></option>
        <option value="0.1" ></option>
        <option value="0.2" ></option>
        <option value="0.3" ></option>
        <option value="0.4" ></option>
        <option value="0.5" ></option>
        <option value="0.6" ></option>
        <option value="0.7" ></option>
        <option value="0.8" ></option>
        <option value="0.9" ></option>
        <option value="1.0" ></option>
        <option value="1.1" ></option>
        <option value="1.2" ></option>
        <option value="1.3" ></option>
        <option value="1.4" ></option>
        <option value="1.5" ></option>
        <option value="1.6" ></option>
        <option value="1.7" ></option>
        <option value="1.8" ></option>
        <option value="1.9" ></option>
        <option value="2.0" ></option>
        <option value="2.1" ></option>
        <option value="2.2" ></option>
        <option value="2.3" ></option>
        <option value="2.4" ></option>
        <option value="2.5" ></option>
        <option value="2.6" ></option>
        <option value="2.7" ></option>
        <option value="2.8" ></option>
        <option value="2.9" ></option>
        <option value="3.0" ></option>
        <option value="3.1" ></option>
        <option value="3.2" ></option>
        <option value="3.3" ></option>
        <option value="3.4" ></option>
        <option value="3.5" ></option>
        <option value="3.6" ></option>
        <option value="3.7" ></option>
        <option value="3.8" ></option>
        <option value="3.9" ></option>
        <option value="4.0" ></option>
        <option value="4.1" ></option>
        <option value="4.2" ></option>
        <option value="4.3" ></option>
        <option value="4.4" ></option>
        <option value="4.5" ></option>
        <option value="4.6" ></option>
        <option value="4.7" ></option>
        <option value="4.8" ></option>
        <option value="4.9" ></option>
        <option value="5.0" ></option>
    </datalist>
    </div>







    </blockquote></div>
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

    <script>
    layui.use('table', function () {
    var table = layui.table;
    //方法级渲染
    table.render({
    elem: '#LAY_table_job'
    , url: '../recommend/work'
    , cellMinWidth: 80
    , cols: [[
    /*{field: 'jobId', width: 90, sort: true, title: '职位id', fixed: 'left',align:'center'}
    ,*/ {field: 'jobName', width: 185, title: '工作名字(点击查看详情)', event: 'getJobDetail'}
    , /*{field: 'companyId', width: 90, title: '公司id',event: 'getCompanyDetail',align:'center'}
    ,*/ {field: 'companyName', width: 185, title: '公司名字'}
    , {field: 'workplace', width: 185, title: '工作地点'}
    , {field: 'salaryMin', width: 100, sort: true, title: '最低薪水',align:'center'}
    , {field: 'salaryMax', width: 100, sort: true, title: '最高薪水',align:'center'}
    , {field: 'education', title: '学历要求', width: 100,align:'center'}
    , {field: 'workexperienceMin', title: '最低工作年限', width: 120,align:'center'}
    , {field: 'workexperienceMax', title: '最高工作年限', width: 120,align:'center'}
    , {field: 'ctime', title: '创建时间', sort: true, width: 100}
    , {field: 'jobNature', title: '工作性质', width: 100,align:'center'}
    , {field: 'welfare', width: 185, title: '福利'}
    , {field: 'workcity', title: '工作城市', width: 100,align:'center'}
    , {field: 'needNum', width: 100, sort: true, title: '需要人数', fixed: 'right',align:'center'}
    ]]
    , id: 'testReload'
    });

    var $ = layui.$, active = {
    reload: function () {
    var demoReload = $('#demoReload');
    //执行重载
    table.reload('testReload', {
    });
    }
    };

    $('.layui-btn').on('click', function () {
    var demoReload = $('#demoReload');
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
    });
    });
    </script>
    <script>
    layui.use('table', function () {
    var table = layui.table;
    //监听单元格事件
    table.on('tool(demoEvent)', function (obj) {
    var data = obj.data;
    if (obj.event === 'getJobDetail') {
    window.location.href = "../detail/job?jobId=" + data.jobId + "&companyId=" + data.companyId + "&userId=<%=uid%>" +"&page=${page}";
    }
    });
    });
    </script>

    <div class="layui-tab">
    <ul class="layui-tab-title">
    <li class="layui-this">职位详情</li>
    <li>公司详情</li>
    <li>猜你喜欢</li>
    </ul>
    <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
    <p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif; text-indent: 24.1pt;"><strong><span style="font-family: 仿宋; color: rgb(25, 0, 0); font-size: 12pt;">${job.getSpecification()}</strong><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;岗位福利：<span style="font-family: 仿宋; color: rgb(255, 0, 0); font-size: 12pt;">${job.getWelfare()}</span></span></strong></p>
    </div>
    <div class="layui-tab-item">
    <p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif; text-indent: 24.1pt;"><strong><span style="font-family: 仿宋; color: rgb(25, 0, 0); font-size: 12pt;">
    公司名称：${company.getCompanyName()}<br/><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;公司主页：<a href="${company.getCompanyHomepage()}">${company.getCompanyHomepage()}</a><br/><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;公司性质：${company.getCompanyNature()}<br/><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;公司行业：${company.getCompanyIndustry()}<br/><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;公司规模：${company.getCompanyScale()}<br/><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;公司地址：${company.getAddress()}
    </span>
    </strong>
    </p>

    </div>
    <div class="layui-tab-item">
    <table class="layui-hide" id="LAY_table_job" lay-filter="demoEvent"></table>
    </div>
    </div>
    </div>
    <button class="layui-btn" onclick="javascript:window.location.href='../${page}'" data-type="reload">返回</button>
        <% if(request.getAttribute("flag").equals("0")){%>
    <button class="layui-btn" onclick="javascript:window.location.href='../action/collect?uid=${user.getUserId()}&jid=${job.getJobId()}'" data-type="reload"><i class="layui-icon">&#xe658;收藏</i></button>
        <%}else{%>
    <button class="layui-btn"  data-type="reload"><i class="layui-icon">已收藏</i></button>
        <%}%>
    <div class="layui-footer">
    <!-- 底部固定区域 -->
    © 969758570@qq.com
    </div>
    </div>
    </body>
    </html>
