
    function getScaleDataArr(path,industryDataArr,scaleDataArr,objDataArr,myChart){
        var httpRequest = new XMLHttpRequest();
        httpRequest.open("GET",path + "?type=2",true);
        httpRequest.send();
        httpRequest.onreadystatechange = function(){
            if(httpRequest.readyState == 4 && httpRequest.status == 200){
                scaleDataArr = httpRequest.responseText;
                // alert(scaleDataArr);
                getObjDataArr(path,industryDataArr,scaleDataArr,objDataArr,myChart);
            }
        }
    }
    function getObjDataArr(path,industryDataArr,scaleDataArr,objDataArr,myChart){
        var httpRequest = new XMLHttpRequest();
        httpRequest.open("GET",path + "?type=3",true);
        httpRequest.send();
        httpRequest.onreadystatechange = function(){
            if(httpRequest.readyState == 4 && httpRequest.status == 200){
                objDataArr = httpRequest.responseText;
                // alert(objDataArr);
                getG(industryDataArr,scaleDataArr,objDataArr,myChart)
            }
        }
    }
    function getIndustryDataArr(path,industryDataArr,scaleDataArr,objDataArr,myChart){
        var httpRequest = new XMLHttpRequest();
        httpRequest.open("GET",path + "?type=1",true);
        httpRequest.send();
        httpRequest.onreadystatechange = function(){
            if(httpRequest.readyState == 4 && httpRequest.status == 200){
                industryDataArr = httpRequest.responseText;
                // alert(industryDataArr);
                getScaleDataArr(path,industryDataArr, scaleDataArr,objDataArr,myChart);
            }
        }
    }
    function getG(industryDataArr,scaleDataArr,objDataArr,myChart){
        /*alert(industryDataArr==null?"null!":"not null!");
        alert(scaleDataArr==null?"null!":"not null!");
        alert(objDataArr==null?"null!":"not null!");*/
        industryDataArr = eval(industryDataArr);
        scaleDataArr = eval(scaleDataArr);
        objDataArr = eval(objDataArr);
        var option = {
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                x:'left',
                data: industryDataArr
            },
            grid: {
                left: '0%',
                right: '4%',
                bottom: '3%',
                containLabel: true,
                top:'11%'
            },
            xAxis:  {
                type: 'value'
            },
            yAxis: {
                type: 'category',
                data: scaleDataArr
            },
            series: objDataArr
        };
    myChart.setOption(option);

    }
    function initChart5(path,myChart) {
        // 初始化要显示的图标div
        //var myChart = echarts.init(document.getElementById('my_chart5'));

        var industryDataArr, scaleDataArr, objDataArr;

        getIndustryDataArr(path, industryDataArr,scaleDataArr,objDataArr,myChart);






    }
