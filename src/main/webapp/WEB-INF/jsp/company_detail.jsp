<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>公司介绍</title>
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
        <a href="index"><div class="layui-logo"> 智能职业推荐系统</div></a>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">消息通知<span class="layui-badge">9</span></a></li>
            <li class="layui-nav-item"><a href="search">搜索<i class="layui-icon">&#xe615;</i></a></li>
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
                    <a href="user_info">个人信息</a>
                </li>
                <li class="layui-nav-item">
                    <a href="job%20intension.html">求职意向</a>
                </li>
                <li class="layui-nav-item"><a href="search">职位搜索</a></li>
                <li class="layui-nav-item"><a href="company_detail">公司分析</a></li>
                <li class="layui-nav-item"><a href="recommended_posts">职位推荐</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <hr>
        <div class="layui-field-box">
            <h1>
                北京美亚伟业珠宝首饰有限公司
            </h1>
            <table class="comTinyDes">
                <tr>
                    <td>
                        <span>公司性质：</span>
                    </td>
                    <td>
                        <span>民营</span>
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
                        <span>公司网站：</span>
                    </td>
                    <td>
                        <span><a href="" target="_blank" rel="nofollow"></a></span>
                    </td>
                </tr>

                <tr>
                    <td>
                        <span>公司行业：</span>
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
                        <span class=""></span>
                    </td>
                </tr>
            </table>
        </div>

        <!--第二部分_公司详情-->
        <div class="part2">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>公司介绍</legend>
            </fieldset>
            <div class="layui-elem-quote">
                <p style="text-indent:43px"><span style="font-size:21px;font-family:楷体">北京美亚伟业珠宝首饰有限公司，是一家于2001年创立于北京，公司以提升珠宝首饰行业服务品质为己任，在珠宝文化的传承方面颇有建树的珠宝企业。</span></p><p style="text-indent:43px"><br/></p><p style="text-indent:43px"><span style="font-size:21px;font-family:楷体">为满足现代人个性化的审美需求，我们通过资源整合化的发展机制，不断拓展企业规模及产品种类，进而将自身的服务范围覆盖至黄金、铂金、18k金饰品、银礼品等珠宝首饰的销售，及相关配套服务领域。</span></p><p style="text-indent:43px"><br/></p><p style="text-indent:43px"><span style="font-size:21px;font-family:楷体">在与行业同步发展的过程中，我们紧握互联网时代契机， 在拥有天雅珠宝城、万特交易中心两家展厅的基础上，在天猫平台创立了美亚珠宝天猫旗舰店，将企业的发展引入到了互联网电商发展的新阶段。</span></p><p style="text-indent:43px"><br/></p><p><span style="font-size:21px;font-family:楷体">   </span><span style="font-size:21px;font-family:楷体">站在行业发展的视角思考，以珠宝文化传承者的姿态，用实际行动诠释自身追求无暇品质的初心，进而在广大消费者心中，树立了美亚珠宝品质典范的印记，在创造美好生活的路上，锐意前行！ </span></p><p><br/></p>
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

