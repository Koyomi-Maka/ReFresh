package com.refresh.control;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.refresh.dao.FundingDAO;
import com.refresh.dto.Funding;

public class FundAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");//요청분석
		if(action ==null)action="list";
		FundingDAO dao = new FundingDAO();
		ActionForward forward=null;
		switch(action){
			case "list" : 
				
				request.setAttribute("list", dao.selectTotal());
				
				forward = mapping.findForward("success");
				
				break;
			case "insert" : 
				
				
				String savePath = request.getServletContext().getRealPath("image");
				
				
				int sizeLimit = 1024*1024*15; // 파일 크기 15MB로 제한
				
				MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
															//요청객체 , 저장될 서버경로, 크기제한,  인코딩방식,   같은파일명방지
				
				String fileName = multi.getFilesystemName("img"); //파일이름 받아오기
				String m_fileFullPath = savePath + "/" + fileName; //파일경로를 DB에 저장
				
				Funding fund = new Funding();
				
					fund.setFileName(fileName);
					fund.setM_fileFullPath(m_fileFullPath);
					fund.setPname(multi.getParameter("pname"));
					System.out.println("setPname : " +  multi.getParameter("pname"));
					fund.setCategory(multi.getParameter("category"));
					fund.setPu(multi.getParameter("pu"));
					fund.setBname(multi.getParameter("bname"));
					fund.setCeoname(multi.getParameter("ceoname"));
					System.out.println("deadLine(): "+multi.getParameter("deadline"));
					fund.setDdate(Integer.parseInt(multi.getParameter("deadline")));
					fund.setFcontent(multi.getParameter("fcontent"));
					fund.setGmoney(Integer.parseInt(multi.getParameter("gmoney")));
					fund.setCmoney(0);
					fund.setState("진행");
					System.out.println("pname : "+multi.getParameter("pname")+" category : "+multi.getParameter("category")+" pu : "+multi.getParameter("pu")+" bname" + multi.getParameter("bname"));
				
				if(dao.insert(fund)){
					request.setAttribute("msg", "성공");
				}else{
					request.setAttribute("msg", "입력실패");
				}
				
				forward = mapping.findForward("msg");
				break;
				
			case "funform" : 
				System.out.println("pnum : "+request.getParameter("pnum"));
				int pnum = Integer.parseInt(request.getParameter("pnum"));
			
				
				forward = mapping.findForward("success");
				break;
			case "update" : //수정
				break;
			case "delete" : //삭제
				break;
			case "main" :
				String pageStr = request.getParameter("page");
				
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
			
				String sort = request.getParameter("sort");
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
							request.setAttribute("sort", sort);
							request.setAttribute("list", list);
							request.setAttribute("page", page);
							request.setAttribute("startPage", startPage);
							request.setAttribute("endPage", endPage);
							request.setAttribute("totalPage", totalPage);
							}//for
						}//if
					forward = mapping.findForward("success");
				   break;
			case "logout" : 
				HttpSession session = request.getSession();
				session.invalidate();
				
				forward = mapping.findForward("logout");
				break;
		
		}
		
		return forward;
	}

}