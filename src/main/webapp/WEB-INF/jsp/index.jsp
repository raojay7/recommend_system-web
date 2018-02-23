<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>智能职业分析系统</title>
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
            <li class="layui-nav-item"><a href="">管理</a></li>
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
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/company_detail">公司分析</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/recommended_posts">职位推荐</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        </fieldset>
        <div class="layui-container animated fadeInUp" id="search-body">
            <div id="search-operate">
                <div id="search-panel">
                    <div class="select-none layui-row layui-col-space20">
                        <div class="layui-inline layui-col-md-offset2 layui-col-md6 layui-col-sm12 layui-col-xs12">
                            <input :value="sw" @keyup.enter="search()" autocomplete="off" class="layui-input search-box" name="sp" placeholder="搜索公司或职位" />
                            <b>热门关键词<i class="layui-icon" style="color: red">&#xe756;</i> </b> &nbsp;&nbsp;&nbsp;<a href="#">大数据</a>&nbsp;&nbsp;&nbsp; <a href="#">数据库</a>
                            &nbsp;&nbsp;&nbsp; <a href="#">Hadoop</a>&nbsp;&nbsp;&nbsp; <a href="#">Java</a>&nbsp;&nbsp;&nbsp; <a href="#">算法</a>
                            &nbsp;&nbsp;&nbsp; <a href="#">分布式</a>&nbsp;&nbsp;&nbsp; <a href="#">SQL</a>
                        </div>
                        <div class="layui-inline layui-col-md3 layui-show-md-inline-block layui-hide-sm layui-hide-xs">
                            <div class="layui-input-inline">
                                <button @click="search()" class="layui-btn">搜索</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>热门职位</legend>
        </fieldset>
        <table class="layui-hide" id="test"></table>
        <script src="../layui-v2.2.5/layui/layui.js" charset="utf-8"></script>
        <script>
            layui.use('table', function(){
                var table = layui.table;

                table.render({
                    elem: '#test'
                    ,url:'.json'
                    ,cols: [[
                        {field:'company_id', minwidth:150, title: '公司名称', sort: true}
                        ,{field:'workplace', width:100, title: '工作地点'}
                        ,{field:'workplace', minwidth:200, title: '工作地点'}
                        ,{field:'salary_min', width:100, title: '最低薪水'}
                        ,{field:'salary_max', width:100, title: '最高薪水'}
                        ,{field:'education', title: '学历要求', width: 100}
                        ,{field:'need_num', width:100, title: '需要人数'}
                        ,{field:'language', width:100, title: '语言要求'}
                        ,{field:'age_min', width:100, title: '最小年龄'}
                        ,{field:'age_max', width:100, title: '最大年龄'}
                        ,{field:'welfare', minwidth:80, title: '福利'}
                        ,{field:'tag', minwidth:80, title: '其他'}
                    ]]
                    ,page: true
                });
            });
        </script>


    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 969758570@qq.com
    </div>
</div>

</body>
</html>
