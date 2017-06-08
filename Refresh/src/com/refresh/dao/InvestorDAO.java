package com.refresh.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.refresh.dto.Investor;

import ibatis.conf.MySqlMapClient;

public class InvestorDAO {

	SqlMapClient sqlMap;
	
	public InvestorDAO() {
		sqlMap = MySqlMapClient.getSqlMapInstance();
	}
	
	public boolean invesInsert(Investor inves){
			try {
			 int t = (int)sqlMap.insert("refresh.invesInsert",inves);
			 if(t>0)return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean invesIdcheck(String idmail) {
		try {
			int i = (int)sqlMap.queryForObject("refresh.invesIdcheck",idmail);
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}
	
	
	public boolean invesSelectLogin(String idmail,String ipass) {
		try {
			String pass = (String)sqlMap.queryForObject("refresh.invesSelectLogin",idmail);
			if(ipass.trim().equals(pass.trim())){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	public Investor invesSelect(String idmail) {
		Investor inves = null;
		try {
			inves = (Investor)sqlMap.queryForObject("refresh.invesSelect",idmail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return inves;
	}
	public List<Investor> invesSelectAll() {
		List<Investor> list = null;
		try {
			list = sqlMap.queryForList("refresh.invesSelectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean invesDelete(int inum) {
		try {
			int t = sqlMap.delete("refresh.invesDelete", inum);
			if(t>0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean invesUpdate(Investor inves) {
		try {
			int t = sqlMap.update("refresh.invesUpdate", inves);
			if(t>0) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
