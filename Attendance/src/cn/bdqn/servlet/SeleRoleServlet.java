package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.util.AbstractServlet;
/**
 *	½ÇÉ«--Servlet
 * @author Lenovo
 *
 */
@WebServlet("/SeleRoleServlet")
public class SeleRoleServlet extends AbstractServlet {

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
	
	
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return SeleRoleServlet.class;
	}

}
