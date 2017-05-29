package com.refresh.dto;

public class Investor {
/*
	회원번호
	이름
	이메일(ID)
	비밀번호
	전화번호
	결제정보
	 		*/
	private int inum;
	private String idmail;
	private String ipass;
	private String iname;
	private String iphone;
	private String ibank;
	private String ipay;
	
	public Investor() {
	}

	public Investor(int inum, String iname, String idmail, String ipass, String iphone, String ibank,String ipay ) {
		this.inum = inum;
		this.iname = iname;
		this.idmail = idmail;
		this.ipass = ipass;
		this.iphone = iphone;
		this.ibank = ibank;
		this.ipay = ipay;
	}



	public String getIbank() {
		return ibank;
	}

	public void setIbank(String ibank) {
		this.ibank = ibank;
	}

	public int getInum() {
		return inum;
	}

	public void setInum(int inum) {
		this.inum = inum;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
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

	public String getIphone() {
		return iphone;
	}

	public void setIphone(String iphone) {
		this.iphone = iphone;
	}

	public String getIpay() {
		return ipay;
	}

	public void setIpay(String ipay) {
		this.ipay = ipay;
	}
	
	
}
