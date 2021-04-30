package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Jurisdiction;


public interface JurisdictionDao {
	List<Jurisdiction> SeleUserMenu(int userid);//查询用户对应权限

	List<Jurisdiction> SelectAllJurisdictions();//查询所有权限
	
	List<Jurisdiction> seleBtn();//查询关联按钮

	int deleteAllot(int id);//删除

	Jurisdiction echo(int id);//回显

	List<Jurisdiction> seleMunuid(int jurid);//查询菜单id

	int updateAllot(Jurisdiction jur);//修改权限

	Jurisdiction seleName(int pid);//查询上级权限名

	int insertAllot(Jurisdiction jur);//新增权限
	
	List<Jurisdiction> seleType(int type);//查询上级权限名
	
	List<Jurisdiction> SelectJurBtn(int parentid);//查询所有权限对应按钮

}
