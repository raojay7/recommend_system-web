
    function initChart5(path,myChart) {
        // 初始化要显示的图标div
        //var myChart = echarts.init(document.getElementById('my_chart5'));
        var httpRequest = new XMLHttpRequest();
        httpRequest.open("GET",path,true);
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
