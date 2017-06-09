package com.refresh.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.refresh.dao.BusinessDAO;
import com.refresh.dao.InvestorDAO;
import com.refresh.dto.Business;
import com.refresh.dto.Investor;
import com.refresh.forms.LoginActionForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Login execute()");
		//요청분석, 입력데이터 얻기, 모델호출(영역저장), 페이지이동
		
		LoginActionForm laf = (LoginActionForm) form;
		
		String login=laf.getLogin();
		
		
		if(login.equals("login1")){//개인회원 로그인
			String idmail=laf.getIdmail();
			String ipass=laf.getIpass();
			//db에서 전체검유효성검사가 끝난 데이터 얻어오기
			InvestorDAO dao1=new InvestorDAO();
			boolean inve=dao1.invesSelectLogin(idmail, ipass);
			
         ActionForward forward;	
         
       //로그인 판단  
    	 if(!inve)//(inve==false)//아이디 존재X 또는 비번 일치X
    		
    		 forward = mapping.findForward("fail");
    	 else {
    		 HttpSession session = request.getSession();
    		 session.setAttribute("inve", inve);
    	     forward = mapping.findForward("success");
    	 }
    	
    	return forward;
         
		}else{//기업회원 로그인    
			int idbnum= Integer.parseInt(laf.getIdbnum());			
			String bpass=laf.getBpass();
			
			BusinessDAO dao2=new BusinessDAO();
			String busi=dao2.selectLogin(idbnum);	
			
			 ActionForward forward;	  
			 
		    	//로그인 판단  
		    	 if(busi==null)//아이디 존재X 또는 비번 일치X
		    		
		    		 forward = mapping.findForward("fail");
		    	 else {
		    		 HttpSession session = request.getSession();
		    	  		 session.setAttribute("busi", busi);
		    		 
		    		
		    	     forward = mapping.findForward("success");
		    	 }
		    	
		    	return forward;
			
		}
		
	}
}
