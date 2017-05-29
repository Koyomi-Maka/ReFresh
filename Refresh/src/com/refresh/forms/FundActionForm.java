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
		InvestorDAO ivdao = new InvestorDAO(); // 투자자객체
		ReplyDAO rpdao = new ReplyDAO(); // 댓글객체
		
		// investor
		if (action == null || action.equals("")) {//

		} else if (action.equals("")) { //

		} else if (action.equals("")) {

		} else if (action.equals("")) {

		}

		// reply
		ActionForward forward = null;
		if (action == null || action.equals("list")) {// 댓글목록보기
			List<Reply> list = rpdao.selectAll();
			request.setAttribute("list", list);
			forward = mapping.findForward("list");

		} else if (action.equals("insert")) { //입력요청
			Reply reply = new Reply();
			reply.setRnum(Integer.parseInt(request.getParameter("rnum")));//번호 //번호를 이렇게입력받으면 수정은 못하게..?
			reply.setPname(request.getParameter("pname"));//펀딩명
			reply.setRname(request.getParameter("rname"));;//작성자
			reply.setRcontent(request.getParameter("rcontent"));//내용
			reply.setRdate(request.getParameter("rdate"));//작성일
		

			if (rpdao.insert(reply)) {
				request.setAttribute("msg", "댓글을 입력했습니다.");
			} else {
				request.setAttribute("msg", "댓글입력에 실패했습니다.");
			}
			forward = mapping.findForward("msg");

		} else if (action.equals("")) {//댓글수정요청
			 Reply reply = new Reply();
			 reply.setRnum(Integer.parseInt(request.getParameter("rnum")));//번호 //번호를 이렇게입력받으면 수정은 못하게..?
				reply.setPname(request.getParameter("pname"));//펀딩명
				reply.setRname(request.getParameter("rname"));;//작성자
				reply.setRcontent(request.getParameter("rcontent"));//내용
				reply.setRdate(request.getParameter("rdate"));//작성일   		         
        
	        if(rpdao.update(reply)){
	        	request.setAttribute("msg", "댓글수정성공!!");
	        }else{
	        	request.setAttribute("msg", "댓글수정실패!!");
	        }
            forward = mapping.findForward("msg"); 
		             break;
		} else if (action.equals("delete")) {//댓글삭제요청

		}

		return super.execute(mapping, form, request, response);

	}
}
