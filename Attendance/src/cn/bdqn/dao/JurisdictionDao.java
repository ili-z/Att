package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Jurisdiction;


public interface JurisdictionDao {
	List<Jurisdiction> SeleUserMenu(int userid);
}
