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
        <a href="${pageContext.request.contextPath}/index"><div class="layui-logo"> 智能职业推荐系统</div></a>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">消息通知<span class="layui-badge">9</span></a></li>
            <li class="layui-nav-item"><a href="">管理</a></li>
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
                <li class="layui-nav-item layui-this">
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
        <input type="hidden" id="jobname" value="${uji.getJobName()}"/>
        <form class="layui-form" action="/User/setIntension" method="post" style="margin-left: 20px;margin-top: 40px">
            <input type="hidden" name="intensionId" value="${uji.getIntensionId()}"/>
            <input type="hidden" name="userId" value="${uji.getUserId()}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">职位行业</label>
                <div class="layui-input-block">
                    <select id="jn" name="jobName" lay-filter="aihao">
                        <option value="" ></option>
                        <option value="大数据工程师">大数据工程师</option>
                        <option value="算法工程师">算法工程师</option>
                        <option value="移动开发">移动开发</option>
                        <option value="数据库开发">数据库开发</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">职位性质</label>
                <div class="layui-input-block">
                    <c:if test="${uji.getJobNature() == null}">
                    <select name="jobNature" lay-filter="aihao">
                        <option value="" selected=""></option>
                        <option value="0">兼职</option>
                        <option value="1">实习</option>
                        <option value="2">全职</option>
                    </select>
                    </c:if>
                    <c:if test="${uji.getJobNature() == 0}">
                        <select name="jobNature" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0" selected="">兼职</option>
                            <option value="1">实习</option>
                            <option value="2">全职</option>
                        </select>
                    </c:if>
                    <c:if test="${uji.getJobNature() == 1}">
                        <select name="jobNature" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0">兼职</option>
                            <option value="1" selected="">实习</option>
                            <option value="2">全职</option>
                        </select>
                    </c:if>
                    <c:if test="${uji.getJobNature() == 2}">
                        <select name="jobNature" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0">兼职</option>
                            <option value="1">实习</option>
                            <option value="2" selected="">全职</option>
                        </select>
                    </c:if>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">期望工作地</label>
                <div class="layui-input-inline">
                    <input type="text" name="workplace" value="${uji.getWorkplace()}" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">期望月薪</label>
                <div class="layui-input-block">
                    <c:if test="${uji.getSalaryMin() == null}">
                    <select name="salaryMin" lay-filter="aihao">
                        <option value="" selected=""></option>
                        <option value="0">3000以下</option>
                        <option value="3000">3000-6000</option>
                        <option value="6000">6000-10000</option>
                        <option value="10000">10000-20000</option>
                        <option value="20000">20000以上</option>
                    </select>
                    </c:if>
                    <c:if test="${uji.getSalaryMin() == 0}">
                        <select name="salaryMin" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0" selected="">3000以下</option>
                            <option value="3000">3000-6000</option>
                            <option value="6000">6000-10000</option>
                            <option value="10000">10000-20000</option>
                            <option value="20000">20000以上</option>
                        </select>
                    </c:if>
                    <c:if test="${uji.getSalaryMin() == 3000}">
                        <select name="salaryMin" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0">3000以下</option>
                            <option value="3000" selected="">3000-6000</option>
                            <option value="6000">6000-10000</option>
                            <option value="10000">10000-20000</option>
                            <option value="20000">20000以上</option>
                        </select>
                    </c:if>
                    <c:if test="${uji.getSalaryMin() == 6000}">
                        <select name="salaryMin" lay-filter="aihao">
                            <option value="" selected=""></option>
                            <option value="0">3000以下</option>
                            <option value="3000">3000-6000</option>
                            <option value="6000" selected="">6000-10000</option>
                            <option value="10000">10000-20000</option>
                            <option value="20000">20000以上</option>
                        </select>
                    </c:if>
                    <c:if test="${uji.getSalaryMin() == 10000}">
                        <select name="salaryMin" lay-filter="aihao">
                            <option value="" selected=""></option>
                            <option value="0">3000以下</option>
                            <option value="3000">3000-6000</option>
                            <option value="6000">6000-10000</option>
                            <option value="10000" selected="">10000-20000</option>
                            <option value="20000">20000以上</option>
                        </select>
                    </c:if>
                    <c:if test="${uji.getSalaryMin() == 20000}">
                        <select name="salaryMin" lay-filter="aihao">
                            <option value="" selected=""></option>
                            <option value="0">3000以下</option>
                            <option value="3000">3000-6000</option>
                            <option value="6000">6000-10000</option>
                            <option value="10000">10000-20000</option>
                            <option value="20000" selected="">20000以上</option>
                        </select>
                    </c:if>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
        <script>
            //Demo
            layui.use('form', function(){
                var form = layui.form;

                //监听提交
                form.on('submit(formDemo)', function(data){
                    layer.msg(JSON.stringify(data.field));
                    return false;
                });
            });
        </script>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 969758570@qq.com
    </div>
</div>

</body>
</html>
