
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
        var myChart = ec.init(document.getElementById('main2'));

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
                text: '技能需求分析',
            },
            tooltip: {
                show: true
            },
            series: [{
                name: '技能需求',
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
                        name: "大数据",
                        value: 6871,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "开发经验",
                        value: 5707,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "熟悉",
                        value: 4076,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "负责",
                        value: 3354,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "本科",
                        value: 2590,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "执行",
                        value: 456,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "沟通",
                        value: 1799,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "软件",
                        value: 1579,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "岗位职责",
                        value: 1511,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "学历",
                        value: 1359,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "精通",
                        value: 1334,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "架构",
                        value: 1243,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "数据库",
                        value: 1117,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "熟练",
                        value: 983,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "协调",
                        value: 956,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "研发",
                        value: 934,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "维护",
                        value: 717,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "Hadoop",
                        value: 664,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "独立",
                        value: 576,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "计算机",
                        value: 571,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "撰写",
                        value: 556,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "Java",
                        value: 556,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "算法",
                        value: 557,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "责任心",
                        value: 450,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "挖掘",
                        value: 443,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "SQL",
                        value: 429,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "协作",
                        value: 420,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "Linux",
                        value: 396,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "数据挖掘",
                        value: 395,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "数据挖掘",
                        value: 395,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "协助",
                        value: 395,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "建模",
                        value: 370,
                        itemStyle: createRandomItemStyle()
                    },
                    {
                        name: "分布式",
                        value: 498,
                        itemStyle: createRandomItemStyle()
                    }
                ]
            }]
        };

        // 为echarts对象加载数据
        myChart.setOption(option);
    }
);
