package com.refresh.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.refresh.dao.BusinessDAO;
import com.refresh.dto.Business;

public class BJoinControl extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String action = request.getParameter("action");

		ActionForward forward =null;
		
		
		if (action == null || action.equals("idCheck")) {//
			
			String idCheck = request.getParameter("id");
			if(idCheck == null){
				forward = mapping.getInputForward();
			}
			
			BusinessDAO dao = new BusinessDAO();
			int id = Integer.parseInt(idCheck);
			int idC = dao.bIdCheck(id);
			ActionMessages msg = new ActionMessages();
			if(idC == 0){
				msg.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("idY"));
				saveMessages(request, msg);
				forward = mapping.findForward("success");
			}else if (idC != 0){
				msg.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("idN"));
				saveMessages(request, msg);
				forward = mapping.getInputForward();
				}
		}
		return forward;
	}
}	// class
