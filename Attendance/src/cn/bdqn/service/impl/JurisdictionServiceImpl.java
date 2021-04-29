package cn.bdqn.service.impl;

import java.util.List;

import cn.bdqn.dao.JurisdictionDao;
import cn.bdqn.dao.impl.JurisdictionDaoImpl;
import cn.bdqn.entity.Jurisdiction;
import cn.bdqn.service.JurisdictionService;
import cn.bdqn.util.DataBaseUtil;

public class JurisdictionServiceImpl implements JurisdictionService{

	private JurisdictionDao jur = new JurisdictionDaoImpl(DataBaseUtil.getConnection());
	
	@Override
	public List<Jurisdiction> SeleUserMenu(int userid) {
		return jur.SeleUserMenu(userid);
	}
	
}
