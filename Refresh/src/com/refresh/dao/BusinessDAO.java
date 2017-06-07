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
	public boolean selectLogin(Business busi){   
		try {
			int t = (int) sqlMap.queryForObject("refresh.businessSelLogin", busi);
			if(t==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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

	public int checkId(int idnum){
		int t=0;
		try {
			 t = (int) sqlMap.queryForObject("refresh.businessCheckId",idnum);
			// System.out.println("아이디 넘겨주는 값 : "+t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
}
