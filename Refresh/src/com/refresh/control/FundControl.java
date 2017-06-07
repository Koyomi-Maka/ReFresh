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

		if(action.equals("admin")) { // �������������� ���,ȸ������,�������,�Խù����̱�

			ReplyDAO rdao = new ReplyDAO();
			List<Reply> reply_list = rdao.selectAll();
			
			InvestorDAO idao = new InvestorDAO();
			List<Investor> investor_list = idao.invesSelectAll();
			
			BusinessDAO bdao = new BusinessDAO();
			List<Business> business_list = bdao.selectAll();
			
			
			//�ݵ� dao�� ���� �ȸ�������� �ּ�ó��
			//FundingDAO fdao = new FundingDAO();
			//List<Funding> funding_list = fdao.sellectAll();
			
			
			req.setAttribute("reply_list", reply_list);
			req.setAttribute("investor_list", investor_list);
			req.setAttribute("business_list", business_list);
			//req.setAttribute("funding_list", funding_list);
			req.getRequestDispatcher("/admin/adminPage.jsp").forward(req, resp);
		}
		else if(action.equals("replyedit")){//��ۼ�������û
			ReplyDAO rdao = new ReplyDAO();
			
			int rnum = Integer.parseInt(req.getParameter("rnum"));
			Reply reply = rdao.select(rnum);
			
			req.getSession().setAttribute("reply_update", reply);			
			req.getRequestDispatcher("/refresh/reply/replyEdit.jsp").forward(req, resp);
			
		}else if(action.equals("replyupdate")){//��ۼ�����û
			Reply reply = new Reply();
			      String rnum = req.getParameter("rnum");
			      String pnum = req.getParameter("pnum");

			        reply.setRnum(Integer.parseInt(rnum));
			        reply.setPnum(Integer.parseInt(pnum));			       
			        reply.setRname(req.getParameter("rname"));
			        reply.setRcontent(req.getParameter("rcontent"));
			        
			       // reply.setRdate(Date); ��¥......�ޱ�.. ==> �������ʿ�

			   ReplyDAO rdao = new ReplyDAO();
			   if(rdao.update(reply)){//��ۼ�������
				   resp.sendRedirect("control?action=list");
			   }else{
				   resp.getWriter().print("������ �����߽��ϴ�.");
			   }
	}else if(action.equals("replydelete")){//�ۻ��� ��û
		   int rnum =   Integer.parseInt(req.getParameter("rnum"));
		   
		   ReplyDAO rdao = new ReplyDAO();
		   if(rdao.delete(rnum)){//��������
			   resp.sendRedirect("control?action=admin");
		   }else{
			   resp.getWriter().print("��������");
		   }
		   
    }else if(action.equals("main")){ //����������
    	String pageStr = req.getParameter("page");
				
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
		FundingDAO dao = new FundingDAO();
		String sort = req.getParameter("sort");
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
			}//mainȭ��
		   
//////////////////////////////////////����ȸ��///////////////////////////////////////////
		   
/*	   }else if(action.equals("replyedit")){//���μ�������û
		   InvestorDAO idao = new InvestorDAO();

			Investor investor = idao.invesSelect(req.getParameter("idmail")) ;
			req.getSession().setAttribute("investor_update", investor);			
			req.getRequestDispatcher("/refresh/investor/investorEdit.jsp").forward(req, resp);
			
		}else if(action.equals("replyupdate")){//����ȸ������
			Investor investor = new Investor();
			      String rnum = req.getParameter("rnum");
			      String pnum = req.getParameter("pnum");

			        reply.setRnum(Integer.parseInt(rnum));
			        reply.setPnum(Integer.parseInt(pnum));			       
			        reply.setRname(req.getParameter("rname"));
			        reply.setRcontent(req.getParameter("rcontent"));
			        
			       // reply.setRdate(Date); ��¥......�ޱ�.. ==> �������ʿ�

			   ReplyDAO rdao = new ReplyDAO();
			   if(rdao.update(reply)){//��ۼ�������
				   resp.sendRedirect("control?action=list");
			   }else{
				   resp.getWriter().print("������ �����߽��ϴ�.");
			   }
	}else if(action.equals("replydelete")){//�ۻ��� ��û
		   int rnum =   Integer.parseInt(req.getParameter("rnum"));
		   
		   ReplyDAO rdao = new ReplyDAO();
		   if(rdao.delete(rnum)){//��������
			   resp.sendRedirect("control?action=admin");
		   }else{
			   resp.getWriter().print("��������");
		   }
	   }*/
		}// service
}