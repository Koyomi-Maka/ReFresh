package com.refresh.dao;
 
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.refresh.dto.Business;

import ibatis.conf.MySqlMapClient;

public class BusinessDAO {
	SqlMapClient sqlMap;
	
	
	public BusinessDAO() {
		sqlMap = MySqlMapClient.getSqlMapInstance(); 
	}//생성자
	
	//중복검사, 로그인(로그인성공, 로그인실패_아이디존재여부,비번일치여부)
	public boolean insert(Business busi){
		try {
			sqlMap.insert("refresh.businessInsert", busi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Business busi){
		try {
			int t = sqlMap.update("refresh.businessUpdate",busi);
			if(t==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int bnum){
		try {
			int t = (int)sqlMap.delete("refresh.businessDelete", bnum);
			if(t==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public String selectLogin(int idbnum){   
		String bpass = null;
		try {
			bpass = (String) sqlMap.queryForObject("refresh.businessSelLogin", idbnum);
			return bpass;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bpass;
	}
	
	public boolean busiIdCheck(int idbnum){ // 중복확인
		try {
			int t = (int) sqlMap.queryForObject("refresh.busiIdCheck",idbnum);
			if(t>0) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int bIdCheck(int idnum){
		int t=0;
		try {
			t = (int) sqlMap.queryForObject("refresh.businessCheckId",idnum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public Business select(int idbnum){
		Business busi = null;   
		try {
			busi = (Business)sqlMap.queryForList("refresh.businessSelect", idbnum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return busi;
	}
	public List<Business> selectAll(){
		List<Business> list = null;
		try {
			list = sqlMap.queryForList("refresh.businessSelectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
