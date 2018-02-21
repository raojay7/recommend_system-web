<%--
  Created by IntelliJ IDEA.
  User: Wenqiang Luo
  Date: 2018/2/14
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();%>
<html>
<head>
    <title>不同行业公司平均工资及岗位需求量</title>
    <script type="text/javascript" src="../js/echarts.js"></script>
    <script type="text/javascript">
        function initChart() {
            // 初始化要显示的图标div
            var myChart = echarts.init(document.getElementById('my_chart'));
            var httpRequest = new XMLHttpRequest();
            httpRequest.open("GET","<%=path%>/company/industryneedavg",true);
            httpRequest.send();
            httpRequest.onreadystatechange = function(){
                if(httpRequest.readyState == 4 && httpRequest.status == 200){
                    var result = httpRequest.responseText;
                    /*alert(result);*/
                    var option = eval("(" + result + ")");
                    myChart.setOption(option);
                }
            }

        }

    </script>
</head>
<body onload="initChart();">

<div id="my_chart" style="width:1400px;height:500px;"></div>

</body>
</html>