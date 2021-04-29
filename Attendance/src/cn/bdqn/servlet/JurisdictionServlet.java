package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Jurisdiction;
import cn.bdqn.service.JurisdictionService;
import cn.bdqn.service.impl.JurisdictionServiceImpl;
import cn.bdqn.util.AbstractServlet;
@WebServlet("/JurisdictionServlet")
public class JurisdictionServlet extends AbstractServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}


	private JurisdictionService jur = new JurisdictionServiceImpl();
	
//	用户权限
	public String seleUserMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Object attribute = request.getSession().getAttribute("userid");
		int userid = Integer.parseInt(String.valueOf(attribute));
		List<Jurisdiction> seleUserMenu = jur.SeleUserMenu(userid);
		request.setAttribute("list", seleUserMenu);
		return "/Background/InitialPage";
	}
	
	@Override
	public Class getServletClass() {
		return JurisdictionServlet.class;
	}
}
