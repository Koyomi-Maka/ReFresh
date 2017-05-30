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




		//2. 유효성검사 - validate메소드 오버라이딩
		@Override
		public ActionErrors validate(ActionMapping mapping, 
				                     HttpServletRequest request) {			
			
			System.out.println("LoginActionForm validate():: "+ login);
			ActionErrors errors = new ActionErrors();//에러메시지를 담는 바구니
			
			System.out.println("errors1 :: "+ errors);
			
			
		 if(login.equals("login1")){//일반회원 로그인시
			 
			 if(idmail==null|| idmail.length()<1 ){
				    errors.add("errorid", new ActionMessage("invalidid", "아이디입력!!"));
			 }else if(idmail.indexOf(" ") > -1 ||
					 idmail.indexOf("\t") >= 0 || 
					 idmail.indexOf("\n") > -1 ){
				errors.add("errorid", new ActionMessage("invalidid", "공백을 포함할 수 없습니다!!"));}
			 
			 
			 if(ipass==null  || ipass.length() == 0){
				    errors.add("errorpass", new ActionMessage("invalidpass"));
			}		 
		//-----------------------------------------------------	 
		 }else if(login.equals("login2")){//기업회원 로그인시
	//숫자검사 공백 빈값 
			
			 if(idbnum==null|| idbnum.length()<1 ){
				    errors.add("errorid", new ActionMessage("invalidid", "아이디입력!!"));
			 
		     }else if(idbnum.indexOf(" ") > -1 ||
					 idbnum.indexOf("\t") >= 0 || 
					 idbnum.indexOf("\n") > -1 ){
				errors.add("errorid", new ActionMessage("invalidid", "공백을 포함할 수 없습니다!!"));
			
				System.out.println("errors2 :: "+ errors);
				  
		      }
			 
			 if(bpass==null  || bpass.length() == 0){
			 	    errors.add("errorpass", new ActionMessage("invalidpass"));
			 }	}
		 
		 return errors;
		 }}
		 
		 
	
			
			