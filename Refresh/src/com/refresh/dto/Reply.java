package com.refresh.dto;

import java.sql.Date;

public class Reply {
/*	
	댓글 번호
  	펀딩번호
	작성자
	내용
	작성일
 			*/
	private int rnum;
	private int pnum;
	private String rname; 
	private String rcontent;
	private Date rdate;
	
	public Reply() {
	}

	public Reply(int rnum, int pnum, String rname, String rcontent, Date rdate) {
	
		this.rnum = rnum;
		this.pnum = pnum;
		this.rname = rname;
		this.rcontent = rcontent;
		this.rdate = rdate;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
	

	
	
	
}
