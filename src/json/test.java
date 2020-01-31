package json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.alibaba.fastjson.JSONObject;
import com.bean.AnalysisBean;
import com.bean.Series;
import com.dao.AnalysisDao;

public class test {
	public static void main(String[] args) {
		String str=test();
		System.out.println(str);
	}
	public static String test()
	{
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		
		List<AnalysisBean> beans=new ArrayList<AnalysisBean>();
		beans=AnalysisDao.select_answer();
		for(AnalysisBean n:beans)
		{
			String str=n.getName();
			xAxisData.add(str);
		}
		List<Integer> list=new ArrayList<Integer>();
		
		for(AnalysisBean n:beans)
		{
			int nu=Integer.parseInt(n.getNum());
			list.add(nu);
		}
		
		 Series series=new Series("回答问题机构","bar",list);
		 JSONObject job = new JSONObject();
         job.put("name", series.getName());
         job.put("type", series.getType());
         job.put("data",series.getData());  
         seriesList.add(job); 
         
         series=new Series("回答问题机构","line",list);
		 job = new JSONObject();
         job.put("name", series.getName());
         job.put("type", series.getType());
         job.put("data",series.getData());  
         seriesList.add(job); 
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("xAxis", xAxisData);  
         jsob.put("series", seriesList); 
         
		return(jsob.toString());
	}
    public static String echartsView()
    {
    	
        List<String> xAxisData = new ArrayList<String>();  
        List< JSONObject> seriesList = new ArrayList< JSONObject>(); 
        for (int i = 1; i < 13; i++)
        {
            xAxisData.add(i+"月");
        }
        for (int i = 1; i < 4; i++)
        {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 1; j < 13; j++)
            {
                 list.add((int)(Math.random()*100));
            }
            
            Series series = new Series("销售"+i, "bar", list);
            JSONObject job = new JSONObject();
            job.put("name", series.toName());
            job.put("type", "bar");
            job.put("data",series.data);  
            seriesList.add(job); 
        }
        //xAxisData和seriesList转为json
        JSONObject jsob = new JSONObject(); 
        JSONArray array=new JSONArray();
        jsob.put("xAxis", xAxisData);  
        jsob.put("series", seriesList); 
        array.put(xAxisData);  
        array.put( seriesList); 
        System.out.println("AAAAAAAAAAA");
        System.out.println(array.toString());
        return jsob.toString();
    }
}
