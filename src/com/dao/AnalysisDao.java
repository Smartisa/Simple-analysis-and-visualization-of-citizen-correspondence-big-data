package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.AnalysisBean;
import com.util.DBUtil;

public class AnalysisDao

{
	
	public static void main(String[] args) 
	{
		
		List<AnalysisBean> strs=new ArrayList<AnalysisBean>();
		strs=select_date();
		for(AnalysisBean s:strs)
		{
			System.out.println(s.getName()+"\t"+s.getNum());
		}
		
	}
	public static ArrayList<AnalysisBean> select_answer( )
	{
		Connection conn = DBUtil.getConn();
		ArrayList<AnalysisBean> userBeans=new ArrayList<AnalysisBean>();
		AnalysisBean userBean;
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("select answer as name , count(1) as num from info group by answer order by num desc");
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				userBean = new AnalysisBean();
				userBean.setName(rs.getString("Name"));
				userBean.setNum(rs.getString("Num"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return userBeans;
	}
	
	
	
	public static ArrayList<AnalysisBean> select_date( )
	{
		Connection conn = DBUtil.getConn();
		ArrayList<AnalysisBean> userBeans=new ArrayList<AnalysisBean>();
		AnalysisBean userBean;
		try {
			Statement state = conn.createStatement();
			
			ResultSet rs = state.executeQuery("select left(Question_date,4) as Name ,count(1) as Num from info group by Name order by num desc");
			while(rs.next()) 
			{
				//如果有结果，是认为是通过验证了
				userBean = new AnalysisBean();
				userBean.setName(rs.getString("Name"));
				userBean.setNum(rs.getString("Num"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return userBeans;
	}
	
	public static ArrayList<AnalysisBean> select_nature( )
	{
		Connection conn = DBUtil.getConn();
		ArrayList<AnalysisBean> userBeans=new ArrayList<AnalysisBean>();
		AnalysisBean userBean;
		try {
			Statement state = conn.createStatement();
			
			ResultSet rs = state.executeQuery("select nature as name , count(1) as num from info group by Nature order by num desc");
			while(rs.next()) 
			{
				//如果有结果，是认为是通过验证了
				userBean = new AnalysisBean();
				userBean.setName(rs.getString("Name"));
				userBean.setNum(rs.getString("Num"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return userBeans;
	}
	
	
}
