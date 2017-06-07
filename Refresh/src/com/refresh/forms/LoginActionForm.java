package com.refresh.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class LoginActionForm extends ActionForm {
  
	private String idmail;
	private String ipass;
	private String idbnum;
	private String bpass;
	private String login;
	
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getIdmail() {
		return idmail;
	}

	public void setIdmail(String idmail) {
		this.idmail = idmail;
	}

	public String getIpass() {
		return ipass;
	}

	public void setIpass(String ipass) {
		this.ipass = ipass;
	}

	

	public String getIdbnum() {
		return idbnum;
	}

	public void setIdbnum(String idbnum) {
		this.idbnum = idbnum;
	}

	public String getBpass() {
		return bpass;
	}

	public void setBpass(String bpass) {
		this.bpass = bpass;
	}




		//2. ��ȿ���˻� - validate�޼ҵ� �������̵�
		@Override
		public ActionErrors validate(ActionMapping mapping, 
				                     HttpServletRequest request) {			
			
			System.out.println("LoginActionForm validate():: "+ login);
			ActionErrors errors = new ActionErrors();//�����޽����� ��� �ٱ���
			
			System.out.println("errors1 :: "+ errors);
			
			
		 if(login.equals("login1")){//�Ϲ�ȸ�� �α��ν�
			 
			 if(idmail==null|| idmail.length()<1 ){
				    errors.add("errorid", new ActionMessage("invalidid", "���̵��Է�!!"));
			 }else if(idmail.indexOf(" ") > -1 ||
					 idmail.indexOf("\t") >= 0 || 
					 idmail.indexOf("\n") > -1 ){
				errors.add("errorid", new ActionMessage("invalidid", "������ ������ �� �����ϴ�!!"));}
			 
			 
			 if(ipass==null  || ipass.length() == 0){
				    errors.add("errorpass", new ActionMessage("invalidpass"));
			}		 
		//-----------------------------------------------------	 
		 }else if(login.equals("login2")){//���ȸ�� �α��ν�
	//���ڰ˻� ���� �� 
			
			 if(idbnum==null|| idbnum.length()<1 ){
				    errors.add("errorid", new ActionMessage("invalidid", "���̵��Է�!!"));
			 
		     }else if(idbnum.indexOf(" ") > -1 ||
					 idbnum.indexOf("\t") >= 0 || 
					 idbnum.indexOf("\n") > -1 ){
				errors.add("errorid", new ActionMessage("invalidid", "������ ������ �� �����ϴ�!!"));
			
				System.out.println("errors2 :: "+ errors);
				  
		      }
			 
			 if(bpass==null  || bpass.length() == 0){
			 	    errors.add("errorpass", new ActionMessage("invalidpass"));
			 }	}
		 
		 return errors;
		 }}
		 
		 
	
			
			