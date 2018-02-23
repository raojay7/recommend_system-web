
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });

// 使用
require(
    [
        'echarts',
        'echarts/chart/wordCloud',    //字符云
    ],
    function (ec) {
        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('main1'));

        function createRandomItemStyle() {
            return {
                normal: {
                    color: 'rgb(' + [
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160)
                    ].join(',') + ')'
                }
            };
        }

        option = {
            title: {
                text: '企业画像',
            },
            tooltip: {
                show: true
            },
            series: [{
                name: '企业画像',
                type: 'wordCloud',
                size: ['80%', '80%'],
                textRotation : [0, 45, 90, -45],
                textPadding: 0,
                autoSize: {
                    enable: true,
                    minSize: 14
                },
                data: [

                    {
                        name: "五险",
                        value: 10095,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "一金",
                        value: 9423,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "民营",
                        value: 7535,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "带薪年假",
                        value: 7153,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "节日福利",
                        value: 7100,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "绩效奖金",
                        value: 5641,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "定期体检",
                        value: 4714,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "补助",
                        value: 4450,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "员工旅游",
                        value: 4125,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "餐补",
                        value: 3446,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "双薪",
                        value: 3024,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "全勤奖",
                        value: 2217,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "股票期权",
                        value: 1963,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "保险",
                        value: 1942,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "调薪",
                        value: 988,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "年终奖",
                        value: 955,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "分红",
                        value: 955,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "包住",
                        value: 460,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "班车",
                        value: 326,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "奖金",
                        value: 259,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "绩效",
                        value: 259,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "住房补贴",
                        value: 81,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "住房",
                        value: 192,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "金餐补",
                        value: 465,
                        itemStyle: createRandomItemStyle()
                    }
                ]
            }]
        };

        // 为echarts对象加载数据
        myChart.setOption(option);
    }
);
