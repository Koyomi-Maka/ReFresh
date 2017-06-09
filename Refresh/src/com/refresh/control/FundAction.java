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
		
		}
		
		return forward;
	}

}