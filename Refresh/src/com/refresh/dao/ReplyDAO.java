package com.refresh.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.refresh.dto.Reply;

import ibatis.conf.MySqlMapClient;

public class ReplyDAO {//DB접근 전담클래스
	
	SqlMapClient sqlMap;
	
	public ReplyDAO() {
		sqlMap = MySqlMapClient.getSqlMapInstance();
	}//생성자
	
	public boolean insert(Reply reply){//댓글쓰기
		
		try {
			sqlMap.insert("reply.insert",reply);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}//insert
	
	public boolean update(Reply reply){//댓글수정
		 try {
			int t = sqlMap.update("reply.update",reply);//t: 수정된 행의 갯수
			 if(t==1)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 return false;
	}//update
	
	public boolean delete(int rnum){//특정 한행 삭제
		try {
			int t = sqlMap.delete("reply.delete",rnum);//t: 삭제된 행의 갯수
			  if(t==1)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		  return false;
	}//delete
	
	
	//댓글창에서 select가 필수요소는 아닌거같은데 혹시 몰라서 일단 만들어 놨어요
	public Reply select(int rnum){//수정하고? list에 출력할 데이터
	   Reply reply=null;
			
		try {
			reply = (Reply) sqlMap.queryForObject("reply.select",rnum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		  return reply;
	}//select
		   
    public List<Reply> selectAll(){//list에 출력할 데이터
	    List<Reply> list=null;
			
		try {
			list = sqlMap.queryForList("reply.selectAll");
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		  return list;
    }//selectAll
    
    public List<Reply> selectPage(int page, int recordCount){//list에 출력할 데이터
 	   
 	   int end = page*recordCount; //page*10
 	   int start = end-(recordCount-1);//end-9;
 	   
 	   /*
 	    * page   start     end
 	    * 1페이지:  1        10
  	    * 2페이지:  11       20
 	    * 3페이지:  21       30
 	    * 4페이지:  31       40
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