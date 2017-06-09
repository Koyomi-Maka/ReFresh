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
		//��û�м�, �Էµ����� ���, ��ȣ��(��������), �������̵�
		
		LoginActionForm laf = (LoginActionForm) form;
		
		String login=laf.getLogin();
		
		
		if(login.equals("login1")){//����ȸ�� �α���
			String idmail=laf.getIdmail();
			String ipass=laf.getIpass();
			//db���� ��ü����ȿ���˻簡 ���� ������ ������
			InvestorDAO dao1=new InvestorDAO();
			boolean inve=dao1.invesSelectLogin(idmail, ipass);
			
         ActionForward forward;	
         
       //�α��� �Ǵ�  
    	 if(!inve)//(inve==false)//���̵� ����X �Ǵ� ��� ��ġX
    		
    		 forward = mapping.findForward("fail");
    	 else {
    		 HttpSession session = request.getSession();
    		 session.setAttribute("inve", inve);
    	     forward = mapping.findForward("success");
    	 }
    	
    	return forward;
         
		}else{//���ȸ�� �α���    
			int idbnum= Integer.parseInt(laf.getIdbnum());			
			String bpass=laf.getBpass();
			
			BusinessDAO dao2=new BusinessDAO();
			String busi=dao2.selectLogin(idbnum);	
			
			 ActionForward forward;	  
			 
		    	//�α��� �Ǵ�  
		    	 if(busi==null)//���̵� ����X �Ǵ� ��� ��ġX
		    		
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
