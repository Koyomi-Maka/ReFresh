package com.refresh.dto;

import java.sql.Date;

public class Reply {
/*	
	댓글 번호
  	펀딩명
	작성자
	내용
	작성일
 			*/
	private int rnum;
	private String pname;
	private String rname;
	private String rcontent;
	private Date rdate;
	
	public Reply() {
	}

	public Reply(int rnum, String pname, String rname, String rcontent, Date rdate) {
		this.rnum = rnum;
		this.pname = pname;
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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
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
