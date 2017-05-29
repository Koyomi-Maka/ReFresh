package com.refresh.forms;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.refresh.dao.InvestorDAO;
import com.refresh.dao.ReplyDAO;
import com.refresh.dto.Reply;

public class FundActionForm extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String action = request.getParameter("action");
		InvestorDAO ivdao = new InvestorDAO(); // �����ڰ�ü
		ReplyDAO rpdao = new ReplyDAO(); // ��۰�ü
		
		// investor
		if (action == null || action.equals("")) {//

		} else if (action.equals("")) { //

		} else if (action.equals("")) {

		} else if (action.equals("")) {

		}

		// reply
		ActionForward forward = null;
		if (action == null || action.equals("list")) {// ��۸�Ϻ���
			List<Reply> list = rpdao.selectAll();
			request.setAttribute("list", list);
			forward = mapping.findForward("list");

		} else if (action.equals("insert")) { //�Է¿�û
			Reply reply = new Reply();
			reply.setRnum(Integer.parseInt(request.getParameter("rnum")));//��ȣ //��ȣ�� �̷����Է¹����� ������ ���ϰ�..?
			reply.setPname(request.getParameter("pname"));//�ݵ���
			reply.setRname(request.getParameter("rname"));;//�ۼ���
			reply.setRcontent(request.getParameter("rcontent"));//����
			reply.setRdate(request.getParameter("rdate"));//�ۼ���
		

			if (rpdao.insert(reply)) {
				request.setAttribute("msg", "����� �Է��߽��ϴ�.");
			} else {
				request.setAttribute("msg", "����Է¿� �����߽��ϴ�.");
			}
			forward = mapping.findForward("msg");

		} else if (action.equals("")) {//��ۼ�����û
			 Reply reply = new Reply();
			 reply.setRnum(Integer.parseInt(request.getParameter("rnum")));//��ȣ //��ȣ�� �̷����Է¹����� ������ ���ϰ�..?
				reply.setPname(request.getParameter("pname"));//�ݵ���
				reply.setRname(request.getParameter("rname"));;//�ۼ���
				reply.setRcontent(request.getParameter("rcontent"));//����
				reply.setRdate(request.getParameter("rdate"));//�ۼ���   		         
        
	        if(rpdao.update(reply)){
	        	request.setAttribute("msg", "��ۼ�������!!");
	        }else{
	        	request.setAttribute("msg", "��ۼ�������!!");
	        }
            forward = mapping.findForward("msg"); 
		             break;
		} else if (action.equals("delete")) {//��ۻ�����û

		}

		return super.execute(mapping, form, request, response);

	}
}
