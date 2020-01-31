<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <body style="height: 100%; margin: 0">
       <div id="container" style="height: 100%"></div>
       <script type="text/javascript" src="${pageContext.request.contextPath}/static/echarts.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.11.3.min.js"></script>
       <script type="text/javascript">
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};
option = null;
option = {
	    title: {
	        text: '回答机构排序',
	        subtext: '数据为真实数据'
	    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            crossStyle: {
                color: '#999'
            }
        }
    },
    toolbox: {
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    
    
    
    
    
    
    legend: {
        data: ['回答问题机构', '平均温度']
    },
    xAxis: [
        {
            type: 'category',
            data:[],
            axisLabel: {  
                interval: 0,  
                formatter:function(value)  
                {  
                    debugger  
                    var ret = "";//拼接加\n返回的类目项  
                    var maxLength = 2;//每项显示文字个数  
                    var valLength = value.length;//X轴类目项的文字个数  
                    var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数  
                    if (rowN > 1)//如果类目项的文字大于3,  
                    {  
                        for (var i = 0; i < rowN; i++) {  
                            var temp = "";//每次截取的字符串  
                            var start = i * maxLength;//开始截取的位置  
                            var end = start + maxLength;//结束截取的位置  
                            //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧  
                            temp = value.substring(start, end) + "\n";  
                            ret += temp; //凭借最终的字符串  
                        }  
                        return ret;  
                    }  
                    else {  
                        return value;  
                    }  
                }  
            },
        grid: {  
        		left: '10%',  
        		bottom:'35%'  
        }

        }
    ],
    yAxis: [
        {
            type: 'value',

        }
    ],
    series: [
        {
            name: '回答问题机构',
            type: 'bar',
            data: []
         },

        {
            name: '回答问题机构',
            type: 'line',
            data:[]
        }
    ]
};

myChart.showLoading(); 

$.ajax({
    type : "post",
    async : true,
    url : "${pageContext.request.contextPath}/charts",
    type:"POST",
    data:
    	{
    	"method":"nianzhu"
    	},
    dataType:"json",
    success:function(result) {
        
        if(result)
        {
        	myChart.hideLoading();
           	
           	myChart.setOption({        //加载数据图表
                xAxis: {
                    data: result.xAxis
                },
                series: [
                    {
                        data: result.series[0].data
                     },
                     {
                         data: result.series[0].data
                      }
                	]
            });
        }
                  
   },
    error : function(errorMsg) {
        //请求失败时执行该函数
    alert("请求数据失败!");
   // myChart.hideLoading();
    }
});
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}

       </script>
   </body>
</html>