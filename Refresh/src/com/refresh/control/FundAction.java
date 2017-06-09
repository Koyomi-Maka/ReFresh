package com.refresh.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		}
		
		return forward;
	}

}