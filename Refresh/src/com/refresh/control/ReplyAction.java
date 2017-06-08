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
		String action=request.getParameter("action");//��û �м�
		
		if(action==null) action="list";
		ReplyDAO dao=new ReplyDAO();
		
		
		ActionForward forward=null;//�̵��� ������ ����
		
		switch(action){
		case "list"://��۸�� if(action==null||action.equals("list"))
			
			   List<Reply> list=dao.selectAll();
			   //System.out.println("��� ����Ʈ: "+ list);
			   request.setAttribute("list", list);
			   forward=mapping.findForward("list");
			break;
		case "insert"://�Է¿�û else if(action.equals("insert"))
		{
		  Reply reply=new Reply();
		    reply.setRname(request.getParameter("rname"));
		    reply.setRcontent(request.getParameter("rcontent"));
			
			
			  if(dao.insert(reply)){
				  request.setAttribute("msg", "����Է¼���");
			  }else{
				  request.setAttribute("msg", "����Է½���");
			  }
			  forward=mapping.findForward("msg");
		}
			break;

		case "delete"://������û
			int rnum=Integer.parseInt(request.getParameter("rnum"));
		    
			  if(dao.delete(rnum)){
				  request.setAttribute("msg", "OK");
			  }else{
				  request.setAttribute("msg", "��ۻ�������");
			  }
			  forward=mapping.findForward("msg");
			break;
		}
		
		
		return forward;
	}//execute

}

