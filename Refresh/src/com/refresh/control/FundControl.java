package com.refresh.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.refresh.dao.BusinessDAO;
import com.refresh.dao.FundingDAO;
import com.refresh.dao.InvestorDAO;
import com.refresh.dao.ReplyDAO;
import com.refresh.dto.Business;
import com.refresh.dto.Funding;
import com.refresh.dto.Investor;
import com.refresh.dto.Reply;


public class FundControl extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if(action.equals("admin")) { // 관리자페이지에 댓글,회원관리,기업관리,게시물보이기

			ReplyDAO rdao = new ReplyDAO();
			List<Reply> reply_list = rdao.selectAll();
			
			InvestorDAO idao = new InvestorDAO();
			List<Investor> investor_list = idao.invesSelectAll();
			
			BusinessDAO bdao = new BusinessDAO();
			List<Business> business_list = bdao.selectAll();
			
			
			//펀딩 dao가 아직 안만들어져서 주석처리
			//FundingDAO fdao = new FundingDAO();
			//List<Funding> funding_list = fdao.sellectAll();
			
			
			req.setAttribute("reply_list", reply_list);
			req.setAttribute("investor_list", investor_list);
			req.setAttribute("business_list", business_list);
			//req.setAttribute("funding_list", funding_list);
			req.getRequestDispatcher("/admin/adminPage.jsp").forward(req, resp);
		}
		else if(action.equals("replyedit")){//댓글수정폼요청
			ReplyDAO rdao = new ReplyDAO();
			
			int rnum = Integer.parseInt(req.getParameter("rnum"));
			Reply reply = rdao.select(rnum);
			
			req.getSession().setAttribute("reply_update", reply);			
			req.getRequestDispatcher("/refresh/reply/replyEdit.jsp").forward(req, resp);
			
		}else if(action.equals("replyupdate")){//댓글수정요청
			Reply reply = new Reply();
			      String rnum = req.getParameter("rnum");
			      String pnum = req.getParameter("pnum");

			        reply.setRnum(Integer.parseInt(rnum));
			        reply.setPnum(Integer.parseInt(pnum));			       
			        reply.setRname(req.getParameter("rname"));
			        reply.setRcontent(req.getParameter("rcontent"));
			        
			       // reply.setRdate(Date); 날짜......받기.. ==> 수정폼필요

			   ReplyDAO rdao = new ReplyDAO();
			   if(rdao.update(reply)){//댓글수정성공
				   resp.sendRedirect("control?action=list");
			   }else{
				   resp.getWriter().print("수정에 실패했습니다.");
			   }
	}else if(action.equals("replydelete")){//글삭제 요청
		   int rnum =   Integer.parseInt(req.getParameter("rnum"));
		   
		   ReplyDAO rdao = new ReplyDAO();
		   if(rdao.delete(rnum)){//삭제성공
			   resp.sendRedirect("control?action=admin");
		   }else{
			   resp.getWriter().print("삭제실패");
		   }
		   
    }else if(action.equals("main")){ //메인페이지
    	String pageStr = req.getParameter("page");
				
		int page;
		if(pageStr==null){
			page = 1;
		}else{
			page = Integer.parseInt(pageStr);
		}
				/*
				 한페이지(한 화면)에 보여질 레코드 수 : currRecord
				 전체 레코드 수 : totalRecord
				 한 화면에 보여질 페이지 수 : currPage
				 전체 페이지 수 : totalPage
				 */
		FundingDAO dao = new FundingDAO();
		String sort = req.getParameter("sort");
		if(sort==null){
			sort = "all";
			}
		int recordCount = 3; //한 페이지에 보일 게시물 갯수
		int currPage = 5; //보일 페이지 갯수
				
		int totalRecord = 0; //총 게시물 갯수
		if(sort.equals("all")){
			totalRecord = dao.selectTotal();
		}else if(sort.equals("ended")){
			totalRecord = dao.selectEndedTotal();
		}else if(sort.equals("close")){
			totalRecord = dao.selectCloseTotal();
		}
				
		int totalPage =  1;
		int startPage = 1;
		int endPage = 1;
		//게시물이 0개일 경우 기본값
		if(totalRecord!=0){	
			totalPage = 0; //총 페이지 갯수
			startPage = ((page-1)/currPage*currPage)+1; 
			// 시작블럭숫자 (1~5페이지일경우 1, 6~10일경우 6) 
			endPage = ((page-1)/currPage*currPage)+currPage; 
			// 끝 블럭 숫자 (1~5일 경우 5, 6~10일경우 10
			totalPage = (int)Math.ceil(totalRecord/(double)recordCount);
			if(endPage > totalPage) {
				endPage = totalPage;
				}
			}

			//DB에서 검색
			List<Funding> list = null;
			if(sort.equals("all")){
				list = dao.selectPageAll(page,recordCount);
			}else if(sort.equals("ended")){
				list = dao.selectEnded(page, recordCount);
			}else if(sort.equals("close")){
				list = dao.selectClose(page, recordCount);
			}
				
			if(list!=null){
				for(int i=0; i<list.size(); i++){
					req.setAttribute("sort", sort);
					req.setAttribute("list", list);
					req.setAttribute("page", page);
					req.setAttribute("startPage", startPage);
					req.setAttribute("endPage", endPage);
					req.setAttribute("totalPage", totalPage);
					}//for
				}//if
			req.getRequestDispatcher("/refresh/main/mainList.jsp")
			.forward(req, resp);
			}//main화면
		   
//////////////////////////////////////개인회원///////////////////////////////////////////
		   
/*	   }else if(action.equals("replyedit")){//개인수정폼요청
		   InvestorDAO idao = new InvestorDAO();

			Investor investor = idao.invesSelect(req.getParameter("idmail")) ;
			req.getSession().setAttribute("investor_update", investor);			
			req.getRequestDispatcher("/refresh/investor/investorEdit.jsp").forward(req, resp);
			
		}else if(action.equals("replyupdate")){//개인회원수정
			Investor investor = new Investor();
			      String rnum = req.getParameter("rnum");
			      String pnum = req.getParameter("pnum");

			        reply.setRnum(Integer.parseInt(rnum));
			        reply.setPnum(Integer.parseInt(pnum));			       
			        reply.setRname(req.getParameter("rname"));
			        reply.setRcontent(req.getParameter("rcontent"));
			        
			       // reply.setRdate(Date); 날짜......받기.. ==> 수정폼필요

			   ReplyDAO rdao = new ReplyDAO();
			   if(rdao.update(reply)){//댓글수정성공
				   resp.sendRedirect("control?action=list");
			   }else{
				   resp.getWriter().print("수정에 실패했습니다.");
			   }
	}else if(action.equals("replydelete")){//글삭제 요청
		   int rnum =   Integer.parseInt(req.getParameter("rnum"));
		   
		   ReplyDAO rdao = new ReplyDAO();
		   if(rdao.delete(rnum)){//삭제성공
			   resp.sendRedirect("control?action=admin");
		   }else{
			   resp.getWriter().print("삭제실패");
		   }
	   }*/
		}// service
}