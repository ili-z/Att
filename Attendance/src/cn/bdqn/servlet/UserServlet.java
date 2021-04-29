package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import cn.bdqn.service.impl.UserServiceImpl;
import cn.bdqn.util.AbstractServlet;
@WebServlet("/UserServlet")
public class UserServlet extends AbstractServlet {

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

	private UserService user = new UserServiceImpl();
	
//	µÇÂ¼
	public User Login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User login = user.Login(request.getParameter("name"), request.getParameter("pwd"));
		request.getSession().setAttribute("userid", login.getId());
		request.getSession().setAttribute("login", login);
		return login;
	}
	
	
	
	@Override
	public Class getServletClass() {
		return UserServlet.class;
	}

}
