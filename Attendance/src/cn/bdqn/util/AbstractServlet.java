package cn.bdqn.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractServlet extends HttpServlet {


	public abstract Class getServletClass();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获得action方法�??
		String actionIndicator = req.getParameter("action");
		Method method = null;
		Object result = null;
		try {
//			EmptyUtils:判断非空
			if (EmptyUtils.isEmpty(actionIndicator)) {
				result = execute(req, resp);
			} else {
				/*
				 * getServletClass():获得每一个Servlet�??
				 * getDeclaredMethod():获取类自身定义的方法
				 * getMethod():获取�??有共有的方法
				 */
				method = getServletClass().getDeclaredMethod(actionIndicator, HttpServletRequest.class, HttpServletResponse.class);
				System.out.println(method);
				result = method.invoke(this, req, resp);//反射机制调用方法，得到该方法的返回�??
			}
			toView(req, resp, result);
		} catch (NoSuchMethodException e) {//用反射机制调用方法，报找不到方法异常会转发到404页面
			String viewName = "404.jsp";
			req.getRequestDispatcher(viewName).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			if (!EmptyUtils.isEmpty(result)) {
				if (result instanceof String) {
					String viewName = "500.jsp";
					req.getRequestDispatcher(viewName).forward(req, resp);
				} else {
					ReturnResult returnResult = new ReturnResult(); 
					returnResult.returnFail("系统错误");
					PrintUtil.write(returnResult, resp);
				}
			} else {
				String viewName = "500.jsp";
				req.getRequestDispatcher(viewName).forward(req, resp);
			}

		}
	}

	protected void toView(HttpServletRequest req, HttpServletResponse resp, Object result) throws IOException, ServletException {
		if (!EmptyUtils.isEmpty(result)) {
			//instanceof:类型判断
			if (result instanceof String) {
				String viewName = result.toString() + ".jsp";
				System.out.println("----------------viewName");
				req.getRequestDispatcher(viewName).forward(req, resp);
			} else {
				System.out.println("----------------PrintUtil.write");
				PrintUtil.write(result, resp);
			}
		}
	}

//	
	public Object execute(HttpServletRequest req, HttpServletResponse resp) {
		return "pre/Index";
	}
}
