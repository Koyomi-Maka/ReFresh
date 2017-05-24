package com.refresh.dto;

import java.sql.Date;

public class Funding {
/*	
	펀딩번호
  	펀딩명
	펀딩종류
	펀딩상태
	카테고리
	회사명
	목표금액
	현재모금액
	달성률
	내용
	등록일
	등록가능일수
			*/
	
	private int pnum;
	private String pname;
	private String pu; 
	private String state;
	private String category;
	private String bname;
	private int gmoney;
	private int cmoney;
	private int rate;
	private String fcontent;
	private Date fdate; 
	private Date deadline;
	
	public Funding() {
	}
	
	public Funding(int pnum, String pname, String pu, String state, String category, String bname, int gmoney,
			int cmoney, int rate, String fcontent, Date fdate, Date deadline) {
		this.pnum = pnum;
		this.pname = pname;
		this.pu = pu;
		this.state = state;
		this.category = category;
		this.bname = bname;
		this.gmoney = gmoney;
		this.cmoney = cmoney;
		this.rate = rate;
		this.fcontent = fcontent;
		this.fdate = fdate;
		this.deadline = deadline;
	}
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPu() {
		return pu;
	}
	public void setPu(String pu) {
		this.pu = pu;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getGmoney() {
		return gmoney;
	}
	public void setGmoney(int gmoney) {
		this.gmoney = gmoney;
	}
	public int getCmoney() {
		return cmoney;
	}
	public void setCmoney(int cmoney) {
		this.cmoney = cmoney;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	} 

	
}
