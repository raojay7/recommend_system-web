<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>图表分析</title>
    <link rel="stylesheet" href="../layui-v2.2.5/layui/css/layui.css">
    <script src="../layui-v2.2.5/layui/layui.js"></script>
    <script type="text/javascript" src="../js/echarts.js"></script>
    <script type="text/javascript" src="../js/china.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    </script>
</head>
<body class="layui-layout-body"
      onload="initChart1('<%=path%>/job/cityavgsalary',echarts.init(document.getElementById('my_chart1')));
              initChart2('<%=path%>/company/companycity',echarts.init(document.getElementById('my_chart2')));
              initChart3('<%=path%>/company/companyindustry',echarts.init(document.getElementById('my_chart3')));
              initChart4('<%=path%>/company/companynature',echarts.init(document.getElementById('my_chart4')));
              initChart5('<%=path%>/company/companyscale',echarts.init(document.getElementById('my_chart5')));
              initChart6('<%=path%>/company/companyntneedavg',echarts.init(document.getElementById('my_chart6')));
              initChart7('<%=path%>/job/education',echarts.init(document.getElementById('my_chart7')));
              initChart8('<%=path%>/company/industryneedavg',echarts.init(document.getElementById('my_chart8')));
              initChart9('<%=path%>/job/jobcity',echarts.init(document.getElementById('my_chart9')));
              initChart10('<%=path%>/job/workex',echarts.init(document.getElementById('my_chart10')));">
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
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/job_search">职位搜索</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/index">统计分析</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/recommended_posts">职位推荐</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend>图表分析</legend>
        </fieldset>
        <div class="layui-collapse" lay-filter="test">
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">城市平均工资分析</h2>
                <script src="../js/city_avg_salary.js"></script>
                <div  class="layui-colla-content">

                    <div id="my_chart1"  style="width:1250px;height:500px;"></div>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">企业地域分布分析</h2>
                <div class="layui-colla-content">
                        <script src="../js/company_city.js"></script>
                    <div id="my_chart2" style="width:1000px;height:500px;"></div>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">公司行业分布分析</h2>
                <div class="layui-colla-content">
                    <script src="../js/company_industry.js"></script>
                    <div id="my_chart3" style="width:1250px;height:500px;"></div>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">公司性质分布分析</h2>
                <div class="layui-colla-content">
                    <script src="../js/company_nature.js"></script>
                    <div id="my_chart4" style="width:1200px;height:500px;"></div>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">公司规模分布分析</h2>
                <div class="layui-colla-content">
                    <script src="../js/company_scale.js"></script>
                    <div id="my_chart5" style="width:1205px;height:700px;"></div>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">不同性质公司的平均工资及岗位需求量</h2>
                <div class="layui-colla-content">
                    <script src="../js/companynt_need_avg.js"></script>
                    <div id="my_chart6" style="width:1200px;height:500px;"></div>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">学历工资分布分析</h2>
                <div class="layui-colla-content">
                    <script src="../js/education.js"></script>
                    <div id="my_chart7" style="width:1000px;height:500px;"></div>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">不同行业公司平均工资及岗位需求量</h2>
                <div class="layui-colla-content">
                    <script src="../js/industry_need_avg.js"></script>
                    <div id="my_chart8" style="width:1250px;height:500px;"></div>

                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">工作地域分布分析</h2>
                <div class="layui-colla-content">
                    <script src="../js/job_city.js"></script>
                    <div id="my_chart9" style="width:1400px;height:500px;"></div>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">工作经验分布分析</h2>
                <div class="layui-colla-content">
                    <script src="../js/workex.js"></script>
                    <div id="my_chart10" style="width:1000px;height:400px;"></div>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">招聘企业画像</h2>
                <div class="layui-colla-content">
                    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
                    <div id="main1" style="width:1000px;height: 500px;"></div>
                    <script src="../js/Business_Portraits.js"></script>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">大数据职位技能需求图谱</h2>
                <div class="layui-colla-content">
                    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
                    <div id="main2" style="width:1000px;height: 500px;"></div>
                    <script src="../js/skills_require.js"></script>
                </div>
            </div>
        </div>
    </div>


    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 969758570@qq.com
    </div>
</div>

</body>
</html>
