<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <li class="layui-nav-item"><a href="">用户</a></li>
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
                    管理员
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
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/company_detail">公司分析</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/recommended_posts">职位推荐</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="">
            <div class="">
                <div class="inner-left fl" style="margin-left: 20px">
                    <h1>云计算大数据工程师（定岗）</h1>
                    <h2><a onclick="recordOutboundLink(this, '', '');" href="#" target="_blank">北京蓝色曙光信息技术有限公司</a></h2>
                    <div class="lightspot"></div>
                </div>
                <div class="inner-right fr">
                </div>
            </div>
        </div>
        <div class="layui-elem-quote layui-quote-nm">
            <div class="terminalpage-left">
                <ul class="terminal-ul clearfix">
                    <li><span>职位月薪：</span><strong>8001-10000元/月&nbsp;</strong></li>
                    <li><span>工作地点：</span></li>
                    <li><span>发布日期：</span><strong><span id="span4freshdate">2018-02-22 10:19:21</span></strong></li>
                    <li><span>工作性质：</span><strong>全职</strong></li>
                    <li><span>工作经验：</span><strong>不限</strong></li>
                    <li><span>最低学历：</span><strong>大专</strong></li>
                    <li><span>招聘人数：</span><strong>20人</strong></li>
                    <li><span>职位类别：</span><strong>软件工程师</strong></li>
                </ul>
                <div class="layui-bg-gray">
                    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                    <ul class="layui-tab-title">
                        <li class="layui-this">职位描述</li>
                        <li>公司介绍</li>
                    </ul>
                    </div>
                    <div class="layui-bg-gray">
                            <!-- SWSStringCutStart -->
                            <p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif; text-indent: 24.1pt;"><strong><span style="font-family: 仿宋; color: rgb(255, 0, 0); font-size: 12pt;">一、Openstack云计算运维定岗委培实习工程师</span></strong><strong><span style="font-family: 仿宋; color: rgb(255, 0, 0); font-size: 12pt;"><o:p></o:p></span></strong></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><strong><span style="font-family: 微软雅黑; font-size: 10.5pt;">职位描述：</span></strong><span style="font-family: 微软雅黑; font-size: 9pt;">伴随着“互联网+”行动计划，当今IT及ICT产业的趋势就是“云端”。他们拥有互联网及移动互联网门户，也与之对应的建立了自己的数据中心；</span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><strong><span style="font-family: 微软雅黑; font-size: 10.5pt;">任职要求：</span></strong></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><span style="font-family: 微软雅黑; font-size: 9pt;">1、</span><span style="font-family: 微软雅黑; font-size: 9pt;">大专以上学历，</span><span style="font-family: 微软雅黑; font-size: 9pt;">理工科专业，所含专业包括计算机、电子信息、软件工程、自动化、测控、机电等。</span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><span style="font-family: 微软雅黑; font-size: 9pt;">2、</span><span style="font-family: 微软雅黑; font-size: 9pt;">在京工作一年后要求回当地工作的，可申请调回当地省会城市的分公司或合作企业工作。</span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><span style="font-family: 微软雅黑; font-size: 9pt;">3、</span><span style="font-family: 微软雅黑; font-size: 9pt;">入职前同意参加四个月的企业岗前项目实训。</span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><strong><span style="font-family: 微软雅黑; font-size: 10.5pt;">待遇：</span></strong><span style="font-family: 微软雅黑; font-size: 9pt;">银行、金融机构、电信、上市科技公司等，从事云计算运维工作</span><span style="font-family: 微软雅黑; font-size: 9pt;">；</span><span style="font-family: 微软雅黑; font-size: 9pt;">享受高端人才补助计划；签定正式劳动合同，享受国家规定的保险福利待遇。第一年工资专科：8000—10000元/月、本科以上：9000—12000元/月</span><span style="font-family: 微软雅黑; font-size: 9pt;">；</span><span style="font-family: 微软雅黑; font-size: 9pt;">第二年工资专科：12000—16000元/月、本科以上：16000—19000元/月</span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif; text-indent: 24.1pt;"><strong><span style="font-family: 仿宋; color: rgb(255, 0, 0); font-size: 12pt;">二、大数据定岗委培实习工程师</span></strong><strong><span style="font-family: 仿宋; color: rgb(255, 0, 0); font-size: 12pt;"><o:p></o:p></span></strong></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><strong><span style="font-family: 微软雅黑; font-size: 10.5pt;">职位描述：</span></strong><span style="font-family: 微软雅黑; font-size: 9pt;">在互联网时代，javaEE技术体系毫无疑问的成为了服务器端编程领域的王者，可以从事金融、互联网、电商、医疗等行业的核心软件系统开发。构建基于Hadoop、spark、Storm等大数据核心技术的商业支撑系统。</span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><strong><span style="font-family: 微软雅黑; font-size: 10.5pt;">任职要求：</span></strong></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><span style="font-family: 微软雅黑; font-size: 9pt;">1、</span><span style="font-family: 微软雅黑; font-size: 9pt;">国家统招本科以上学历，<span style="font-family: 微软雅黑; font-size: 12px; line-height: 18px;">理工科</span><span style="font-family: 微软雅黑; font-size: 12px; line-height: 18px;">优先。</span></span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><span style="font-family: 微软雅黑; font-size: 9pt;">2、</span><span style="font-family: 微软雅黑; font-size: 9pt;">普通专科，二年以上工作经验,参加远程测试，成绩合格者。</span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><strong><span style="font-family: 微软雅黑; font-size: 10.5pt;">晋级空间：</span></strong><span style="font-family: 微软雅黑; font-size: 9pt;">初级大数据开发工程师→中级开发工程师→高级技术专家→高层管理/CTO</span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><strong><span style="font-family: 微软雅黑; font-size: 10.5pt;">待遇：</span></strong><span style="font-family: 微软雅黑; font-size: 9pt;">在入职之前需参加</span><span style="font-family: 微软雅黑; font-size: 9pt;">以</span><span style="font-family: 微软雅黑; font-size: 9pt;">大数据核心技术</span><span style="font-family: 微软雅黑; font-size: 9pt;">的</span><span style="font-family: 微软雅黑; font-size: 9pt;">岗前强化训练，起薪不低于</span><span style="font-family: 微软雅黑; font-size: 9pt;">9</span><span style="font-family: 微软雅黑; font-size: 9pt;">000元/月；</span><span style="font-family: 微软雅黑; font-size: 9pt;">工作两年后月薪在</span><span style="font-family: 微软雅黑; font-size: 9pt;">2万以上。</span></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><strong><span style="font-family: 仿宋; color: rgb(255, 0, 0); font-size: 12pt;">工作地址：中国农机研究院</span></strong></p><p class="MsoNormal" style="margin: 5px 0px; line-height: 1.5; font-size: 14px; font-family: sans-serif;"><strong><span style="font-family: 仿宋; color: rgb(255, 0, 0); font-size: 12pt;">电话（微信）17326908690；QQ:1061965274</span></strong></p>
                            <!-- SWSStringCutEnd -->
                            <b>工作地址：</b>
                            <h2>
                                北京市昌平沙河高教园（中国农机研究院）
                            </h2>
                    </div>
                </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 969758570@qq.com
    </div>
</div>
</body>
</html>

