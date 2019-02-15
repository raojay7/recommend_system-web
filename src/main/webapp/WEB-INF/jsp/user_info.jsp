<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>个人信息</title>
    <link rel="stylesheet" href="../layui-v2.2.5/layui/css/layui.css">
    <script src="../layui-v2.2.5/layui/layui.js"></script>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/jquery.validate.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
        $().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
            $("#infoForm").validate({
                rules: {
                    userName: {
                        required: true,
                        minlength: 3
                    },
                    password: {
                        required: true,
                        minlength: 6
                    },
                    age: {
                        required: true,
                        minlength: 1
                    },
                    presentAddress: {
                        required: true,
                        minlength: 2
                    },
                    professional: {
                        required: true,
                        minlength: 2
                    },
                    school: {
                        required: true,
                        minlength: 2
                    },
                },
                messages: {
                    userName: {
                        required: "请输入用户名",
                        minlength: "<font color='red'>用户名必需由6个字符组成</font>"
                    },
                    password: {
                        required: "请输入密码",
                        minlength: "<font color='red'>密码长度不能小于 6 个字母数字</font>"
                    },
                    age: {
                        required: "请输入年龄",
                        minlength: ""
                    },
                    presentAddress: {
                        required: "请输入现居地",
                        minlength: "<font color='red'>现居地长度不能小于 2 个字符</font>"
                    },
                    professional: {
                        required: "请输入专业",
                        minlength: "<font color='red'>专业长度不能小于 2 个字符</font>"
                    },
                    school: {
                        required: "请输入毕业院校",
                        minlength: "<font color='red'>毕业院校长度不能小于 2 个字符</font>"
                    },
                }
            })
        });


    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <a href="${pageContext.request.contextPath}/index"><div class="layui-logo">智能职业分析系统</div></a>
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
                <li class="layui-nav-item layui-nav-itemed layui-this">
                    <a href="${pageContext.request.contextPath}/user_info">个人信息</a>
                </li>
                <li class="layui-nav-item">
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

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>用户信息</legend>
        </fieldset>
        <form id="infoForm" class="layui-form layui-form-pane" action="/User/setUser" method="post" style="margin-left: 20px">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="text" id="un" name="userName" value="${user.getUserName()}" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">请务必填写用户名</div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="password" value="${user.getPassword()}" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <input type="hidden" name="userId" value="${user.getUserId()}"/>
            <div class="layui-form-item" pane="">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                    <c:if test="${user.getGender() == 1}">
                    <input type="radio" name="gender" value="1" title="男" checked="">
                    <input type="radio" name="gender" value="0" title="女">
                    </c:if>
                    <c:if test="${user.getGender() == 0}">
                    <input type="radio" name="gender" value="1" title="男">
                    <input type="radio" name="gender" value="0" title="女" checked="">
                    </c:if>
                    <c:if test="${user.getGender() == null}">
                        <input type="radio" name="gender" value="1" title="男">
                        <input type="radio" name="gender" value="0" title="女">
                    </c:if>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-inline">
                    <input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" name="age" value="${user.getAge()}" lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">教育程度</label>
                <div class="layui-input-block">
                    <c:if test="${user.getEducation() == 0}">
                        <select name="education" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0" selected="">大专及以下</option>
                            <option value="1">本科</option>
                            <option value="2">硕士</option>
                            <option value="3">博士</option>
                        </select>
                    </c:if>
                    <c:if test="${user.getEducation() == 1}">
                        <select name="education" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0">大专及以下</option>
                            <option value="1" selected="">本科</option>
                            <option value="2">硕士</option>
                            <option value="3">博士</option>
                        </select>
                    </c:if>
                    <c:if test="${user.getEducation() == 2}">
                        <select name="education" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0">大专及以下</option>
                            <option value="1">本科</option>
                            <option value="2" selected="">硕士</option>
                            <option value="3">博士</option>
                        </select>
                    </c:if>
                    <c:if test="${user.getEducation() == 3}">
                        <select name="education" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0" selected="">大专及以下</option>
                            <option value="1">本科</option>
                            <option value="2">硕士</option>
                            <option value="3" selected="">博士</option>
                        </select>
                    </c:if>
                    <c:if test="${user.getEducation() == null}">
                        <select name="education" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0">大专及以下</option>
                            <option value="1">本科</option>
                            <option value="2">硕士</option>
                            <option value="3" selected="">博士</option>
                        </select>
                    </c:if>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">专业</label>
                <div class="layui-input-inline">
                    <input type="text" name="professional" value="${user.getProfessional()}" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">现居地</label>
                <div class="layui-input-inline">
                    <input type="text" name="presentAddress" value="${user.getPresentAddress()}" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">毕业学校</label>
                <div class="layui-input-inline">
                    <input type="text" name="school" value="${user.getSchool()}" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="demo2">提交</button>
            </div>
        </form>
        <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
        <script>
            layui.use(['form', 'layedit', 'laydate'], function(){
                var form = layui.form
                    ,layer = layui.layer
                    ,layedit = layui.layedit
                    ,laydate = layui.laydate;

                //日期
                laydate.render({
                    elem: '#date'
                });
                laydate.render({
                    elem: '#date1'
                });

                //创建一个编辑器
                var editIndex = layedit.build('LAY_demo_editor');

                //自定义验证规则
                form.verify({
                    title: function(value){
                        if(value.length < 5){
                            return '标题至少得5个字符啊';
                        }
                    }
                    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
                    ,content: function(value){
                        layedit.sync(editIndex);
                    }
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
