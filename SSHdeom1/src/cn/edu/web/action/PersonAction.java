package cn.edu.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.edu.service.PersonService;

public class PersonAction extends Action {

	@Resource
	private PersonService personService;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());
		PersonService personService = (PersonService)context.getBean("personService");*/
		
		request.setAttribute("personList",personService.getPersons());
		return mapping.findForward("list");
	}

	
}
