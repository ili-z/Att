package cn.bdqn.service.impl;

import java.util.List;

import cn.bdqn.dao.JurisdictionDao;
import cn.bdqn.dao.impl.JurisdictionDaoImpl;
import cn.bdqn.entity.Jurisdiction;
import cn.bdqn.entity.Layui;
import cn.bdqn.service.JurisdictionService;
import cn.bdqn.util.DataBaseUtil;

public class JurisdictionServiceImpl implements JurisdictionService{

	private JurisdictionDao jur = new JurisdictionDaoImpl(DataBaseUtil.getConnection());
	
	@Override
	public List<Jurisdiction> SeleUserMenu(int userid) {
		return jur.SeleUserMenu(userid);
	}

	@Override
	public List<Jurisdiction> SelectAllJurisdictions() {
		return jur.SelectAllJurisdictions();
	}

	@Override
	public int deleteAllot(int id) {
		// TODO Auto-generated method stub
		return jur.deleteAllot(id);
	}

	@Override
	public Jurisdiction echo(int id) {
		// TODO Auto-generated method stub
		return jur.echo(id);
	}

	@Override
	public List<Jurisdiction> seleMunuid(int jurid) {
		// TODO Auto-generated method stub
		return jur.seleMunuid(jurid);
	}

	@Override
	public int updateAllot(Jurisdiction jura) {
		// TODO Auto-generated method stub
		return jur.updateAllot(jura);
	}

	@Override
	public Jurisdiction seleName(int pid) {
		// TODO Auto-generated method stub
		return jur.seleName(pid);
	}

	@Override
	public int insertAllot(Jurisdiction juris) {
		// TODO Auto-generated method stub
		return jur.insertAllot(juris);
	}
	

	@Override
	public Layui<Jurisdiction> SelectAllJurisdiction() {
		Layui<Jurisdiction> layui = new Layui<Jurisdiction>();
		List<Jurisdiction> allMenu = new JurisdictionDaoImpl(DataBaseUtil.getConnection()).SelectAllJurisdictions();
		layui.setCode(0); 
		layui.setCount(allMenu.size());
		layui.setMassage("");
		layui.setData(allMenu);
		return layui;
	}

	@Override
	public List<Jurisdiction> seleBtn() {
		return jur.seleBtn();
	}

	@Override
	public List<Jurisdiction> seleType(int type) {
		return jur.seleType(type);
	}

	@Override
	public List<Jurisdiction> SelectJurBtn(int parentid) {
		return jur.SelectJurBtn(parentid);
	}
	
}
