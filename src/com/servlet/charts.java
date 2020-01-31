package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import com.bean.AnalysisBean;
import com.bean.Series;
import com.dao.AnalysisDao;
import com.alibaba.fastjson.JSONObject;


/**
 * Servlet implementation class charts
 */
@WebServlet("/charts")
public class charts extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if ("zhu".equals(method)) {
			Zhu(req, resp);
		}else if("shan".equals(method))
		{
			shan(req,resp);
		}
		else if("huizhu".equals(method))
		{
			huizhu(req,resp);
		}
		else if("huishan".equals(method))
		{
			huishan(req,resp);
		}
		else if("nianzhu".equals(method))
		{
			nianzhu(req,resp);
		}
		else if("nianshan".equals(method))
		{
			nianshan(req,resp);
		}
		
		
	}   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public charts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void Zhu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
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
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    private void shan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
        
		List<AnalysisBean> beans=new ArrayList<AnalysisBean>();
		beans=AnalysisDao.select_answer();
		for(AnalysisBean n:beans)
		{
			String str=n.getName();
			xAxisData.add(str);
		}
		
		
		int i=0;
		for(AnalysisBean n:beans)
		{
			JSONObject job = new JSONObject();
	         job.put("value", n.getNum());
	         job.put("name", n.getName());
	         seriesList.add(job); 
	         i=i+1;
	         if(i>30)
	         {
	        	 break;
	         }
	         
		}
		
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("legend", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		//System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    
    private void huizhu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		
		List<AnalysisBean> beans=new ArrayList<AnalysisBean>();
		beans=AnalysisDao.select_date();
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
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    
    private void huishan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
        
		List<AnalysisBean> beans=new ArrayList<AnalysisBean>();
		beans=AnalysisDao.select_date();
		for(AnalysisBean n:beans)
		{
			String str=n.getName();
			xAxisData.add(str);
		}
		
		
		int i=0;
		for(AnalysisBean n:beans)
		{
			JSONObject job = new JSONObject();
	         job.put("value", n.getNum());
	         job.put("name", n.getName());
	         seriesList.add(job); 
	         i=i+1;
	         if(i>30)
	         {
	        	 break;
	         }
	         
		}
		
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("legend", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		//System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    private void nianzhu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		
		List<AnalysisBean> beans=new ArrayList<AnalysisBean>();
		beans=AnalysisDao.select_nature();
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
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    private void nianshan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
        
		List<AnalysisBean> beans=new ArrayList<AnalysisBean>();
		beans=AnalysisDao.select_nature();
		for(AnalysisBean n:beans)
		{
			String str=n.getName();
			xAxisData.add(str);
		}
		
		
		int i=0;
		for(AnalysisBean n:beans)
		{
			JSONObject job = new JSONObject();
	         job.put("value", n.getNum());
	         job.put("name", n.getName());
	         seriesList.add(job); 
	         i=i+1;
	         if(i>30)
	         {
	        	 break;
	         }
	         
		}
		
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("legend", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		//System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
}
