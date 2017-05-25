package com.refresh.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.refresh.dto.Reply;

import ibatis.conf.MySqlMapClient;

public class ReplyDAO {//DB���� ����Ŭ����
	
	SqlMapClient sqlMap;
	
	public ReplyDAO() {
		sqlMap = MySqlMapClient.getSqlMapInstance();
	}//������
	
	public boolean insert(Reply reply){//��۾���
		
		try {
			sqlMap.insert("reply.insert",reply);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}//insert
	
	public boolean update(Reply reply){//��ۼ���
		 try {
			int t = sqlMap.update("reply.update",reply);//t: ������ ���� ����
			 if(t==1)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 return false;
	}//update
	
	public boolean delete(int rnum){//Ư�� ���� ����
		try {
			int t = sqlMap.delete("reply.delete",rnum);//t: ������ ���� ����
			  if(t==1)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		  return false;
	}//delete
	
	
	//���â���� select�� �ʼ���Ҵ� �ƴѰŰ����� Ȥ�� ���� �ϴ� ����� �����
	public Reply select(int rnum){//�����ϰ�? list�� ����� ������
	   Reply reply=null;
			
		try {
			reply = (Reply) sqlMap.queryForObject("reply.select",rnum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		  return reply;
	}//select
		   
    public List<Reply> selectAll(){//list�� ����� ������
	    List<Reply> list=null;
			
		try {
			list = sqlMap.queryForList("reply.selectAll");
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		  return list;
    }//selectAll
    
    public List<Reply> selectPage(int page, int recordCount){//list�� ����� ������
 	   
 	   int end = page*recordCount; //page*10
 	   int start = end-(recordCount-1);//end-9;
 	   
 	   /*
 	    * page   start     end
 	    * 1������:  1        10
  	    * 2������:  11       20
 	    * 3������:  21       30
 	    * 4������:  31       40
 	    *       end-9     page*10
 	    * */
 	   
 	  
 		List<Reply> list=null;
 		try {
 			Map<String, Integer> map = new HashMap<>();
 			   map.put("start", start);
 			   map.put("end", end);
 			   
 			list = sqlMap.queryForList("reply.selectPage",map);
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}	  
 		  return list;
 	   }//selectPage
    
    public int selectCount(){
   	 int count=0;
   	try {
			count = (Integer) sqlMap.queryForObject("reply.count");
		} catch (SQLException e) {
			e.printStackTrace();
		}
   	return count;
    }//selectCount

}