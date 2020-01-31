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
        subtext: '数据真实',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c} ({d}%)'
    },
    legend: {
        type: 'scroll',
        orient: 'vertical',
        right: 10,
        top: 20,
        bottom: 20,
        data: [],
		selected: {}
    },
    series: [
        {
            name: '访问来源',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [],
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
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
    	"method":"huishan"
    	},
    dataType:"json",
    
    success:function(result) {
       // alert(result.selected);
        if(result)
        {
        	myChart.hideLoading();
           	myChart.setOption({        //加载数据图表
                legend: {
                    data: result.legend,
                   // selected:result.selected
                },
                series: [
                    {
                        data: result.series
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