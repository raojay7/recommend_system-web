function initChart10(path,myChart) {
        // 初始化要显示的图标div
        //var myChart = echarts.init(document.getElementById('my_chart10'));
        var httpRequest = new XMLHttpRequest();
        httpRequest.open("GET",path,true);
        httpRequest.send();
        httpRequest.onreadystatechange = function(){
            if(httpRequest.readyState == 4 && httpRequest.status == 200){
                var result = eval(httpRequest.responseText);
                /*alert(result);*/
                var option = {
                    title: {
                        text: '工作经验雷达图'
                    },
                    tooltip: {},
                    legend: {
                        data: ['薪水']
                    },
                    radar: {
                        // shape: 'circle',
                        indicator: [
                            { name: '1到3年', max: 25000},
                            { name: '3到5年', max: 25000},
                            { name: '5到10年', max: 25000}
                        ]
                    },
                    series: [{
                        name: '薪水',
                        type: 'radar',
                        // areaStyle: {normal: {}},
                        data : [
                            {
                                value : result,
                                name : '薪水'
                            }
                        ]
                    }]
                };
                myChart.setOption(option);
            }
        }

    }
