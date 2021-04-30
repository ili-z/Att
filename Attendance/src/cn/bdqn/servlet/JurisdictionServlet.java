package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Jurisdiction;
import cn.bdqn.entity.Layui;
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
	
	public String Jurisdiction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int parentid = Integer.parseInt(request.getParameter("id"));
		
		List<Jurisdiction> selectBtn = new JurisdictionServiceImpl().SelectJurBtn(parentid);
		System.out.println(">>>>>>>>>>>>>>"+parentid+"--------"+selectBtn.size());
		request.setAttribute("list", selectBtn);
		return "/Background/Content";
	}
	
	public List<Jurisdiction> Juris(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return new JurisdictionServiceImpl().seleBtn();
	}
	
	public Layui<Jurisdiction> selectAllJurisdiction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Layui<Jurisdiction> selectAllJurisdiction = new JurisdictionServiceImpl().SelectAllJurisdiction();
		return selectAllJurisdiction;
	}
	
	public int deleteAllot(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return new JurisdictionServiceImpl().deleteAllot(Integer.parseInt(request.getParameter("id")));
	}
	
	public List<Jurisdiction> seleType(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int type = Integer.parseInt(request.getParameter("type"))-1; 
		List<Jurisdiction> seleType = new JurisdictionServiceImpl().seleType(type);
		return seleType;
	}
	
	public int updateAllot(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Jurisdiction jur = new Jurisdiction();
		jur.setId(Integer.parseInt(request.getParameter("id")));
		jur.setQname(request.getParameter("mname"));
		jur.setParentid(Integer.parseInt(request.getParameter("parentid")));
		jur.setType(Integer.parseInt(request.getParameter("type2")));
		jur.setButton(request.getParameter("mbtn"));
		jur.setJs(request.getParameter("js"));
		jur.setIsdelete(Integer.parseInt(request.getParameter("isdelete")));
		return new JurisdictionServiceImpl().updateAllot(jur);
	}
	
	public int insertAllot(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Jurisdiction jur = new Jurisdiction();
		jur.setQname(request.getParameter("mname"));
		jur.setParentid(Integer.parseInt(request.getParameter("parentid")));
		jur.setType(Integer.parseInt(request.getParameter("type2")));
		jur.setButton(request.getParameter("mbtn"));
		jur.setIsdelete(Integer.parseInt(request.getParameter("isdelete")));
		return new JurisdictionServiceImpl().insertAllot(jur);
	}
	
	public Jurisdiction JurId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("000000"+Integer.parseInt(request.getParameter("id"))+"-----"+new JurisdictionServiceImpl().echo(Integer.parseInt(request.getParameter("id"))));
		System.out.println(new JurisdictionServiceImpl().echo(Integer.parseInt(request.getParameter("id"))).getJs()+"//////////////////");
		return new JurisdictionServiceImpl().echo(Integer.parseInt(request.getParameter("id")));
	}
	
	public Jurisdiction AllotName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new JurisdictionServiceImpl().seleName(Integer.parseInt(request.getParameter("pid")));
	}
	
	@Override
	public Class getServletClass() {
		return JurisdictionServlet.class;
	}
}
