package com.refresh.dao;
 
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.refresh.dto.Business;

import ibatis.conf.MySqlMapClient;

public class BusinessDAO {
	SqlMapClient sqlMap;
	
	public BusinessDAO() {
		sqlMap = MySqlMapClient.getSqlMapInstance(); 
	}//생성자
	
	//update, select, selectAll, 중복검사, 로그인(로그인성공, 로그인실패_아이디존재여부,비번일치여부)
	public boolean insert(Business busi){
		try {
			sqlMap.insert("busi.businessInsert", busi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Business busi){
		try {
			int t = sqlMap.update("busi.businessUpdate",busi);
			if(t==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int bnum){
		try {
			int t = (int)sqlMap.delete("busi.businessDelete", bnum);
			if(t==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Business select(int idbnum){
		Business busi = null;   
		try {
			busi = (Business)sqlMap.queryForList("busi.businessSelect", idbnum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return busi;
	}
	public List<Business> selectAll(){
		List<Business> list = null;
		try {
			list = sqlMap.queryForList("busi.businessSelectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}   
}

