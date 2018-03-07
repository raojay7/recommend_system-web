<%@ page import="com.recommend_system.user.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();
User user = (User)session.getAttribute("user");
int uid = user.getUserId();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>智能职业分析系统</title>
    <link rel="stylesheet" href="../layui-v2.2.5/layui/css/layui.css">
    <script type="text/javascript" src="../layui-v2.2.5/layui/layui.js" charset="utf-8"/>
    <script type="text/javascript">
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;

        });
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <a href="${pageContext.request.contextPath}/index">
            <div class="layui-logo"> 智能职业推荐系统</div>
        </a>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">消息通知<span class="layui-badge">9</span></a></li>
            <li class="layui-nav-item"><a href="">管理</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/my_favorites">我的收藏</a></li>
            <li class="layui-nav-item">
                <a href="javascript:">其它</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${user.getUserName()}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/User/logOut">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
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
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        </fieldset>
        <div class="layui-container animated fadeInUp" id="search-body">
            <div id="search-operate">
                <div id="search-panel">
                    <div class="select-none layui-row layui-col-space20">


                    </div>
                </div>
            </div>
        </div>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>您可能感兴趣的职位</legend><br/>
            <div class="layui-inline layui-col-md3 layui-show-md-inline-block layui-hide-sm layui-hide-xs">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="layui-btn" data-type="reload">换一组</button>
            </div>
        </fieldset>
        <table class="layui-hide" id="LAY_table_job" lay-filter="demoEvent"></table>

        <script type="text/javascript" src="../layui-v2.2.5/layui/layui.js" charset="utf-8"/>
        <script type="text/javascript">


        </script>

    </div>

    <script>
        layui.use('table', function () {
            var table = layui.table;
            //方法级渲染
            table.render({
                elem: '#LAY_table_job'
                , url: '../moreIikeByItem'
                , cellMinWidth: 80
                , cols: [[
                    {field: 'jobId', width: 90, sort: true, title: '职位id', fixed: 'left',align:'center'}
                    , {field: 'jobName', width: 185, title: '工作名字(点击查看详情)', event: 'getJobDetail'}
                    , {field: 'companyId', width: 90, title: '公司id',event: 'getCompanyDetail',align:'center'}
                    , {field: 'companyName', width: 185, title: '公司名字'}
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
                        /*page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        , where: {
                            kw: demoReload.val()
                        }*/
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
                    //layer.msg('jobID：'+ data.jobId + ' 的查看操作');
                    //接下来进行ajax请求，根据jobid查询job
                    window.location.href = "../detail/job?jobId=" + data.jobId + "&companyId=" + data.companyId + "&userId=<%=uid%>" +"&page=recommended_posts";
                    /*$.post("/detail/job", { jobId: data.jobId, companyId: data.companyId},
                        function(redata){
                            alert("Data Loaded: " + redata);
                        });*/
                }

                /*if (obj.event === 'getCompanyDetail') {
                    layer.msg('companyID：'+ data.companyId + ' 的查看操作');
                    //接下来进行ajax的请求，根据companyid查询company
                    $.post("/getCompanyDetailUI", { companyId:data.companyId },
                        function(redata){
                            alert("Data Loaded: " + redata);
                        });
                }*/
            });
        });
    </script>
    <div class="layui-footer">
        <!-- 底部固定区域-->
        © 969758570@qq.com
    </div>
</div>
</body>
</html>

