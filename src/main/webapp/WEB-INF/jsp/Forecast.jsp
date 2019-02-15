<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>求职意向</title>
    <link rel="stylesheet" href="../layui-v2.2.5/layui/css/layui.css">
    <script src="../layui-v2.2.5/layui/layui.js"></script>
    <script src="../js/jquery.min.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });

        $(function(){
            var nodes = document.getElementById('jn').getElementsByTagName('option');
            var name = document.getElementById('jobname').value;
            for(var i=0;i<nodes.length;i++){
                if(nodes[i].innerHTML==name)nodes[i].setAttribute("selected","");
            }
        })

    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <a href="${pageContext.request.contextPath}/index"><div class="layui-logo"> 智能职业分析系统</div></a>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">消息通知<span class="layui-badge">9</span></a></li>
            <li class="layui-nav-item"><a href="">管理</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/my_favorites">我的收藏</a></li>
            <li class="layui-nav-item"><a href="http://localhost:9099">实时分析系统</a></li>
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
                <li class="layui-nav-item layui-this">
                    <a href="${pageContext.request.contextPath}/job_intension">求职意向</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/job_search">职位搜索</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/index">统计分析</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/recommended_posts">职位推荐</a></li>
                <li class="layui-nav-item"><a href="http://127.0.0.1:8088/login">智能预测</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <h1 style="color:black">工资预测</h1>

        <div class="container w3layouts agileits" style="height: 400px">

            <div class="login w3layouts agileits" style="color: white">
                <h2>预测<i class="layui-icon" style="color: white;font-size: 25px;margin-left: 10px">&#xe6b2;</i></h2>
                <form  method="post" class="bs-example bs-example-form">
                    <div class="dropdown">
                        <input name="workyear" list="place" placeholder="工作经验（只能填写数字）" class="form-control" onkeyup="value=value.replace(/[^0-9]/g,'')" onpaste="value=value.replace(/[^0-9]/g,'')" oncontextmenu = "value=value.replace(/[^0-9]/g,'')">

                        <datalist id="place">

                            <option value="0" ></option>
                            <option value="1"></option>
                            <option value="2"></option>
                            <option value="3"></option>
                            <option value="4"></option>
                            <option value="5"></option>
                            <option value="6"></option>
                            <option value="7"></option>
                            <option value="8"></option>
                            <option value="9"></option>
                            <option value="10"></option>
                        </datalist>
                    </div>
                    <br>
                    <div class="dropdown">
                        <input name="education" list="place2" name="education" placeholder="学历" class="form-control" >
                        <datalist id="place2">

                            <option value="大专及其以下" ></option>
                            <option value="本科"></option>
                            <option value="硕士"></option>
                            <option value="博士"></option>
                        </datalist>
                    </div>
                    <br>
                    <input type="submit" value="开始预测" class="layui-btn" >

                </form>
                <ul class="tick w3layouts agileits">
                    <li>

                    </li>
                </ul>
                <div class="send-button w3layouts agileits">

                </div>

                <a href="#">分享</a>
                <div class="social-icons w3layouts agileits">
                    <p>- 其他方式</p>
                    <ul>
                        <li class="qq"><a href="#">
                            <span class="icons w3layouts agileits"></span>
                            <span class="text w3layouts agileits">QQ</span></a></li>
                        <li class="weixin w3ls"><a href="#">
                            <span class="icons w3layouts"></span>
                            <span class="text w3layouts agileits">微信</span></a></li>
                        <li class="weibo aits"><a href="#">
                            <span class="icons agileits"></span>
                            <span class="text w3layouts agileits">微博</span></a></li>
                        <div class="clear"> </div>
                    </ul>
                </div>
                <div class="clear"></div>
            </div><div class="copyrights">Colle

            <div class="clear"></div>

        </div>

            <div class="footer w3layouts agileits">
                <p>Machine Learning<a href="#" target="_blank" title="预测"></a> <a href="#" title="" target="_blank"></a></p>
                <p>Linear  regression</p>
                <br>
                <br>
                <p>次预测仅供参考</p>
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
