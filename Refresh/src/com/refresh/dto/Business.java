package com.refresh.dto;

public class Business {
/*	
	회사회원번호
  	회사명
	비밀번호
	대표자
	회사번호
	전화번호
	회사주소
	회사계좌정보
			*/
	
	private int bnum;
	private String bname;
	private String bpass;
	private String ceoname;
	private int idbnum;
	private String btel;
	private String baddr;
	private String bacc;
	
	public Business() {
	}
	
	public Business(int bnum, String bname, String bpass, String ceoname, 
			int idbnum, String btel, String baddr,String bacc) {
	this.bnum = bnum;
	this.bname = bname;
	this.bpass = bpass;
	this.ceoname = ceoname;
	this.idbnum = idbnum;
	this.btel = btel;
	this.baddr = baddr;
	this.bacc = bacc;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBpass() {
		return bpass;
	}

	public void setBpass(String bpass) {
		this.bpass = bpass;
	}

	public String getCeoname() {
		return ceoname;
	}

	public void setCeoname(String ceoname) {
		this.ceoname = ceoname;
	}

	public int getIdbnum() {
		return idbnum;
	}

	public void setIdbnum(int idbnum) {
		this.idbnum = idbnum;
	}

	public String getBtel() {
		return btel;
	}

	public void setBtel(String btel) {
		this.btel = btel;
	}

	public String getBaddr() {
		return baddr;
	}

	public void setBaddr(String baddr) {
		this.baddr = baddr;
	}

	public String getBacc() {
		return bacc;
	}

	public void setBacc(String bacc) {
		this.bacc = bacc;
	}
	

}
