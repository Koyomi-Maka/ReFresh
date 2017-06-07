package com.refresh.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.refresh.dto.Funding;

import ibatis.conf.MySqlMapClient;

public class FundingDAO {
	
	SqlMapClient smc;
	
	public FundingDAO(){
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	//메인 페이징 작업
	public List<Funding> selectPageAll(int page,int recordCount){ 
		List list = null;
		try {
			Map<String, Integer> map = new HashMap<>();
			int end = page * recordCount;
			int start = end-(recordCount-1);
			
			map.put("start",start);
			map.put("end",end);
			list = smc.queryForList("refresh.selectPageAll",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int selectTotal(){ //게시글의 수를 구하는 DAO
		int totalRecord = 0;
		try {
			totalRecord = (int) smc.queryForObject("refresh.selectTotal");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRecord;
	}
	
	public List<Funding> selectEnded(int page,int recordCount){
		List list = null;
		try {
			Map<String, Integer> map = new HashMap<>();
			int end = page * recordCount;
			int start = end-(recordCount-1);
			
			map.put("start",start);
			map.put("end",end);
			list = smc.queryForList("refresh.selectEnded",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int selectEndedTotal(){ //게시글의 수를 구하는 DAO
		int totalRecord = 0;
		try {
			totalRecord = (int) smc.queryForObject("refresh.selectEndedTotal");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRecord;
	}
	
	public List<Funding> selectClose(int page,int recordCount){
		List list = null;
		try {
			Map<String, Integer> map = new HashMap<>();
			int end = page * recordCount;
			int start = end-(recordCount-1);
			
			map.put("start",start);
			map.put("end",end);
			list = smc.queryForList("refresh.selectClose",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int selectCloseTotal(){ //게시글의 수를 구하는 DAO
		int totalRecord = 0;
		try {
			totalRecord = (int) smc.queryForObject("refresh.selectCloseTotal");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRecord;
	}
	//main DAO
	//-------------------------------------------------
}
