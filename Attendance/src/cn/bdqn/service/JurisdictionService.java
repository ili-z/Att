package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Jurisdiction;
import cn.bdqn.entity.Layui;

public interface JurisdictionService {
	List<Jurisdiction> SeleUserMenu(int userid);//查询用户对应权限

	List<Jurisdiction> SelectAllJurisdictions();//查询所有权限
	
	List<Jurisdiction> seleBtn();//查询关联按钮

	int deleteAllot(int id);//删除

	Jurisdiction echo(int id);//回显

	List<Jurisdiction> seleMunuid(int menuid);//查询菜单id

	int updateAllot(Jurisdiction menu);//修改权限

	Jurisdiction seleName(int pid);//查询上级权限名

	int insertAllot(Jurisdiction menu);//新增权限
	
	Layui<Jurisdiction> SelectAllJurisdiction();//查询所有权限
	
	List<Jurisdiction> seleType(int type);//查询上级权限名
	
	List<Jurisdiction> SelectJurBtn(int parentid);//查询所有权限对应按钮
}
