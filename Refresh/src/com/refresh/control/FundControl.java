package com.refresh.control;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.refresh.dao.BusinessDAO;
import com.refresh.dao.InvestorDAO;
import com.refresh.dao.ReplyDAO;
import com.refresh.dto.Business;
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
			List<Investor> investor_list = idao.invesSelectAll()
					;
			BusinessDAO bdao = new BusinessDAO();
			List<Business> business_list = bdao.selectAll();
			
			//�ݵ� dao�� ���� ����.
			
			req.setAttribute("reply_list", reply_list);
			req.setAttribute("investor_list", investor_list);
			req.setAttribute("business_list", business_list);
			req.getRequestDispatcher("/admin/adminPage.jsp").forward(req, resp);
		}
		else if(action.equals("edit")){//��ۼ�������û
			ReplyDAO rdao = new ReplyDAO();
			
			int rnum = Integer.parseInt(req.getParameter("rnum"));
			Reply reply = rdao.select(rnum);
			
			req.getSession().setAttribute("reply_update", reply);			
			req.getRequestDispatcher("/refresh/replyWrite.jsp").forward(req, resp);//4.
			
		}else if(action.equals("update")){//��ۼ�����û
			Reply reply = new Reply();
			      String rnum = req.getParameter("rnum");
			      String pnum = req.getParameter("pnum");

			        reply.setRnum(Integer.parseInt(rnum));
			        reply.setPnum(Integer.parseInt(pnum));			       
			        reply.setRname(req.getParameter("rname"));
			        reply.setRcontent(req.getParameter("rcontent"));
			        
			       // reply.setRdate(Date); ��¥......

			   ReplyDAO rdao = new ReplyDAO();
			   if(rdao.update(reply)){//��ۼ�������
				   resp.sendRedirect("control?action=list");
			   }else{
				   resp.getWriter().print("������ �����߽��ϴ�.");
			   }
	}

}// service
}