<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>职位推荐</title>
    <link rel="stylesheet" href="../layui-v2.2.5/layui/css/layui.css">
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
                <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/recommended_posts">职位推荐</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <ul class="layui-nav" >
            <li class="layui-nav-item" style="font-size: 18px"><a href="#"> 适合你的职位</a></li>
        </ul>
        <div class="layui-collapse" lay-filter="test">
            <div class="layui-colla-item">
                <h2 class="layui-colla-title" style="font-size: 16px"><a href="#"><b> 公司名称</b></a> &nbsp;&nbsp;&nbsp;&nbsp;工作名称
                    &nbsp;&nbsp;&nbsp;&nbsp;<b style="color: #dd4410">年薪</b>&nbsp;&nbsp;&nbsp;&nbsp;工作地点</h2>
                <div class="layui-colla-content">
                    <p><table style="font-size: 16px">
                    <tr>
                        <td>
                            <span>公司性质：</span>
                        </td>
                        <td>
                            <span></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>公司规模：</span>
                        </td>
                        <td>
                            <span></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>经验要求:</span>
                        </td>
                        <td>
                            <span><a href="" target="_blank" rel="nofollow"></a></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>工作职责：</span>
                        </td>
                        <td>
                            <span></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>公司地址：</span>
                        </td>
                        <td>
                            <span></span>
                        </td>
                    </tr>
                </table></p>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 969758570@qq.com
    </div>
</div>
<script src="../layui-v2.2.5/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>

