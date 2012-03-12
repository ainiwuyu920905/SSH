package cn.edu.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.bean.Person;
import cn.edu.service.PersonService;
import cn.edu.web.formbean.PersonFormBean;

public class PersonManage extends DispatchAction {

	@Resource
	private PersonService personvice;
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonFormBean personForm = (PersonFormBean)form;
		System.out.println("name"+personForm.getName());
		personvice.save(new Person(personForm.getName()));
		request.setAttribute("message","add is OK");
		return mapping.findForward("message");
	}
	
}
