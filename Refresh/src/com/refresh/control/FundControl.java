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

		if (action.equals("admin")) { // �������������� ���,ȸ������,�������,�Խù����̱�

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
}}