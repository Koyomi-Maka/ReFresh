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
		String action = request.getParameter("action");//��û�м�
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
				
				
				int sizeLimit = 1024*1024*15; // ���� ũ�� 15MB�� ����
				
				MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
															//��û��ü , ����� �������, ũ������,  ���ڵ����,   �������ϸ����
				
				String fileName = multi.getFilesystemName("img"); //�����̸� �޾ƿ���
				String m_fileFullPath = savePath + "/" + fileName; //���ϰ�θ� DB�� ����
				
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
					fund.setState("����");
					System.out.println("pname : "+multi.getParameter("pname")+" category : "+multi.getParameter("category")+" pu : "+multi.getParameter("pu")+" bname" + multi.getParameter("bname"));
				
				if(dao.insert(fund)){
					request.setAttribute("msg", "����");
				}else{
					request.setAttribute("msg", "�Է½���");
				}
				
				forward = mapping.findForward("msg");
				break;
				
			case "funform" : 
				System.out.println("pnum : "+request.getParameter("pnum"));
				int pnum = Integer.parseInt(request.getParameter("pnum"));
			
				
				forward = mapping.findForward("success");
				break;
			case "update" : //����
				break;
			case "delete" : //����
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
						 ��������(�� ȭ��)�� ������ ���ڵ� �� : currRecord
						 ��ü ���ڵ� �� : totalRecord
						 �� ȭ�鿡 ������ ������ �� : currPage
						 ��ü ������ �� : totalPage
						 */
			
				String sort = request.getParameter("sort");
				if(sort==null){
					sort = "all";
					}
				int recordCount = 3; //�� �������� ���� �Խù� ����
				int currPage = 5; //���� ������ ����
						
				int totalRecord = 0; //�� �Խù� ����
				if(sort.equals("all")){
					totalRecord = dao.selectTotal();
				}else if(sort.equals("ended")){
					totalRecord = dao.selectEndedTotal();
				}else if(sort.equals("close")){
					totalRecord = dao.selectCloseTotal();
				}else{
					//Ư�� ī�װ�
					totalRecord = dao.selectCategoryTotal(sort);
				}
						
				int totalPage =  1;
				int startPage = 1;
				int endPage = 1;
				//�Խù��� 0���� ��� �⺻��
				if(totalRecord!=0){	
					totalPage = 0; //�� ������ ����
					startPage = ((page-1)/currPage*currPage)+1; 
					// ���ۺ����� (1~5�������ϰ�� 1, 6~10�ϰ�� 6) 
					endPage = ((page-1)/currPage*currPage)+currPage; 
					// �� �� ���� (1~5�� ��� 5, 6~10�ϰ�� 10
					totalPage = (int)Math.ceil(totalRecord/(double)recordCount);
					if(endPage > totalPage) {
						endPage = totalPage;
						}
					}

					//DB���� �˻�
					List<Funding> list = null;
					if(sort.equals("all")){
						list = dao.selectPageAll(page,recordCount);
					}else if(sort.equals("ended")){
						list = dao.selectEnded(page, recordCount);
					}else if(sort.equals("close")){
						list = dao.selectClose(page, recordCount);
					}else{
						//Ư�� ī�װ�
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