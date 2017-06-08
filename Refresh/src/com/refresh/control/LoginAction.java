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
		
		//ActionForm클래스가 존재O : String id = form.getId();
		LoginActionForm laf = (LoginActionForm) form;
		
		String login=laf.getLogin();
		
		Investor inve=null;
		
		if(login.equals("login1")){//개인회원 로그인
			String idmail=laf.getIdmail();
			String ipass=laf.getIpass();
			//db에서 전체검유효성검사가 끝난 데이터 얻어오기
			InvestorDAO dao1=new InvestorDAO();
			//dao1.selectLogin(idmail, ipass);
			
		}else{//기업회원 로그인      //숫자열변환을 해야함
			int idbnum= Integer.parseInt(laf.getIdbnum());			
			String bpass=laf.getBpass();
			
			BusinessDAO dao2=new BusinessDAO();
			String busi=(String) dao2.selectLogin(idbnum);
			//dao2.selectLogin(idbnum,bpass);
		}
		
						
		ActionForward forward;//ActionForward: 이동할 페이지에 대한 정보를 담는 클래스    	  
				    	  
				    	//로그인 판단  
				    	 if(inve==null)//아이디 존재X 또는 비번 일치X
				    		
				    		 forward = mapping.findForward("fail");
				    	   //ActionMapping mapping: struts-config.xml에 정의(매핑)된 전송페이지 정보
				    	 else {
				    		 //영역저장 (사용자 정보) ==> 왜?  이동하는 뷰와 데이터 공유
				    		 //request.setAttribute("user", user);
				    		 HttpSession session = request.getSession();
				    		 session.setAttribute("inve", inve);
				    		 
				    		 //성공했다
				    	     forward = mapping.findForward("success");
				    	 }
				    	
				    	return forward;
			}
}
