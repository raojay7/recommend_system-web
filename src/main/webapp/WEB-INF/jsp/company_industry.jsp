<%--
  Created by IntelliJ IDEA.
  User: Wenqiang Luo
  Date: 2018/2/10
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();%>
<html>
<head><%--看看哪些行业类别的公司最多--%>
    <title>公司行业分布</title>
    <script type="text/javascript" src="../js/echarts.js"></script>
    <script type="text/javascript">
        function initChart() {
            // 初始化要显示的图标div
            var myChart = echarts.init(document.getElementById('my_chart'));
            var httpRequest = new XMLHttpRequest();
            httpRequest.open("GET","<%=path%>/company/companyindustry",true);
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

<div id="my_chart" style="width:1000px;height:500px;"></div>

</body>
</html>