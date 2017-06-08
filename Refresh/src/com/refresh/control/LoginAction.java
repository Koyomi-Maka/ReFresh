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
		
		//ActionFormŬ������ ����O : String id = form.getId();
		LoginActionForm laf = (LoginActionForm) form;
		
		String login=laf.getLogin();
		
		Investor inve=null;
		
		if(login.equals("login1")){//����ȸ�� �α���
			String idmail=laf.getIdmail();
			String ipass=laf.getIpass();
			//db���� ��ü����ȿ���˻簡 ���� ������ ������
			InvestorDAO dao1=new InvestorDAO();
			//dao1.selectLogin(idmail, ipass);
			
		}else{//���ȸ�� �α���      //���ڿ���ȯ�� �ؾ���
			int idbnum= Integer.parseInt(laf.getIdbnum());			
			String bpass=laf.getBpass();
			
			BusinessDAO dao2=new BusinessDAO();
			String busi=(String) dao2.selectLogin(idbnum);
			//dao2.selectLogin(idbnum,bpass);
		}
		
						
		ActionForward forward;//ActionForward: �̵��� �������� ���� ������ ��� Ŭ����    	  
				    	  
				    	//�α��� �Ǵ�  
				    	 if(inve==null)//���̵� ����X �Ǵ� ��� ��ġX
				    		
				    		 forward = mapping.findForward("fail");
				    	   //ActionMapping mapping: struts-config.xml�� ����(����)�� ���������� ����
				    	 else {
				    		 //�������� (����� ����) ==> ��?  �̵��ϴ� ��� ������ ����
				    		 //request.setAttribute("user", user);
				    		 HttpSession session = request.getSession();
				    		 session.setAttribute("inve", inve);
				    		 
				    		 //�����ߴ�
				    	     forward = mapping.findForward("success");
				    	 }
				    	
				    	return forward;
			}
}
