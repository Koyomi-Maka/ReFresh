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
//////////////// ====�������������� ���,ȸ������,�������,�Խù����̱�====//////////////////////////
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
//------------------------���list------------------------------		
			InvestorDAO idao = new InvestorDAO();
			List<Investor> investor_list = idao.invesSelectAll();
			req.setAttribute("investor_list", investor_list);
			
//------------------------���� list------------------------------			
			BusinessDAO bdao = new BusinessDAO();
			List<Business> business_list = bdao.selectAll();
			req.setAttribute("business_list", business_list);
			
//------------------------��� list------------------------------			
			FundingDAO fdao = new FundingDAO();
			
//	List<Funding> funding_list = fdao.selectPageAll(page, recordCount)();

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
			}//mainȭ��
		   
//////////////////////////////////////����ȸ��///////////////////////////////////////////
		   
else if(action.equals("investoredit"))

	{// ���μ�������û
		InvestorDAO idao = new InvestorDAO();

		Investor investor = idao.invesSelect(req.getParameter("idmail"));
		req.getSession().setAttribute("investor_update", investor);
		req.getRequestDispatcher("/refresh/investor/investorEdit.jsp").forward(req, resp);

	}else if(action.equals("investorupdate"))
	{// ����ȸ������
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

		if (idao.invesUpdate(investor)) {// ��ۼ�������
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("������ �����߽��ϴ�.");
		}
	}else if(action.equals("investordelete"))
	{// �ۻ��� ��û
		int inum = Integer.parseInt(req.getParameter("inum"));

		InvestorDAO idao = new InvestorDAO();
		if (idao.invesDelete(inum)) {// ��������
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("��������");
		}
	}

	///////////////////////////////////////// ���ȸ��////////////////////////////////////////////

	else if(action.equals("businessedit")){// �����������û
		BusinessDAO bdao = new BusinessDAO();

		int bnum = Integer.parseInt(req.getParameter("bnum"));

		Business business = bdao.select(bnum);
		req.getSession().setAttribute("business_update", business);
		req.getRequestDispatcher("/refresh/business/businessEdit.jsp").forward(req, resp);

	}else if(action.equals("businessupdate")){// ���ȸ������
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

		if (bdao.update(business)) {// ��ۼ�������
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("������ �����߽��ϴ�.");
		}
	}else if(action.equals("businessdelete")){// �ۻ��� ��û
		int bnum = Integer.parseInt(req.getParameter("bnum"));

		BusinessDAO bdao = new BusinessDAO();
		if (bdao.delete(bnum)) {// ��������
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("��������");
		}
	}
		
		
	////////////////////////////////////// �ݵ�(�Խ�list)/////////////////////////////////////////////
	else if(action.equals("fundingedit"))
	{// �ݵ���������û
		FundingDAO fdao = new FundingDAO();

		int pnum = Integer.parseInt(req.getParameter("pnum"));

		//Funding funding = fdao.select(pnum);
	//	req.getSession().setAttribute("funding_update", funding);
		req.getRequestDispatcher("/refresh/funding/fundingEdit.jsp").forward(req, resp);

	}else if(action.equals("fundingupdate")){// �ݵ�������
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

		/*if (fdao.update(funding)) {// ��ۼ�������
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("������ �����߽��ϴ�.");
		}*/
	}/*else if(action.equals("fundingdelete")){// �ۻ��� ��û
		int pnum = Integer.parseInt(req.getParameter("pnum"));

		FundingDAO fdao = new FundingDAO();
		if (fdao.delete(pnum)) {// ��������
			resp.sendRedirect("control?action=admin");
		} else {
			resp.getWriter().print("��������");
		}
	}*/
}// service
}