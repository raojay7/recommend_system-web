
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();%>
<html>

<!-- Head -->
<head>

	<title>智能求职分析系统</title>

	<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Meta-Tags -->

	<!-- Style --> <link rel="stylesheet" href="../css/style.css" type="text/css" media="all">
		<script src="../js/jquery.min.js"></script>
	<script src="../js/jquery.validate.js"></script>
	<script type="text/javascript">
        $().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
            $("#registerForm").validate({
                rules: {
                    userName: {
                        required: true,
                        minlength: 2
                    },
                    password: {
                        required: true,
                        minlength: 6
                    }
                },
                messages: {
                    userName: {
                        required: "请输入用户名",
                        minlength: "<font color='red'>用户名至少2个字符</font>"
                    },
                    password: {
                        required: "请输入密码",
                        minlength: "<font color='red'>密码长度不能小于 6 个字母数字</font>"
                    }
                }
            })

            $("#logInForm").validate({
                rules: {
                    userName: {
                        required: true,
                        minlength: 2
                    },
                    password: {
                        required: true,
                        minlength: 6
                    }
                },
                messages: {
                    userName: {
                        required: "请输入用户名",
                        minlength: "<font color='red'>用户名至少2个字符</font>"
                    },
                    password: {
                        required: "请输入密码",
                        minlength: "<font color='red'>密码长度不能小于 6 个字母数字</font>"
                    }
                }
            })

			$("#usernm").keyup(function(){
			    $("#msg").text("");
			})
            $("#userpd").keyup(function(){
                $("#msg").text("");
            })
            $("#ru").keyup(function(){
                $("#msg2").text("");
            })

            $("#ru").blur(function () {
                var page = "<%=path%>/User/validate";
                var value = $(this).val();
                $.post(
                    page,
                    {name:value},
                    function(result){
                        if(result != "") {
                            $("#msg2").html(result);
                            $("#smt").attr({"disabled":"disabled"});
                        }else{
                            $("#msg2").html("");
                            $("#smt").removeAttr("disabled");
						}
                    }
                );
            })
        });


	</script>


</head>
<!-- //Head -->

<!-- Body -->
<% String flag = (String)session.getAttribute("flag")==null?"":(String)session.getAttribute("flag");

	String name = "";
	String password = "";
	try{
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
		    System.out.println("cookies not null");
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("cookie_user")){
					String value =  cookies[i].getValue();
					if(value!=null&&!"".equals(value)){
						name=cookies[i].getValue().split("-")[0];
						if(cookies[i].getValue().split("-")[1]!=null && !cookies[i].getValue().split("-")[1].equals("null")){
							password=cookies[i].getValue().split("-")[1];
						}
						System.out.println(name+" "+password);

					}
				}
				request.setAttribute("name",name);
				request.setAttribute("passward",password);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<body>

	<h1>智能职位分析系统</h1>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<form id="logInForm" action="/User/logIn" method="post">
				<input type="text" id="usernm" Name="userName" value="<%=name%>" placeholder="用户名" required=""/><div id="msg">${msg}</div>
				<input type="password" id="userpd" Name="password" value="<%=password%>" placeholder="密码" required="">
				<ul class="tick w3layouts agileits">
					<li>
						<input type="checkbox" id="flag" name="flag" value="1" <%if(flag!=null && flag.equals("1")){%> checked="checked" ; value ="1"; <%}else {%> value="0" <%;}%>/>
						<label for="flag"><span></span>记住我</label>
					</li>
				</ul>
				<div class="send-button w3layouts agileits">
						<input type="submit" value="登 录">
				</div>
			</form>
			<a href="#">忘记密码?</a>
			<div class="social-icons w3layouts agileits">
				<p>- 其他方式登录 -</p>
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
		</div>
		

		<div class="register w3layouts agileits">
			<h2>注 册</h2>
			<form id="registerForm" action="/User/register" method="post">
				<input type="text" id="ru" Name="userName" placeholder="用户名" required=""><div id="msg2"></div>
				<input type="password" id="rp" Name="password" placeholder="密码" required="">
				<input type="hidden" name="userId"/>
				<div class="send-button w3layouts agileits">
					<input type="submit" id="smt" value="免费注册">
				</div>
			</form>

			<div class="clear"></div>
		</div>

		<div class="clear"></div>

	</div>

	<div class="footer w3layouts agileits">
		<p>Copyright &copy; More Templates</p>
	</div>

</body>
<!-- //Body -->

</html>