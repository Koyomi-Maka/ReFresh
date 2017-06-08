package com.refresh.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.refresh.dao.ReplyDAO;
import com.refresh.dto.Reply;


public class ReplyAction extends Action{

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");//요청 분석
		
		if(action==null) action="list";
		ReplyDAO dao=new ReplyDAO();
		
		
		ActionForward forward=null;//이동할 페이지 저장
		
		switch(action){
		case "list"://댓글목록 if(action==null||action.equals("list"))
			
			   List<Reply> list=dao.selectAll();
			   //System.out.println("댓글 리스트: "+ list);
			   request.setAttribute("list", list);
			   forward=mapping.findForward("list");
			break;
		case "insert"://입력요청 else if(action.equals("insert"))
		{
		  Reply reply=new Reply();
		    reply.setRname(request.getParameter("rname"));
		    reply.setRcontent(request.getParameter("rcontent"));
			
			
			  if(dao.insert(reply)){
				  request.setAttribute("msg", "댓글입력성공");
			  }else{
				  request.setAttribute("msg", "댓글입력실패");
			  }
			  forward=mapping.findForward("msg");
		}
			break;

		case "delete"://삭제요청
			int rnum=Integer.parseInt(request.getParameter("rnum"));
		    
			  if(dao.delete(rnum)){
				  request.setAttribute("msg", "OK");
			  }else{
				  request.setAttribute("msg", "댓글삭제실패");
			  }
			  forward=mapping.findForward("msg");
			break;
		}
		
		
		return forward;
	}//execute

}

