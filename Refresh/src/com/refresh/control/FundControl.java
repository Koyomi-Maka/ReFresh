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
//////////////// ====관리자페이지에 댓글,회원관리,기업관리,게시물보이기====//////////////////////////
		if(action.equals("admin")) { 
			
			String pageStr = req.getParameter("page"); 
			  int page;
			  if(pageStr==null){
				  page=1;
			  }else{
			      page= Integer.parseInt(pageStr);
			  }
			  ReplyDAO rdao = new ReplyDAO();
			  
			  int recordCount=5;
			  int totalRecord= rdao.selectCount();//32;
			  int totalPage=totalRecord/recordCount;//3
			  if(totalRecord%recordCount>0){
				  totalPage++;
			  }

			  List<Reply> reply_list = rdao.selectPage(page,recordCount);
			  req.setAttribute("reply_list", reply_list);	
			  req.setAttribute("page", page);
			  req.setAttribute("totalPage", totalPage);   
//------------------------댓글list------------------------------		
			InvestorDAO idao = new InvestorDAO();
			List<Investor> investor_list = idao.invesSelectAll();
			req.setAttribute("investor_list", investor_list);
			
//------------------------개인 list------------------------------			
			BusinessDAO bdao = new BusinessDAO();
			List<Business> business_list = bdao.selectAll();
			req.setAttribute("business_list", business_list);
			
//------------------------기업 list------------------------------			
			FundingDAO fdao = new FundingDAO();
			
//	List<Funding> funding_list = fdao.selectPageAll(page, recordCount)();

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
		}else{
			//특정 카테고리
			totalRecord = dao.selectCategoryTotal(sort);
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
			}else{
				//특정 카테고리
				list = dao.selectCategory(page, recordCount, sort);
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
			req.getRequestDispatcher("/refresh/main/ffmain.jsp")
			.forward(req, resp);
			}//main화면
		   
//////////////////////////////////////개인회원///////////////////////////////////////////
		   
else if(action.equals("investoredit"))

	{// 개인수정폼요청
		InvestorDAO idao = new InvestorDAO();

		Investor investor = idao.invesSelect(req.getParameter("idmail"));
		req.getSession().setAttribute("investor_update", investor);
		req.getRequestDispatcher("/refresh/investor/investorEdit.jsp").forward(req, resp);

	}else if(action.equals("investorupdate"))
	{// 개인회원수정
		Investor investor = new Investor();
		String inum = req.getParameter("inum");
		investor.setInum(Integer.parseInt(inum));
		investor.setIdmail(req.getParameter("idmail"));
		investor.setIpass(req.getParameter("ipass"));
		investor.setIname(req.getParameter("iname"));
		investor.setIphone(req.getParameter("iphone"));
		investor.setIbank(req.getParameter("ibank"));
		investor.setIpay(req.getParameter("ipay"));

		InvestorDAO idao = new InvestorDAO();

		if (idao.invesUpdate(investor)) {// 댓글수정성공
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("수정에 실패했습니다.");
		}
	}else if(action.equals("investordelete"))
	{// 글삭제 요청
		int inum = Integer.parseInt(req.getParameter("inum"));

		InvestorDAO idao = new InvestorDAO();
		if (idao.invesDelete(inum)) {// 삭제성공
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("삭제실패");
		}
	}

	///////////////////////////////////////// 기업회원////////////////////////////////////////////

	else if(action.equals("businessedit")){// 기업수정폼요청
		BusinessDAO bdao = new BusinessDAO();

		int bnum = Integer.parseInt(req.getParameter("bnum"));

		Business business = bdao.select(bnum);
		req.getSession().setAttribute("business_update", business);
		req.getRequestDispatcher("/refresh/business/businessEdit.jsp").forward(req, resp);

	}else if(action.equals("businessupdate")){// 기업회원수정
		Business business = new Business();
		String bnum = req.getParameter("bnum");
		business.setBnum(Integer.parseInt(bnum));
		business.setBname(req.getParameter("bname"));
		business.setBpass(req.getParameter("bpass"));
		business.setCeoname(req.getParameter("ceoname"));
		business.setIdbnum(Integer.parseInt(req.getParameter("idbnum")));
		business.setBtel(req.getParameter("btel"));
		business.setBaddr(req.getParameter("baddr"));
		business.setBacc(req.getParameter("bacc"));

		BusinessDAO bdao = new BusinessDAO();

		if (bdao.update(business)) {// 댓글수정성공
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("수정에 실패했습니다.");
		}
	}else if(action.equals("businessdelete")){// 글삭제 요청
		int bnum = Integer.parseInt(req.getParameter("bnum"));

		BusinessDAO bdao = new BusinessDAO();
		if (bdao.delete(bnum)) {// 삭제성공
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("삭제실패");
		}
	}
		
		
	////////////////////////////////////// 펀딩(게시list)/////////////////////////////////////////////
	else if(action.equals("fundingedit"))
	{// 펀딩수정폼요청
		FundingDAO fdao = new FundingDAO();

		int pnum = Integer.parseInt(req.getParameter("pnum"));

		//Funding funding = fdao.select(pnum);
	//	req.getSession().setAttribute("funding_update", funding);
		req.getRequestDispatcher("/refresh/funding/fundingEdit.jsp").forward(req, resp);

	}else if(action.equals("fundingupdate")){// 펀딩폼수정
		Funding funding = new Funding();
		String pnum = req.getParameter("pnum");
		funding.setPnum(Integer.parseInt(pnum));
		funding.setPname(req.getParameter("pname"));
		funding.setPu(req.getParameter("pu"));
		funding.setState(req.getParameter("state"));
		funding.setCategory(req.getParameter("category"));
		funding.setBname(req.getParameter("bname"));
		funding.setGmoney(Integer.parseInt(req.getParameter("gmoney")));
		funding.setCmoney(Integer.parseInt(req.getParameter("cmoney")));
		funding.setRate(Integer.parseInt(req.getParameter("rate")));
		funding.setFcontent(req.getParameter("fcontent"));

		FundingDAO fdao = new FundingDAO();

		/*if (fdao.update(funding)) {// 댓글수정성공
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("수정에 실패했습니다.");
		}*/
	}/*else if(action.equals("fundingdelete")){// 글삭제 요청
		int pnum = Integer.parseInt(req.getParameter("pnum"));

		FundingDAO fdao = new FundingDAO();
		if (fdao.delete(pnum)) {// 삭제성공
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("삭제실패");
		}
	}*/
}// service
}