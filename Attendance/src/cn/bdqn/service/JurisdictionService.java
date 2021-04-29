package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Jurisdiction;

public interface JurisdictionService {
	List<Jurisdiction> SeleUserMenu(int userid);//用户权限
}
